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
}
