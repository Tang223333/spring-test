package websx.spring.test.springtest.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ConcernForumAll {
    private Long id;
    private Long fid;
    private String forumName;
    private String forumLogo;
    private Long aid;
    private String accountName;
    private String accountLogo;
    private Date time;
}
