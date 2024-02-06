package com.project.common.redis.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.project.common.redis.mapper.RedisMapper;

@Service
public class RedisService {
	
    private final RedisMapper redisMapper;

    public RedisService(RedisMapper redisMapper) {
        this.redisMapper = redisMapper;
    }
    
    /**
     * Redis select
     */
    public Object redisSelect(String key) {
        return redisMapper.findById(""+key+"");
    }
    
    /**
     * Redis insert
     */
    public void redisInsert(String key, Map<String, Object> map) {
    	redisMapper.save(key, map.get(""+key+""));
    }
    
    /**
     * Redis update
     */
    public void redisUpdate(String key, Map<String, Object> map) {
        redisMapper.update(key, map.get(""+key+""));
    }

    /**
     * Redis delete
     */
    public void redisDelete(String key) {
    	redisMapper.delete(""+key+"");
    }
    
    /**
     * Redis Multi select
     */
    public Object redisMultiSelect(List<String> keys) {
        return redisMapper.findByIds(keys);
    }
    
    /**
     * Redis Multi insert
     */
    public void redisMultiInsert(Map<String, Object> keys) {
    	redisMapper.saves(keys);
    }

}
