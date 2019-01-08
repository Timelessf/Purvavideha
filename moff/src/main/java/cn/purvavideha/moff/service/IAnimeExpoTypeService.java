package cn.purvavideha.moff.service;

import cn.purvavideha.moff.entity.AnimeExpoType;
import com.baomidou.mybatisplus.core.conditions.Wrapper;

import java.util.List;

/**
 * @BelongsProject: moff
 * @BelongsPackage: cn.purvavideha.moff.service
 * @Author: 朱喜亮
 * @CreateTime: 2019-01-04 10:48
 * @Description: 漫展类型service接口
 * @Version: 1.0
 */
public interface IAnimeExpoTypeService {

    /*
    * @Description: 查全部漫展类型 
    * @Param: [queryWrapper]
    * @return: java.util.List<cn.purvavideha.moff.entity.AnimeExpoType> 
    * @Author: 朱喜亮
    * @Date: 11:02 2019/1/4
    */ 
    List<AnimeExpoType> queryAetList(Wrapper<AnimeExpoType> queryWrapper);

    /*  
    * @Description: 根据ID查漫展类型
    * @Param: [aet_id] 
    * @return: cn.purvavideha.moff.entity.AnimeExpoType 
    * @Author: 朱喜亮
    * @Date: 10:48 2019/1/5 
    */
    AnimeExpoType queryAetById(Integer aetID);
}
