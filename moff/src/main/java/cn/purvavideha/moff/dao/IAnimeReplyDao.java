package cn.purvavideha.moff.dao;

import cn.purvavideha.moff.entity.AnimeReply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @BelongsProject: moff
 * @BelongsPackage: cn.purvavideha.moff.dao
 * @Author: 刘甲哲
 * @CreateTime: 2019-01-04 11:16
 * @Description: ${Description}
 * @Version: 1.0
 */
@Repository
@Mapper
public interface IAnimeReplyDao extends BaseMapper<AnimeReply> {

}
