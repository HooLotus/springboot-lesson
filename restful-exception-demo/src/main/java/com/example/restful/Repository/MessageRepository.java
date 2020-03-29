package com.example.restful.Repository;

import com.example.restful.Pojo.Message;

import java.util.List;

/**
 * @author WU, Homer
 * @version 1.0
 * @date 2020/3/24 11:27
 * @description
 */
public interface MessageRepository {
    List<Message> findAll();
    Message findOne(Long id);
    Message save(Message message);
    void delete(Long id);
    Message update(Message message);
    Message updateText(Message message);
}
