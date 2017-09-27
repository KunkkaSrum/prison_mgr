package com.yixing.prison_mgr.services;

import com.yixing.prison_mgr.entity.StudentEntity;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Master_Q on 2017/9/18.
 */
public interface StudentService {

    StudentEntity[] selectByName(String name);

    int studentAddSave(HashMap<String, Object> map);

    int studentDeleteSave(int id);

    int studentAllDeleteSave(List<Integer> ids);

    int studentUpdateSave(HashMap<String, Object> map);
}
