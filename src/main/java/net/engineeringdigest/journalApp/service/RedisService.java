package net.engineeringdigest.journalApp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.engineeringdigest.journalApp.api.response.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    @Autowired
    private RedisTemplate redisTemplate;
    private final static Logger logger = LoggerFactory.getLogger(RedisService.class);

    public <T> T get(String key, Class<T> entityClass){
        try {
            Object o = redisTemplate.opsForValue().get(key);
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(o.toString(),entityClass);
        }catch (Exception e){
            logger.error("exception"+e);
            return null;
        }
    }

    public void set(String key, Object o,Long ttl){
        try {
            ObjectMapper mapper= new ObjectMapper();
            String s = mapper.writeValueAsString(o);
            redisTemplate.opsForValue().set(key,s,ttl, TimeUnit.SECONDS);
        }catch (Exception e){
            logger.error("exception"+e);
        }
    }

    }
