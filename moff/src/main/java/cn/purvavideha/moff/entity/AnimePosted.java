package cn.purvavideha.moff.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("anime_posted")
public class AnimePosted implements Serializable{

  /**
   * 论坛发帖 id
   * 主键自增长
   */
  @TableId(value = "post_id",type = IdType.AUTO)
  private int postId;
  /**
   * 论坛版快 id
   */
  @TableField(value = "section_id")
  private int sectionId;
  /**
   * 用户 id
   */
  @TableField(value = "au_id")
  private int auId;
  /**
   * 发帖类型
   */
  @TableField(value = "post_type")
  private int postType;
  /**
   * 发帖标题
   */
  @TableField(value = "post_title")
  private String postTitle;
  /**
   * 发帖内容
   */
  @TableField(value = "post_content")
  private String postContent;
  /**
   * 发帖标签
   */
  @TableField(value = "post_label")
  private String postLabel;
  /**
   * 发帖版块
   */
  @TableField(value = "post_section")
  private String postSection;
  /**
   * 发帖时间
   */
  @JsonFormat(pattern = "yyyyMMddHHmmssSSS", timezone="GMT+8")
  @TableField(value = "post_time")
  private Date postTime;
  /**
   * 发帖图片
   */
  @TableField(value = "post_picture")
  private String postPicture;

}
