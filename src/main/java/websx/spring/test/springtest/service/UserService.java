package websx.spring.test.springtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import websx.spring.test.springtest.dao.UserDao;
import websx.spring.test.springtest.entity.User;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> findAllUser(){
        return userDao.findAllUser();
    }

    public User findByIdUser(Integer id){
        return userDao.findByIdUser(id);
    }
}
