package io.github.dunwu.springboot.autoconfigure;

import java.util.List;

import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.oschina.j2cache.CacheChannel;
import net.oschina.j2cache.J2Cache;
import io.github.dunwu.springboot.support.J2CacheCacheManger;

/**
 * 开启对spring cache支持的配置入口
 * @author zhangsaizz
 *
 */
@Configuration
@ConditionalOnClass(J2Cache.class)
@EnableConfigurationProperties({ J2CacheProperties.class, CacheProperties.class })
@ConditionalOnProperty(name = "j2cache.open-spring-cache", havingValue = "true")
@EnableCaching
public class J2CacheSpringCacheAutoConfiguration {

	private final CacheProperties cacheProperties;
	
	private final J2CacheProperties j2CacheProperties;

	J2CacheSpringCacheAutoConfiguration(CacheProperties cacheProperties, J2CacheProperties j2CacheProperties) {
		this.cacheProperties = cacheProperties;
		this.j2CacheProperties = j2CacheProperties;
	}

	@Bean
	@ConditionalOnBean(CacheChannel.class)
	public J2CacheCacheManger cacheManager(CacheChannel cacheChannel) {
		List<String> cacheNames = cacheProperties.getCacheNames();
		J2CacheCacheManger cacheCacheManger = new J2CacheCacheManger(cacheChannel);
		cacheCacheManger.setAllowNullValues(j2CacheProperties.isAllowNullValues());
		cacheCacheManger.setCacheNames(cacheNames);
		return cacheCacheManger;
	}


}
