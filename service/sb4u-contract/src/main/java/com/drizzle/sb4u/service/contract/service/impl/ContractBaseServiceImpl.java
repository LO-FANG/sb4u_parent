package com.drizzle.sb4u.service.contract.service.impl;

import com.drizzle.sb4u.service.contract.entity.ContractBase;
import com.drizzle.sb4u.service.contract.mapper.ContractBaseMapper;
import com.drizzle.sb4u.service.contract.service.ContractBaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 合约基本信息表，用于存储合约的基本信息 服务实现类
 * </p>
 *
 * @author drizzle
 * @since 2024-10-08
 */
@Service
public class ContractBaseServiceImpl extends ServiceImpl<ContractBaseMapper, ContractBase> implements ContractBaseService {
    @Resource
    private ContractBaseMapper contractBaseMapper;



}
