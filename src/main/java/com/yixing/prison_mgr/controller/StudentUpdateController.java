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
@Controller("studentUpdateController")
public class StudentUpdateController extends SelectorComposer<Component> {
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
    private  String Id;
    private String Name;
    private String Password;
    private int Age;
    private String Sex;



    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        Id = (String) Executions.getCurrent().getArg().get("StudentId");
        Password = (String) Executions.getCurrent().getArg().get("password");
        Name = (String) Executions.getCurrent().getArg().get("name");
        Age = Integer.parseInt((String) Executions.getCurrent().getArg().get("age"));
        Sex = (String) Executions.getCurrent().getArg().get("sex");
        name.setValue(Name);
        password.setValue(Password);
        age.setValue(Age);
        sex.setValue(Sex);
    }
    @Listen("onClick = #updateSaveButton")
    public void studentUpdateSave(){

        int idt = Integer.parseInt(Id);
        String names = name.getValue();
        String passwords = password.getValue();
        int ages = age.getValue();
        int sexs = Integer.valueOf(sex.getSelectedItem().getValue());
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("id",idt);
        map.put("name",names);
        map.put("password",passwords);
        map.put("age",ages);
        map.put("sex",sexs);
        int a = studentService.studentUpdateSave(map);
        if (a == 1){
            alert("修改成功");
        }else {
            alert("修改失败");
        }
    }


}