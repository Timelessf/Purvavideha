package cn.purvavideha.moff.service;

import cn.purvavideha.moff.entity.AnimePosted;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * @BelongsProject: moff
 * @BelongsPackage: cn.purvavideha.moff.service
 * @Author: 王振
 * @CreateTime: 2019-01-03 19:35
 * @Description:
 * @Version: 1.0
 */
public interface IAnimePostedService {
    /**
    * @Description: 分页查贴子数据
    * @Param: [animePosted]
    * @return: int
    * @Author: 王振
    * @Date: 10:09 2019/1/5
    */
    int addPosted(AnimePosted animePosted);

    /**
     * @Description: 查看帖子全部内容
     * @Param:
     * @return:
     * @Author: 王振
     * @Date: 10:08 2019/1/5
     */
    IPage<AnimePosted> queryPostedPage(@Param("pg") Page<AnimePosted> page);

    /**
     * @Description: 根据删除帖子
     * @Param:
     * @return:
     * @Author: 王振
     * @Date: 16:02 2019/1/5
     */
    int deletePosted(AnimePosted animePosted);
}
