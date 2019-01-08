package cn.purvavideha.moff.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_collect")
public class UserCollect implements Serializable{

  /**
   * 发帖Id
   */
  @TableId(value = "post_id")
  private int postId;

  /**
   * 用户Id
   */
  @TableId(value = "au_id")
  private int auId;

}