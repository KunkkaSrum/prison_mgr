package com.yixing.prison_mgr.controller;

import com.yixing.prison_mgr.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Textbox;

import java.util.HashMap;

/**
 * Created by Master_Q on 2017/9/22.
 */
@Controller("studentAddController")
public class StudentAddController extends SelectorComposer<Component> {
    @Wire
    private Textbox name;
    @Wire
    private Textbox password;
    @Wire
    private Intbox age;
    @Wire
    private Combobox sex;
    @Autowired
    private StudentService studentService;
    private String type;

    public void doBeforeComposeChildren() {
        type = (String) Executions.getCurrent().getArg().get("type");
        System.out.println(type);
    }


    @Listen("onClick = #addSaveButton")
    public void studentAddSave(){
        String names = name.getValue();
        String passwords = password.getValue();
        int ages = age.getValue();
        int sexs = Integer.valueOf(sex.getSelectedItem().getValue());
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("name",names);
        map.put("password",passwords);
        map.put("age",ages);
        map.put("sex",sexs);
        int a = studentService.studentAddSave(map);
        if (a == 1){
            alert("添加成功");
        }else {
            alert("添加失败");
        }
    }

}
