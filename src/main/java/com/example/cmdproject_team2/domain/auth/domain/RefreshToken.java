package com.example.cmdproject_team2.domain.auth.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@Builder
@RedisHash
public class RefreshToken {

    @Id
    private String userId;

    @Indexed
    private String token;

    @TimeToLive
    private Long timeToLive;

    public void updateToken(Long timeToLive) {
        this.timeToLive = timeToLive;
    }

}
