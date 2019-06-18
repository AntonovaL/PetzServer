package com.petz.server.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.awt.image.ToolkitImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;


@Controller
@RequestMapping("/image")
public class ImageController {
    @GetMapping("/small/{path}")
    @ResponseBody
    public ResponseEntity<byte[]> getSmallPhoto(@PathVariable("path") String path) throws IOException {
        File imgPath = new File("../images/"+path);

        BufferedImage bufImg = null;
        Image newImage=null;
        try
        {
            bufImg = ImageIO.read(imgPath);
            newImage = bufImg.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        BufferedImage bimage = new BufferedImage(newImage.getWidth(null), newImage.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(newImage, 0, 0, null);
        bGr.dispose();
        //byte[] bytes = Files.readAllBytes(imgPath.toPath());
        ImageIO.write(bimage, "png", baos );
        byte[] bytes=baos.toByteArray();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(bytes.length);
        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }
    @GetMapping("/middle/{path}")
    @ResponseBody
    public ResponseEntity<byte[]> getMiddlePhoto(@PathVariable("path") String path) throws IOException {
        File imgPath = new File("../images/"+path);

        BufferedImage bufImg = null;
        Image newImage=null;
        try
        {
            bufImg = ImageIO.read(imgPath);
            newImage = bufImg.getScaledInstance(bufImg.getWidth(), bufImg.getHeight(), Image.SCALE_REPLICATE);
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        BufferedImage bimage = new BufferedImage(newImage.getWidth(null), newImage.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(newImage, 0, 0, null);
        bGr.dispose();
        //byte[] bytes = Files.readAllBytes(imgPath.toPath());
        ImageIO.write(bimage, "png", baos );
        byte[] bytes=baos.toByteArray();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(bytes.length);
        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }
}
