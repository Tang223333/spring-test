package websx.spring.test.springtest.entity;

import lombok.Data;

import java.util.Date;

@Data
public class InvitationCommentAll {

    private Long id;
    private Long iid;
    private String invitationContent;
    private Long aid;
    private String accountName;
    private String accountLogo;
    private String content;
    private Date time;
    private Object imgs;
    private Object videos;
    private String ip;
}
