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
@TableName("user_funs")
public class UserFuns implements Serializable{

  /**
   * 粉丝关系Id
   */
  @TableId(value = "uf_relation_id",type = IdType.AUTO)
  private int ufRelationId;

  /**
   * 用户Id
   */
  @TableField(value = "au_id")
  private int auId;

  /**
   * 粉丝Id
   */
  @TableField(value = "uf_fans_id")
  private int ufFansId;

}
