package com.cluster8.c8.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@Configuration
@EnableCaching
public class RedisConfig {

  @Value("${SPRING_REDIS_URL}")
  String redisUrl;

  @Bean
  public JedisConnectionFactory connectionFactory() {
    RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();

    configuration.setHostName(getHostFromUrl(redisUrl));
    configuration.setPort(getPortFromUrl(redisUrl));
    configuration.setPassword(getPasswordFromUrl(redisUrl));

    return new JedisConnectionFactory(configuration);
  }

  String getHostFromUrl(String url) {
    url = url.substring(url.indexOf("@") + 1);

    String value = url.substring(0, url.indexOf(":"));

    System.out.println("value: " + value);

    return value;
  }

  int getPortFromUrl(String url) {
    url = url.substring(url.lastIndexOf(":") + 1);

    int value = Integer.parseInt(url);

    System.out.println("value: " + value);

    return value;
  }

  String getPasswordFromUrl(String url) {
    url = url.substring(9);

    String value = url.substring(0, url.indexOf("@"));

    System.out.println("value: " + value);

    return value;
  }
}