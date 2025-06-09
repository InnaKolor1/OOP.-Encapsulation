package org.skypro.skyshop;

import jdk.jfr.SettingControl;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.SearchEngine.SearchEngine;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.exception.BestResultNotFound;



public class App {
    public static void main(String[] args) throws IllegalArgumentException, BestResultNotFound {

        Product product1 = new SimpleProduct("ПопСокет", 530);
        Product product2 = new FixPriceProduct("USB Кабель");
        Product product3 = new DiscountedProduct("Наушники", 4500, 30);
        Product product4 = new SimpleProduct("Адаптер", 700);
        Product product5 = new SimpleProduct(" Монитор", 21000);
        Product product6 = new SimpleProduct(" Коврик для мышки", 500);

        Article article1 = new Article("ПопСокет.", "Это универсальный держатель для телефона.") {
            @Override
            public String getName() {
                return "";
            }
        };
        Article article2 = new Article("USB-C Кабель.", "Последовательный интерфейс для подключения периферийных устройств к вычислительной технике.") {
            @Override
            public String getName() {
                return "";
            }
        };
        Article article3 = new Article("Наушники.", "Новая модель и функция шумоподавления.") {
            @Override
            public String getName() {
                return "";
            }
        };
        ProductBasket firstProductBasket = new ProductBasket();

        firstProductBasket.addProduct(product1);
        firstProductBasket.addProduct(product2);
        firstProductBasket.addProduct(product3);
        firstProductBasket.addProduct(product4);

        ProductBasket secondProductBasket = new ProductBasket();
        secondProductBasket.addProduct(product5);
        secondProductBasket.addProduct(product6);

        firstProductBasket.printProductBasket();
        System.out.println();

        secondProductBasket.printProductBasket();
        System.out.println();

        System.out.println(firstProductBasket.searchProduct("Компютер"));
        System.out.println(firstProductBasket.searchProduct("Мышь"));
        System.out.println(secondProductBasket.searchProduct("ПопСокет"));
        System.out.println();

        System.out.println(firstProductBasket.removeThisProduct("Коврик для мышки"));
        System.out.println();

        firstProductBasket.printProductBasket();
        System.out.println();

        System.out.println(secondProductBasket.removeThisProduct("Адаптер"));


        firstProductBasket.clear();
        firstProductBasket.printProductBasket();
        System.out.println();
        System.out.println(firstProductBasket.searchProduct("USB Кабель"));
        SearchEngine searchEngine = new SearchEngine();


        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        System.out.println();

        System.out.println();
        System.out.println(searchEngine.search("ПопСокет"));
        System.out.println(searchEngine.search("Мышь"));
        System.out.println(searchEngine.search("Клавиатура"));

        try {
            Searchable bestMatch = searchEngine.searchMostRelevant("ПопСокет");
            System.out.println("Наиболее подходящий объект: " + bestMatch.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.err.println(e);

        }

        try {
            product5 = new SimpleProduct(" Монитор  ", 21000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            product6 = new SimpleProduct("Коврик для мышки", 500);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }
}
