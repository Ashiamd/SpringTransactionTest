package com.example.springboottest.controller;

import com.example.springboottest.entity.Student;
import com.example.springboottest.service.StudentService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Student)表控制层
 *
 * @author ashiamd
 * @since 2021-07-27 23:35:24
 */
@Slf4j
@RestController
@RequestMapping("student")
public class StudentController {
    /**
     * 服务对象
     */
    @Resource
    private StudentService studentService;

    @GetMapping("A")
    public void controller(Integer id) {
        try {
            this.studentService.A(id);
        } catch (Exception e) {
            log.info("Controller解决异常");
        }
        log.info("Controller正常");
    }

}
