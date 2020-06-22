package websx.spring.test.springtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import websx.spring.test.springtest.entity.InvitationCollect;
import websx.spring.test.springtest.mapper.IInvitationCollectMapper;
import websx.spring.test.springtest.service.IInvitationCollectService;

import java.util.List;

@Service
public class InvitationCollectService implements IInvitationCollectService {

    @Autowired
    private IInvitationCollectMapper iInvitationCollectMapper;

    @Override
    public List<InvitationCollect> findAllInvitationCollect() {
        return iInvitationCollectMapper.findAllInvitationCollect();
    }

    @Override
    public InvitationCollect findByIdInvitationCollect(Long id) {
        return iInvitationCollectMapper.findByIdInvitationCollect(id);
    }

    @Override
    public List<InvitationCollect> findByAidInvitationCollect(Long aid) {
        return iInvitationCollectMapper.findByAidInvitationCollect(aid);
    }

    @Override
    public List<InvitationCollect> findByIidInvitationCollect(Long gid) {
        return iInvitationCollectMapper.findByIidInvitationCollect(gid);
    }

    @Override
    public InvitationCollect findByAidIidInvitationCollect(Long aid, Long gid) {
        return iInvitationCollectMapper.findByAidIidInvitationCollect(aid,gid);
    }

    @Override
    public InvitationCollect saveInvitationCollect(InvitationCollect invitationCollect) {
        iInvitationCollectMapper.saveInvitationCollect(invitationCollect);
        invitationCollect=iInvitationCollectMapper.findAllInvitationCollect().get(iInvitationCollectMapper.findAllInvitationCollect().size()-1);
        return invitationCollect;
    }

    @Override
    public InvitationCollect deleteInvitationCollect(Long id) {
        InvitationCollect invitationCollect=iInvitationCollectMapper.findByIdInvitationCollect(id);
        iInvitationCollectMapper.deleteInvitationCollect(id);
        return invitationCollect;
    }
}
