package websx.spring.test.springtest.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class Invitation {
    private Long id;
    private Long fid;
    private Long aid;
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
