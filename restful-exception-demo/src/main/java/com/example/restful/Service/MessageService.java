package com.example.restful.Service;

import com.example.restful.Exception.CustomException;
import com.example.restful.Pojo.Message;

import java.util.List;

/**
 * @author WU, Homer
 * @version 1.0
 * @date 2020/3/24 11:28
 * @description
 */
public interface MessageService {
    List<Message> findAll();
    Message findOne(Long id);
    Message save(Message message) throws CustomException;
    void delete(Long id);
    Message update(Message message) throws CustomException;
    Message updateText(Message message) throws CustomException;
}
