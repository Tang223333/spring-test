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
}
