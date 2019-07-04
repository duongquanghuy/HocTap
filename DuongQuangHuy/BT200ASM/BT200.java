/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt200;

import com.sun.org.apache.xerces.internal.util.FeatureState;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author DuongQuangHuy
 */
public class BT200 {

    /**
     * @param args the command line arguments
     */
    static List<SanPham> listSanPham = new ArrayList<>();
    static List<SanPham> listSanPhamDaBan = new ArrayList<>();
    static List<SanPham> listSanPhamHetHan = new ArrayList<>();
    static List<SanPham> listSanPhamConLai = new ArrayList<>();
    static List<DanhMucSanPham> listDanhMuc = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws ParseException, IOException {
        // TODO code application logic here

        int choose;
        do {
            showMenu();
            System.out.println(" nhap muc muon chon");
            choose = Integer.parseInt(scan.nextLine());

            switch (choose) {
                case 1:
                    inputDanhMuc();
                    break;
                case 2:
                    inputSanPham();
                    break;
                case 3:
                    displaySanPhamDaBan();
                    break;
                case 4:
                    displaySanPhamTonKho();
                    break;
                case 5:
                    displayHetHSD();
                    break;
                case 6:
                    displaySapHetHSD();
                    break;
                case 7:
                    searechSanPham();
                    break;
                case 8:
                    luuVaoFile();
                    break;
                case 9:
                    readFile();
                    break;
                case 10:
                    System.exit(0);
                    break;
                default:
                    System.out.println("moi chon lai");
                    break;

            }
        } while (choose != 10);
    }

    public static void showMenu() {
        System.out.println("1. Nhập thông tin danh mục");
        System.out.println("2. Nhập thông tin sản phẩm ");
        System.out.println("3. In ra danh sách các sản phẩm đã bán");
        System.out.println("4. In ra danh sách sản phầm còn tồn kho");
        System.out.println("5. In ra danh sách sản phẩm đã quá hạn sử dụng");
        System.out.println("6. In ra danh sách sản phẩm sắp hết hạn sử dụng");
        System.out.println("7. Tìm kiếm >>> nhập tên sản phẩm -> in ra tất cả các sản phẩm có tên nhập vào và số sản phẩm.");
        System.out.println("8. Lưu vào file ");
        System.out.println("9. Đọc dữ liệu từ file và lưu ra chương trình.");

    }

