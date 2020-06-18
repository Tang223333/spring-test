package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.Type;

import java.util.List;

@Repository
public interface ITypeMapper {

    @Select("select * from type;")
    List<Type> findAllType();
}
