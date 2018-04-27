package com.zhihua.demo_upload.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("file")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @RequestMapping("upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {

        if (file.isEmpty()) {
            return "文件为空";
        }
    // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为:" + fileName);

        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为:" + suffixName);
        // 文件上传路径
        String filePath = "/home/user01/file/";
        // 解决中文问题,liunx 下中文路径,图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);

        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest);
            System.out.println("文件上传成功");
            return "文件上传成功";
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件上传失败");
        }
        return "文件上传失败";
    }


}
