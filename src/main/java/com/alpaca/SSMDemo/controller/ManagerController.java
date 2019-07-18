package com.alpaca.SSMDemo.controller;

import com.alpaca.SSMDemo.entity.UserEntity;
import com.alpaca.SSMDemo.mapper.UserMapperForJPA;
import com.alpaca.SSMDemo.mapper.UserMapperForXML;
import com.alpaca.SSMDemo.utils.AjaxJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: daixueyun
 * @Description:
 * @Date: Create in 22:42 2019/7/17
 */
@Controller
@RequestMapping(value = "/managerController")
public class ManagerController {

    /*@Resource
    private UserMapperForJPA userMapperForJPA;*/

    @Resource
    private UserMapperForXML userMapperForXML;

    @RequestMapping(value = "showUsers")
    public String showUsers(HttpServletRequest request){
        String page = "manager/showUsers";
        List<UserEntity> userEntityList = userMapperForXML.findAll();
        request.setAttribute("users",userEntityList);
        return page;
    }

    @RequestMapping(value = "findOneById")
    @ResponseBody
    public AjaxJson findOneById(HttpServletRequest request){
        AjaxJson j = new AjaxJson();
        String id = request.getParameter("id");
        UserEntity user = userMapperForXML.findOneById(Integer.parseInt(id));
        if(null != user){
            j.setSuccess(true);
            j.setObj(user);
        }else{
            j.setSuccess(false);
            j.setMsg("无数据");
        }
        return j;
    }

    @RequestMapping(value = "editUser")
    @ResponseBody
    public AjaxJson editUser(HttpServletRequest request){
        AjaxJson j = new AjaxJson();
        String flag = request.getParameter("flag");
        String userName = request.getParameter("userName");
        String advantage = request.getParameter("advantage");
        if("edit".equals(flag)){
            String id = request.getParameter("id");
            UserEntity user = userMapperForXML.findOneById(Integer.parseInt(id));
            user.setUserName(userName);
            user.setAdvantage(advantage);
            int result = userMapperForXML.updateUser(user);
        }else if("add".equals(flag)){
            UserEntity user = new UserEntity();
            user.setUserName(userName);
            user.setAdvantage(advantage);
            int result = userMapperForXML.insertUser(user);
        }
        return j;
    }

    @RequestMapping(value = "deleteUser")
    @ResponseBody
    public AjaxJson deleteUser(HttpServletRequest request){
        AjaxJson j = new AjaxJson();
        String id = request.getParameter("id");
        int result = userMapperForXML.deleteUser(Integer.parseInt(id));
        j.setSuccess(true);
        return j;
    }

}
