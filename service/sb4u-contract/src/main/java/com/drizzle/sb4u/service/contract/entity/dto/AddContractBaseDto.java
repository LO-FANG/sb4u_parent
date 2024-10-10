package com.drizzle.sb4u.service.contract.entity.dto;

import com.drizzle.sb4u.service.base.handler.ValidationGroups;
import com.drizzle.sb4u.service.contract.entity.po.ContractBase;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: drizzle
 * @Date: 2024/10/10/9:11
 * @Description:
 */
@Data
@ApiModel("新增合约基本信息")
public class AddContractBaseDto{

    @NotEmpty(message = "公司名称不能为空", groups = {ValidationGroups.Inster.class})
    @ApiModelProperty(value = "公司名称")
    public String companyName;

    @NotEmpty(message = "合约名称不能为空", groups = {ValidationGroups.Inster.class})
    @ApiModelProperty(value = "合约名称")
    public String name;

    @ApiModelProperty(value = "合约标签")
    public String tag;

    @ApiModelProperty(value = "大分类")
    public String mt;

    @ApiModelProperty(value = "小分类")
    public String st;

    @ApiModelProperty(value = "合约等级")
    public String grade;

    @ApiModelProperty(value = "合约描述")
    public String description;

    @ApiModelProperty(value = "附件地址")
    public String file;

}
