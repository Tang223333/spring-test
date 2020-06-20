package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.Img;
import websx.spring.test.springtest.entity.Type;

import java.util.List;

@Repository
public interface ITypeMapper {

    @Select("select * from type;")
    List<Type> findAllType();

    @Select("select * from type where id=#{id};")
    Type findByIdType(Long id);

    @Select("select * from type where tKeys=#{tKeys};")
    List<Type> findAllKeyType(String tKeys);

    @Insert("insert into type(tKeys,value) values" +
            "(#{tKeys},#{value});")
    void saveType(Type type);

    @Delete("delete from type where id=#{id};")
    void deleteByIdType(Long id);

    @Delete("delete from type where tKeys=#{tKeys};")
    void deleteByKeyType(String tKeys);
}
