package com.yixing.prison_mgr.mapper;

import com.yixing.prison_mgr.entity.StudentEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Master_Q on 2017/9/18.
 */
@Mapper
public interface StudentMapper {

    StudentEntity[] selectByName(String name);

    StudentEntity queryByNameAndPassword(HashMap<String, Object> map);

    int studentAddSave(HashMap<String, Object> map);

    int studentDeleteSave(int id);

    int studentAllDeleteSave(List<Integer> ids);

    int studentUpdateSave(HashMap<String, Object> map);
}
