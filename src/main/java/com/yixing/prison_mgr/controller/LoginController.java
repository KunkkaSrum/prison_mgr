package com.yixing.prison_mgr.controller;

import com.yixing.prison_mgr.entity.StudentEntity;
import com.yixing.prison_mgr.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Textbox;


/**
 * Created by Master_Q on 2017/9/20.
 */
@Controller("loginController")
public class LoginController extends SelectorComposer<Component> {
    @Wire
    private Textbox account;
    @Wire
    private Textbox password;
    @Wire
    private Grid userLoginBody;
    @Autowired
    private LoginService loginService;

    @Listen("onClick=#loginButton")
    public void login(){
        String accountL = account.getValue();
        String passwordL = password.getValue();
        StudentEntity studentEntity = loginService.queryByNameAndPassword(accountL,passwordL);
        if (studentEntity != null){
            Executions.sendRedirect("/upm/desktop/index.zul");
        }else {
            alert("查无此人");
            return;
        }
    }
}
