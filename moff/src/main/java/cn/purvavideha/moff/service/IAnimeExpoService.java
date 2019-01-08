package cn.purvavideha.moff.service;

import cn.purvavideha.moff.entity.AnimeExpo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * @Title: IAnimeExpoService
 * @ProjectName moff
 * @Description: 漫展业务层
 * @author:季怀斌
 * @date 2019/1/315:19
 */
public interface IAnimeExpoService {
    /*  
    * @Description: 分页查漫展数据
    * @Param: [page, animeExpo] 
    * @return: java.util.List<cn.purvavideha.moff.entity.AnimeExpo> 
    * @Author: 朱喜亮
    * @Date: 17:14 2019/1/4 
    */
    IPage<AnimeExpo> queryAePage(@Param("pg") Page<AnimeExpo> page, AnimeExpo animeExpo);

    /*
     * @Description: 根据id获取漫展详情
     * @Param: [ae_id]
     * @return: cn.purvavideha.moff.entity.AnimeExpo
     * @Author: 季怀斌
     * @Date: 12:08 2019/1/4
     */
    AnimeExpo getAnimeExpoById(Integer ae_id);
}
