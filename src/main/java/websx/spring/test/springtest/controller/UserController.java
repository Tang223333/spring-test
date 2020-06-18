package websx.spring.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.User;
import websx.spring.test.springtest.service.impl.UserService;
import websx.spring.test.springtest.utils.JsonUtils;

import java.util.List;
import java.util.Map;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public Map<String,Object> findAllUser(){
        List<User> allUser = userService.findAllUser();
        return JsonUtils.getJson(allUser,allUser!=null?0:1);
    }
}
