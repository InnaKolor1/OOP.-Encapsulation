package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.SearchEngine.SearchEngine;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();

        Product product1 = new SimpleProduct("ПопСокет", 530);
        Product product2 = new FixPriceProduct("USB-C Кабель");
        Product product3 = new DiscountedProduct("Наушники", 4500, 30);

        productBasket.addProduct(product1);
        productBasket.addProduct(product2);
        productBasket.addProduct(product3);
        printSeparator();

        System.out.println("Добавить товар в полную корзину");
        productBasket.addProduct(new SimpleProduct("ПопСокет", 530));
        printSeparator();

        System.out.println("Печать содержимого с помощью нескольких продуктов");
        productBasket.printProductBasket();
        printSeparator();

        System.out.println("Сумма чека корзины с несколькими товарами");
        System.out.println("Окончательная стоимость: " + productBasket.getSumOfProducts());
        System.out.println("Поиск товара в корзине");

        String name = "HDMI Кабель";
        System.out.println(name + " " + productBasket.checkProduct(name));
        printSeparator();

        System.out.println("Печать содержимого перед стиранием");
        productBasket.printProductBasket();
        productBasket.cleanBasket();
        printSeparator();

        System.out.println("Печать пустой корзины");
        productBasket.printProductBasket();
        printSeparator();

        System.out.println("Цена пустой корзины");
        productBasket.printProductBasket();
        System.out.println("Окончательная стоимость тележки: " + productBasket.getSumOfProducts());
        printSeparator();

        System.out.println("Поиск товара в пустой корзине");
        name = "Клавиатура";
        System.out.println(name + " " + productBasket.checkProduct(name));
        printSeparator();

        Article article1 = new Article("ПопСокет.", "Это универсальный держатель для телефона.");
        Article article2 = new Article("USB-C Кабель.", "Последовательный интерфейс для подключения периферийных устройств к вычислительной технике.");
        Article article3 = new Article("Наушники.", "Новая модель и функция шумоподавления.");


        SearchEngine searchEngine = new SearchEngine(6);

        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);

        String query = "Наушники";
        Searchable[] searchResults = searchEngine.search(query);
        System.out.println("Результаты поиска " + query + ": " + Arrays.toString(searchResults));

        query = "Клавиатура";
        searchResults = searchEngine.search(query);
        System.out.println("Результаты поиска " + query + ": " + Arrays.toString(searchResults));

        query = "Случай";
        searchResults = searchEngine.search(query);
        System.out.println("Результаты поиска " + query + ": " + Arrays.toString(searchResults));

        query = "Наклейка";
        searchResults = searchEngine.search(query);

        System.out.println("Результаты поиска " + query + ": " + Arrays.toString(searchResults));

        System.out.println();

        System.out.println("Результат поиска по имени: ");

        for (Searchable searchResult : searchResults) {
            if (searchResult != null) {
                System.out.println("Имя для поиска: " + searchResult.getStringRepresentation());
                try {
                    Product product = new SimpleProduct("ПопСокет ", 530);
                } catch (IllegalArgumentException e) {
                    System.err.println("Ошибка при создании товара" + e.getMessage());
                }
                try {
                    Product product = new FixPriceProduct(" USB-C Кабель");
                } catch (IllegalArgumentException e) {
                    System.err.println("Ошибка при создании товара" + e.getMessage());
                }

            }
        }
    }

    public static void printSeparator() {

    }
}