package websx.spring.test.springtest.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class Game {
    private Long id;
    private String name;
    private String describes;
    private Object videos;
    private Object imgs;
    private Object types;
    private Integer pType;
    private String developer;
    private String publisher;
    private String team;
    private Date time;
}
