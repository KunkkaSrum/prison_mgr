package com.yixing.prison_mgr.controller;

import com.yixing.prison_mgr.entity.StudentEntity;
import com.yixing.prison_mgr.services.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.*;

import java.util.*;

/**
 * Created by Master_Q on 2017/9/18.
 */
@Controller("studentController")
public class StudentController extends SelectorComposer<Component> {
    @Wire
    private Textbox name;
    @Wire
    private Listbox studentListbox;
    @Autowired
    private StudentService studentService;
    private static Logger logger = Logger.getLogger(StudentController.class);

    /**
     * 注册监听器，将该方法与id为searchButton的Button的onClick绑定
     */

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        search();
    }
    @Listen("onClick=#searchButton")
    public void search() {
        String keyword = name.getValue();
        StudentEntity[] studentEntity = studentService.selectByName(keyword);
        List<StudentEntity> list = new ArrayList<StudentEntity>();
        if (studentEntity != null) {
            for(int i=0;i<studentEntity.length;++i) {
                int sexq = studentEntity[i].getSex();
                if (sexq == 1) {
                    studentEntity[i].setSexs("女");
                } else {
                    studentEntity[i].setSexs("男");
                }
                list.add(studentEntity[i]);

            }
            ListModelList listModelList = new ListModelList<StudentEntity>(list);
            listModelList.setMultiple(true);
            studentListbox.setModel(listModelList);
        }else {
            alert("没有数据");
            return;
        }
    }
    @Listen("onClick=#addButton")
    public void add(){
        Component component = Executions.createComponents("/upm/desktop/add.zul", null, null);
        Window win = (Window) component;
        win.setBorder("normal");
        win.setClosable(true);
        win.setPosition("center");
        win.setAttribute("type","add");
        try {
            win.doModal();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @Listen("onClick=#deleteButton")
    public void delete(){
        Set<Listitem> set = studentListbox.getSelectedItems();
        if (set.size()<=0){
            alert("请选择一条数据");
            return;
        }else {
            List<Listitem> list = new ArrayList(set);
            Listitem listitem = list.get(0);
            StudentEntity studentEntity = listitem.getValue();
            System.out.println(studentEntity.getId());
            int id = studentEntity.getId();
            int a = studentService.studentDeleteSave(id);
            if (a==1){
                alert("删除成功！");
            }else {
                alert("删除失败！");
            }
        }
        search();
    }
    @Listen("onClick=#updateButton")
    public void update(){
        Set<Listitem> set = studentListbox.getSelectedItems();
        if (set.size() <= 0){
            alert("请选择一条数据，您还没有选择");
            return;
        }
        else if (set.size() > 1){
            alert("请选择一条数据，你的选择数量超过限定");
            return;
        } else{
            List<Listitem> list = new ArrayList(set);
            Listitem listitem = list.get(0);
            StudentEntity studentEntity = listitem.getValue();
            HashMap<String,String> arg = new HashMap<String, String>();
            arg.put("StudentId", String.valueOf(studentEntity.getId()));
            arg.put("name", studentEntity.getName());
            arg.put("password", studentEntity.getPassword());
            arg.put("age", String.valueOf(studentEntity.getAge()));
            arg.put("sex", studentEntity.getSexs());
            Component component = Executions.createComponents("/upm/desktop/update.zul", null, arg);
            Window win = (Window) component;
            win.setBorder("normal");
            win.setClosable(true);
            win.setPosition("center");
            win.setAttribute("type","update");
            win.setAttribute("ids","1");

            try {
                win.doModal();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    @Listen("onClick = #deleteAllButton")
    public void studentAllDeleteSave(){
        Set<Listitem> set = studentListbox.getSelectedItems();
        if (set.size()<=0){
            alert("请选择一条数据");
            return;
        }
        else {
            List<Listitem> list = new ArrayList(set);
            List<Integer> ids = new ArrayList<>();
            for(int i=0;i<list.size();++i) {
                Listitem listitem = list.get(i);
                StudentEntity studentEntity = listitem.getValue();
//                System.out.println(studentEntity.getId());
                ids.add(studentEntity.getId());

            }
            int a = studentService.studentAllDeleteSave(ids);
            if (a>0) {
                alert("删除成功！");
            } else {
                alert("删除失败！");
            }
        }
        search();
    }

}
