package websx.spring.test.springtest.entity;

import lombok.Data;

import java.util.Date;

@Data
public class GameCollectAll {
    private Long id;
    private Long gid;
    private String gameName;
    private String gameDeveloper;
    private String gamePublisher;
    private String gameTeam;
    private Long aid;
    private String accountName;
    private String accountLogo;
    private Date time;
}
