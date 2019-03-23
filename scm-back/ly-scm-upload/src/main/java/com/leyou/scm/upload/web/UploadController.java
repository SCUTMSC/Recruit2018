package com.leyou.scm.upload.web;

import com.leyou.scm.upload.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("upload")
public class UploadController {

    @Autowired
    UploadService uploadService;

    @PostMapping("rar")
    public ResponseEntity<String> uploadRAR(@RequestParam("file")MultipartFile file,@RequestParam("teamName") String teamName){
        String url = uploadService.uploadRAR(file,teamName);
        return ResponseEntity.ok(url);
    }
}
