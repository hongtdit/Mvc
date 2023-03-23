package rikkei.academy.compartor;

import rikkei.academy.modal.Product;

import java.util.Comparator;

public class ComparatorWithPrice implements Comparator<Product> {


    @Override
    public int compare(Product o1, Product o2) {
//        return (int) (o1.getPrice()- o2.getPrice());
             return (int) (o2.getPrice()- o1.getPrice());
    }


}
