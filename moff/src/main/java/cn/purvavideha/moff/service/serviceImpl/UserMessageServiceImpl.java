package cn.purvavideha.moff.service.serviceImpl;

import cn.purvavideha.moff.dao.IUserMessageDao;
import cn.purvavideha.moff.entity.UserMessage;
import cn.purvavideha.moff.service.IUserMessageService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: moff
 * @BelongsPackage: cn.purvavideha.moff.service.serviceImpl
 * @Author: 吕名阳
 * @CreateTime: 2019-01-04 09:52
 * @Description: 用户·个人消息·业务层·实现类
 * @Version: 1.0
 */
@Service
public class UserMessageServiceImpl implements IUserMessageService {

    @Resource
    private IUserMessageDao userMessageDao;

    /**
     * @Description: 根据用户id·分页查询·用户的个人消息
     * @Param: [auId, currentPage, pageSize]
     * @return: java.util.List<cn.purvavideha.moff.entity.UserMessage>
     * @Author: 吕名阳
     * @Date: 2019/1/4 16:15
     */
    @Override
    public List<Map<String, Object>> getUserMessageByUserId(Page page, int auId) {
        List<Map<String, Object>> userMessageByUserId = userMessageDao.getUserMessageByUserId(page, auId);
        return userMessageByUserId;
    }

    /**
     * @Description: 增加用户个人消息
     * @Param: [userMessage]
     * @return: void
     * @Author: 吕名阳
     * @Date: 2019/1/4 16:17
     */
    @Override
    public int addUserMessage(UserMessage userMessage) {
        return userMessageDao.insert(userMessage);
    }

    /**
     * @Description: 用户删除个人消息，即更改用户查询状态
     * @Param: [userMessage]
     * @return: void
     * @Author: 吕名阳
     * @Date: 2019/1/4 20:24
     */
    @Override
    public void updateUserMessage(int msgId) {
        //查询msgId的对象信息
        QueryWrapper<UserMessage> queryWrapper = new QueryWrapper<>();
        UserMessage userMessage = userMessageDao.selectById(msgId);
        //将查询状态0改为1
        userMessage.setMsgState(1);
        //更新数据库
        UpdateWrapper<UserMessage> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("msg_id", userMessage.getMsgId());
        userMessageDao.update(userMessage, updateWrapper);
    }
}