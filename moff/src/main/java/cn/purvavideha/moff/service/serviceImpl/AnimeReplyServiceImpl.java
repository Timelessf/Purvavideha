package cn.purvavideha.moff.service.serviceImpl;

import cn.purvavideha.moff.dao.IAnimeReplyDao;
import cn.purvavideha.moff.entity.AnimeReply;
import cn.purvavideha.moff.service.IAnimeReplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @BelongsProject: moff
 * @BelongsPackage: cn.purvavideha.moff.service.serviceImpl
 * @Author: 刘甲哲
 * @CreateTime: 2019-01-04 10:26
 * @Description:
 * @Version: 1.0
 */
@Service
public class AnimeReplyServiceImpl implements IAnimeReplyService {

    @Resource
    private IAnimeReplyDao iAnimeReplyDao;

    /*
     * @Description: 添加评价实现
     * @Param: [animeReply]
     * @return: java.util.List<cn.purvavideha.moff.entity.AnimeReply>
     * @Author: 刘甲哲
     * @Date: 12:12 2019/1/4
     */
    @Override
    public int addEvaluate(AnimeReply animeReply) {
        int insert = iAnimeReplyDao.insert(animeReply);
        return insert;
    }

    /*
    * @Description: 评价查询 
    * @Param: [] 
    * @return: java.util.List<cn.purvavideha.moff.entity.AnimeReply> 
    * @Author: 刘甲哲
    * @Date: 15:42 2019/1/5 
    */ 
    @Override
    public List<AnimeReply> queryEvaluate() {
        List<AnimeReply> list = iAnimeReplyDao.selectList(null);
        return list;
    }
}
