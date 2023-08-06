package com.example.cmdproject_team2.domain.user.service.commonService;

import com.example.cmdproject_team2.domain.user.domain.User;
import com.example.cmdproject_team2.domain.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;


@RequiredArgsConstructor
@Service
public class PasswordResetService {

    private final UserRepository userRepository;
    private final JavaMailSender mailSender;
    private final BCryptPasswordEncoder passwordEncoder;

    public void resetPasswordAndSendEmail(String userEmail) throws Exception {
        User user = userRepository.findByUserEmail(userEmail)
                .orElseThrow(() -> new Exception("입력한 이메일에 해당하는 회원이 없습니다."));

        String temporaryPassword = generateTemporaryPassword();

        String hashedTemporaryPassword = passwordEncoder.encode(temporaryPassword);
        user.setPassword(hashedTemporaryPassword);
        userRepository.save(user);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(userEmail);
        message.setSubject("임시 비밀번호 안내");
        message.setText("회원님의 임시 비밀번호는 " + temporaryPassword + "입니다." + "로그인 후에 비밀번호를 변경해 주세요.");

        try {
            mailSender.send(message);
            System.out.println("임시 비밀번호 이메일이 전송되었습니다.");
        } catch (MailException e) {
            System.err.println("이메일 전송 중 오류가 발생했습니다: " + e.getMessage());
            throw new Exception("이메일 전송 중 오류가 발생했습니다.");
        }
    }

    private String generateTemporaryPassword() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[10];
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }
}
