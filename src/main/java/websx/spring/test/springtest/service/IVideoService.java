package websx.spring.test.springtest.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import websx.spring.test.springtest.entity.Img;
import websx.spring.test.springtest.entity.Type;
import websx.spring.test.springtest.entity.Video;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED)
public interface IVideoService {

    List<Video> findAllVideo();

    Video findByIdVideo(Long id);

    List<Video> findByKeyVideo(String vKeys);

    Video saveVideo(Video video);

    Video deleteByIdVideo(Long id);

    List<Video> deleteByKeyVideo(String vKeys);
}
