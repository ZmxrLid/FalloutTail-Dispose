package com.fallouttail.dispose.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.fallouttail.dispose.utils.ImportUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
@Controller
@RestController
@RequestMapping("/file")
public class FileController {

    @Value("${files.upload.path}")
    private String fileUploadPath;

    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file) throws IOException{
        String originalFilename = file.getOriginalFilename();
        String type = FileUtil.extName(originalFilename);
        File uploadParentFile = new File(fileUploadPath);
        if (!uploadParentFile.exists()){
            uploadParentFile.mkdirs();
        }
        String uuid = IdUtil.fastSimpleUUID();
        File uploadFile = new File(fileUploadPath + uuid + StrUtil.DOT +type);
        file.transferTo(uploadFile);
        return uuid+StrUtil.DOT+type;
    }

}
