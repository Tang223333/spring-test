package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.InvitationComment;
import websx.spring.test.springtest.entity.InvitationComment;

import java.util.List;

@Repository
public interface IInvitationCommentMapper {

    @Select("select * from invitation_comment;")
    List<InvitationComment> findAllInvitationComment();

    @Select("select * from invitation_comment where id=#{id};")
    InvitationComment findByIdInvitationComment(Long id);

    @Select("select * from invitation_comment where iid=#{iid};")
    List<InvitationComment> findByGidInvitationComment(Long iid);

    @Select("select * from invitation_comment where aid=#{aid};")
    List<InvitationComment> findByAidInvitationComment(Long aid);

    @Insert("insert into invitation_comment(iid,aid,content,videos,imgs,ip,time) " +
            "values(#{iid},#{aid},#{content},#{videos},#{imgs},#{ip},#{time});")
    void saveInvitationComment(InvitationComment invitationComment);

    @Update("update invitation_comment set iid=#{iid},aid=#{aid},content=#{content},videos=#{videos}" +
            ",imgs=#{imgs},ip=#{ip},time=#{time} where id=#{id};")
    void updateInvitationComment(InvitationComment invitationComment);

    @Delete("delete from invitation_comment where id=#{id};")
    void deleteInvitationComment(Long id);
}
