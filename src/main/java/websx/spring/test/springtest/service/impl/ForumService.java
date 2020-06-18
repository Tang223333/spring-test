package websx.spring.test.springtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import websx.spring.test.springtest.entity.Forum;
import websx.spring.test.springtest.mapper.IForumMapper;
import websx.spring.test.springtest.service.IForumService;

import java.util.List;

@Service
public class ForumService implements IForumService {

    @Autowired
    private IForumMapper iForumMapper;

    @Override
    public List<Forum> findAllForum() {
        return iForumMapper.findAllForum();
    }
}
