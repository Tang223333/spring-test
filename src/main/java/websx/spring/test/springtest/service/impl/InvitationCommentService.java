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

    @Override
    public InvitationComment findByIdInvitationComment(Long id) {
        return iInvitationCommentMapper.findByIdInvitationComment(id);
    }

    @Override
    public List<InvitationComment> findByIidInvitationComment(Long iid) {
        return iInvitationCommentMapper.findByIidInvitationComment(iid);
    }

    @Override
    public List<InvitationComment> findByAidInvitationComment(Long aid) {
        return iInvitationCommentMapper.findByAidInvitationComment(aid);
    }

    @Override
    public InvitationComment findByIidAidInvitationComment(Long iid, Long aid) {
        return iInvitationCommentMapper.findByIidAidInvitationComment(iid,aid);
    }

    @Override
    public InvitationComment saveInvitationComment(InvitationComment invitationComment) {
        iInvitationCommentMapper.saveInvitationComment(invitationComment);
        invitationComment=iInvitationCommentMapper.findAllInvitationComment().get(iInvitationCommentMapper.findAllInvitationComment().size()-1);
        return invitationComment;
    }

    @Override
    public InvitationComment updateInvitationComment(InvitationComment invitationComment) {
        iInvitationCommentMapper.updateInvitationComment(invitationComment);
        invitationComment=iInvitationCommentMapper.findByIdInvitationComment(invitationComment.getId());
        return invitationComment;
    }

    @Override
    public InvitationComment deleteInvitationComment(Long id) {
        InvitationComment invitationComment=iInvitationCommentMapper.findByIdInvitationComment(id);
        iInvitationCommentMapper.deleteInvitationComment(id);
        return invitationComment;
    }
}
