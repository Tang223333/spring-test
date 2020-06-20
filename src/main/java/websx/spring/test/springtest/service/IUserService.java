package websx.spring.test.springtest.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import websx.spring.test.springtest.entity.User;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED)
public interface IUserService {

    List<User> findAllUser();

    User findByIdUser(Long id);

    User findByNameUser(String name);

    User findByNumberUser(String number);

    User saveUser(User user);

    User updateUser(User user);

    User deleteUser(Long id);
}
