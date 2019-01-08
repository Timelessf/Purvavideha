package cn.purvavideha.moff.controller;

import cn.purvavideha.moff.entity.UserMessage;
import cn.purvavideha.moff.service.IUserMessageService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: moff
 * @BelongsPackage: cn.purvavideha.moff.controller
 * @Author: 吕名阳
 * @CreateTime: 2019-01-04 09:56
 * @Description: 用户·个人消息·控制层·接口
 * @Version: 1.0
 */

@RestController
@RequestMapping("userMessage")
public class UserMessageController {

    @Resource
    private IUserMessageService userMessageService;

    /**
     * @Description: 根据用户id·分页查询·用户的个人消息
     * @Param: [currentPage, pageSize, auId]
     * @return: java.util.List<cn.purvavideha.moff.entity.UserMessage>
     * @Author: 吕名阳
     * @Date: 2019/1/4 16:16
     */
    @RequestMapping("/queryUserMessageByUserId")
    public List<Map<String,Object>> queryUserMessageByUserId(@RequestParam("currentPage") Integer currentPage,
                                                                 @RequestParam("pageSize") Integer pageSize, int auId) {
        Map map = new HashMap();
        Page<UserMessage> page = new Page<>(currentPage, pageSize);

        List<Map<String,Object>> listMessage = userMessageService.getUserMessageByUserId(page, auId);
        return listMessage;
    }

    /**
     * @Description: 增加用户个人消息
     * @Param: [userMessage]
     * @return: void
     * @Author: 吕名阳
     * @Date: 2019/1/4 16:16
     */
    @RequestMapping("/addUserMessage")
    public void addUserMessage(UserMessage userMessage) {
        userMessageService.addUserMessage(userMessage);
    }

    /**
    * @Description: 用户删除信息，即更改信息状态
    * @Param: [auId]
    * @return: void
    * @Author: 吕名阳
    * @Date: 2019/1/5 16:15
    */
    @RequestMapping("/delUserMessage")
    public void delUserMessage(int msgId){
        userMessageService.updateUserMessage(msgId);
    }

}
