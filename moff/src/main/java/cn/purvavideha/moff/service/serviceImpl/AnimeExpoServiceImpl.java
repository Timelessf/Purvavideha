package cn.purvavideha.moff.service.serviceImpl;

import cn.purvavideha.moff.dao.IAnimeExpoDao;
import cn.purvavideha.moff.entity.AnimeExpo;
import cn.purvavideha.moff.service.IAnimeExpoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @Title: AnimeExpoServiceImpl
 * @ProjectName moff
 * @Description: ${Description}
 * @author:季怀斌
 * @date 2019/1/315:23
 */
@Setter
@Getter
@Service
public class AnimeExpoServiceImpl implements IAnimeExpoService {

    @Resource
    private IAnimeExpoDao animeExpoDao;

    /*
    * @Description: 分页查漫展数据 
    * @Param: [page, animeExpo] 
    * @return: java.util.List<cn.purvavideha.moff.entity.AnimeExpo> 
    * @Author: 朱喜亮
    * @Date: 17:12 2019/1/4 
    */ 
    @Override
    public IPage<AnimeExpo> queryAePage(@Param("pg") Page<AnimeExpo> page,AnimeExpo animeExpo) {
        QueryWrapper<AnimeExpo> wrapper = new QueryWrapper<>();
        wrapper.like("ae_address", animeExpo.getAeAddress());
        if (animeExpo.getAetId() != 0){
            wrapper.eq("aet_id",animeExpo.getAetId());
        }
        IPage<AnimeExpo> animeExpoPage = animeExpoDao.selectPage(page,wrapper);

        return animeExpoPage;
    }

    /*
     * @Description: 根据id获取漫展详情
     * @Param: [ae_id]
     * @return: cn.purvavideha.moff.entity.AnimeExpo
     * @Author: 季怀斌
     * @Date: 12:08 2019/1/4
     */
    @Override
    public AnimeExpo getAnimeExpoById(Integer ae_id) {
        return animeExpoDao.selectById(ae_id);
    }

}
