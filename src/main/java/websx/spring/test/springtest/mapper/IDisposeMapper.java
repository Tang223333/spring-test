package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.Dispose;

import java.util.List;

@Repository
public interface IDisposeMapper {

    @Select("select * from dispose;")
    List<Dispose> findAllDispose();

    @Select("select * from dispose where gid=#{gid}")
    Dispose findByGidDispose(Long gid);

    @Insert("insert into dispose(gid,systemDown,handlerDown,ramDown,gpuDown,storeDown,deviceDown,systemUp,handlerUp,ramUp,gpuUp,storeUp,deviceUp,care)" +
            "values(#{gid},#{systemDown},#{handlerDown},#{ramDown},#{gpuDown},#{storeDown},#{deviceDown},#{systemUp},#{handlerUp},#{ramUp},#{gpuUp},#{storeUp},#{deviceUp},#{care});")
    void saveDispose(Dispose dispose);

    @Update("update dispose set systemDown=#{systemDown},handlerDown=#{handlerDown},ramDown=#{ramDown},gpuDown=#{gpuDown},storeDown=#{storeDown},deviceDown=#{deviceDown}" +
            ",systemUp=#{systemUp},handlerUp=#{handlerUp},ramUp=#{ramUp},gpuUp=#{gpuUp},storeUp=#{storeUp},deviceUp=#{deviceUp},care=#{care} where gid=#{gid};")
    void updateDispose(Dispose dispose);

    @Delete("delete from dispose where gid=#{gid};")
    void deleteDispose(Long gid);
}
