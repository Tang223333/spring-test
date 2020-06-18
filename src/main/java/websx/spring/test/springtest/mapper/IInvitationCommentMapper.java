package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.InvitationComment;

import java.util.List;

@Repository
public interface IInvitationCommentMapper {

    @Select("select * from invitation_comment;")
    List<InvitationComment> findAllInvitationComment();
}
