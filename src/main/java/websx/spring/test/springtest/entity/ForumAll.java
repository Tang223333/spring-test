package websx.spring.test.springtest.entity;

import lombok.Data;

@Data
public class ForumAll {
    private Long id;
    private Long aid;
    private String accountName;
    private String accountLogo;
    private Integer concerns;
    private Integer invitations;
    private Integer views;
    private String name;
    private String logo;
    private String ip;
}
