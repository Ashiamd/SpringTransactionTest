package com.example.springboottest.controller;

import com.example.springboottest.entity.Person;
import com.example.springboottest.service.PersonService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Person)表控制层
 *
 * @author ashiamd
 * @since 2021-07-27 23:34:20
 */
@RestController
@RequestMapping("person")
public class PersonController {
    /**
     * 服务对象
     */
    @Resource
    private PersonService personService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Person selectOne(Integer id) {
        return this.personService.queryById(id);
    }

}
