package cn.purvavideha.moff.service;

import cn.purvavideha.moff.entity.AnimeReply;

import java.util.List;

/**
 * @BelongsProject: moff
 * @BelongsPackage: cn.purvavideha.moff.service
 * @Author: 刘甲哲
 * @CreateTime: 2019-01-04 10:25
 * @Description: ${Description}
 * @Version: 1.0
 */
public interface IAnimeReplyService {

    /*
     * @Description: 添加评价
     * @Param: [animeReply]
     * @return: java.util.List<cn.purvavideha.moff.entity.AnimeReply>
     * @Author: 刘甲哲
     * @Date: 14:30 2019/1/4
     */
    int addEvaluate(AnimeReply animeReply);

    /*
     * @Description: 查询评价
     * @Param: []
     * @return: java.util.List<cn.purvavideha.moff.entity.AnimeReply>
     * @Author: 刘甲哲
     * @Date: 16:49 2019/1/4
     */
    List<AnimeReply> queryEvaluate();
}
