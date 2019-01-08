package cn.purvavideha.moff.dao;

import cn.purvavideha.moff.entity.AnimePosted;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @BelongsProject: moff
 * @BelongsPackage: cn.purvavideha.moff.dao
 * @Author: 王振
 * @CreateTime: 2019-01-03 14:36
 * @Description: 论坛发帖接口层
 * @Version: 1.0
 */
@Repository
@Mapper
public interface IAnimePostedDao extends BaseMapper<AnimePosted> {

}
