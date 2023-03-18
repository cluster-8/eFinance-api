package com.cluster8.c8.config;

import org.springframework.boot.autoconfigure.data.redis.LettuceClientConfigurationBuilderCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class RedisConfig {

  @Bean
  public LettuceClientConfigurationBuilderCustomizer lettuceClientConfigurationBuilderCustomizer() {
    return clientConfigurationBuilder -> {
      if (clientConfigurationBuilder.build().isUseSsl()) {
        clientConfigurationBuilder.useSsl().disablePeerVerification();
      }
    };
  }

  // @Bean
  // public RedisCacheConfiguration cacheConfiguration() {
  // return RedisCacheConfiguration.defaultCacheConfig()
  // .entryTtl(Duration.ofMinutes(60))
  // .disableCachingNullValues()
  // .serializeValuesWith(RedisSerializationContext.SerializationPair
  // .fromSerializer(new GenericJackson2JsonRedisSerializer()));
  // }

  // @Bean
  // public RedisCacheManagerBuilderCustomizer
  // redisCacheManagerBuilderCustomizer() {
  // return (builder) -> builder
  // .withCacheConfiguration("itemCache",
  // RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(30)))
  // .withCacheConfiguration("customerCache",
  // RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(5)));
  // }

}