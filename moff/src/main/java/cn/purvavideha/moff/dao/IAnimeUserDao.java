package cn.purvavideha.moff.dao;

import cn.purvavideha.moff.entity.AnimeUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @BelongsProject: moff
 * @BelongsPackage: cn.purvavideha.moff.dao
 * @Author: 王墨霖，焦瑞敏
 * @CreateTime: 2019-01-04 09:53
 * @Description: 用户信息查询
 * @Version: 1.0
 */
@Mapper
public interface IAnimeUserDao extends BaseMapper<AnimeUser> {
    /**
     * 查询所用的用户信息
     * @Author: 王墨霖
     * @return
     */
    @Select("select * from anime_user")
     List<AnimeUser> queryselect();

    /**
     * 新增用户信息
     * @Author: 王墨霖
     * @param user
     */
    @Insert("insert into anime_user(au_id,au_name,au_tele,au_pwd,au_age,au_sex,au_socialPlat,au_works,au_address,au_email,au_role,au_balance,au_cons,au_avatar)" +
            " values(#{auId},#{auName},#{auTele},#{auPwd},#{auAge},#{auSex},#{auSocialPlat},#{auWorks},#{auAddress},#{auEmail},#{auRole},#{auBalance},#{auCons},#{auAvatar})")
    void addIUser(AnimeUser user);

    /**
     * 修改用户信息
     * @Author: 王墨霖
     * @param user
     */
    @Update("update anime_user set " +
            "au_name = #{auName}," +
            "au_tele = #{auTele}," +
            "au_pwd =#{auPwd}," +
            "au_age = #{auAge}," +
            "au_sex = #{auSex}," +
            "au_socialPlat = #{auSocialPlat}," +
            "au_works = #{auWorks}," +
            "au_address = #{auAddress}," +
            "au_email = #{auEmail}," +
            "au_role = #{auRole}," +
            "au_balance = #{auBalance}," +
            "au_cons = #{auCons}," +
            "au_avatar = #{auAvatar}" +
            " where au_id = #{auId}")
    void updateUser(AnimeUser user);

    /**
     * 删除用户信息
     * @Author: 王墨霖
     * @param user
     */
    @Delete("delete from anime_user where au_id = #{auId}")
    void delUser(AnimeUser user);

    /**
     * 通过用户名字来进行用户信息查询
     * @Author: 王墨霖
     * @param auName
     * @return
     */
    @Select("select au_id,au_tele,au_pwd,au_age,au_sex,au_socialPlat,au_works,au_address,au_email,au_role,au_balance,au_cons,au_avatar from anime_user where au_name = #{auName}")
    AnimeUser queryName(String auName);

    /**
     * 根据用户Id查询信息
     * @Author: 王墨霖
     */
    @Select("select * from anime_user where au_id = #{auId}")
     AnimeUser queryById(int auId);

    /**
     * 查询手机号码是否存在
     * @param
     */
    @Select("select au_tele from anime_user where au_id = #{auId}")
    void checkUserPhone(String phone);


}
