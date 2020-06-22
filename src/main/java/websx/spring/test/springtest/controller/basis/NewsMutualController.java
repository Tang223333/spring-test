package websx.spring.test.springtest.controller.basis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.NewsMutual;
import websx.spring.test.springtest.service.impl.NewsMutualService;
import websx.spring.test.springtest.utils.JsonUtils;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@RequestMapping("/newsMutual")
@RestController
public class NewsMutualController {
    
    @Autowired
    private NewsMutualService newsMutualService;

    @RequestMapping("/findAll")
    public Map<String,Object> findAllNewsMutual(){
        List<NewsMutual> allNewsMutual = newsMutualService.findAllNewsMutual();
        return JsonUtils.getJson(allNewsMutual,allNewsMutual!=null?0:1);
    }


    @RequestMapping(value = "/findByNid",method = RequestMethod.POST)
    public Map<String,Object> findByGidNewsMutual(@PathParam("nid") Long nid){
        NewsMutual newsMutual = newsMutualService.findByNidNewsMutual(nid);
        return JsonUtils.getJson(newsMutual,newsMutual!=null?0:1);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Map<String,Object> findSaveNewsMutual(@PathParam("nid") Long nid){
        NewsMutual newsMutual=newsMutualService.findByNidNewsMutual(nid);
        if (newsMutual != null) {
            newsMutual=null;
        }else {
            newsMutual= NewsMutual.builder().nid(nid).views((double) 0).goods((double) 0).bads((double) 0).build();
            newsMutual=newsMutualService.saveNewsMutual(newsMutual);
        }
        return JsonUtils.getJson(newsMutual,newsMutual!=null?0:1);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map<String,Object> findUpdateNewsMutual(@PathParam("nid") Long nid,
                                                   @PathParam("views") Double views,
                                                   @PathParam("goods") Double goods,
                                                   @PathParam("bads") Double bads){
        NewsMutual newsMutual=newsMutualService.findByNidNewsMutual(nid);
        if (newsMutual != null) {
            newsMutual= NewsMutual.builder().nid(nid!=null?nid:newsMutual.getNid()).views(views!=null?views:newsMutual.getViews())
                    .goods(goods!=null?goods:newsMutual.getGoods()).bads(bads!=null?bads:newsMutual.getBads()).build();
            newsMutual=newsMutualService.updateNewsMutual(newsMutual);
        }else {
            newsMutual=null;
        }
        return JsonUtils.getJson(newsMutual,newsMutual!=null?0:1);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Map<String,Object> findDeleteNewsMutual(@PathParam("nid") Long nid){
        NewsMutual newsMutual=newsMutualService.deleteNewsMutual(nid);
        return JsonUtils.getJson(newsMutual,newsMutual!=null?0:1);
    }
}
