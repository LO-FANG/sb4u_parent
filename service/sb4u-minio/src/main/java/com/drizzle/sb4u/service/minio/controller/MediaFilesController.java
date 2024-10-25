package com.drizzle.sb4u.service.minio.controller;


import com.drizzle.sb4u.common.base.result.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 媒资信息 前端控制器
 * </p>
 *
 * @author drizzle
 * @since 2024-10-23
 */
@RestController
@RequestMapping("/contract/media-files")
public class MediaFilesController {

    @ApiOperation("上传文件")
    @RequestMapping(value = "/upload/coursefile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public R upload(@RequestPart("filedata")MultipartFile upload) {
        return null;
    }
}

