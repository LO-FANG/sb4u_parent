package com.drizzle.sb4u.service.minio.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.drizzle.sb4u.service.minio.entity.po.MediaFiles;
import com.drizzle.sb4u.service.minio.mapper.MediaFilesMapper;
import com.drizzle.sb4u.service.minio.service.MediaFilesService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 媒资信息 服务实现类
 * </p>
 *
 * @author drizzle
 * @since 2024-10-23
 */
@Service
public class MediaFilesServiceImpl extends ServiceImpl<MediaFilesMapper, MediaFiles> implements MediaFilesService {

}
