package cn.purvavideha.moff.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("anime_section")
public class AnimeSection implements Serializable{
  /**
   *版块id
   * 主键自增
   */
  @TableId(value = "section_id",type = IdType.AUTO)//主键自增长
  private int sectionId;
  /**
   * 板块名字
   */
  @TableField(value = "section_name")
  private String sectionName;

}
