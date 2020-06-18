package websx.spring.test.springtest.entity;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Builder
@Data
public class Order {
    private Long id;
    private Long aid;
    private Long gid;
    private Integer type;
    private Date time;
}
