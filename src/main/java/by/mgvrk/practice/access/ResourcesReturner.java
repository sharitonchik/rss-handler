package by.mgvrk.practice.access;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * User: sharitonchik
 */
public class ResourcesReturner {
    private final String PATH = "E:\\For mgvrk\\rss-handler\\src\\main\\webapp\\";

    public String getResource(String pathFile) {
        File jsFile = new File(PATH + pathFile);
        StringBuilder buffer = new StringBuilder();
        FileInputStream stream = null;

        try {
            stream = new FileInputStream(jsFile);
            int data = stream.read();

            while (data != -1) {
                buffer.append((char) data);

                data = stream.read();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    //quality
                }
            }
        }

        return buffer.toString();
    }
}
