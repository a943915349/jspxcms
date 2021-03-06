package com.jspxcms.core.web.back;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jspxcms.common.upload.Uploader;
import com.jspxcms.core.domain.Site;
import com.jspxcms.core.support.Context;

/**
 * UploadController
 *
 * @author liufang
 */
@Controller
@RequestMapping("/core")
public class UploadController extends UploadControllerAbstract {
    @PostMapping(value = "upload_image.do")
    public void uploadImage(Boolean scale, Boolean exact, Integer width, Integer height, Boolean thumbnail,
                            Integer thumbnailWidth, Integer thumbnailHeight, Boolean watermark, HttpServletRequest request,
                            HttpServletResponse response) throws IOException {
        Site site = Context.getCurrentSite();
        upload(site, request, response, Uploader.IMAGE, scale, exact, width, height, thumbnail, thumbnailWidth,
                thumbnailHeight, watermark);
    }

    @PostMapping(value = "upload_flash.do")
    public void uploadFlash(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Site site = Context.getCurrentSite();
        upload(site, request, response, Uploader.FLASH);
    }

    @PostMapping(value = "upload_file.do")
    public void uploadFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Site site = Context.getCurrentSite();
        upload(site, request, response, Uploader.FILE);
    }

    @PostMapping(value = "upload_video.do")
    public void uploadVideo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Site site = Context.getCurrentSite();
        upload(site, request, response, Uploader.VIDEO);
    }

    @PostMapping(value = "upload_doc.do")
    public void uploadDocument(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Site site = Context.getCurrentSite();
        upload(site, request, response, Uploader.DOC);
    }

    @RequestMapping(value = "ueditor.do")
    public void ueditor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if ("config".equals(action)) {
            super.ueditorConfig(request, response);
        } else if ("uploadimage".equals(action)) {
            uploadImage(null, null, null, null, null, null, null, null, request, response);
        } else if ("catchimage".equals(action)) {
            ueditorCatchImage(request, response);
        } else if ("uploadvideo".equals(action)) {
            uploadVideo(request, response);
        } else if ("uploadfile".equals(action)) {
            uploadFile(request, response);
        } else if ("uploadscrawl".equals(action)) {

        } else if ("listimage".equals(action)) {

        } else if ("listfile".equals(action)) {

        }
    }

    public void ueditorCatchImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Site site = Context.getCurrentSite();
        super.ueditorCatchImage(site, request, response);
    }
}
