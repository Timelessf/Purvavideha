package cn.purvavideha.moff.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName("anime_expo")
public class AnimeExpo implements Serializable
{

  /**
   * 创建漫展 id
   */
  @TableId(value = "ae_id", type = IdType.AUTO)
  private int aeId;

  /**
   * 展会类型表 id
   */
  @TableField(value = "aet_id")
  private int aetId;

  /**
   *展会名称
   */
  @TableField(value = "ae_name")
  private String aeName;

  /**
   *展会 Logo
   */
  @TableField(value = "ae_logo")
  private String aeLogo;

  /**
   *上届展会名称
   */
  @TableField(value = "ae_old")
  private int aeOld;

  /**
   *展会开展时间
   */
  @TableField(value = "ae_starttime")
  private Date aeStarttime;

  /**
   *展会结束时间
   */
  @TableField(value = "ae_endtime")
  private Date aeEndtime;

  /**
   *展会举办地区
   */
  @TableField(value = "ae_address")
  private String aeAddress;

  /**
   *展会举办的 场馆
   */
  @TableField(value = "ae_venue")
  private int aeVenue;

  /**
   *乘坐的交通类型
   */
  @TableField(value = "ae_traffic")
  private int aeTraffic;

  /**
   *详细地址
   */
  @TableField(value = "ae_fulladdress")
  private String aeFulladdress;

  /**
   *  漫展售票 票价
   */
  @TableField(value = "ae_newfare")
  private double aeNewfare;

  /**
   * 场馆现场票价
   */
  @TableField(value = "ae_oldfare")
  private double aeOldfare;

  /**
   * 展会的标签
   */
  @TableField(value = "ae_lable")
  private String aeLable;

  /**
   * 信息来源  联系方式
   */
  @TableField(value = "ae_message")
  private String aeMessage;

}
