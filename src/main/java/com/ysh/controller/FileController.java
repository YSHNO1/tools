package com.ysh.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author shanghai.yu
 * @date 2023/10/17 16:24
 */

@RestController
@RequestMapping("/file")
public class FileController {

    /**
     * 大文件上传
     */
    @PostMapping("/bigFileUpload")
    public String bitFileUpload(@RequestParam String fileName,
                                @RequestParam String fileMd5,
                                @RequestParam String fileID){
        return null;
    }
}
