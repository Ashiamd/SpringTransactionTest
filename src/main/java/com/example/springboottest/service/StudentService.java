package com.example.springboottest.service;

import com.example.springboottest.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Student)表服务接口
 *
 * @author ashiamd
 * @since 2021-07-27 23:35:24
 */
public interface StudentService {


    /**
     * 新增数据
     *
     * @param student 实例对象
     * @return 实例对象
     */
    Student insert(Student student);

    void A(Integer id) throws Exception;
}
