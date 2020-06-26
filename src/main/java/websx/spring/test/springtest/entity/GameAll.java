package websx.spring.test.springtest.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class GameAll {
    private Long id;
    private String name;
    private String describes;
    private Integer pType;
    private String developer;
    private String publisher;
    private String team;
    private Date time;
    private Integer status;
    private Object videos;
    private Object imgs;
    private Object types;
    private Double collects;
    private Double comments;
    private Double goods;
    private Double bads;
    private Integer grades;
    private String systemDown;
    private String handlerDown;
    private String ramDown;
    private String gpuDown;
    private String storeDown;
    private String deviceDown;
    private String systemUp;
    private String handlerUp;
    private String ramUp;
    private String gpuUp;
    private String storeUp;
    private String deviceUp;
    private String care;
}
