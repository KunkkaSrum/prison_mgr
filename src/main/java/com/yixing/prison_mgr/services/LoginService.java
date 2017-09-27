package com.yixing.prison_mgr.services;

import com.yixing.prison_mgr.entity.StudentEntity;

/**
 * Created by Master_Q on 2017/9/20.
 */
public interface LoginService {
    //01111
    StudentEntity queryByNameAndPassword(String name,String password);

}
