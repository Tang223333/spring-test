package websx.spring.test.springtest.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import websx.spring.test.springtest.entity.Forum;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED)
public interface IForumService {

    List<Forum> findAllForum();

    Forum findByIdForum(Long id);

    List<Forum> findByAidForum(Long aid);

    Forum saveForum(Forum forum);

    Forum updateForum(Forum forum);

    Forum deleteForum(Long id);
}
