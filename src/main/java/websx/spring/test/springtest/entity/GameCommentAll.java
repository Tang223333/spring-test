package websx.spring.test.springtest.entity;

import lombok.Data;

import java.util.Date;

@Data
public class GameCommentAll {
    private Long id;
    private Long gid;
    private String gameName;
    private Long aid;
    private String accountName;
    private String accountLogo;
    private String content;
    private Integer goodOrBad;
    private Integer grade;
    private String ip;
    private Date time;
}
