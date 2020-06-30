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

    @Select("select * from invitation_comment order by id limit #{page},#{limit};")
    List<InvitationComment> findAll2InvitationComment(Integer page,Integer limit);

    @Select("select * from invitation_comment where id=#{id};")
    InvitationComment findByIdInvitationComment(Long id);

    @Select("select * from invitation_comment where iid=#{iid};")
    List<InvitationComment> findByIidInvitationComment(Long iid);

    @Select("select * from invitation_comment where iid=#{iid} order by id limit #{page},10;")
    List<InvitationComment> findByIid2InvitationComment(Long iid,Integer page);

    @Select("select * from invitation_comment where aid=#{aid};")
    List<InvitationComment> findByAidInvitationComment(Long aid);

    @Select("select * from invitation_comment where iid=#{iid} and aid=#{aid};")
    InvitationComment findByIidAidInvitationComment(Long iid,Long aid);

    @Insert("insert into invitation_comment(iid,aid,content,videos,imgs,ip,time) " +
            "values(#{iid},#{aid},#{content},#{videos},#{imgs},#{ip},#{time});")
    void saveInvitationComment(InvitationComment invitationComment);

    @Update("update invitation_comment set iid=#{iid},aid=#{aid},content=#{content},videos=#{videos}" +
            ",imgs=#{imgs},ip=#{ip},time=#{time} where id=#{id};")
    void updateInvitationComment(InvitationComment invitationComment);

    @Delete("delete from invitation_comment where id=#{id};")
    void deleteInvitationComment(Long id);
}
