package websx.spring.test.springtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import websx.spring.test.springtest.entity.InvitationComment;
import websx.spring.test.springtest.service.impl.InvitationCommentService;
import websx.spring.test.springtest.utils.JsonUtils;

import java.util.List;
import java.util.Map;

@RequestMapping("/invitationComment")
@RestController
public class InvitationCommentController {

    @Autowired
    private InvitationCommentService invitationCommentService;

    @RequestMapping("findAll")
    public Map<String,Object> findAllInvitationComment(){
        List<InvitationComment> allInvitationComment = invitationCommentService.findAllInvitationComment();
        return JsonUtils.getJson(allInvitationComment,allInvitationComment!=null?0:1);
    }
}
