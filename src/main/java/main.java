import com.mollin.yapi.YeelightDevice;
import com.mollin.yapi.exception.YeelightResultErrorException;
import com.mollin.yapi.exception.YeelightSocketException;
import screen.ScreenColor;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class main {
    public static void main(String args[]) throws YeelightSocketException, AWTException, InterruptedException, YeelightResultErrorException {
        ScreenColor screenColor = new ScreenColor();
        List<List> prova = new ArrayList<>();
        YeelightDevice yeelight = new YeelightDevice("192.168.0.100");
        for(int x = 0; x < 255; x++) {
            yeelight.setRGB(1, 0, x);
            System.out.println(x);
        }
        /*int contatore = 0;
        while (true) {
            TimeUnit.MILLISECONDS.sleep(100);
            BufferedImage image = screenColor.getImage();
            prova = screenColor.getColor(image);
            int r = screenColor.getInt(prova.get(0));
            int temp1= 0;
            int v = screenColor.getInt(prova.get(1));
            int temp2 = 0;
            int b = screenColor.getInt(prova.get(2));
            int temp3 = 0;
            System.out.printf("%d:: %d - %d - %d \n", contatore, r, v, b);
            contatore++;
            if(r > 0 && r < 256 && v >= 0 && v < 256 && b >= 0 && b < 256 && r !=temp1 && v != temp2 && b != temp3) {
                yeelight.setRGB(r, v, b);
                temp1 = r;
                temp2 = v;
                temp3 = b;
            }
        }*/
    }
}
