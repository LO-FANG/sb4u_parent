package com.drizzle.sb4u.service.contract.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.drizzle.sb4u.service.base.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 合约基本信息表，用于存储合约的基本信息
 * </p>
 *
 * @author drizzle
 * @since 2024-10-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_contract_base")
@ApiModel(value="ContractBase对象", description="合约基本信息表，用于存储合约的基本信息")
public class ContractBase extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "公司id")
    private Long companyId;

    @ApiModelProperty(value = "公司名称")
    private String companyName;

    @ApiModelProperty(value = "合约标签")
    private String tag;

    @ApiModelProperty(value = "大分类")
    private String mt;

    @ApiModelProperty(value = "小分类")
    private String st;

    @ApiModelProperty(value = "合约等级")
    private String grade;

    @ApiModelProperty(value = "介绍")
    private String description;

    @ApiModelProperty(value = "创建者")
    private String createPeople;

    @ApiModelProperty(value = "更新者")
    private String updatePeople;

    @ApiModelProperty(value = "审核状态")
    private String auditStatus;

    @ApiModelProperty(value = "发布状态")
    private Integer publishStatus;

    @ApiModelProperty(value = "是否删除")
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;


}