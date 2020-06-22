package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.InvitationCollect;
import websx.spring.test.springtest.entity.InvitationCollect;

import java.util.List;

@Repository
public interface IInvitationCollectMapper {

    @Select("select * from invitation_collect;")
    List<InvitationCollect> findAllInvitationCollect();

    @Select("select * from invitation_collect where id=#{id};")
    InvitationCollect findByIdInvitationCollect(Long id);

    @Select("select * from invitation_collect where aid=#{aid};")
    List<InvitationCollect> findByAidInvitationCollect(Long aid);

    @Select("select * from invitation_collect where iid=#{iid};")
    List<InvitationCollect> findByIidInvitationCollect(Long iid);

    @Select("select * from invitation_collect where aid=#{aid} and iid=#{iid};")
    InvitationCollect findByAidIidInvitationCollect(Long aid, Long iid);

    @Insert("insert into invitation_collect(iid,aid,time)" +
            "values(#{iid},#{aid},#{time});")
    void saveInvitationCollect(InvitationCollect invitationCollect);

    @Delete("delete from invitation_collect where id=#{id};")
    void deleteInvitationCollect(Long id);
}
