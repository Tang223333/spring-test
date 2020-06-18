package websx.spring.test.springtest.entity;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Builder
@Data
public class Game {
    private Long id;
    private String name;
    private double money;
    private String describes;
    private Integer download;
    private Integer comment;
    private Integer grade;
    private Integer good;
    private Integer bad;
    private Object video;
    private Object img;
    private Object type;
    private Integer pType;
    private String developer;
    private String publisher;
    private String team;
    private Date time;
}
