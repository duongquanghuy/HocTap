/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adf2javaadvance.bt200asmquanlybanhang;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Duy Lumiere
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Scanner z = new Scanner(System.in);
        int soLuongTimKiem = 0;
        String luaChon;
        String timKiem;

        Calendar cal = Calendar.getInstance();
        Calendar calTemp = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        List<DanhMuc> danhSachDanhMuc = new ArrayList<>();
        List<SanPham> danhSachSanPham = new ArrayList<>();
        List<SanPham> danhSachSanPhamDaBan = new ArrayList<>();
        List<SanPham> danhSachSanPhamTonKho = new ArrayList<>();
        List<SanPham> danhSachSanPhamHetHsd = new ArrayList<>();

        boolean kTraSanPhamHsd = false; //bằng TRUE khi tồn tại sản phẩm sắp bị quá hạn, bằng FALSE khi không có bất kỳ sản phẩm nào sắp quá hạn
        boolean kTraTimKiem = false; //bằng TRUE khi tìm thấy sản phẩm, bằng FALSE khi không tìm thấy bất kỳ sản phẩm nào

        File sell = new File("C:\\Users\\Duy Lumiere\\Documents\\NetBeansProjects\\T1811E\\src\\adf2javaadvance\\bt200asmquanlybanhang\\sell.dat");
        File expired = new File("C:\\Users\\Duy Lumiere\\Documents\\NetBeansProjects\\T1811E\\src\\adf2javaadvance\\bt200asmquanlybanhang\\expired.dat");
        File category = new File("C:\\Users\\Duy Lumiere\\Documents\\NetBeansProjects\\T1811E\\src\\adf2javaadvance\\bt200asmquanlybanhang\\category.dat");
        File products = new File("C:\\Users\\Duy Lumiere\\Documents\\NetBeansProjects\\T1811E\\src\\adf2javaadvance\\bt200asmquanlybanhang\\products.dat");

        while (true) {
            hienThiMenu();

            luaChon = z.nextLine();
            if (luaChon.matches("[0-9]{1,2}")) {
                switch (Integer.parseInt(luaChon)) {
                    case 1:
                        System.out.println("");
                        System.out.println("NHẬP THÔNG TIN DANH MỤC: ");
                        DanhMuc danhMuc = new DanhMuc();
                        danhMuc.nhapDanhMuc();
                        danhSachDanhMuc.add(danhMuc);
                        System.out.println("");
                        break;

                    case 2:
                        System.out.println("");
                        System.out.println("NHẬP THÔNG TIN SẢN PHẨM: ");
                        SanPham sanPham = new SanPham();
                        sanPham.nhapSanPham();
                        danhSachSanPham.add(sanPham);
                        if (!sanPham.getNgayBan().equalsIgnoreCase("")) {
                            danhSachSanPhamDaBan.add(sanPham);
                        }
                        if (sanPham.getNgayBan().equalsIgnoreCase("") && !(sanPham.getNgayNhap().equalsIgnoreCase(""))) {
                            danhSachSanPhamTonKho.add(sanPham);
                        }
                        try {
                            Date thoiDiemHienTai = cal.getTime();
                            Date hanSuDung = sdf.parse(sanPham.getHanSuDung());
                            if (thoiDiemHienTai.before(hanSuDung)) {
                                danhSachSanPhamHetHsd.add(sanPham);
                            }
                        } catch (ParseException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.out.println("");
                        break;

                    case 3:
                        System.out.println("");
                        if (danhSachSanPhamDaBan.isEmpty()) {
                            System.out.println("Không có Sản phẩm nào đã được Bán!!");
                        } else {
                            System.out.println("DANH SÁCH CÁC SẢN PHẨM ĐÃ BÁN: ");
                            danhSachSanPhamDaBan.forEach((sp) -> {
                                sp.hienSanPham();
                            });
                        }
                        System.out.println("");
                        break;

                    case 4:
                        System.out.println("");
                        if (danhSachSanPhamTonKho.isEmpty()) {
                            System.out.println("Bạn chưa nhập Sản phẩm nào, vui lòng thử lại!");
                        } else {
                            System.out.println("DANH SÁCH CÁC SẢN PHẨM CÒN TỒN KHO: ");
                            danhSachSanPhamTonKho.forEach((sp) -> {
                                sp.hienSanPham();
                            });
                        }
                        System.out.println("");
                        break;

                    case 5:
                        System.out.println("");
                        if (danhSachSanPhamHetHsd.isEmpty()) {
                            System.out.println("Bạn chưa nhập Sản phẩm nào, vui lòng thử lại!");
                        } else {
                            System.out.println("DANH SÁCH CÁC SẢN PHẨM ĐÃ QUÁ HẠN SỬ DỤNG: ");
                            danhSachSanPhamHetHsd.forEach((sp) -> {
                                sp.hienSanPham();
                            });
                        }
                        System.out.println("");
                        break;

                    case 6:
                        System.out.println("");
                        if (danhSachSanPham.isEmpty()) {
                            System.out.println("Bạn chưa nhập Sản phẩm nào, vui lòng thử lại!");
                        } else {
                            System.out.println("DANH SÁCH CÁC SẢN PHẨM SẮP HẾT HẠN SỬ DỤNG: ");
                            for (SanPham sp : danhSachSanPham) {
                                try {
                                    Date thoiDiemHienTai = cal.getTime();
                                    Date hanSuDung = sdf.parse(sp.getHanSuDung());
                                    calTemp.setTime(hanSuDung);
                                    calTemp.add(Calendar.DAY_OF_WEEK_IN_MONTH, 7);
                                    Date hanSuDungTru7 = calTemp.getTime();
                                    if ((thoiDiemHienTai.before(hanSuDungTru7)) && (thoiDiemHienTai.after(hanSuDung))) {
                                        sp.hienSanPham();
                                        kTraSanPhamHsd = true;
                                    }
                                } catch (ParseException ex) {
                                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            if (kTraSanPhamHsd == false) {
                                System.out.println("Không có Sản phẩm nào Sắp quá hạn!");
                            }
                            kTraSanPhamHsd = false;
                        }
                        System.out.println("");
                        break;

                    case 7:
                        System.out.println("");
                        if (danhSachSanPham.isEmpty()) {
                            System.out.println("Bạn chưa nhập Sản phẩm nào, vui lòng thử lại!");
                        } else {
                            System.out.println("TÌM KIẾM");
                            System.out.print("- Nhập Tên sản phẩm: ");
                            timKiem = z.nextLine();
                            for (SanPham sp : danhSachSanPham) {
                                if (sp.getTenSanPham().equalsIgnoreCase(timKiem)) {
                                    soLuongTimKiem++;
                                    sp.hienSanPham();
                                    kTraTimKiem = true;
                                }
                            }
                            System.out.println("Số lượng: " + soLuongTimKiem);
                            if (kTraTimKiem == false) {
                                System.out.println("Không tìm thấy Sản phẩm nào có tên là: " + timKiem);
                            }
                            kTraTimKiem = false;
                            soLuongTimKiem = 0;
                        }
                        System.out.println("");
                        break;

                    case 8:
                        System.out.println("");
                        System.out.println("LƯU FILE: ");
                        System.out.println("Lưu danh mục: ");
                        if (danhSachDanhMuc.isEmpty()) {
                            System.out.println("Bạn chưa nhập danh mục nào!");
                        } else {
                            try {
                                FileOutputStream fos = new FileOutputStream(category);
                                try {
                                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                                    oos.writeObject(danhSachDanhMuc);
                                    System.out.println("Lưu Danh mục thành công!");
                                    oos.close();
                                    fos.close();
                                } catch (IOException ex) {
                                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                        System.out.println("Lưu Sản phẩm đã bán: ");
                        if (danhSachSanPhamDaBan.isEmpty()) {
                            System.out.println("Bạn chưa có Sản phẩm đã bán nào!");
                        } else {
                            try {
                                FileOutputStream fos = new FileOutputStream(sell);
                                try {
                                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                                    oos.writeObject(danhSachSanPhamDaBan);
                                    System.out.println("Lưu Sản phẩm Đã bán thành công!");
                                    oos.close();
                                    fos.close();
                                } catch (IOException ex) {
                                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                        System.out.println("Lưu Sản phẩm hết hạn sử dụng: ");
                        if (danhSachSanPhamHetHsd.isEmpty()) {
                            System.out.println("Bạn chưa có Sản phẩm đã hết HSD nào!");
                        } else {
                            try {
                                FileOutputStream fos = new FileOutputStream(expired);
                                try {
                                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                                    oos.writeObject(danhSachSanPhamHetHsd);
                                    System.out.println("Lưu Sản phẩm Hết HSD thành công!");
                                    oos.close();
                                    fos.close();
                                } catch (IOException ex) {
                                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                        System.out.println("Lưu Sản phẩm Còn tồn kho: ");
                        if (danhSachSanPhamTonKho.isEmpty()) {
                            System.out.println("Bạn chưa có Sản phẩm Tồn kho nào!");
                        } else {
                            try {
                                FileOutputStream fos = new FileOutputStream(products);
                                try {
                                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                                    oos.writeObject(danhSachSanPhamTonKho);
                                    System.out.println("Lưu Sản phẩm còn Tồn kho thành công!");
                                    oos.close();
                                    fos.close();
                                } catch (IOException ex) {
                                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        System.out.println("");
                        break;

                    case 9:
                        System.out.println("");
                        System.out.println("Đọc đữ liệu từ các file sell.dat, expired.dat, category.dat, products.dat: ");

                        System.out.println("Đọc dữ liệu từ sell.dat: ");
                        if (!sell.exists()) {
                            System.out.println("File sell.dat chưa được tạo ra, vui lòng thử lại!");
                        } else if (sell.length() == 0) {
                            System.out.println("File sell.dat không có nội dung nào, vui lòng thử lại!");
                        } else {
                            FileInputStream fis = new FileInputStream(sell);
                            ObjectInputStream ois = new ObjectInputStream(fis);
                            List<SanPham> temp = (List<SanPham>) ois.readObject();
                            temp.forEach((sp) -> {
                                sp.hienSanPham();
                            });
                            temp.clear();
                            fis.close();
                            ois.close();
                        }

                        System.out.println("Đọc dữ liệu từ expired.dat: ");
                        if (!expired.exists()) {
                            System.out.println("File expired.dat chưa được tạo ra, vui lòng thử lại!");
                        } else if (expired.length() == 0) {
                            System.out.println("File expired.dat không có nội dung nào, vui lòng thử lại!");
                        } else {
                            FileInputStream fis = new FileInputStream(expired);
                            ObjectInputStream ois = new ObjectInputStream(fis);
                            List<SanPham> temp = (List<SanPham>) ois.readObject();
                            temp.forEach((sp) -> {
                                sp.hienSanPham();
                            });
                            temp.clear();
                            fis.close();
                            ois.close();
                        }

                        System.out.println("Đọc dữ liệu từ products.dat: ");
                        if (!products.exists()) {
                            System.out.println("File products.dat chưa được tạo ra, vui lòng thử lại!");
                        } else if (products.length() == 0) {
                            System.out.println("File products.dat không có nội dung nào, vui lòng thử lại!");
                        } else {
                            FileInputStream fis = new FileInputStream(products);
                            ObjectInputStream ois = new ObjectInputStream(fis);
                            List<SanPham> temp = (List<SanPham>) ois.readObject();
                            temp.forEach((sp) -> {
                                sp.hienSanPham();
                            });
                            temp.clear();
                            fis.close();
                            ois.close();
                        }

                        System.out.println("Đọc dữ liệu từ category.dat: ");
                        if (!category.exists()) {
                            System.out.println("File category.dat chưa được tạo ra, vui lòng thử lại!");
                        } else if (category.length() == 0) {
                            System.out.println("File category.dat không có nội dung nào, vui lòng thử lại!");
                        } else {
                            FileInputStream fis = new FileInputStream(category);
                            ObjectInputStream ois = new ObjectInputStream(fis);
                            List<DanhMuc> temp = (List<DanhMuc>) ois.readObject();
                            temp.forEach((dm) -> {
                                dm.hienDanhMuc();
                            });
                            temp.clear();
                            fis.close();
                            ois.close();
                        }
                        System.out.println("");
                        break;

                    case 10:
                        System.exit(0);

                    default:
                        System.out.println("Bạn đã nhập sai, vui lòng nhập lại!");
                        System.out.println("");
                        break;
                }
            } else {
                System.out.println("Vui lòng chỉ nhập số (theo các lựa chọn Menu)");
                System.out.println("");
            }
        }
    }

    public static void hienThiMenu() {
        System.out.println("=== CHƯƠNG TRÌNH QUẢN LÝ BÁN HÀNG ===");
        System.out.println("1. Nhập thông tin danh mục");
        System.out.println("2. Nhập thông tin sản phẩm");
        System.out.println("3. In ra danh sách các sản phẩm đã bán");
        System.out.println("4. In ra danh sách sản phầm còn tồn kho");
        System.out.println("5. In ra danh sách sản phẩm đã quá hạn sử dụng");
        System.out.println("6. In ra danh sách sản phẩm sắp hết hạn sử dụng");
        System.out.println("7. Tìm kiếm");
        System.out.println("8. Lưu vào file");
        System.out.println("9. Đọc dữ liệu từ file và lưu ra chương trình");
        System.out.println("10. Thoát");
        System.out.print("*** Mời bạn chọn: ");
    }
}
