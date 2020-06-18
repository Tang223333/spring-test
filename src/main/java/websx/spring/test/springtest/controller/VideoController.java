package websx.spring.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.Video;
import websx.spring.test.springtest.service.impl.VideoService;
import websx.spring.test.springtest.utils.JsonUtils;

import java.util.List;
import java.util.Map;

@RequestMapping("/video")
@RestController
public class VideoController {

    @Autowired
    private VideoService videoService;

    @RequestMapping("/findAll")
    public Map<String,Object> findAllVideo(){
        List<Video> allVideo = videoService.findAllVideo();
        return JsonUtils.getJson(allVideo,allVideo!=null?0:1);
    }
}
