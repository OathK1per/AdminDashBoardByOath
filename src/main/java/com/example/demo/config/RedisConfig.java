package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
public class RedisConfig
{
    @Bean
    LettuceConnectionFactory jedisConnectionFactory()
    {
        final RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName("redis-19999.c14.us-east-1-2.ec2.cloud.redislabs.com");
        config.setPort(19999);
        config.setPassword(RedisPassword.of("***"));
        return new LettuceConnectionFactory();
    }
}
