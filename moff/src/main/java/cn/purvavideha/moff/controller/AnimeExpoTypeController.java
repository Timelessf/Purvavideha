package cn.purvavideha.moff.controller;

import cn.purvavideha.moff.entity.AnimeExpoType;
import cn.purvavideha.moff.service.serviceImpl.AnimeExpoTypeServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: moff
 * @BelongsPackage: cn.purvavideha.moff.controller
 * @Author: 朱喜亮
 * @CreateTime: 2019-01-04 11:05
 * @Description: 漫展类型control
 * @Version: 1.0
 */
@RestController
@RequestMapping("animeExpoType")
public class AnimeExpoTypeController {

    @Resource
    private AnimeExpoTypeServiceImpl animeExpoTypeService;

    /*
    * @Description: 全部漫展类型
    * @Param: []
    * @return: java.util.Map
    * @Author: 朱喜亮
    * @Date: 11:09 2019/1/4
    */
    @RequestMapping("getAetList")
    public Map queryAnimeExpoTypeList(){
        Map map = new HashMap();
        List<AnimeExpoType> animeExpoTypes = animeExpoTypeService.queryAetList(new QueryWrapper<AnimeExpoType>());
        map.put("aetList",animeExpoTypes);
        return map;
    }
}
