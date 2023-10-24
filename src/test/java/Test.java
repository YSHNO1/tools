import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author shanghai.yu
 * @date 2023/10/17 13:59
 */
public class Test {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("C:\\Users\\YSH\\Pictures\\20231023_EdgeDevice0007_0204.png");
        BufferedImage bufferedImage = ImageIO.read(inputFile);

        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setColor(Color.red);
        // 设置线条的宽度（加粗）
        //graphics2D.setStroke(new BasicStroke(2)); // 5表示线条宽度

        int x1 = 1085;
        int y1 = 309;
        int width = 176;
        int height = 78;

        String text = "流动摊贩(38)"; // 中文文本
        int textX = x1; // 调整文本的X坐标
        int textY = y1 - 20; // 调整文本的Y坐标

        // 使用支持中文字符的字体
        Font chineseFont = new Font(Font.DIALOG, Font.PLAIN, 16);
        graphics2D.setFont(chineseFont);
        // 计算文本的边界
        FontMetrics metrics = graphics2D.getFontMetrics(chineseFont);
        int textWidth = metrics.stringWidth(text);
        int textHeight = metrics.getHeight();

        // 绘制文本底色
        graphics2D.setColor(Color.LIGHT_GRAY); // 设置文本底色颜色
        graphics2D.fillRect(textX, textY + textHeight - metrics.getAscent() - 5, textWidth, textHeight);

        // 添加中文文本
        graphics2D.setColor(Color.red); // 设置文本颜色
        graphics2D.drawString(text, textX, textY + textHeight - metrics.getDescent());
        //graphics2D.drawString(text, textX, textY);

        //绘制矩形框
        graphics2D.drawRect(x1, y1, width, height);

        //生成新图片
        File outImageFile = new File("C:\\Users\\YSH\\Pictures\\20231023_EdgeDevice0007_0204(1).png");
        ImageIO.write(bufferedImage, "png", outImageFile);


        graphics2D.dispose();
    }
}
