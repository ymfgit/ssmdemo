package com.thinkive.demo.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * 文件控制类
 *
 * @author yyt
 * @date 2018/3/21
 * @email yangyt@thinkive.com
 */
@Controller
@RequestMapping("/file")
public class FileController {


    /**
     * 跳转到上传的页面
     *
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String toUploadJsp() {
        return "upload";
    }

    /**
     * 上传文件
     *
     * @param request:上传请求
     * @param file:上传的文件
     * @return :成功返回文件路径  失败返回error
     * @throws IOException:IO异常
     */
    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadFile(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws IOException {
        //如果文件不为空，写入上传路径
        if (!file.isEmpty()) {
            //上传文件路径
            String path = request.getServletContext().getRealPath("/images/");
            //上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path, filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            file.transferTo(new File(path + File.separator + filename));
            return filepath.getPath();
        } else {
            return "error";
        }
    }

    /**
     * 文件下载链接
     *
     * @param request:下载链接的请求
     * @return :返回要下载的文件
     * @throws Exception:IO异常
     */
    @RequestMapping(value = "/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request) throws Exception {
        //下载文件路径
        String path = request.getServletContext().getRealPath("/images/test.jpg");
        File file = new File(path);
        HttpHeaders headers = new HttpHeaders();
        //下载显示的文件名，解决中文名称乱码问题
        String downloadFielName = new String("test.jpg".getBytes("UTF-8"), "iso-8859-1");
        //通知浏览器以attachment（下载方式）打开图片
        headers.setContentDispositionFormData("attachment", downloadFielName);
        //application/octet-stream ： 二进制流数据（最常见的文件下载）。
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.OK);
    }


}
