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

    List<ConcernForum> findByFidConcernForum(Long fid);

    ConcernForum findByAidFidConcernForum(Long aid, Long fid);

    ConcernForum saveConcernForum(ConcernForum concernForum);

    ConcernForum deleteConcernForum(Long id);
}
