package websx.spring.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.User;
import websx.spring.test.springtest.service.UserService;
import websx.spring.test.springtest.utils.JsonUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dao")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public List<User> findAllUser(){
        return userService.findAllUser();
    }

    @RequestMapping("/getUser/{id}")
    public User findByIdUser(@PathVariable Integer id){
        return userService.findByIdUser(id);
    }

    @RequestMapping("/getUser/map")
    public Map<String,Object> findGetMapUser(){
        List<User> users=userService.findAllUser();
        if (users != null) {
            return JsonUtils.getJson(users,0);
        }else {
            return JsonUtils.getJson(users,1);
        }
    }
}
