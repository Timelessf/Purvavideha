package cn.purvavideha.moff.service.serviceImpl;

import cn.purvavideha.moff.dao.IAnimeUserDao;
import cn.purvavideha.moff.entity.AnimeUser;
import cn.purvavideha.moff.service.IAnimeUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @BelongsProject: moff
 * @BelongsPackage: cn.purvavideha.moff.service.serviceImpl
 * @Author: 王墨霖
 * @CreateTime: 2019-01-04 10:03
 * @Author: 焦瑞敏
 * @CreateTime: 2019-01-04 13:22
 * @Description: 用户操作
 * @Version: 1.0
 */
@Service
public class AnimeUserServiceImpl implements IAnimeUserService {

    @Resource
    private IAnimeUserDao animeUserDao;


    /**
    * @Description: 查询所有的用户信息
    * @Param: []
    * @return: java.util.List<cn.purvavideha.moff.entity.AnimeUser>
    * @Author: 王墨霖
    * @Date: 19:04 2019/1/4
    */
    @Override
    public List<AnimeUser> queryselect() {
        return animeUserDao.queryselect();
    }

    /**
     * 新增用户信息
     * @Author: 王墨霖
     * @param user
     */
    @Override
    public boolean addIUser(AnimeUser user) {
        boolean flag = false;
        try {
            animeUserDao.addIUser(user);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /*  
    * @Description: 查看手机号是否存在（就是用户是否已注册） 
    * @Param: [phone] 
    * @return: boolean 
    * @Author: 焦瑞敏
    * @Date: 10:42 2019/1/5 
    */
    @Override
    public boolean updateUser(AnimeUser user) {
        boolean flag = false;
        try {
            animeUserDao.updateUser(user);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

   /*  
   * @Description: 判断用户是否存在 注册 并把用户信息添加到数据库
   * @Param: [animeUser] 
   * @return: boolean 
   * @Author: 焦瑞敏
   * @Date: 11:07 2019/1/5
   */
    @Override
    public boolean delUser(AnimeUser user) {
        boolean flag = false;
        try {
            animeUserDao.delUser(user);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /*
    * @Description: 注册用户  添加用户信息到数据库
    * @Param: [animeUser]
    * @return: int
    * @Author: 焦瑞敏
    * @Date: 11:07 2019/1/5
    */
    @Override
    public AnimeUser queryName(String auName) {
       return animeUserDao.queryName(auName);
    }

    /**
     * 根据用户Id进行查询
     * @Author: 王墨霖
     * @param auId
     * @return
     */

    @Override
    public AnimeUser queryById(int auId) {
        return animeUserDao.queryById(auId);
    }

    /**
     * 查询手机号码是否存在
     * @param phone
     * @return
     */
    @Override
    public boolean checkUserPhone(String phone) {
       /* boolean bl = false;
        try {
            animeUserDao.checkUserPhone(phone);
            bl = true;
        }catch (Exception e){
            e.printStackTrace();
        }*/
        return  false;
    }

    /**
     * 新增新的登录用户
     * 登录账户
     *
     */
    @Override
    public int addUser(AnimeUser animeUser)
    {
        return animeUserDao.insert(animeUser);
    }

    /*  
    * @Description: 查询手机号密码是否在表中
    * @Param:  
    * @return:  
    * @Author: 焦瑞敏
    * @Date: 13:31 2019/1/5
    */
    @Override
    public boolean queryAnimeUser(String auTele, String auPwd) {
        Map<String, Object> map = new HashMap<>();
        map.put("au_tele", auTele);
        map.put("au_pwd", auPwd);

        QueryWrapper<AnimeUser> qw = new QueryWrapper<>();
        qw.allEq(map);
        AnimeUser animeUser = animeUserDao.selectOne(qw);
        return animeUser != null;
    }


}
