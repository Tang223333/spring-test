package websx.spring.test.springtest.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import websx.spring.test.springtest.entity.Img;
import websx.spring.test.springtest.entity.Video;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED)
public interface IImgService {

    List<Img> findAllImg();

    Img findByIdImg(Long id);

    List<Img> findByKeyImg(String iKeys);

    Img saveImg(Img img);

    Img deleteByIdImg(Long id);

    List<Img> deleteImg(String iKeys);
}
