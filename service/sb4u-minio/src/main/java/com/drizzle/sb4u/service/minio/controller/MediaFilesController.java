package com.drizzle.sb4u.service.minio.controller;


import com.drizzle.sb4u.common.base.result.PageParams;
import com.drizzle.sb4u.common.base.result.PageResult;
import com.drizzle.sb4u.common.base.result.R;
import com.drizzle.sb4u.common.base.result.ResultCodeEnum;
import com.drizzle.sb4u.service.minio.entity.dto.QueryMediaParamsDto;
import com.drizzle.sb4u.service.minio.entity.dto.UploadFileParamsDto;
import com.drizzle.sb4u.service.minio.entity.dto.UploadFileResultDto;
import com.drizzle.sb4u.service.minio.entity.po.MediaFiles;
import com.drizzle.sb4u.service.minio.service.MediaFilesService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * <p>
 * 媒资信息 前端控制器
 * </p>
 *
 * @author drizzle
 * @since 2024-10-23
 */
@RestController
@RequestMapping("admin/contract/media-files")
@CrossOrigin
public class MediaFilesController {



    @Autowired
    MediaFilesService mediaFilesService;


    @ApiOperation("媒资列表查询接口")
    @PostMapping("/files")
    public PageResult<MediaFiles> list(PageParams pageParams, @RequestBody QueryMediaParamsDto queryMediaParamsDto) {
        return mediaFilesService.queryMediaFiels(pageParams, queryMediaParamsDto);

    }

    @ApiOperation("上传合约文件")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public R upload(@RequestPart("file") MultipartFile multipartFile,
                    @RequestParam(value = "objectName", required = false) String objectName) throws IOException {

        // 上传文件信息准备
        UploadFileParamsDto uploadFileParamDto = new UploadFileParamsDto();
        //原始文件名称
        uploadFileParamDto.setFilename(multipartFile.getOriginalFilename());
        // 扩展名
        String extension = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
        // 文件大小
        uploadFileParamDto.setFileSize(multipartFile.getSize());
        // 文件类型
        uploadFileParamDto.setFileType(extension);

        // 创建一个临时文件 将传到服务端的文件保存下来，并获取临时文件的本地路径
        File tempFile = File.createTempFile("minio", ".tmp");
        // 将上传的文件内容拷贝到临时文件
        multipartFile.transferTo(tempFile);

        String localFilePath = tempFile.getAbsolutePath();

        UploadFileResultDto uploadFileResultDto = mediaFilesService.uploadFile(uploadFileParamDto, localFilePath, objectName);

        //返回r对象
        return R.ok().message("文件上传成功").data("fileId", uploadFileResultDto.getFileId());
    }


    @ApiOperation("删除合约文件")
    @PostMapping(value = "/delete")
    public Boolean delete(@RequestParam(value = "fileId") String id) {
        boolean deleteFromMinio = mediaFilesService.deleteContractFileById(id);
        boolean deleteFromDB = mediaFilesService.removeById(id);
        if(deleteFromMinio && deleteFromDB) {
            return true;
        } else {
            return false;
        }

    }

}

