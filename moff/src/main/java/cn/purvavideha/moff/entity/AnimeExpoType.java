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
@TableName("anime_expo_type")
public class AnimeExpoType implements Serializable
{


  /**
   * 展会类型id
   */
  @TableId(value = "aet_id")
  private int aetId;


  /**
   *   展会类型名字
   */
  @TableId(value = "aet_name")
  private String aetName;

}
