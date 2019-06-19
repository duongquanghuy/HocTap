/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adf2javaadvance.bt19;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.*;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author Duy Lumiere
 */
public class bt19b1 {
    /*
    THUẬT TOÁN:
    
    NÉN:
    - Truyền đường dẫn file được nén vào File Input Stream
    - Tạo đường dẫn file sản phẩm vào File Output Stream
    - Truyền đường dẫn file sản phẩm vào Deflater Output Stream (thực thi việc nén)
    - Ghi dữ liệu từ file truyền vào sang file sản phẩm trong bộ nén Deflater (thực thi việc nén)
    
    GIẢI NÉN:
    - Truyền đường dẫn file nén vào File Input Stream
    - Truyền đường dẫn file nén vào Inflater Input Stream (thực thi việc giải nén)
    - Tạo đường dẫn file sau khi được giải nén vào File Output Stream
    - Ghi dữ liệu từ file sản phẩm trong bộ giải nén Inflater (thực thi việc giải nén) sang file sản phẩm
    */
    public static void main(String[] args) throws Exception {
        //Nén
        FileInputStream fis = new FileInputStream("C:\\Users\\Duy Lumiere\\Desktop\\bigfile.txt");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Duy Lumiere\\Desktop\\vidu.dat");
        DeflaterOutputStream dos = new DeflaterOutputStream(fos);       
        System.out.println("Compressing...");
        doCopy(fis, dos);
        System.out.println("Compress Completed!");
        
        //Giải nén
        FileInputStream fis2 = new FileInputStream("C:\\Users\\Duy Lumiere\\Desktop\\vidu.dat");
        InflaterInputStream iis = new InflaterInputStream(fis2);
        FileOutputStream fos2 = new FileOutputStream("C:\\Users\\Duy Lumiere\\Desktop\\giainen.txt");
        System.out.println("Uncompressing...");
        doCopy(iis, fos2);
        System.out.println("Uncompress Completed!");
        
    }

    public static void doCopy(InputStream is, OutputStream os) throws Exception {
        //hàm doCopy nhằm mục đích:
        //ghi dữ liệu từ tệp đầu vào (fis) sang tệp thực thi việc nén (dos)
        //ghi dữ liệu từ tệp thực thi việc giải nén (iis) sang  tệp đàu ra (fos2)
        int oneByte;
        while ((oneByte = is.read()) != -1) {
            os.write(oneByte);
        }
        os.close();
        is.close();
    }
}
