package com.example.cmdproject_team2.global.security.jwt;

import com.example.cmdproject_team2.domain.auth.domain.RefreshToken;
import com.example.cmdproject_team2.domain.auth.domain.RefreshTokenRepository;
import com.example.cmdproject_team2.domain.user.domain.UserRepository;
import com.example.cmdproject_team2.domain.auth.presentation.dto.response.TokenResponse;
import com.example.cmdproject_team2.global.exception.token.ExpiredTokenException;
import com.example.cmdproject_team2.global.exception.token.InvalidTokenException;
import com.example.cmdproject_team2.global.security.auth.CustomUserDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.TimeZone;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final JwtProperties jwtProperties;
    private final CustomUserDetailsService customUserDetailsService;
    private final RefreshTokenRepository refreshTokenRepository;
    private final UserRepository userRepository;

    public TokenResponse createToken(String userId){
        Date now = new Date();
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul")); // 고객의 위치에 맞게 설정
        return TokenResponse
                .builder()
                .accessToken(createAccessToken(userId))
                .refreshToken(createRefreshToken(userId))
                .accessExpiredAt(new Date(now.getTime() + jwtProperties.getAccessExpiration()))
                .refreshExpiredAt(new Date(now.getTime() + jwtProperties.getRefreshExpiration()))
                .build();
    }

    public String createAccessToken(String username) {

        Date now = new Date();

        return Jwts.builder()
                .setSubject(username)
                .claim("type", "access")
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + jwtProperties.getAccessExpiration() * 1000))
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecret())
                .compact();
    }
    public String createRefreshToken(String userId) {

        Date now = new Date();

        String refreshToken = Jwts.builder()
                .claim("type", "refresh")
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + jwtProperties.getRefreshExpiration() * 1000))
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecret())
                .compact();

        refreshTokenRepository.save(
                RefreshToken.builder()
                        .userId(userId)
                        .token(refreshToken)
                        .timeToLive(jwtProperties.getRefreshExpiration())
                        .build());

        return refreshToken;
    }

    public TokenResponse reissue(String refreshToken) {

        RefreshToken token = refreshTokenRepository.findByToken(refreshToken)
                .orElseThrow(()-> InvalidTokenException.EXCEPTION);

        String userId = userRepository.findByUserId(token.getUserId())
                .orElseThrow(() -> InvalidTokenException.EXCEPTION).getUserId();

        refreshTokenRepository.delete(token);

        return createToken(userId);


    }

    // 토큰에 담겨있는 username으로 SpringSecurity Authentication 정보를 반환하는 메서드
    public Authentication getAuthentication(String token) {
        Claims claims = getClaims(token);
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(claims.getSubject());
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private Claims getClaims(String token) {
        try {
            return Jwts
                    .parser()
                    .setSigningKey(jwtProperties.getSecret())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw ExpiredTokenException.EXCEPTION;
        } catch (Exception e) {
            throw InvalidTokenException.EXCEPTION;
        }
    }

    // HTTP 요청 헤더에서 토큰을 가져오는 메서드
    public String resolveToken(HttpServletRequest request) {

        String bearerToken = request.getHeader(jwtProperties.getHeader());

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(jwtProperties.getPrefix())
                && bearerToken.length() > jwtProperties.getPrefix().length() + 1) {
            return bearerToken.substring(7);
        }
        return null;
    }
}