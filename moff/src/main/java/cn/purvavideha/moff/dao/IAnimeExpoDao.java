package cn.purvavideha.moff.dao;

import cn.purvavideha.moff.entity.AnimeExpo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * @Title: IAnimeExpoDao
 * @ProjectName moff
 * @Description: 以漫展为核心的接口
 * @author:季怀斌
 * @date 2019/1/314:37
 */
@Repository
@Mapper
public interface IAnimeExpoDao extends BaseMapper<AnimeExpo> {

}
