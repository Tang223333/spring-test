package websx.spring.test.springtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import websx.spring.test.springtest.mapper.IUserMapper;
import websx.spring.test.springtest.entity.User;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserMapper userDao;

    @Override
    public List<User> findAllUser(){
        return userDao.findAllUser();
    }

    @Override
    public User findByIdUser(Long id){
        return userDao.findByIdUser(id);
    }

    @Override
    public User saveUser(User user){
        System.out.println(user);
        userDao.saveUser(user);
        user=null;
        user=findByIdUser(findAllUser().get(findAllUser().size()-1).getId());
        System.out.println(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        userDao.updateUser(user);
        user=userDao.findByIdUser(user.getId());
        return user;
    }

    @Override
    public User deleteUser(Long id){
        User user=userDao.findByIdUser(id);
        userDao.deleteUser(user.getId());
        return user;
    }
}
