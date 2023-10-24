package com.ysh.file;

import cn.hutool.http.server.HttpServerResponse;
import cn.hutool.poi.excel.ExcelReader;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author shanghai.yu
 * @date 2023/10/17 14:41
 */
public class ExcelUtil {

    /**
     * excel导入
     * @param file 前端上传的文件
     * @return 导入的对象列表
     */
    public List<Object> excelImport(MultipartFile file){
        //ExcelReader reader = cn.hutool.poi.excel.ExcelUtil.getReader(f)
        return null;
    }

    /**
     * excel导出
     * @param data 要导出的实体对象数据
     * @param response 响应
     */
    public void excelExport(List<Object> data, HttpServerResponse response){

    }
}