package websx.spring.test.springtest.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Date;

@Builder
@Data
public class User implements Serializable {
    private Long id;
    private String name;
    private String number;
    private String address;
    private Integer sex;
    private Date birthday;
    private String style;
}
