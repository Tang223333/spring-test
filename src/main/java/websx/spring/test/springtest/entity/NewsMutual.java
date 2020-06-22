package websx.spring.test.springtest.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NewsMutual {

    private Long nid;
    private Double views;
    private Double goods;
    private Double bads;
}
