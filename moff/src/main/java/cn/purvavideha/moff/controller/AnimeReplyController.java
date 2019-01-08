package cn.purvavideha.moff.controller;

import cn.purvavideha.moff.entity.AnimeReply;
import cn.purvavideha.moff.service.IAnimeReplyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @BelongsProject: moff
 * @BelongsPackage: cn.purvavideha.moff.controller
 * @Author: 刘甲哲
 * @CreateTime: 2019-01-04 15:55
 * @Description: 回帖，评价
 * @Version: 1.0
 */
@RestController
@RequestMapping("animeReply")
public class AnimeReplyController {

    @Resource
    private IAnimeReplyService iAnimeReplyService;

    /*
     * @Description: 添加评价
     * @Param: [animeReply]
     * @return: java.lang.String
     * @Author: 刘甲哲
     * @Date: 16:39 2019/1/4
     */
    @RequestMapping("/addEvaluate")
    public String addEvaluate(AnimeReply animeReply) {

        animeReply.setPostId(9);
        animeReply.setAeId(9);
        animeReply.setAuId(9);
        animeReply.setPostId(9);
        animeReply.setReplyContent("2019我一定要变优秀");
        animeReply.setReplyStar(3);
        int i = iAnimeReplyService.addEvaluate(animeReply);
        System.out.println("添加成功");
        return "addEvaluate";
    }


    /*
    * @Description: 评价查询 
    * @Param: [] 
    * @return: java.util.List<cn.purvavideha.moff.entity.AnimeReply> 
    * @Author: 刘甲哲
    * @Date: 15:42 2019/1/5 
    */ 
    @RequestMapping("/queryEvaluate")
    public List<AnimeReply> queryEvaluate() {
        List<AnimeReply> list = iAnimeReplyService.queryEvaluate();
        System.out.println(list);
        return list;
    }
}
