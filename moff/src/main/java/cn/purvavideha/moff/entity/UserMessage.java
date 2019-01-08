package cn.purvavideha.moff.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_message")
public class UserMessage implements Serializable{

  /**
   * 个人消息Id
   */
  @TableId(value = "msg_id",type = IdType.AUTO)
  private int msgId;

  /**
   * 用户Id
   */
  @TableField(value = "au_id")
  private int auId;

  /**
   * 发信人Id
   */
  @TableField(value = "msg_send_id")
  private int msgSendId;

  /**
   * 类型
   */
  @TableField(value = "msg_type")
  private int msgType;

  /**
   * 内容
   */
  @TableField(value = "msg_content")
  private String msgContent;

   /**
   * 时间
   */
  @TableField(value = "msg_date")
  private Date msgDate;

  /**
   * 信息状态
   * 默认为0，即用户可以查看
   * 删除为1，即用户删除，不可查看
   */
  @TableField(value = "msg_state")
  private int msgState;

}

