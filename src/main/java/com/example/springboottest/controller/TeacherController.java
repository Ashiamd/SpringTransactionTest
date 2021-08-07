package com.example.springboottest.controller;

import com.example.springboottest.entity.Teacher;
import com.example.springboottest.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Teacher)表控制层
 *
 * @author ashiamd
 * @since 2021-07-27 23:35:33
 */
@RestController
@RequestMapping("teacher")
public class TeacherController {
    /**
     * 服务对象
     */
    @Resource
    private TeacherService teacherService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Teacher selectOne(Integer id) {
        return this.teacherService.queryById(id);
    }

}
