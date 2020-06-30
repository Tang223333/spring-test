package websx.spring.test.springtest.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import websx.spring.test.springtest.entity.InvitationComment;
import websx.spring.test.springtest.entity.InvitationComment;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED)
public interface IInvitationCommentService {

    List<InvitationComment> findAllInvitationComment();

    List<InvitationComment> findAll2InvitationComment(Integer page,Integer limit);

    InvitationComment findByIdInvitationComment(Long id);

    List<InvitationComment> findByIidInvitationComment(Long iid);

    List<InvitationComment> findByIid2InvitationComment(Long iid,Integer page);

    List<InvitationComment> findByAidInvitationComment(Long aid);

    InvitationComment findByIidAidInvitationComment(Long iid, Long aid);

    InvitationComment saveInvitationComment(InvitationComment invitationComment);

    InvitationComment updateInvitationComment(InvitationComment invitationComment);

    InvitationComment deleteInvitationComment(Long id);
}
