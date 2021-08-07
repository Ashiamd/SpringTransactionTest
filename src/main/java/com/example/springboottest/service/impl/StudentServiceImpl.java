package com.example.springboottest.service.impl;

import com.example.springboottest.entity.Student;
import com.example.springboottest.dao.StudentDao;
import com.example.springboottest.service.StudentService;
import com.example.springboottest.service.TeacherService;
import com.zaxxer.hikari.util.IsolationLevel;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Student)表服务实现类
 *
 * @author ashiamd
 * @since 2021-07-27 23:35:24
 */
@Slf4j
//@Transactional(rollbackFor = Throwable.class, propagation = Propagation.SUPPORTS)
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    @Resource
    private TransactionTemplate transactionTemplate;

    @Resource
    private TeacherService teacherService;

    @Override
    public Student insert(Student student) {
        this.studentDao.insert(student);
        return student;
    }

    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.SUPPORTS)
    @Override
    public void A(Integer id) throws Exception {
        insert(new Student(0, id, id));
//        transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_NEVER);
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @SneakyThrows
            @Override
            public Object doInTransaction(TransactionStatus status) {
//                B(id);
                ((StudentServiceImpl)AopContext.currentProxy()).B(id);
                return null;
            }
        });
//        ((StudentServiceImpl)AopContext.currentProxy()).B(id);
//        this.B(id);
//        teacherService.B(id);
        log.info("A");
        int a = 1 / 0;
    }

    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRED)
    public void B(Integer id) throws Exception {
        insert(new Student(0, id + 1, id - 1));
//        int a = 1/0;
        log.info("B");
    }
}

