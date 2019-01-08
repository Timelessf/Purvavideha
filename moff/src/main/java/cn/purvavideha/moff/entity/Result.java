package cn.purvavideha.moff.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @BelongsProject: moff
 * @BelongsPackage: cn.purvavideha.moff.entity
 * @Author: 王振
 * @CreateTime: 2019-01-05 15:23
 * @Description:
 * @Version: 1.0
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {
    //业务代码
    private int code;
    //业务消息
    private String message;
    //业务数据
    private List<Object> data;
}

