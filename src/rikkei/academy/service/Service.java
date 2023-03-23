package rikkei.academy.service;

import rikkei.academy.Config.Config;
import rikkei.academy.compartor.ComparatorWithPrice;
import rikkei.academy.modal.Product;


import java.util.ArrayList;
import java.util.Collections;

import static rikkei.academy.view.Main.productList;

public class Service  {
    public static Product createPrd() {
        System.out.println("input product infor");
        System.out.println("id");
        int id = Config.scanner().nextInt();
        System.out.println("name");
        String name = Config.scanner().nextLine();
        System.out.println("price");
        double price = Config.scanner().nextDouble();
        System.out.println("quantity");
        long quantity = Config.scanner().nextLong();
        System.out.println("color");
        String color = Config.scanner().nextLine();
        System.out.println("brand");
        String brand = Config.scanner().nextLine();
        return new Product(id, name, price, quantity, color, brand);
    }

    public static void addProduct() {
        productList.add(createPrd());
    }

    public static void editProduct() {
        System.out.println("input id of product you want to edit");
        int id =Config.scanner().nextInt();
        int index = findIndexById(id);
        if (index != -1) {
            System.out.println("name");
            String name = Config.scanner().nextLine();
            System.out.println("price");
            double price = Config.scanner().nextDouble();
            System.out.println("quantity");
            long quantity = Config.scanner().nextLong();
            System.out.println("color");
            String color = Config.scanner().nextLine();
            System.out.println("brand");
            String brand = Config.scanner().nextLine();
            productList.set(index, new Product(id, name, price, quantity, color, brand));
        }
    }

    public static int findIndexById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (id == productList.get(i).getId()) {
                return i;
            }
        }
        System.err.println("cannot find this product in list");
        return -1;
    }

    public static void deleteById() {
        System.out.println("in id of product you want to delete");
        int id = Config.scanner().nextInt();
        int index = findIndexById(id);
        if (index != -1){
            productList.remove(index);
        }
    }
    public  static ArrayList<Product> sortByPrice() {
        ComparatorWithPrice comparatorWithPrice=new ComparatorWithPrice();
        Collections.sort(productList,comparatorWithPrice);
        return productList;
    }
    public static Product searchWithName(){
        System.out.println("Nhập name");
        String name =Config.scanner().nextLine();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equals(name)){
                return productList.get(i);
            }
        }
        System.err.println("không có tên này");
        return null;
    }
}
