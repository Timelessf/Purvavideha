package cn.purvavideha.moff.controller;




import cn.purvavideha.moff.entity.AnimeUser;
import cn.purvavideha.moff.service.IAnimeUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * @BelongsProject: moff
 * @BelongsPackage: cn.purvavideha.moff.controller
 * @Author: 王墨霖
 * @CreateTime: 2019-01-04 10:18
 * @Description: 用户的controller层
 * @Version: 1.0
 */

@RestController
@RequestMapping("animeuser")
public class AnimeUserController {

    @Resource
    private IAnimeUserService animeUserService;

    /**
     * 查询所有的用户信息
     * @Author: 王墨霖
     * @return
     */
    @RequestMapping("/serAll") //跳转到上传文件的页面
    public List<AnimeUser> queryselect(){
        List<AnimeUser> users = animeUserService.queryselect();
        return users;
    }

    /**
     * 增加新的用户信息
     * @Author: 王墨霖
     * @param user
     * @return
     */
    @RequestMapping("/addUser")
    public boolean addIUser(AnimeUser user){
        System.out.println("新增用户");
       return animeUserService.addIUser(user);
    }

    /**
     * 修改用户信息
     * @Author: 王墨霖
     * @param user
     * @return
     */
    @RequestMapping("/updateUser")
    public boolean updateUser(AnimeUser user){
        System.out.println("修改用户");
        return animeUserService.updateUser(user);
    }

    /**
     * 删除用户信息
     * @Author: 王墨霖
     * @param user
     * @return
     */
    @RequestMapping("/delUser")
    public boolean delUser(AnimeUser user){
        System.out.println("删除用户");
        return animeUserService.delUser(user);
    }

    /**
     * 通过用户名字进行查询
     * @Author: 王墨霖
     * @param auName
     * @return
     */
    @RequestMapping("/queryauName")
    public AnimeUser queryauName(String auName){
        System.out.println("通过用户的名字进行查询");
        return animeUserService.queryName(auName);
    }

    /**
     * 根据Id进行查询用户信息
     * @Author: 王墨霖
     * @param auId
     * @return
     */
    @RequestMapping("/query")
    public AnimeUser queryById(int auId){
        System.out.println("开始查询");
        return animeUserService.queryById(auId);
    }

    /**
     * 查看手机号是否存在
     * @param phone
     * @return
     */
    @RequestMapping("/checkUserPhone")
    public boolean checkUserPhone(String phone){
    System.out.println("查看手机号是否存在");
    return  animeUserService.checkUserPhone(phone);
}

}
