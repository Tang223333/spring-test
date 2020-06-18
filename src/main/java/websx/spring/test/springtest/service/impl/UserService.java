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
}
