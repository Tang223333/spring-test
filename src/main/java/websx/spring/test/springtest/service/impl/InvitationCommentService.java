package websx.spring.test.springtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import websx.spring.test.springtest.entity.InvitationComment;
import websx.spring.test.springtest.mapper.IInvitationCommentMapper;
import websx.spring.test.springtest.service.IInvitationCommentService;

import java.util.List;

@Service
public class InvitationCommentService implements IInvitationCommentService {

    @Autowired
    private IInvitationCommentMapper iInvitationCommentMapper;

    @Override
    public List<InvitationComment> findAllInvitationComment() {
        return iInvitationCommentMapper.findAllInvitationComment();
    }
}
