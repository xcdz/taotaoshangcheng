package com.taotao.service.impl;

import com.taotao.common.utils.FastDFSClient;
import com.taotao.pojo.PictureResult;
import com.taotao.service.PictureService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName PictureServiceImpl
 * @Description
 * @Author dz
 * @Date 2019/6/11 16:56
 * @Version 1.0
 **/
@Service
public class PictureServiceImpl implements PictureService {
    @Override
    public PictureResult uploadPic(MultipartFile picFile) {
        PictureResult result = new PictureResult();
        //判断图片是否为空
        if (picFile.isEmpty()) {
            result.setError(1);
            result.setMessage("图片为空");
            return result;
        }
        //上传到图片服务器
        try {
            //取图片扩展名
            String originalFilename = picFile.getOriginalFilename();
            System.out.println("originalFilename:    "+originalFilename);
            //取扩展名不要“.”
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            FastDFSClient client = new FastDFSClient("D:\\lianxi\\idea\\xiangmu\\taotaoshangcheng\\taotao-web\\src\\main\\resources\\client.conf");
            System.out.println("client: "+client);
            String url = "http://192.168.140.128/"+client.uploadFile(picFile.getBytes(),extName );
            System.out.println("url:    "+url);
            //把url响应给客户端
            result.setError(0);
            result.setUrl(url);
        } catch (Exception e) {
            e.printStackTrace();
            result.setError(1);
            result.setMessage("图片上传失败");
        }
        return result;
    }
}
