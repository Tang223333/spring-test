package websx.spring.test.springtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import websx.spring.test.springtest.entity.Invitation;
import websx.spring.test.springtest.mapper.IInvitationMapper;
import websx.spring.test.springtest.service.IInvitationService;

import java.util.List;

@Service
public class InvitationService implements IInvitationService {

    @Autowired
    private IInvitationMapper iInvitationMapper;

    @Override
    public List<Invitation> findAllInvitation() {
        return iInvitationMapper.findAllInvitation();
    }

    @Override
    public List<Invitation> findAll22Invitation(Integer page) {
        page=(page-1)*10;
        return iInvitationMapper.findAll22Invitation(page);
    }

    @Override
    public List<Invitation> findAll2Invitation(Integer page,Integer limit) {
        page=(page-1)*limit;
        return iInvitationMapper.findAll2Invitation(page,limit);
    }

    @Override
    public Invitation findByIdInvitation(Long id) {
        return iInvitationMapper.findByIdInvitation(id);
    }

    @Override
    public List<Invitation> findByFidInvitation(Long fid) {
        return iInvitationMapper.findByFidInvitation(fid);
    }

    @Override
    public List<Invitation> findByFid2Invitation(Long fid,Integer page) {
        page=(page-1)*10;
        return iInvitationMapper.findByFid2Invitation(fid,page);
    }

    @Override
    public List<Invitation> findByAidInvitation(Long aid) {
        return iInvitationMapper.findByAidInvitation(aid);
    }

    @Override
    public Invitation findByFidAidInvitation(Long fid, Long aid) {
        return iInvitationMapper.findByFidAidInvitation(fid,aid);
    }

    @Override
    public Invitation saveInvitation(Invitation invitationComment) {
        iInvitationMapper.saveInvitation(invitationComment);
        invitationComment=iInvitationMapper.findAllInvitation().get(iInvitationMapper.findAllInvitation().size()-1);
        return invitationComment;
    }

    @Override
    public Invitation updateInvitation(Invitation invitationComment) {
        iInvitationMapper.updateInvitation(invitationComment);
        invitationComment=iInvitationMapper.findByIdInvitation(invitationComment.getId());
        return invitationComment;
    }

    @Override
    public Invitation deleteInvitation(Long id) {
        Invitation invitationComment=iInvitationMapper.findByIdInvitation(id);
        iInvitationMapper.deleteInvitation(id);
        return invitationComment;
    }
}
