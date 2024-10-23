package com.drizzle.sb4u.service.contract.controller.admin;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.drizzle.sb4u.common.base.result.PageParams;
import com.drizzle.sb4u.common.base.result.R;
import com.drizzle.sb4u.service.contract.entity.dto.AddContractBaseDto;
import com.drizzle.sb4u.service.contract.entity.dto.QueryContractBaseDto;
import com.drizzle.sb4u.service.contract.entity.dto.UpdateContractBaseDto;
import com.drizzle.sb4u.service.contract.entity.po.ContractBase;
import com.drizzle.sb4u.service.contract.service.ContractBaseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 合约基本信息表，用于存储合约的基本信息 前端控制器
 * </p>
 *
 * @author drizzle
 * @since 2024-10-08
 */
@CrossOrigin
@RestController
@RequestMapping("admin/sb4u/contract")
public class ContractBaseController {

    @Autowired
    private ContractBaseService contractBaseService;

    @ApiOperation("所有智能合约列表")
    @GetMapping("/list")
    public R listAll() {
        List<ContractBase> list = contractBaseService.list();
        return R.ok().data("items", list);
    }

    @ApiOperation("所有智能合约列表")
    @GetMapping("/get/{id}")
    public R getById(@ApiParam(value = "合约id", required = true) @PathVariable String id) {
        ContractBase contractBase = contractBaseService.getById(id);
        if(contractBase != null) {
            return R.ok().data("item", contractBase);
        } else {
            return R.error().message("数据不存在");
        }
    }

    @ApiOperation(value = "根据ID删除智能合约", notes = "根据ID删除智能合约")
    @DeleteMapping("/remove/{id}")
    public R removeById(@ApiParam(value = "智能合约ID", required = true) @PathVariable("id") String id) {
        boolean b = contractBaseService.removeById(id);
        if(b) {
            return R.ok().message("删除成功");
        } else {
            return R.error().message("删除失败");
        }
    }

    @ApiOperation(value = "获取合约分页列表", notes = "获取合约分页列表")
    @GetMapping("/listpage/{pageNo}/{pageSize}")
    public R listPage(@PathVariable Long pageNo, @PathVariable Long pageSize,
                      @ApiParam("contract查询条件对象") QueryContractBaseDto queryContractBaseDto) {
        PageParams pageParams = new PageParams();
        if(pageNo != null && pageSize != null) {
            pageParams.setPageNo(pageNo);
            pageParams.setPageSize(pageSize);
        }
        IPage<ContractBase> pageResult = contractBaseService.selectPage(pageParams, queryContractBaseDto);
        List<ContractBase> contractBaseList =pageResult.getRecords();

        Long total = pageResult.getTotal();
        return R.ok().data("total", total).data("rows", contractBaseList);
    }

    @ApiOperation(value = "修改合约信息", notes = "修改合约信息")
    @PutMapping("/update")
    public R updateById(@ApiParam("更新合约信息") @RequestBody UpdateContractBaseDto updateContractBaseDto) {
        //获取合约id
        String id = updateContractBaseDto.getId();
        ContractBase contractBase = contractBaseService.getById(id);
        if(contractBase == null) {
            return R.error().message("合约不存在");
        }
        BeanUtils.copyProperties(updateContractBaseDto, contractBase);
        boolean b = contractBaseService.updateById(contractBase);
        if(b) {
            return R.ok().data("data", contractBase).message("修改成功");
        } else {
            return R.error().data("data", contractBase).message("修改失败");
        }
    }

    @ApiOperation(value = "新增合约信息", notes = "新增合约信息")
    @PostMapping("/save")
    public R add(@ApiParam("新增合约信息") @RequestBody AddContractBaseDto addContractBaseDto) {
        ContractBase contractBase = new ContractBase();
        BeanUtils.copyProperties(addContractBaseDto, contractBase);

        contractBase.setAuditStatus("80001");
        contractBase.setPublishStatus("90001");

        boolean save = contractBaseService.save(contractBase);

        if(save) {
            return R.ok().message("添加成功").data("data", contractBase);
        } else {
            return R.error().message("添加失败").data("data", contractBase);
        }
    }
}

