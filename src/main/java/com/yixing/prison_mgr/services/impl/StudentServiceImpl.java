package com.yixing.prison_mgr.services.impl;

import com.yixing.prison_mgr.services.StudentService;
import com.yixing.prison_mgr.entity.StudentEntity;
import com.yixing.prison_mgr.mapper.StudentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Master_Q on 2017/9/18.
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;
    public StudentEntity[] selectByName(String name) {
        StudentEntity[] studentEntity = studentMapper.selectByName(name);
        return studentEntity;
    }

    public int studentAddSave(HashMap<String, Object> map) {
        int a = studentMapper.studentAddSave(map);
        return a;
    }

    @Override
    public int studentDeleteSave(int id) {
        int a= studentMapper.studentDeleteSave(id);
        return a;
    }



    @Override
    public int studentAllDeleteSave(List<Integer> ids) {
        int a = studentMapper.studentAllDeleteSave(ids);
        return a;
    }

    @Override
    public int studentUpdateSave(HashMap<String, Object> map) {
        int a = studentMapper.studentUpdateSave(map);
        return a;
    }
}
