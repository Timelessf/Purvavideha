package cn.purvavideha.moff.controller;

import cn.purvavideha.moff.entity.AnimeExpo;
import cn.purvavideha.moff.entity.AnimeExpoType;
import cn.purvavideha.moff.service.serviceImpl.AnimeExpoServiceImpl;
import cn.purvavideha.moff.service.serviceImpl.AnimeExpoTypeServiceImpl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.*;

/**
 * @BelongsProject: moff
 * @BelongsPackage: cn.purvavideha.moff.controller
 * @Author: 朱喜亮
 * @CreateTime: 2019-01-04 10:09
 * @Description: 漫展cotrol
 * @Version: 1.0
 */
@Getter
@Setter
@RestController
@RequestMapping("animeExpo")
public class AnimeExpoController {

    @Resource
    private AnimeExpoServiceImpl animeExpoService;

    @Resource
    private AnimeExpoTypeServiceImpl animeExpoTypeServiceImpl;

    /*
     * @Description: 跳转到漫展首页
     * @Param: []
     * @return: org.springframework.web.servlet.ModelAndView
     * @Author: 朱喜亮
     * @Date: 10:16 2019/1/4
     */
    @RequestMapping("toManzhan")
    public ModelAndView toManzhan() {
        return new ModelAndView("manzhan");
    }

    /*
    * @Description: 分页查漫展数据 
    * @Param: [pageNum, pageSize, animeExpo] 
    * @return: java.util.Map 
    * @Author: 朱喜亮
    * @Date: 17:13 2019/1/4 
    */ 
    @RequestMapping("getAePageList")
    public Map queryAePageList(int pageCurrent, int pageSize,AnimeExpo animeExpo){
        Map map = new HashMap();
        Page<AnimeExpo> page = new Page<>(pageCurrent,pageSize);
        IPage<AnimeExpo> animeExpoIPage = animeExpoService.queryAePage(page,animeExpo);
        //得到漫展数据
        List<AnimeExpo> animeExpoList = animeExpoIPage.getRecords();
        map.put("page",animeExpoList);

        List animeExpoTypelist = new ArrayList();

        for (AnimeExpo expo : animeExpoList) {
            AnimeExpoType animeExpoType = animeExpoTypeServiceImpl.queryAetById(expo.getAetId());
            animeExpoTypelist.add(animeExpoType.getAetName());
        }

        System.out.println(animeExpoTypelist);
        //漫展总条数
        map.put("totalPage",animeExpoIPage.getTotal());

        //漫展类型
        map.put("animeExpoTypelist",animeExpoTypelist);
        return map;
    }

    /*
     * @Description: 获取单个漫展信息
     * @Param: [ae_id]
     * @return: org.springframework.web.servlet.ModelAndView
     * @Author: 季怀斌
     * @Date: 14:32 2019/1/4
     */
    @GetMapping("/queryExpoDetail/{ae_id}")
    public ModelAndView showExpoDetail(@PathVariable("ae_id") Integer ae_id) {
        AnimeExpo animeExpo = animeExpoService.getAnimeExpoById(ae_id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("animeExpo", animeExpo);
        mv.setViewName("ExpoDeatil");
        return mv;
    }

}
