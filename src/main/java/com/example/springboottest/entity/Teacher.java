package com.example.springboottest.entity;

import java.io.Serializable;

/**
 * (Teacher)实体类
 *
 * @author ashiamd
 * @since 2021-07-27 23:35:32
 */
public class Teacher implements Serializable {
    private static final long serialVersionUID = 598509067183221873L;
    /**
     * 主键
     */
    private Integer id;
    /**
     * 教师编号
     */
    private Integer teacherNo;
    /**
     * 教师姓名
     */
    private String name;
    /**
     * 教师性别
     */
    private Integer gender;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(Integer teacherNo) {
        this.teacherNo = teacherNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

}
