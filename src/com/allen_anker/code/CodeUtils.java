package com.allen_anker.code;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class CodeUtils {

    public static String drawImage(HttpServletResponse response) {

        StringBuilder codeBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            codeBuilder.append(randomChar());
        }
        String code = codeBuilder.toString();

        int width = 120;
        int height = 25;
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bufferedImage.createGraphics();
        Font font = new Font("san-serif", Font.PLAIN, 20);
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.setBackground(Color.WHITE);

        g.clearRect(0, 0, width, height);
        FontRenderContext context = g.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(code, context);
        double x = (width - bounds.getWidth()) / 2;
        double y = (height - bounds.getHeight()) / 2;
        double ascent = bounds.getY();
        double baseY = y - ascent;
        g.drawString(code, (int) x, (int) baseY);

        g.dispose();
        try {
            ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return code;
    }

    public static String drawArithmeticImage(HttpServletResponse response) {

        int width = 120;
        int height = 25;
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bufferedImage.createGraphics();
        Font font = new Font("san-serif", Font.PLAIN, 20);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        // get random arithmetic expression
        String expression = "";
        String result = "";
        Random random = new Random();
        int a = random.nextInt(10) + 1;
        int b = random.nextInt(10) + 1;
        switch (random.nextInt(3)) {
            case 0:
                expression = a + " + " + b + " = ?";
                result = (a + b) + "";
            case 1:
                expression = a + " - " + b + " = ?";
                result = (a - b) + "";
            case 2:
                expression = a + " * " + b + " = ?";
                result = (a * b) + "";
        }

        // draw distraction lines
        g.setColor(randomColor(160, 255));
        for (int i = 0; i < 24; i++) {
            g.drawLine(random.nextInt(width), random.nextInt(height), random.nextInt(width), random.nextInt(height));
        }

        // draw expression image
        g.setColor(randomColor(20, 120));
        g.drawString(expression, 5, 25);
        g.dispose();

        try {
            ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return result;
    }

    private static char randomChar() {

        String chars = "QWERTYUIOPASDFGHJKLZXCVBNM0123456789";
        Random random = new Random();
        return chars.charAt(random.nextInt(chars.length()));
    }

    /**
     * Generate random color in a specific range
     *
     * @param lb
     * @param rb
     * @return
     */
    private static Color randomColor(int lb, int rb) {
        Random random = new Random();
        return new Color(
                lb + random.nextInt(rb - lb),
                lb + random.nextInt(rb - lb),
                lb + random.nextInt(rb - lb)
        );
    }
}
