package com.taotao.service;
import com.taotao.pojo.PictureResult;
import org.springframework.web.multipart.MultipartFile;
public interface PictureService {
    public PictureResult uploadPic(MultipartFile picFile);
}
