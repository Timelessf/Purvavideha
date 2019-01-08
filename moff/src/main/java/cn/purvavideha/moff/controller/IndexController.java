package cn.purvavideha.moff.controller;

import cn.purvavideha.moff.entity.AnimeUser;
import cn.purvavideha.moff.service.IAnimeUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;


/**
 * @BelongsProject: moff
 * @BelongsPackage: cn.purvavideha.moff.controller
 * @Author: 焦瑞敏
 * @CreateTime: 2019-01-04 11:04
 * @Description: 登录
 * @Version: 1.0
 */

@RestController
@RequestMapping("index")
public class  IndexController {

    @Resource
    private IAnimeUserService animeUserService;
    private AnimeUser animeUser = new AnimeUser();



   /*
   * @Description: 注册
   * @Param: [animeUser]
   * @return: java.lang.String
   * @Author: 焦瑞敏
   * @Date: 11:10 2019/1/5
   */
   @GetMapping("/register")
    public String register(AnimeUser animeUser) {
        animeUserService.addUser(animeUser);
        return "成功";
    }

    /*
    * @Description:登录
    * @Param: []
    * @return: java.lang.String
    * @Author: 焦瑞敏
    * @Date: 20:41 2019/1/4
    */
    @RequestMapping("/login")
    public ModelAndView login(AnimeUser animeUser) {
        String phone = animeUser.getAuTele();
        String pwd = animeUser.getAuPwd();
        boolean succ = animeUserService.queryAnimeUser(phone, pwd);
        ModelAndView mv = new ModelAndView();

        if (succ == true){
            mv.addObject("animeUser", animeUser);
            mv.setViewName("Home");
        }else {
            mv.setViewName("login");
        }

        return mv;
    }

}
