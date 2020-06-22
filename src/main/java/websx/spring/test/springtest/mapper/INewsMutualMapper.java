package websx.spring.test.springtest.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import websx.spring.test.springtest.entity.NewsMutual;

import java.util.List;

@Repository
public interface INewsMutualMapper {

    @Select("select * from news_mutual;")
    List<NewsMutual> findAllNewsMutual();

    @Select("select * from news_mutual where nid=#{nid}")
    NewsMutual findByNidNewsMutual(Long nid);

    @Insert("insert into news_mutual(nid,views,goods,bads)" +
            "values(#{nid},#{views},#{goods},#{bads});")
    void saveNewsMutual(NewsMutual newsMutual);

    @Update("update news_mutual set views=#{views},goods=#{goods},bads=#{bads} where nid=#{nid};")
    void updateNewsMutual(NewsMutual newsMutual);

    @Delete("delete from news_mutual where nid=#{nid};")
    void deleteNewsMutual(Long nid);
}
