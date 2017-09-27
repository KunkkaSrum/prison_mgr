package com.yixing.prison_mgr.services.impl;

import com.yixing.prison_mgr.mapper.StudentMapper;
import com.yixing.prison_mgr.services.LoginService;
import com.yixing.prison_mgr.entity.StudentEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * Created by Master_Q on 2017/9/20.
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Resource
    private StudentMapper studentMapper;
    public StudentEntity queryByNameAndPassword(String name, String password) {

        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("name",name);
        map.put("password",password);
        return studentMapper.queryByNameAndPassword(map);
    }

}
