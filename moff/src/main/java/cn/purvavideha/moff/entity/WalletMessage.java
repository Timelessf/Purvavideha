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
@TableName("waller_message")
public class WalletMessage implements Serializable{

  /**
   * 创建钱包信息id
   */
  @TableId(value = "wmsg_id", type = IdType.AUTO)
  private int wmsgId;

  /**
   * 用户id
   */
  @TableField(value = "au_id")
  private int auId;
  /**
   * 关联用户id
   */
  @TableId(value = "wmsg_link_user_id")
  private int wmsgLinkUserId;

  /**
   * 钱包收入支出
   */
  @TableField(value = "wmsg_income")
  private int wmsgIncome;

  /**
   * 操作类型
   */
  @TableField(value = "wmsg_type")
  private int wmsgType;

  /**
   * 操作金额
   */
  @TableField(value = "wmsg_money")
  private double wmsgMoney;

  /**
   * 操作日期
   */
  @TableField(value = "wmsg_date")
  private Date wmsgDate;

}
