package rikkei.academy.view;

import rikkei.academy.Config.Config;
import rikkei.academy.modal.Product;
import rikkei.academy.service.Service;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Product> productList = new ArrayList<>();
    public static void main(String[] args) {

        productList.add(new Product(1, "name1", 123, 100, "ccc", "hp"));
        productList.add(new Product(2, "sang", 124, 100, "ttt", "hp"));

        int choice;
        do {
            System.out.println("1. Hiện danh sách sản phẩm");
            System.out.println("2. thêm sản phẩm");
            System.out.println("3. sửa sản phẩm");
            System.out.println("4. xóa sản phẩm");
            System.out.println("5.sắp xếp sản phẩm");
            System.out.println("6.tìm kiếm sản phẩm");
            System.out.println("0. thoát");
            choice = Config.scanner().nextInt();
            switch (choice){
                case 1:
                    System.out.println(productList);
                    break;
                case 2:
                    Service.addProduct();
                    break;
                case 3: Service.editProduct();
                    break;
                case 4: Service.deleteById();
                    break;
                case 5:
                    System.out.println(Service.sortByPrice());
                    break;
                case 6:
                    System.out.println(Service.searchWithName());
                    break;


            }
        }while (choice != 0);
    }
}
