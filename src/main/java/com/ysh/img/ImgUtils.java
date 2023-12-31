package com.ysh.img;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;

/**
 * @author shanghai.yu
 * @date 2023/10/17 10:41
 */
@Slf4j
public class ImgUtils {

    /**
     * 图片转base64
     * @param file MultipartFile类型文件，前端上传
     * @return 图片base64编码                         ·
     */
    public String imgToBase64(MultipartFile file){
        try{
            byte[] imageBytes = file.getBytes();
            return Base64.getEncoder().encodeToString(imageBytes);
        }catch (IOException e){
            log.error("转换失败：" + e.getMessage());
        }
        return null;
    }

    /**
     * 图片转base64
     * @param path 图片路径
     * @return base64编码
     */
    public String imgToBase64(String path){
        File file = new File(path);
        try{
            FileInputStream inputStream = new FileInputStream(file);
            byte[] imageBytes = new byte[(int)file.length()];
            inputStream.read(imageBytes);
            inputStream.close();

            //将字节数组转换为base64编码

            return Base64.getEncoder().encodeToString(imageBytes);
        }catch (IOException e){
            log.error("转换失败："+ e.getMessage());
        }
        return null;
    }

    /**
     * base64转图片
     * @param base64 图片的base64编码
     * @return MultipartFile
     */
    public MultipartFile base64ToImgFile(String base64, String fileName){
        //如果base64不以 data:image/jpeg;base64 开始，则不需要这一步骤
        String base64Image = base64.split(",")[1];
        byte[] decodedBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);
        // 将字节数组包装成MultipartFile对象
        MultipartFile multipartFile = null;
        try{
            multipartFile = new MockMultipartFile(fileName, fileName, "image/png", new ByteArrayInputStream(decodedBytes));
        } catch (Exception e){
            log.error("生成文件失败：" + e.getMessage());
        }
        return multipartFile;
    }


    /**
     * base64编码转为图片文件并保存
     * @param base64 图片的base64编码
     * @param path 图片的保存路径
     */
    public void base64ToImg(String base64, String path){
        try {
            // 将Base64编码的字符串解码为字节数组
            byte[] imageBytes = Base64.getDecoder().decode(base64);

            // 创建文件输出流并保存图片
            try (FileOutputStream fos = new FileOutputStream(path)) {
                fos.write(imageBytes);
                log.info("Image saved to: " + path);
            } catch (IOException e) {
                log.error("Image saved false: " + e.getMessage());
            }
        } catch (IllegalArgumentException e) {
            // 处理Base64解码失败的情况
            log.error("base64 解码失败: " + e.getMessage());
        }
    }

    /**
     *对图片进行绘制修改-根据图像坐标点绘制红框
     *@param filePath 源文件路径
     *@param fileName 生成的新文件名
     * @param x1 左上角横坐标点
     * @param y1 右上角横坐标点
     * @param width 框宽度
     * @param height 框高度
     */
    public void imageDraw(String filePath, String fileName, int x1, int y1, int width, int height){
        try{
            File inputFile = new File(filePath);
            BufferedImage bufferedImage = ImageIO.read(inputFile);

            Graphics2D graphics2D = bufferedImage.createGraphics();
            graphics2D.setColor(Color.red);
            // 设置线条的宽度（加粗）
            graphics2D.setStroke(new BasicStroke(3)); // 3表示线条宽度

            graphics2D.drawRect(x1, y1, width, height);

            //生成新图片 -指定保存路径，可以改为传参
            File outImageFile = new File(fileName);
            ImageIO.write(bufferedImage, "png", outImageFile);

            graphics2D.dispose();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
