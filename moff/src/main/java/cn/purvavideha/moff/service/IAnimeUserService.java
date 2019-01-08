package cn.purvavideha.moff.service;

import cn.purvavideha.moff.entity.AnimeUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @BelongsProject: moff
 * @BelongsPackage: cn.purvavideha.moff.service
 * @Author: 王墨霖
 * @CreateTime: 2019-01-04 10:02
 * @Description: 用户接口
 * @Version: 1.0
 */
@Mapper
public interface IAnimeUserService {

    /**
     * 查询用户所有的信息
     * @Author: 王墨霖
     * @param
     * @return
     */
    List<AnimeUser> queryselect();

    /**
     * 新增用户信息
     * @Author: 王墨霖
     * @param user
     */
    boolean addIUser(AnimeUser user);

    /**
     * 修改用户信息
     * @Author: 王墨霖
     */
    boolean updateUser(AnimeUser user);

    /**
     * 删除用户信息
     * @Author: 王墨霖
     * @param user
     * @return
     */
    boolean delUser(AnimeUser user);

    /**
     * 通过用户的名字查询用户的信息
     * @Author: 王墨霖
     * @param auName
     * @return
     */
    AnimeUser queryName(String auName);

    /**
     * 根据用户Id进行查询
     * @Author: 王墨霖
     * @param auId
     * @return
     */
     AnimeUser queryById(int auId);

    /**
     * 判断用户用户是否存在
     * @param phone
     * @return
     */
     boolean checkUserPhone(String phone);


    /*
   * @Description: 添加用户信息到数据库
   * @Param: [animeUser]
   * @return: int
   * @Author: 焦瑞敏
   * @Date: 11:06 2019/1/5
   */
    int addUser(AnimeUser animeUser);

    /*
    * @Description: 查询用户账户和密码 
    * @Param:  
    * @return:  
    * @Author: 焦瑞敏
    * @Date: 11:15 2019/1/5
    */
    boolean queryAnimeUser(String auTele, String auPwd);


}
