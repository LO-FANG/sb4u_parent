package com.drizzle.sb4u.service.contract.controller.admin;


import com.drizzle.sb4u.service.contract.entity.ContractBase;
import com.drizzle.sb4u.service.contract.service.ContractBaseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@RestController
@RequestMapping("admin/contract/contract-base")
public class ContractBaseController {

    @Autowired
    private ContractBaseService contractBaseService;


    @ApiOperation("所有智能合约列表")
    @GetMapping("/list")
    public List<ContractBase> listAll() {
        List<ContractBase> list = contractBaseService.list();
        return list;
    }


    @ApiOperation(value = "根据ID删除智能合约", notes = "根据ID删除智能合约")
    @DeleteMapping("/remove/{id}")
    public Boolean removeById(@ApiParam(value = "智能合约ID", required = true) @PathVariable("id") String id) {
        return contractBaseService.removeById(id);
    }


}

