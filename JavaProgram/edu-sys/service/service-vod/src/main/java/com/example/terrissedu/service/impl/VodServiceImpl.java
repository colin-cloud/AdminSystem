package com.example.terrissedu.service.impl;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.aliyuncs.vod.model.v20170321.DeleteVideoResponse;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
import com.example.terrissedu.exception.CustomException;
import com.example.terrissedu.service.VodService;
import com.example.terrissedu.utils.CommonResult;
import com.example.terrissedu.utils.InitObject;
import com.example.terrissedu.utils.ResultCode;
import com.example.terrissedu.utils.ResultMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Terriss
 * @time 2023-07-04 15:52:10
 * @description TODO
 */

@Service
public class VodServiceImpl implements VodService {

    @Value("${aliyun.oss.file.keyid}")
    private String accessKeyId;

    @Value("${aliyun.oss.file.keysecret}")
    private String accessKeySecret;

    @Override
    public CommonResult<Map<String, String>> uploadVideo(MultipartFile file) {
        Map<String, String> map = new HashMap<>();
        CommonResult<Map<String, String>> result = new CommonResult<>();
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
            String fileName = file.getOriginalFilename();
            String title = UUID.randomUUID().toString();
            // title 上传之后显示名称
            // fileName 上传文件原始名称
            UploadStreamRequest request = new UploadStreamRequest(accessKeyId, accessKeySecret,
                    title, fileName, inputStream);
            UploadVideoImpl uploader = new UploadVideoImpl();
            UploadStreamResponse response = uploader.uploadStream(request);
            System.out.print("RequestId=" + response.getRequestId() + "\n");  //请求视频点播服务的请求ID
            String videoId = response.getVideoId();
            if (response.isSuccess()) {
                System.out.print("VideoId=" + response.getVideoId() + "\n");
            } else { //如果设置回调URL无效，不影响视频上传，可以返回VideoId同时会返回错误码。
                // 其他情况上传失败时，VideoId为空，此时需要根据返回错误码分析具体错误原因
                System.out.print("VideoId=" + response.getVideoId() + "\n");
                System.out.print("ErrorCode=" + response.getCode() + "\n");
                System.out.print("ErrorMessage=" + response.getMessage() + "\n");
            }
            map.put("videoId", videoId);
            map.put("videoName", title);
            return result.success().message(ResultMessage.UPLOAD_VOD_SUCCESS).data(map);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result.error().message(ResultMessage.UPLOAD_VOD_ERROR);
    }

    @Override
    public CommonResult<Boolean> removeVideo(String videoId) {
        DefaultAcsClient vodClient = InitObject.initVodClient(accessKeyId, accessKeySecret);
        DeleteVideoRequest request = new DeleteVideoRequest();
        //支持传入多个视频ID，多个用逗号分隔
        request.setVideoIds(videoId);
        try {
            vodClient.getAcsResponse(request);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return new CommonResult<Boolean>().success()
                .message(ResultMessage.DELETE_VIDEO_SUCCESS).data(true);
    }

    @Override
    public CommonResult<String> getVideoIdById(String id) {

        DefaultAcsClient vodClient = InitObject.initVodClient(accessKeyId, accessKeySecret);
        // 创建获取凭证的request和response对象
        GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();

        // 设置id
        request.setVideoId(id);

        // 获取response
        try {
            GetVideoPlayAuthResponse response = vodClient.getAcsResponse(request);

            String playAuth = response.getPlayAuth();

            return new CommonResult<String>().success()
                    .message(ResultMessage.PLAY_AUTH_VOD_GET_SUCCESS).data(playAuth);
        } catch (ClientException e) {
            throw new CustomException(ResultCode.ERROR, ResultMessage.PLAY_AUTH_VOD_GET_ERROR);
        }
    }
}
