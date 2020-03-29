package com.spring.api.swagger.repository;

import com.spring.api.swagger.pojo.Message;

import java.util.List;

/**
 * @author WU, Homer
 * @version 1.0
 * @date 2020/3/26
 * @description
 * */

public interface MessageRepository {
    List<Message> findAll();
    Message findOne(Long id);
    Message save(Message message);
    void delete(Long id);
    Message update(Message message);
    Message updateText(Message message);
}
