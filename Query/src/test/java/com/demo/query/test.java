package com.demo.query;


import com.demo.domain.UserDTO;
import com.demo.query.Util.RedisClientUtil;
import com.hundsun.jrescloud.rpc.annotation.CloudComponent;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@CloudComponent
@SpringBootTest(classes = QueryStarter.class)
@RunWith(SpringRunner.class)
public class test {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisClientUtil redisClientUtil;

    @Autowired
    RabbitTemplate rabbitTemplate;

    private static Logger logger = Logger.getLogger(test.class);
    @Test
    public void contextLoads() {
        UserDTO user =new UserDTO();
        user.setName("张三");
        user.setPassword("123456");
        redisClientUtil.set("wangwu",user);
//        Object zhangsan = jsonredisTemplate.opsForValue().get("zhangsan");
//        System.out.println(zhangsan);

    }
    @Test
    public void test1(){
        for (int i = 0; i < 5; i++) {
            rabbitTemplate.convertAndSend("hello","hello!!!");
        }
    }
    @Test
    public void test2(){
        System.out.println(LocalDateTime.now());
    }
}
