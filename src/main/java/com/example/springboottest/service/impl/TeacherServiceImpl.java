package com.example.springboottest.service.impl;

import com.example.springboottest.dao.StudentDao;
import com.example.springboottest.entity.Student;
import com.example.springboottest.entity.Teacher;
import com.example.springboottest.dao.TeacherDao;
import com.example.springboottest.service.StudentService;
import com.example.springboottest.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Teacher)表服务实现类
 *
 * @author ashiamd
 * @since 2021-07-27 23:35:33
 */
@Slf4j
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private StudentDao studentDao;

    @Resource
    private StudentService studentService;

    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.NOT_SUPPORTED)
    public void B(Integer id) throws Exception {
        Student student = new Student(0,id - 1,id - 1);
        studentService.insert(student);
        log.info("teacher - B");
    }

    @Resource
    private TeacherDao teacherDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Teacher queryById(Integer id) {
        return this.teacherDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Teacher> queryAllByLimit(int offset, int limit) {
        return this.teacherDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param teacher 实例对象
     * @return 实例对象
     */
    @Override
    public Teacher insert(Teacher teacher) {
        this.teacherDao.insert(teacher);
        return teacher;
    }

    /**
     * 修改数据
     *
     * @param teacher 实例对象
     * @return 实例对象
     */
    @Override
    public Teacher update(Teacher teacher) {
        this.teacherDao.update(teacher);
        return this.queryById(teacher.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.teacherDao.deleteById(id) > 0;
    }
}
