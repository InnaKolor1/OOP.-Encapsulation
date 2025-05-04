package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();

        productBasket.addProduct(new Product("Молоко", 98));
        productBasket.addProduct(new Product("Сахар", 54));
        productBasket.addProduct(new Product("Яйца", 130));

        System.out.println("Добавить товар в полную корзину");
        productBasket.addProduct(new Product("Кофе", 597));
        line();

        System.out.println("Печать содержимого с несколькими продуктами");
        productBasket.printProductBasket();
        line();

        System.out.println("Сумма чека корзины с несколькими товарами");
        System.out.println("Окончательная стоимость: " + productBasket.getSumOfProducts());
        line();

        System.out.println("Поиск товара в корзине");
        String name = "Молоко";
        System.out.println(name + " - " + productBasket.checkProduct(name));
        line();

        System.out.println("Распечатка содержимого перед очисткой");
        productBasket.printProductBasket();
        productBasket.cleanBasket();
        line();

        System.out.println("Распечатка оценок перед очисткой");
        productBasket.printProductBasket();
        line();

        System.out.println("Цена пустой корзины");
        System.out.println("\n" + "Цена пустых корзин: " + productBasket.getSumOfProducts());
        line();

        System.out.println("Поиск товара в пустой корзине");
        name = "Сода";
        System.out.println(name + " - " + productBasket.checkProduct(name));
    }

    public static void line() {
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------");
    }
}
