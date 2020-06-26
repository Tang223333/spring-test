package websx.spring.test.springtest.entity;

import lombok.Data;

import java.util.Date;

@Data
public class InvitationAll {
    private Long id;
    private Long fid;
    private String forumName;
    private String forumLogo;
    private Long aid;
    private String accountName;
    private String accountLogo;
    private String content;
    private Integer goods;
    private Integer bads;
    private Integer collects;
    private Integer comments;
    private Date time;
    private Object imgs;
    private Object videos;
    private String ip;
}
