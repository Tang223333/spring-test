package websx.spring.test.springtest.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import websx.spring.test.springtest.entity.InvitationCollect;
import websx.spring.test.springtest.entity.InvitationCollect;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED)
public interface IInvitationCollectService {

    List<InvitationCollect> findAllInvitationCollect();

    InvitationCollect findByIdInvitationCollect(Long id);

    List<InvitationCollect> findByAidInvitationCollect(Long aid);

    List<InvitationCollect> findByGidInvitationCollect(Long gid);

    InvitationCollect findByAidGidInvitationCollect(Long aid,Long gid);

    InvitationCollect saveInvitationCollect(InvitationCollect invitationCollect);

    InvitationCollect deleteInvitationCollect(Long id);
}
