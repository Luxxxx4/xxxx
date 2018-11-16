package main.java.com.xxxx.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Write2FileUtil {

    public static String inputsteam2file(InputStream in,String fileName){

        String path = "";
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("/Users/lux/Downloads/"+fileName);
            int ch = 0;
            while ( ( ch =in.read()) != -1){
                fos.write(ch);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path = "/Users/lux/Downloads/"+fileName;

    }

}
