package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.InvitationCollect;

import java.util.List;

@Repository
public interface IInvitationCollectMapper {

    @Select("select * from invitation_collect;")
    List<InvitationCollect> findAllInvitationCollect();
}
