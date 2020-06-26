package websx.spring.test.springtest.entity;

import lombok.Data;

import java.util.Date;

@Data
public class NewsCollectAll {
    private Long id;
    private Long nid;
    private String newsTitle;
    private String newsWriter;
    private String newsContent;
    private Long aid;
    private String accountName;
    private String accountLogo;
    private Date time;
}
