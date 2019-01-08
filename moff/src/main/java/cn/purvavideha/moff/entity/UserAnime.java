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
@TableName("user_anime")
public class UserAnime implements Serializable{

  /**
   * 用户id
   */
  @TableId(value = "au_id")
  private int auId;

  /**
   * 漫展id
   */
  @TableId(value = "ae_id")
  private int aeId;

}
