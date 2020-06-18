package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.Img;
import websx.spring.test.springtest.entity.Type;
import websx.spring.test.springtest.entity.Video;

import java.util.List;

@Repository
public interface ITypeVideoImgMapper {

    @Select("select * from type where tKeys=#{tKeys};")
    List<Type> findByKeyType(String tKeys);

    @Select("select * from video where vKeys=#{vKeys};")
    List<Video> findByKeyVideo(String vKeys);

    @Select("select * from img where iKeys=#{iKeys};")
    List<Img> findByKeyImg(String iKeys);
}
