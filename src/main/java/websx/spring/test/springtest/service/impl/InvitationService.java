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
}
