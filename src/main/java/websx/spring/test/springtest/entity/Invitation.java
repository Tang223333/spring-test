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
    private Date time;
    private Object img;
    private Object video;
    private String ip;
}
