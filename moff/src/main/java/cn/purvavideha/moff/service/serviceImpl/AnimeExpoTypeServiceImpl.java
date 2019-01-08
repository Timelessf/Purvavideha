package cn.purvavideha.moff.service.serviceImpl;

import cn.purvavideha.moff.dao.IAnimeExpoTypeDao;
import cn.purvavideha.moff.entity.AnimeExpoType;
import cn.purvavideha.moff.service.IAnimeExpoTypeService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @BelongsProject: moff
 * @BelongsPackage: cn.purvavideha.moff.service.serviceImpl
 * @Author: 朱喜亮
 * @CreateTime: 2019-01-04 10:48
 * @Description: 漫展类型service实现类
 * @Version: 1.0
 */
@Service
public class AnimeExpoTypeServiceImpl implements IAnimeExpoTypeService {

    @Resource
    private IAnimeExpoTypeDao animeExpoTypeDao;

    /*
    * @Description: 查全部漫展类型
    * @Param: [queryWrapper]
     * @return: java.util.List<cn.purvavideha.moff.entity.AnimeExpoType>
    * @Author: 朱喜亮
    * @Date: 11:02 2019/1/4
    */
    @Override
    public List<AnimeExpoType> queryAetList(Wrapper<AnimeExpoType> queryWrapper) {
        return animeExpoTypeDao.selectList(queryWrapper);
    }

    /*
     * @Description: 根据ID查漫展类型
     * @Param: [aetIdList]
     * @return: cn.purvavideha.moff.entity.AnimeExpoType
     * @Author: 朱喜亮
     * @Date: 10:50 2019/1/5
     */
    @Override
    public AnimeExpoType queryAetById(Integer aetID) {
        return animeExpoTypeDao.selectById(aetID);
    }

}
