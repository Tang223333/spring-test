package websx.spring.test.springtest.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Dispose {
    private Long gid;
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
