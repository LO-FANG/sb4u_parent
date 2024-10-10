package com.drizzle.sb4u.service.contract.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: drizzle
 * @Date: 2024/10/09/21:07
 * @Description:
 */
@Data
@ApiModel("contract查询对象")
public class QueryContractBaseDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("合约名称")
    private String name;
    @ApiModelProperty("公司名称")
    private String companyName;
    @ApiModelProperty("标签")
    private String tag;
    @ApiModelProperty("大分类")
    private String mt;
    @ApiModelProperty("小分类")
    private String st;
    @ApiModelProperty("等级")
    private String grade;
    @ApiModelProperty("审核状态")
    private String auditStatus;
    @ApiModelProperty("发布状态")
    private Integer publishStatus;
}
