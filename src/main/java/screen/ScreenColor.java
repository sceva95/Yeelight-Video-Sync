package screen;

import com.mollin.yapi.YeelightDevice;
import com.mollin.yapi.exception.YeelightSocketException;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ScreenColor {


    private Map<Integer, Integer> topRossi = new TreeMap<>();
    private Map<Integer, Integer> topBlu = new TreeMap<>();
    private Map<Integer, Integer> topVerdi = new TreeMap<>();
    private Robot robot = new Robot();
    private final Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
    final int screenHeight = screensize.height;
    final int screenWidth = screensize.width;



    public ScreenColor() throws AWTException, YeelightSocketException {
    }

    public BufferedImage getImage() {
        Rectangle rectangle = new Rectangle(screensize);
        return robot.createScreenCapture(rectangle);
    }

    public List<List> getColor(BufferedImage image) throws InterruptedException {
        List<Integer> rossi = new ArrayList<>();
        List<Integer> verdi = new ArrayList<>();
        List<Integer> blu = new ArrayList<>();
        for (int x = 0; x < screenWidth; x += 2) {
            for (int y = 0; y < screenHeight; y += 2) {
                int clr = image.getRGB(x, y);
                int red = (clr & 0x00ff0000) >> 16;
                rossi.add(red);
                int green = (clr & 0x0000ff00) >> 8;
                verdi.add(green);
                int blue = clr & 0x000000ff;
                blu.add(blue);
                //System.out.println("pixel: " + x + ", " + y + " / red = " + red + ", green = " + green + ", blue = " + blue);
            }
        }
        List<List> result = new ArrayList<>();
        result.add(rossi);
        result.add(verdi);
        result.add(blu);
        return result;

    }

    public int getInt(List<Integer> lista) {
        Map<Integer, Integer> top = new TreeMap<>();
        for (Integer tmp : lista) {
            if (top.containsKey(tmp))
                top.put(tmp, top.get(tmp) + 1);
            else
                top.put(tmp, 0);
        }

        int max = 0;
        for (int n = 0; n < 256; n++) {
            if (top.containsKey(n)) {
                if (top.get(n) > top.get(max))
                    max = n;
            }
        }
        return max;
    }





}