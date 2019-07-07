/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2.bt200ass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LQT
 */
public class Main {

    public static Scanner input = new Scanner(System.in);

    // các list dùng lưu file
    public static ArrayList<Product> sellDat = new ArrayList<>(); // sản phẩm đã bán
    public static ArrayList<Product> expire = new ArrayList<>(); // sản phẩm hết hạn
    public static ArrayList<Product> productStillValid = new ArrayList<>(); // sản phẩm còn hạn

    public static void main(String[] args) {
        int choose;
        do {
            showMenu();
            System.out.println("Mời bạn chọn 1 mục : ");
            choose = Integer.parseInt(input.nextLine());

            switch (choose) {
                case 1:
                    System.out.println("=== Thêm danh mục ===");
                    Category category = new Category();
                    category.inputCategory();
                    Category.listCategory.add(category);
                    break;

                case 2:
                    System.out.println("=== Thêm sản phẩm ===");
                    Product product = new Product();
                    product.inputProduct();
                    Product.listProduct.add(product);
                    break;

                case 3:
                    for (int i = 0; i < Product.listProduct.size(); i++) {
                        String dateType = "dd-mm-yyyy";
                        DateFormat df = new SimpleDateFormat(dateType);
                        Date dfDateSale = null;
                        try {
//                        Product.listProduct.get(i).getDateSale()
                            dfDateSale = df.parse(Product.listProduct.get(i).getDateSale());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        // convert to Long
                        Long dateNowByLong = new java.util.Date().getTime();
                        Long dateSaleByLong = dfDateSale.getTime();
                        System.out.println("Các sản phẩm đã bán");
                        if (dateNowByLong - dateSaleByLong > 0) {
                            Product.listProduct.get(i).showProduct();
                            sellDat.add(Product.listProduct.get(i));
                        }

                    }
                    break;

                case 4:
                    for (int i = 0; i < Product.listProduct.size(); i++) {
                        String dateType = "dd-mm-yyyy";
                        DateFormat df = new SimpleDateFormat(dateType);
                        Date dfDateSale = null;
                        try {
//                        Product.listProduct.get(i).getDateSale()
                            dfDateSale = df.parse(Product.listProduct.get(i).getDateSale());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        // convert to Long
                        Long dateNowByLong = new java.util.Date().getTime();
                        Long dateSaleByLong = dfDateSale.getTime();
                        System.out.println("Các sản phẩm còn tồn kho");
                        if (dateNowByLong - dateSaleByLong < 0) {
                            Product.listProduct.get(i).showProduct();
                        }

                    }
                    break;

                case 5:
                    for (int i = 0; i < Product.listProduct.size(); i++) {
                        String dateType = "dd-mm-yyyy";
                        DateFormat df = new SimpleDateFormat(dateType);
                        Date dfDateExpiry = null;
                        try {
//                        Product.listProduct.get(i).getDateSale()
                            dfDateExpiry = df.parse(Product.listProduct.get(i).getDateExpiry());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        // convert to Long
                        Long dateNowByLong = new java.util.Date().getTime();
                        Long dateExpiryByLong = dfDateExpiry.getTime();
                        System.out.println("Các sản phẩm hết hạn sử dụng");
                        if (dateNowByLong - dateExpiryByLong > 0) {
                            Product.listProduct.get(i).showProduct();
                            expire.add(Product.listProduct.get(i));
                        }

                    }
                    break;

                case 6:
                    for (int i = 0; i < Product.listProduct.size(); i++) {
                        String dateType = "dd-mm-yyyy";
                        DateFormat df = new SimpleDateFormat(dateType);
                        Date dfDateExpiry = null;
                        try {
//                        Product.listProduct.get(i).getDateSale()
                            dfDateExpiry = df.parse(Product.listProduct.get(i).getDateExpiry());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        // convert to Long
                        Long dateNowByLong = new java.util.Date().getTime();
                        Long dateExpiryByLong = dfDateExpiry.getTime();
                        System.out.println("Các sản phẩm sắp hết hạn sử dụng");
                        if (- 86400000 * 7 < dateNowByLong - dateExpiryByLong && dateNowByLong - dateExpiryByLong < 0) {
                            Product.listProduct.get(i).showProduct();
                        }

                    }
                    break;

                case 7:
                    int count = 0;
                    System.out.println("Nhập và tên sản phẩm cần tìm : ");
                    String s = input.nextLine();
                    System.out.println("Sản phẩm cần tìm là : ");
                    for (int i = 0; i < Product.listProduct.size(); i++) {
                        if (Product.listProduct.get(i).getNameProduct().contains(s)) {
                            Product.listProduct.get(i).showProduct();
                            count++;
                        }
                    }
                    System.out.println("Số sản phẩm : " + count);
                    break;

                case 8:
                    createFileList(Category.listCategory, "E:/category.dat");
                    createFileList(sellDat, "E:/sell.dat");
                    createFileList(expire, "E:/expire.dat");
                    checkProductStillValid();
                    createFileList(productStillValid, "E:/product.dat");
                    System.out.println("Đã lưu các thông tin sản phẩm vào file");
                    break;

                case 9:
                    ArrayList<Category> listCategory = readFileList("E:/category.dat");
                    for (Category category1 : listCategory) {
                        category1.showCategory();
                    }

                    ArrayList<Product> sellDat1 = readFileList("E:/sell.dat");
                    for (Product product1 : sellDat1) {
                        product1.showProduct();
                    }

                    ArrayList<Product> expire1 = readFileList("E:/expire.dat");
                    for (Product product1 : expire1) {
                        product1.showProduct();
                    }

                    ArrayList<Product> productStillValid1 = readFileList("E:/product.dat");
                    for (Product product1 : productStillValid1) {
                        product1.showProduct();
                    }
                    break;

                case 0:
                    System.out.println("Thoát chương trình");
                    break;
            }

        } while (choose != 0);
    }

    static void showMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Nhập thông tin danh mục");
        System.out.println("2. Nhập thông tin sản phẩm");
        System.out.println("3. In ra danh sách các sản phẩm đã bán");
        System.out.println("4. In ra danh sách các sản phẩm còn tồn kho");
        System.out.println("5. In ra danh sách các sản phẩm hết hạn sử dụng");
        System.out.println("6. In ra danh sách các sản phẩm sắp hết hạn sử dụng");
        System.out.println("7. Tìm kiếm theo tên sản phẩm");
        System.out.println("8. Lưu dữ liệu vào file");
        System.out.println("9. Đọc dữ liệu từ file");
        System.out.println("0. Thoát");
    }

    public static void createFileList(ArrayList list, String nameFileOutPut) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File(nameFileOutPut));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    static ArrayList readFileList(String nameFileInPut) {
        FileInputStream fis = null;
        ArrayList list = new ArrayList();
        try {
            fis = new FileInputStream(new File(nameFileInPut));
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (ArrayList) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return list;
    }

    static void checkProductStillValid() {
        for (int i = 0; i < Product.listProduct.size(); i++) {
            String dateType = "dd-mm-yyyy";
            DateFormat df = new SimpleDateFormat(dateType);
            Date dfDateExpiry = null;
            try {
//                        Product.listProduct.get(i).getDateSale()
                dfDateExpiry = df.parse(Product.listProduct.get(i).getDateExpiry());
            } catch (Exception e) {
                e.printStackTrace();
            }
            // convert to Long
            Long dateNowByLong = new java.util.Date().getTime();
            Long dateExpiryByLong = dfDateExpiry.getTime();
            if (- 86400000 * 7 < dateNowByLong - dateExpiryByLong && dateNowByLong - dateExpiryByLong < 0) {
                productStillValid.add(Product.listProduct.get(i));
            }

        }
    }
}
