package websx.spring.test.springtest.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import websx.spring.test.springtest.entity.Invitation;
import websx.spring.test.springtest.entity.Invitation;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED)
public interface IInvitationService {

    List<Invitation> findAllInvitation();

    Invitation findByIdInvitation(Long id);

    List<Invitation> findByFidInvitation(Long fid);

    List<Invitation> findByAidInvitation(Long aid);

    Invitation saveInvitation(Invitation invitation);

    Invitation updateInvitation(Invitation invitation);

    Invitation deleteInvitation(Long id);
}
