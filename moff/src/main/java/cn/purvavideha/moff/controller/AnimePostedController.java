package cn.purvavideha.moff.controller;

import cn.purvavideha.moff.entity.AnimePosted;
import cn.purvavideha.moff.entity.Result;
import cn.purvavideha.moff.service.IAnimePostedService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @BelongsProject: moff
 * @BelongsPackage: cn.purvavideha.moff.controller
 * @Author: 王振
 * @CreateTime: 2019-01-04 09:55
 * @Description:
 * @Version: 1.0
 */
@RestController
@Getter
@Setter
@RequestMapping("animePosted")
public class AnimePostedController {

    @Resource
    private IAnimePostedService iAnimePostedService;


    /**
     * @Description: 跳转到发布帖子页面
     * @Param:
     * @return:
     * @Author: 王振
     * @Date: 10:06 2019/1/5
     */
    @RequestMapping("/addPosted")
    public ModelAndView addPosted() {
        return new ModelAndView("addposted");
    }

    /**
     * @Description: 发布普通帖子
     * @Param: []
     * @return: int
     * @Author: 王振
     * @Date: 10:03 2019/1/4
     */
    @RequestMapping("addpuposted")
    public Result posted(AnimePosted animePosted) {
        /*animePosted.setSectionId(7);
        animePosted.setAuId(8);
        animePosted.setPostType(1);
        animePosted.setPostTitle("西游记");
        animePosted.setPostContent("四大名著");
        animePosted.setPostLabel("西天取经");
        animePosted.setPostSection("九九八十一难");
        animePosted.setAuId(555);
        animePosted.setPostTitle("水浒传");*/
        /*animePosted.setPostTitle("post_type");
        animePosted.setPostContent("post_content");
        animePosted.setPostSection("post_section");*/
        int i = iAnimePostedService.addPosted(animePosted);
        System.out.println("发布成功!!!!!");
        return new Result();
    }

    /**
     * @Description: 跳转到展示帖子页面
     * @Param:
     * @return:
     * @Author: 王振
     * @Date: 10:06 2019/1/5
     */
    @RequestMapping("/showPosted")
    public ModelAndView showPosted() {
        return new ModelAndView("showPosted");
    }

    /**
     * @Description: 展示帖子内容
     * @Param:
     * @return:
     * @Author: 王振
     * @Date: 10:21 2019/1/5
     */
    @RequestMapping("getPostedPage")
    public Map queryPostedPage(int pageCurrent, int pageSize) {
        Map map = new HashMap();
        Page<AnimePosted> page = new Page<>(pageCurrent,pageSize);
        IPage<AnimePosted> animePostedIPage = iAnimePostedService.queryPostedPage(page);
        //得到发帖数据
        List<AnimePosted> animePostedList = animePostedIPage.getRecords();
        map.put("page",animePostedList);
        //发帖总条数
        map.put("totalPage",animePostedIPage.getTotal());
        return map;
    }
    /**  
    * @Description: 删除帖子 
    * @Param: [animePosted] 
    * @return: cn.purvavideha.moff.entity.Result 
    * @Author: 王振
    * @Date: 16:08 2019/1/5 
    */ 
    @RequestMapping("deletePosted")
    public Result deletePosted(AnimePosted animePosted) {
        iAnimePostedService.deletePosted(animePosted);
        return new Result();
    }

}
