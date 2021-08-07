package com.example.springboottest.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Student)实体类
 *
 * @author ashiamd
 * @since 2021-07-27 23:35:23
 */
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private static final long serialVersionUID = -79473109378601675L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 学生编号
     */
    private Integer stuNo;
    /**
     * 班级编号
     */
    private Integer classNo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStuNo() {
        return stuNo;
    }

    public void setStuNo(Integer stuNo) {
        this.stuNo = stuNo;
    }

    public Integer getClassNo() {
        return classNo;
    }

    public void setClassNo(Integer classNo) {
        this.classNo = classNo;
    }

}
