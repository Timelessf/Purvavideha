package cn.purvavideha.moff.service;

import cn.purvavideha.moff.entity.UserMessage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: moff
 * @BelongsPackage: cn.purvavideha.moff.service
 * @Author: 吕名阳
 * @CreateTime: 2019-01-04 09:50
 * @Description: 用户·个人消息·业务层·接口
 * @Version: 1.0
 */
public interface IUserMessageService {

    /**
     * @Description: 根据用户id·分页查询·用户的个人消息
     * @Param: [auId, currentPage, pageSize]
     * @return: List<UserMessage>
     * @Author: 吕名阳
     * @Date: 2019/1/4 16:13
     */
    List<Map<String,Object>> getUserMessageByUserId(Page<UserMessage> page, int auId);

    /**
     * @Description: 增加用户的个人消息
     * @Param: [userMessage]
     * @return: void
     * @Author: 吕名阳
     * @Date: 2019/1/4 16:14
     */
    int addUserMessage(UserMessage userMessage);

    /**
     * @Description: 用户删除个人消息，即更改用户查询状态
     * @Param: [userMessage]
     * @return: void
     * @Author: 吕名阳
     * @Date: 2019/1/4 20:21
     */
    void updateUserMessage(int msgId);
}
