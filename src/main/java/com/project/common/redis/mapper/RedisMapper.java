package com.project.common.redis.mapper;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("RedisMapper")
public class RedisMapper {

    private final RedisTemplate<String, Object> redisTemplate;

    public RedisMapper(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
	
	// select
    public Object findById(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    // insert
    public void save(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    // Update
    public void update(String key, Object newValue) {
        redisTemplate.opsForValue().set(key, newValue);
    }

    // Delete
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    // Multi select
    public List<Object> findByIds(List<String> keys) {
        return redisTemplate.opsForValue().multiGet(keys);
    }

    // Multi insert
    public void saves(Map<String, Object> keys) {
        redisTemplate.opsForValue().multiSet(keys);
    }
}

