package cn.purvavideha.moff.service.serviceImpl;

import cn.purvavideha.moff.dao.IAnimePostedDao;
import cn.purvavideha.moff.entity.AnimePosted;
import cn.purvavideha.moff.service.IAnimePostedService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @BelongsProject: moff
 * @BelongsPackage: cn.purvavideha.moff.service.serviceImpl
 * @Author: 王振
 * @CreateTime: 2019-01-03 19:36
 * @Description:
 * @Version: 1.0
 */
@Service
public class AnimePostedServiceImpl implements IAnimePostedService {
    @Autowired
    private IAnimePostedDao iAnimePostedDao;

    /**
     * @Description: 发布帖子
     * @Param: [animePosted]
     * @return: int
     * @Author: 王振
     * @Date: 10:19 2019/1/5
     */
    @Override
    public int addPosted(AnimePosted animePosted) {
        /*String id=animePosted.getPostId()+" ";
        if (id!=null) {
            iAnimePostedDao.updateById(animePosted);
        }else {
            iAnimePostedDao.insert(animePosted);
        }*/
        int insert = iAnimePostedDao.insert(animePosted);
        return insert;
    }
    /**
     * @Description: 查看分页帖子内容
     * @Param: [queryWrapper]
     * @return: java.util.List<cn.purvavideha.moff.entity.AnimePosted>
     * @Author: 王振
     * @Date: 10:16 2019/1/5
     */
    @Override
    public IPage<AnimePosted> queryPostedPage(Page<AnimePosted> page) {
       /* QueryWrapper<AnimePosted> wrapper = new QueryWrapper<>();
        wrapper.like("post_title", animePosted.getPostTitle());
        if (animePosted.getPostId() != 0){
            wrapper.eq("post_id",animePosted.getPostId());
        }*/
        IPage<AnimePosted> animeExpoPage = iAnimePostedDao.selectPage(page,null);

        return animeExpoPage;
    }

    /**
    * @Description: 删除帖子
    * @Param: [animePosted]
    * @return: int
    * @Author: 王振
    * @Date: 16:03 2019/1/5
    */
    @Override
    public int deletePosted(AnimePosted animePosted) {
        return iAnimePostedDao.deleteById(animePosted);
    }


}
