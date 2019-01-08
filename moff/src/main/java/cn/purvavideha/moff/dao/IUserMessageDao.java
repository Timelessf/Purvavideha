package cn.purvavideha.moff.dao;

import cn.purvavideha.moff.entity.UserMessage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: moff
 * @BelongsPackage: cn.purvavideha.moff.dao
 * @Author: 吕名阳
 * @CreateTime: 2019-01-04 09:47
 * @Description: 用户·个人消息·持久层·接口
 * @Version: 1.0
 */

@Mapper
public interface IUserMessageDao extends BaseMapper<UserMessage> {

    /**
     * @Description: 根据用户id·分页查询·用户的个人消息
     * @Param: [page, auId]
     * @return: java.util.List<cn.purvavideha.moff.entity.UserMessage>
     * @Author: 吕名阳
     * @Date: 2019/1/4 14:45
     */
    @Select("SELECT um.msg_id,um.au_id,um.msg_type,au.au_name as send_name,um.msg_content,um.msg_date " +
            "FROM user_message AS um " +
            "LEFT JOIN anime_user AS au ON um.msg_send_id = au.au_id " +
            "WHERE um.au_id = #{auId} ")
    List<Map<String,Object>> getUserMessageByUserId(Page page, int auId);

}
