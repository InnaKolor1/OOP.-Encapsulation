package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();

        productBasket.addProduct(new SimpleProduct("Молоко", 98));
        productBasket.addProduct(new FixPriceProduct("Сахар"));
        productBasket.addProduct(new DiscountedProduct("Яйца", 130,30));
        printSeparator();

        System.out.println("Добавить продукт в полную корзину");
        productBasket.addProduct(new SimpleProduct("Кофе", 597));
        printSeparator();

        System.out.println("Печать содержимого с несколькими продуктами");
        productBasket.printProductBasket();
        printSeparator();

        System.out.println("Сумма чека корзины с несколькими товарами");
        System.out.println("Окончательная стоимость: " + productBasket.getSumOfProducts());
        System.out.println("Поиск товара в корзине");
        String name = "Молоко";
        System.out.println(name + " " + productBasket.checkProduct(name));
        printSeparator();

        System.out.println("Распечатка содержимого перед очисткой");
        productBasket.printProductBasket();
        productBasket.cleanBasket();
        printSeparator();

        System.out.println("Printing of the empty cart");
        productBasket.printProductBasket();
        printSeparator();

        System.out.println("Распечатка оценок перед очисткой");
        productBasket.printProductBasket();
        System.out.println("Цена пустой корзины: " + productBasket.getSumOfProducts());
        printSeparator();

        System.out.println("Поиск товара в пустой корзине");
        name = "Сода";
        System.out.println(name + " " + productBasket.checkProduct(name));
    }

    public static void printSeparator() {
        System.out.println();
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------");
    }
}