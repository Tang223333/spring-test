package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.Img;
import websx.spring.test.springtest.entity.Type;
import websx.spring.test.springtest.entity.Video;

import java.util.List;

@Repository
public interface IVideoMapper {

    @Select("select * from video;")
    List<Video> findAllVideo();

    @Select("select * from video where id=#{id};")
    Video findByIdVideo(Long id);

    @Select("select * from video where vKeys=#{vKeys};")
    List<Video> findByKeyVideo(String vKeys);

    @Insert("insert into video(vKeys,value) values" +
            "(#{vKeys},#{value});")
    void saveVideo(Video video);

    @Delete("delete from video where id=#{id};")
    void deleteByIdVideo(Long id);

    @Delete("delete from video where vKeys=#{vKeys};")
    void deleteByKeyVideo(String vKeys);
}
