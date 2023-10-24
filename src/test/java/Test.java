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
        graphics2D.setStroke(new BasicStroke(3)); // 5表示线条宽度

        int x1 = 1085;
        int y1 = 309;
        int width = 176;
        int height = 78;

        graphics2D.drawRect(x1, y1, width, height);

        //生成新图片
        File outImageFile = new File("C:\\Users\\YSH\\Pictures\\20231023_EdgeDevice0007_0204(1).png");
        ImageIO.write(bufferedImage, "png", outImageFile);

        graphics2D.dispose();
    }
}
