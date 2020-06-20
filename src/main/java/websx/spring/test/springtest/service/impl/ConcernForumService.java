package websx.spring.test.springtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import websx.spring.test.springtest.entity.ConcernForum;
import websx.spring.test.springtest.mapper.IConcernForumMapper;
import websx.spring.test.springtest.service.IConcernForumService;

import java.util.List;

@Service
public class ConcernForumService implements IConcernForumService {

    @Autowired
    private IConcernForumMapper iConcernForumMapper;

    @Override
    public List<ConcernForum> findAllConcernForum() {
        return iConcernForumMapper.findAllConcernForum();
    }

    @Override
    public ConcernForum findByIdConcernForum(Long id) {
        return iConcernForumMapper.findByIdConcernForum(id);
    }

    @Override
    public List<ConcernForum> findByAidConcernForum(Long aid) {
        return iConcernForumMapper.findByAidConcernForum(aid);
    }

    @Override
    public List<ConcernForum> findByGidConcernForum(Long gid) {
        return iConcernForumMapper.findByGidConcernForum(gid);
    }

    @Override
    public ConcernForum findByAidGidConcernForum(Long aid, Long gid) {
        return iConcernForumMapper.findByAidGidConcernForum(aid,gid);
    }

    @Override
    public ConcernForum saveConcernForum(ConcernForum concernForum) {
        iConcernForumMapper.saveConcernForum(concernForum);
        concernForum=iConcernForumMapper.findAllConcernForum().get(iConcernForumMapper.findAllConcernForum().size()-1);
        return concernForum;
    }

    @Override
    public ConcernForum deleteConcernForum(Long id) {
        ConcernForum byIdConcernForum = iConcernForumMapper.findByIdConcernForum(id);
        iConcernForumMapper.deleteConcernForum(id);
        return byIdConcernForum;
    }
}
