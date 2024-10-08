package com.drizzle.sb4u.service.contract.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.drizzle.sb4u.service.base.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 合约分类表，用于存储合约的分类信息
 * </p>
 *
 * @author drizzle
 * @since 2024-10-08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("t_contract_category")
@ApiModel(value="ContractCategory对象", description="合约分类表，用于存储合约的分类信息")
public class ContractCategory extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "分类名称")
    private String name;

    @ApiModelProperty(value = "分类标签，便于识别和搜索")
    private String label;

    @ApiModelProperty(value = "父级分类ID，用于构建分类树")
    private String parentId;

    @ApiModelProperty(value = "是否显示该分类，0为不显示，1为显示")
    @TableField("is_show")
    private Boolean show;

    @ApiModelProperty(value = "排序值，值越大排序越靠后")
    private Integer orderby;

    @ApiModelProperty(value = "是否是叶子节点，0为非叶子节点，1为叶子节点")
    @TableField("is_leaf")
    private Boolean leaf;

    @ApiModelProperty(value = "是否删除")
    @TableField("is_deleted")
    @TableLogic
    private Boolean deleted;


}
