package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.Dispose;

import java.util.List;

@Repository
public interface IDisposeMapper {

    @Select("select * from dispose;")
    List<Dispose> findAllDispose();
}
