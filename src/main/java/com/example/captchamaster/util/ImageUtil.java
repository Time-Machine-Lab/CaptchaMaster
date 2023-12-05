package com.example.captchamaster.util;

import com.example.captchamaster.common.builder.Graphics2DBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Random;

@Component
public class ImageUtil {
    @Value("${captcha.image-code.width}")
    private int width;
    @Value("${captcha.image-code.height}")
    private int height;
    @Value("${captcha.image-code.dot-size}")
    private int dotsSize;
    private final Random random = new Random();
    public String CodeToBase64(String code){
        BufferedImage captchaImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2DBuilder graphics2DBuilder = new Graphics2DBuilder(captchaImage.createGraphics());
        graphics2DBuilder
                .code(code)
                .backgroundColor(randColor(), width, height)
                .font(randColor(), randFont())
                .dot(dotsSize)
                .draw(width, height)
                .done();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(captchaImage, "png", outputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        byte[] imageBytes = outputStream.toByteArray();
        return Base64.getEncoder().encodeToString(imageBytes);
    }
    private Font randFont(){
        return new Font("Arial", Font.ITALIC, 40);
    }
    private Color randColor(){
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
}
