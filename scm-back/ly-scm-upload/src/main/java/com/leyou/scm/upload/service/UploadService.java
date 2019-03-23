package com.leyou.scm.upload.service;

import com.leyou.scm.common.enums.ExceptionEnum;
import com.leyou.scm.common.exception.ScmException;
import com.leyou.scm.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
@Slf4j
public class UploadService {

    //这样就耦合了，两个微服务之前，但是我懒得写了，就当成是一个微服务了吧
    @Autowired
    TeamService teamService;


    //private static final List<String> ALLOW_TYPES = Arrays.asList("application/x-zip-compressed","application/x-rar-compressed");
    public String uploadRAR(MultipartFile file,String teamName){
        System.out.println(file.getOriginalFilename());
        if(!teamService.findAllTeamsName().contains(teamName)){
            throw new ScmException(ExceptionEnum.TEAM_NOT_REGISTED);
        }

        //校验文件类型
       /*String contentType = file.getContentType();
        if(!ALLOW_TYPES.contains(contentType)){
            throw new ScmException(ExceptionEnum.INVALID_FILE_TYPE);
        }*/
        String contentType = null;
        String fileType = null;

        String fileName = file.getOriginalFilename();
        contentType = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
        System.out.println(contentType);
        if(contentType.equals("zip")){
            fileType = "zip";
        }
        else if(contentType.equals("rar")){
            fileType = "rar";
        }
        else{
            throw new ScmException(ExceptionEnum.INVALID_FILE_TYPE);
        }

        try {
            String finalFileName = System.currentTimeMillis() + teamName + "." +fileType;
            File dest = new File("/home/scm/upload" , finalFileName);
            file.transferTo(dest);


            return "文件上传成功";
        } catch (IOException e) {
            log.error("文件上传失败!",e);
            throw new ScmException(ExceptionEnum.FILE_UPLOAD_ERROR);
        }

    }
}
