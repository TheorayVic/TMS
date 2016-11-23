package com.yf.bx.tms.utils;


import android.os.Bundle;
import android.widget.ProgressBar;

import com.yf.bx.tms.customview.CustomRoundProcessbar;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;

/**
 * Created by bai on 2016/11/21.
 */

public class DownloadFileUtils {

        public static void downLoadFile(String fileUrl, String address, CustomRoundProcessbar bar){
            URL url = null;
            try {
            url = new URL(fileUrl);
            URLConnection connection = url.openConnection();
            connection.connect();
            // this will be useful so that you can show a typical 0-100% progress bar
            int fileLength = connection.getContentLength();
            // download the file
            InputStream input = new BufferedInputStream(connection.getInputStream());
            OutputStream output = new FileOutputStream(address);
            byte data[] = new byte[1024];
            long total = 0;
            int count;
            while ((count = input.read(data)) != -1) {
                total += count;
                bar.setProgress((int) (total * 100 / fileLength));
                output.write(data, 0, count);
            }
            output.flush();
            output.close();
            input.close(); }
            catch (Exception e) {
                e.printStackTrace();
            }
    }

}
