package wxrp.rad.net;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Downloader {
	
    public File downloadFile(final String urlPath,
            final File outputFile) {
        InputStream is = null;
        BufferedInputStream bin = null;
        BufferedOutputStream bout = null;

        outputFile.getParentFile().mkdirs();

        try {
            URL url = new URL(urlPath);
            is = url.openStream();
            bin = new BufferedInputStream(is);
            bout = new BufferedOutputStream(
                    new FileOutputStream(outputFile));
            while (true) {
                int datum = bin.read();
                if (datum == -1) {
                    break;
                }
                bout.write(datum);
            }
            bout.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                is.close();
                bin.close();
                bout.close();
            } catch (IOException ioe) {
            }
        }
        return outputFile;
    }
}