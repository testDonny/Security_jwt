package com.example.testabc.config;
import java.time.Duration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;



@Configuration
public class RedisCacheConfig extends CachingConfigurerSupport {

	/**
	 * redis key生成策略 target: 類 method: 方法 params: 引數
	 * 
	 * @return KeyGenerator
	 * 
	 *         注意: 該方法只是聲明瞭key的生成策略,還未被使用,需在@Cacheable註解中指定keyGenerator
	 *         如: @Cacheable(value = "key", keyGenerator = "cacheKeyGenerator")
	 */
	@Bean
	public KeyGenerator cacheKeyGenerator() {
		return (target, method, params) -> {
			StringBuilder sb = new StringBuilder();
			sb.append(target.getClass().getName());
			sb.append(method.getName());
			for (Object obj : params) {
				// 由於引數可能不同, hashCode肯定不一樣, 快取的key也需要不一樣
				sb.append(JSON.toJSONString(obj).hashCode());
			}
			return sb.toString();
		};
	}

//	@Bean
//	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
//		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
//		redisTemplate.setConnectionFactory(factory);
//		return redisTemplate;
//	}
	
	
	@Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
            RedisTemplate<String, Object> template = new RedisTemplate();
            template.setConnectionFactory(factory);
            Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
            ObjectMapper om = new ObjectMapper();
            om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
            // 必须配置,有兴趣参考源码解读
            om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
            jackson2JsonRedisSerializer.setObjectMapper(om);
            StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
            // key采用String的序列化方式
            template.setKeySerializer(stringRedisSerializer);
            // hash的key也采用String的序列化方式
            template.setHashKeySerializer(stringRedisSerializer);
            // value序列化方式采用jackson
            template.setValueSerializer(jackson2JsonRedisSerializer);
            // hash的value序列化方式采用jackson
            template.setHashValueSerializer(jackson2JsonRedisSerializer);
            template.afterPropertiesSet();
            return template;
        }
//	public static RedisTemplate<String, RedisModel> redisTemplate() {
//	    RedisTemplate<String, RedisModel> redisTemplate = new RedisTemplate<String ,RedisModel>();
//	    redisTemplate.setConnectionFactory(redisConnectionFactory());
//	    redisTemplate.afterPropertiesSet();
//	    return redisTemplate;
//	}
	
	
	
	
	
	
	@Bean
	public CacheManager cacheManager(RedisConnectionFactory factory) {

		RedisSerializationContext.SerializationPair<Object> pair = RedisSerializationContext.SerializationPair
				.fromSerializer(new GenericJackson2JsonRedisSerializer());
		RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
				.computePrefixWith(name -> name + ":") // 变双冒号为单冒号
				.serializeValuesWith(pair) // 序列化方式
				.entryTtl(Duration.ofHours(1)); // 過期時間

		return RedisCacheManager.builder(RedisCacheWriter.nonLockingRedisCacheWriter(factory))
				.cacheDefaults(defaultCacheConfig).build();

	}

}