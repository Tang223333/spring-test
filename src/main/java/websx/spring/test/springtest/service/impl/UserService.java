package websx.spring.test.springtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import websx.spring.test.springtest.entity.User;
import websx.spring.test.springtest.mapper.IUserMapper;
import websx.spring.test.springtest.service.IUserService;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserMapper iUserMapper;

    @Override
    public List<User> findAllUser() {
        return iUserMapper.findAllUser();
    }

    @Override
    public User findByIdUser(Long id) {
        return iUserMapper.findByIdUser(id);
    }

    @Override
    public List<User> findByNameUser(String name) {
        return iUserMapper.findByNameUser(name);
    }

    @Override
    public User findByNumberUser(String number) {
        return iUserMapper.findByNumberUser(number);
    }

    @Override
    public User saveUser(User user) {
        iUserMapper.saveUser(user);
        user=iUserMapper.findAllUser().get(iUserMapper.findAllUser().size()-1);
        return user;
    }

    @Override
    public User updateUser(User user) {
        iUserMapper.update(user);
        user=iUserMapper.findByIdUser(user.getId());
        return user;
    }

    @Override
    public User deleteUser(Long id) {
        User user=iUserMapper.findByIdUser(id);
        iUserMapper.delete(id);
        return user;
    }

}
