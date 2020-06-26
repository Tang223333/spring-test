package websx.spring.test.springtest.entity;

import lombok.Data;

import java.util.Date;

@Data
public class NewsAll {
    private Long id;
    private Long aid;
    private String name;
    private String logo;
    private String title;
    private String writer;
    private Date time;
    private String content;
    private Object videos;
    private Object imgs;
    private String ip;
    private Integer status;
    private Double views;
    private Double goods;
    private Double bads;
}
