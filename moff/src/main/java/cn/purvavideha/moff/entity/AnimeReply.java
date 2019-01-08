package cn.purvavideha.moff.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AnimeReply implements Serializable{
  /**
   * 回帖id
   * 主键自增
   */
  @TableId(value = "reply_id",type = IdType.AUTO)
  private int replyId;
  /**
   * 发帖id
   */
  @TableField(value = "post_id")
  private int postId;
  /**
   * 用户id
   */
  @TableField(value = "au_id")
  private int auId;
  /**
   * 漫展id
   */
  @TableField(value = "ae_id")
  private int aeId;
  /**
   * 回帖类型
   */
  @TableField(value = "reply_type")
  private int replyType;
  /**
   * 回帖内容
   */
  @TableField(value = "reply_content")
  private String replyContent;
  /**
   * 回帖时间
   */
  @JsonFormat(pattern = "yyyyMMddHHmmssSSS", timezone="GMT+8")
  @TableField(value = "reply_time")
  private Date replyTime;
  /**
   * 回帖评价（小星星）
   */
  @TableField(value = "reply_star")
  private int replyStar;
  /**
   * 根据发帖id回复
   */
  @TableField(value = "rpost_id")
  private int rpostId;

}