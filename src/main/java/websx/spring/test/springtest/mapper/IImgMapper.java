package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.Img;
import websx.spring.test.springtest.entity.Video;

import java.util.List;

@Repository
public interface IImgMapper {

    @Select("select * from img;")
    List<Img> findAllImg();

    @Select("select * from img where id=#{id};")
    Img findByIdImg(Long id);

    @Select("select * from img where iKeys like #{iKeys};")
    List<Img> findByKeyImg(String iKeys);

    @Insert("insert into img(iKeys,value) values" +
            "(#{iKeys},#{value});")
    void saveImg(Img img);

    @Delete("delete from img where id=#{id};")
    void deleteByIdImg(Long id);

    @Delete("delete from img where iKeys=#{iKeys};")
    void deleteByKeyImg(String iKeys);
}
