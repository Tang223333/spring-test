package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.Invitation;

import java.util.List;

@Repository
public interface IInvitationMapper {

    @Select("select * from invitation;")
    List<Invitation> findAllInvitation();
}
