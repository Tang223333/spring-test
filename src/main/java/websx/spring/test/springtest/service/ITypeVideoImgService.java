package websx.spring.test.springtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import websx.spring.test.springtest.entity.Img;
import websx.spring.test.springtest.entity.Type;
import websx.spring.test.springtest.entity.Video;
import websx.spring.test.springtest.mapper.ITypeVideoImgMapper;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED)
public interface ITypeVideoImgService {

    List<Type> findByKeyType(String tKeys);

    List<Video> findByKeyVideo(String vKeys);

    List<Img> findByKeyImg(String iKeys);
}
