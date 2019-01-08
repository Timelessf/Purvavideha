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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@TableName("anime_user")
public class AnimeUser implements Serializable{

  /**
   *用户 id
   */
  @TableId(value = "au_id",type = IdType.AUTO)
  private int auId;


    /**
     * 用户昵称
     */
  @TableField(value = "au_name")
  private String auName;

    /**
     * 用户电话及账户名
     */
  @TableField(value = "au_tele")
  private String auTele;

    /**
     * 用户登录密码
     */
  @TableField(value = "au_pwd")
  private String auPwd;

    /**
     * 用户年龄
     */
  @TableField(value = "au_age")
  private int auAge;

  /**
   * 用户性别
   */
  @TableField(value = "au_sex")
  private String auSex;

    /**
     * 用户的社交平台
     */
  @TableField(value = "au_socialPlat")
  private String auSocialPlat;


    /**
     * 用户的代表作
     */
  @TableId(value = "au_works")
  private String auWorks;

    /**
     * 用户的地址
     */
  @TableField(value = "au_address")
  private String auAddress;

    /**
     * 用户的邮箱
     */
  @TableField(value = "au_email")
  private String auEmail;

    /**
     * 用户的角色
     */
  @TableField(value = "au_role")
  private int auRole;


    /**
     * 用户的个人钱包余额
     */
  @TableField(value = "au_balance")
  private double auBalance;

    /**
     * 用户的个人消费
     */
  @TableField(value = "au_cons")
  private double auCons;

    /**
     * 用户的头像
     */
  @TableField(value = "au_avatar")
  private String auAvatar;

}
