package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.Dispose;

@Repository
public interface IDisposeMapper {

    @Select("select * from dispose where gid=#{gid};")
    Dispose findByGidDispose(Long gid);

    @Insert("insert into dispose(gid,systemDown,handlerDown,ramDown,gpuDown,storeDown,deviceDown,systemUp,handlerUp,ramUp,gpuUp,storeUp,deviceUp,care)" +
            "values(#{gid},#{systemDown},#{handlerDown},#{ramDown},#{gpuDown},#{storeDown},#{deviceDown},#{systemUp},#{handlerUp},#{ramUp},#{gpuUp},#{storeUp},#{deviceUp},#{care});")
    void saveDispose(Dispose dispose);
}
