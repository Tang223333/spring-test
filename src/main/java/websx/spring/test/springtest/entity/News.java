package websx.spring.test.springtest.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class News {
    private Long id;
    private String title;
    private String writer;
    private Date time;
    private String content;
    private Object videos;
    private Object imgs;
}
