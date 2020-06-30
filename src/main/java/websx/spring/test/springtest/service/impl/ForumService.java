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

    @Override
    public List<Forum> findAll2Forum(Integer page) {
        page=(page-1)*10;
        return iForumMapper.findAll2Forum(page);
    }

    @Override
    public Forum findByIdForum(Long id) {
        return iForumMapper.findByIdForum(id);
    }

    @Override
    public List<Forum> findByAidForum(Long aid) {
        return iForumMapper.findByAidForum(aid);
    }

    @Override
    public Forum findByNameForum(String name) {
        return iForumMapper.findByNameForum(name);
    }

    @Override
    public Forum saveForum(Forum forum) {
        iForumMapper.saveForum(forum);
        forum=iForumMapper.findAllForum().get(iForumMapper.findAllForum().size()-1);
        return forum;
    }

    @Override
    public Forum updateForum(Forum forum) {
        iForumMapper.updateForum(forum);
        forum=iForumMapper.findByIdForum(forum.getId());
        return forum;
    }

    @Override
    public Forum deleteForum(Long id) {
        Forum byIdForum = iForumMapper.findByIdForum(id);
        iForumMapper.deleteForum(id);
        return byIdForum;
    }
}
