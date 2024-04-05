/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp_decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.GZIPOutputStream;

/**
 *
 * @author yasha
 */
public class compressor {
    public static void method(File file) throws IOException
    {
        String fileDirectory=file.getParent();//returns parent of the file we have chosen
        String originalFileName = file.getName(); // get original file name
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss"); // date format for timestamp
        String timestamp = dateFormat.format(new Date()); // current timestamp
        String compressedFileName = originalFileName + "_" + timestamp + "_Compressed" + ".gz"; // new compressed file name
        
        FileInputStream fis=new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/" + compressedFileName);
        GZIPOutputStream gzip=new GZIPOutputStream(fos);
        
        byte[] buffer=new byte[1024];
        int len;
        
        while((len=fis.read(buffer))!=-1)
        {
            gzip.write(buffer,0,len);
        }
        gzip.close();
        fis.close();
        fos.close();
    }
}
