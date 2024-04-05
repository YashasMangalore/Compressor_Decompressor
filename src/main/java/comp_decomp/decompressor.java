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
import java.util.zip.GZIPInputStream;

/**
 *
 * @author yasha
 */
public class decompressor {
    public static void method(File file) throws IOException
    {
        String fileDirectory=file.getParent();
        String originalFileName = file.getName(); // get original file name
        String fileNameWithoutExtension = originalFileName.substring(0, originalFileName.lastIndexOf("_Compressed")); // remove file extension
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss"); // date format for timestamp
        String timestamp = dateFormat.format(new Date()); // current timestamp
        String decompressedFileName = fileNameWithoutExtension + "_Decompressed_" + timestamp; // new decompressed file name
        
        FileInputStream fis=new FileInputStream(file);//compressed file
        GZIPInputStream gzip=new GZIPInputStream(fis);
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/" + decompressedFileName);

        byte[] buffer=new byte[1024];
        int len;
        
        while( (len=gzip.read(buffer)) !=-1 )
        {
            fos.write(buffer,0,len);
        }
        gzip.close();
        fis.close();
        fos.close();
    }
}