    static void inputDanhMuc() {
        int n;
        System.out.println("nhap so danh muc can them : ");
        n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            DanhMucSanPham dmsp = new DanhMucSanPham();
            System.out.println("nhap danh muc thu : " + (i + 1));
            dmsp.inputDanhMuc();

            listDanhMuc.add(dmsp);
        }
    }

    private static void inputSanPham() {
        int n;
        System.out.println("nhap so san pham can them : ");
        n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            SanPham sp = new SanPham();
            System.out.println("nhap san pham thu : " + (i + 1));
            sp.inputSanPham();

            listSanPham.add(sp);
        }
    }

    private static void displaySanPhamDaBan() {
        boolean chuoi;
        int count = 0;
        for (int i = 0; i < listSanPham.size(); i++) {
            SanPham sp = new SanPham();
            chuoi = listSanPham.get(i).getNgayban().isEmpty();
            if (chuoi == false) {
                listSanPham.get(i).displaySanPham();
                listSanPhamDaBan.add(listSanPham.get(i));
                count++;
            }

        }
        if (count == 0) {
            System.out.println("ko co san pham nao dk ban ");
        }

    }

    private static void displaySanPhamTonKho() {
        boolean chuoi = false;
        for (int i = 0; i < listSanPham.size(); i++) {
            SanPham sp = new SanPham();
            chuoi = listSanPham.get(i).getNgayban().isEmpty();
            if (chuoi == true) {
                listSanPham.get(i).displaySanPham();
                listSanPhamConLai.add(listSanPham.get(i));
            }
        }
        if (!chuoi) {
            System.out.println("ko co san pham ton kho : ");
        }
    }

    private static void displayHetHSD() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date thoiGian = new Date();
        String thoigianthuc = formatter.format(thoiGian.getTime());
        int count = 0;
        for (int i = 0; i < listSanPham.size(); i++) {
            thoiGian = formatter.parse(thoigianthuc);
            Date date = formatter.parse(listSanPham.get(i).getHanSuDung());
            if (thoiGian.compareTo(date) > 0) {
                listSanPham.get(i).displaySanPham();
                listSanPhamHetHan.add(listSanPham.get(i));
                count++;
            }

        }
        if (count == 0) {
            System.out.println("ko co san pham nao het han : ");
        }

    }

    private static void displaySapHetHSD() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:MM  dd/MM/yyyy");
        SimpleDateFormat formatterSP = new SimpleDateFormat("dd/MM/yyyy");
        Date thoiGian = new Date();
        String thoigianthuc = formatter.format(thoiGian.getTime());
        int count = 0;

        for (int i = 0; i < listSanPham.size(); i++) {
            thoiGian = formatter.parse(thoigianthuc);
            Date date = formatterSP.parse(listSanPham.get(i).getHanSuDung());
            if (date.getTime() > thoiGian.getTime()) {
                float diff = date.getTime() - thoiGian.getTime();
                // tinh thoi gian con lai bang phut
                float diffMinutes = diff / (60 * 1000);
                if (diffMinutes <= 10080) {
                    listSanPham.get(i).displaySanPham();

                    count++;
                }
            }

        }
        if (count != 0) {
            System.out.println("cac san pham sap het han dung");
        }
        if (count == 0) {
            System.out.println("ko tim thay san pham nao");
        }
    }

    private static void searechSanPham() {
        System.out.println("nhap ten san pham can tim");
        String searech = scan.nextLine();

        for (SanPham sanPham : listSanPham) {
            if (searech.equalsIgnoreCase(sanPham.getTenSP())) {
                System.out.println(" ten san pham : " + sanPham.tenSP + " ; " + " gia san pham : " + sanPham.giaSP + " ; "
                        + " ngay nhap hang : " + sanPham.ngayNhap + " ; "
                        + "ngay ban hang : " + sanPham.ngayban + " ; "
                        + "ngay het han su dung : " + sanPham.hanSuDung + " ; "
                );
            }
        }
    }

    private static void luuVaoFile() {
        fileDanhMuc();
        fileSanPhamHetHSD();
        fileSanPhamConLai();
        fileSanPhamDaBan();
    }

    private static void readFile() {
      
            System.out.println("Danh muc \n");
            readFileDanhMuc();
            System.out.println("............");
            
            System.out.println("san pham da ban");
            readFileSanPhamDaBan();
            System.out.println(".............");
            
            System.out.println("san pham het han su dung");
            readFileSanPhamHetHSD();
            System.out.println("........");
            
            System.out.println("san pham con lai");
            readFileSanPhamConLai();
      

    }

    private static void fileDanhMuc() {
        // PHAN DANH MUC
        // sự dung để ghi dữ liêu vào file
        FileOutputStream fos = null;
        //su dung đẻ ghi dư liêu nguyên thủy
        ObjectOutputStream oss = null;

        try {
            fos = new FileOutputStream("category.dat");
            oss = new ObjectOutputStream(fos);
            oss.writeObject(listDanhMuc);

        } catch (IOException e) {
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }

                if (oss != null) {
                    oss.close();
                }
            } catch (IOException ex) {
                System.out.println("loi ghi file : " + ex);
            }
        }
    }

    private static void fileSanPhamDaBan() {
        // PHAN DANH MUC
        // sự dung để ghi dữ liêu vào file
        FileOutputStream fos = null;
        //su dung đẻ ghi dư liêu nguyên thủy
        ObjectOutputStream oss = null;

        try {
            fos = new FileOutputStream("sell.dat");
            oss = new ObjectOutputStream(fos);
            oss.writeObject(listSanPhamDaBan);

        } catch (IOException e) {
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }

                if (oss != null) {
                    oss.close();
                }
            } catch (IOException ex) {
                System.out.println("loi ghi file : " + ex);
            }
        }
    }

    private static void fileSanPhamHetHSD() {
        // PHAN DANH MUC
        // sự dung để ghi dữ liêu vào file
        FileOutputStream fos = null;
        //su dung đẻ ghi dư liêu nguyên thủy
        ObjectOutputStream oss = null;

        try {
            fos = new FileOutputStream("expire.dat");
            oss = new ObjectOutputStream(fos);
            oss.writeObject(listSanPhamHetHan);

        } catch (IOException e) {
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }

                if (oss != null) {
                    oss.close();
                }
            } catch (IOException ex) {
                System.out.println("loi ghi file : " + ex);
            }
        }
    }

    private static void fileSanPhamConLai() {
        // PHAN DANH MUC
        // sự dung để ghi dữ liêu vào file
        FileOutputStream fos = null;
        //su dung đẻ ghi dư liêu nguyên thủy
        ObjectOutputStream oss = null;

        try {
            fos = new FileOutputStream("product.dat");
            oss = new ObjectOutputStream(fos);
            oss.writeObject(listSanPhamConLai);

        } catch (IOException e) {
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }

                if (oss != null) {
                    oss.close();
                }
            } catch (IOException ex) {
                System.out.println("loi ghi file : " + ex);
            }
        }
    }

    private static void readFileDanhMuc() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("category.dat");
            ois = new ObjectInputStream(fis);

            listDanhMuc = (List<DanhMucSanPham>) ois.readObject();

            for (DanhMucSanPham danhMuc : listDanhMuc) {
                System.out.println(danhMuc.toString());
            }
        } catch (Exception ex) {
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (ois != null) {
                    ois.close();
                }

            } catch (IOException ex) {
                System.out.println("loi doc file : " + ex);
            }
        }

    }

    private static void readFileSanPhamDaBan() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("sell.dat");
            ois = new ObjectInputStream(fis);

            listSanPhamDaBan = (List<SanPham>) ois.readObject();

            for (SanPham sp : listSanPhamDaBan) {
                System.out.println(sp.toString());
            }
        } catch (Exception ex) {
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (ois != null) {
                    ois.close();
                }

            } catch (IOException ex) {
                System.out.println("loi doc file : " + ex);
            }
        }

    }

    private static void readFileSanPhamHetHSD() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("expire.dat");
            ois = new ObjectInputStream(fis);

            listSanPhamHetHan = (List<SanPham>) ois.readObject();

            for (SanPham sp : listSanPhamHetHan) {
                System.out.println(sp.toString());
            }
        } catch (Exception ex) {
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (ois != null) {
                    ois.close();
                }

            } catch (IOException ex) {
                System.out.println("loi doc file : " + ex);
            }
        }

    }

    private static void readFileSanPhamConLai() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("product.dat");
            ois = new ObjectInputStream(fis);

            listSanPhamConLai = (List<SanPham>) ois.readObject();

            for (SanPham sp : listSanPhamConLai) {
                System.out.println(sp.toString());
            }
        } catch (Exception ex) {
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (ois != null) {
                    ois.close();
                }

            } catch (IOException ex) {
                System.out.println("loi doc file : " + ex);
            }
        }

    }

}
