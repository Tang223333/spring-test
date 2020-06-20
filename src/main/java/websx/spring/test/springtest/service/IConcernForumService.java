package websx.spring.test.springtest.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import websx.spring.test.springtest.entity.ConcernForum;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED)
public interface IConcernForumService {

    List<ConcernForum> findAllConcernForum();

    ConcernForum findByIdConcernForum(Long id);

    List<ConcernForum> findByAidConcernForum(Long aid);

    List<ConcernForum> findByGidConcernForum(Long gid);

    ConcernForum findByAidGidConcernForum(Long aid,Long gid);

    ConcernForum saveConcernForum(ConcernForum concernForum);

    ConcernForum deleteConcernForum(Long id);
}
