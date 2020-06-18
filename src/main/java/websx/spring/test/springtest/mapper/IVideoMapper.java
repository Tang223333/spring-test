package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.Type;
import websx.spring.test.springtest.entity.Video;

import java.util.List;

@Repository
public interface IVideoMapper {

    @Select("select * from video;")
    List<Video> findAllVideo();
}
