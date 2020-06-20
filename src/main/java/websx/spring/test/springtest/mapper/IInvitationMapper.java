package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.Invitation;
import websx.spring.test.springtest.entity.Invitation;

import java.util.List;

@Repository
public interface IInvitationMapper {

    @Select("select * from invitation;")
    List<Invitation> findAllInvitation();

    @Select("select * from invitation where id=#{id};")
    Invitation findByIdInvitation(Long id);

    @Select("select * from invitation where fid=#{fid};")
    List<Invitation> findByFidInvitation(Long fid);

    @Select("select * from invitation where aid=#{aid};")
    List<Invitation> findByAidInvitation(Long aid);

    @Select("select * from invitation where fid=#{fid} and aid=#{aid};")
    Invitation findByFidAidInvitation(Long fid,Long aid);

    @Insert("insert into invitation(fid,aid,content,videos,imgs,ip,time,goods,bads) " +
            "values(#{fid},#{aid},#{content},#{videos},#{imgs},#{ip},#{time},#{goods},#{bads});")
    void saveInvitation(Invitation invitationComment);

    @Update("update invitation set fid=#{fid},aid=#{aid},content=#{content},videos=#{videos}" +
            ",imgs=#{imgs},ip=#{ip},time=#{time},goods=#{goods},bads=#{bads} where id=#{id};")
    void updateInvitation(Invitation invitationComment);

    @Delete("delete from invitation where id=#{id};")
    void deleteInvitation(Long id);
}
