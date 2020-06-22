package websx.spring.test.springtest.controller.basis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.Video;
import websx.spring.test.springtest.entity.Video;
import websx.spring.test.springtest.service.impl.VideoService;
import websx.spring.test.springtest.utils.JsonUtils;

import javax.websocket.server.PathParam;
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

    @RequestMapping(value = "/findById",method = RequestMethod.POST)
    public Map<String,Object> findByIdVideo(@PathParam("id") Long id){
        Video video = videoService.findByIdVideo(id);
        return JsonUtils.getJson(video,video!=null?0:1);
    }

    @RequestMapping(value = "/findByKey",method = RequestMethod.POST)
    public Map<String,Object> findByKeyVideo(@PathParam("vKeys") String vKeys){
        List<Video> imgs = videoService.findByKeyVideo(vKeys);
        return JsonUtils.getJson(imgs,imgs!=null?0:1);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Map<String,Object> saveVideo(@PathParam("vKeys") String vKeys,
                                      @PathParam("value") String value){
        Video img=Video.builder().vKeys(vKeys).value(value).build();
        img=videoService.saveVideo(img);
        return JsonUtils.getJson(img,img!=null?0:1);
    }

    @RequestMapping(value = "/deleteById",method = RequestMethod.POST)
    public Map<String,Object> deleteByIdVideo(@PathParam("id") Long id){
        Video img = videoService.deleteByIdVideo(id);
        return JsonUtils.getJson(img,img!=null?0:1);
    }

    @RequestMapping(value = "/deleteByKey",method = RequestMethod.POST)
    public Map<String,Object> deleteVideo(@PathParam("vKeys")String vKeys){
        List<Video> imgs = videoService.deleteByKeyVideo(vKeys);
        return JsonUtils.getJson(imgs,imgs!=null?0:1);
    }
}
