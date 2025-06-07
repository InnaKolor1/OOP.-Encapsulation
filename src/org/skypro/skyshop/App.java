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
import java.util.List;
import java.util.Map;


public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();

        Product product1 = new SimpleProduct("ПопСокет", 530);
        Product product2 = new FixPriceProduct("USB Кабель");
        Product product3 = new DiscountedProduct("Наушники", 4500, 30);
        Product product4 = new SimpleProduct("Адаптер", 700);

        productBasket.addProduct(product1);
        productBasket.addProduct(product2);
        productBasket.addProduct(product3);
        productBasket.addProduct(product4);
        productBasket.addProduct(product3);
        printSeparator();

        System.out.print(new StringBuilder()
                .append("Удалить корзину")
                .append("Распечатать содержание"));
        productBasket.printProductBasket();


        System.out.println(new StringBuilder("Удалить продукт-ПопСокет"));
        productBasket.deleteAndPrintProductsByName("ПопСокет");
        System.out.println();
        productBasket.printProductBasket();

        System.out.println(new StringBuilder("Удалить продукт-Наушники"));
        productBasket.deleteAndPrintProductsByName("Наушники");
        System.out.println();
        productBasket.printProductBasket();
        printSeparator();

        System.out.println(new StringBuilder("Распечатать содержимое с помощью нескольких продуктов"));
        productBasket.printProductBasket();
        printSeparator();

        System.out.println(new StringBuilder()
                .append("Стоимость корзины с несколькими продуктами")
                .append("Общая стоимость корзины: ")
                .append(productBasket.getSumOfProducts()));
        printSeparator();


        String name = "HDMI Кабель";
        System.out.println(new StringBuilder()
                .append("Поиск товара, который находится в корзине")
                .append(name)
                .append(" - ")
                .append(productBasket.checkProduct(name)));
        printSeparator();

        name = "Телефон";
        System.out.println(new StringBuilder()
                .append("Поиск товара, Которого нет в корзине")
                .append(name)
                .append(" - ")
                .append(productBasket.checkProduct(name)));
        printSeparator();

        System.out.println(new StringBuilder("Печать содержимого перед стиранием"));
        productBasket.printProductBasket();
        productBasket.cleanBasket();
        printSeparator();

        System.out.println(new StringBuilder("Печать пустой корзины"));
        productBasket.printProductBasket();
        printSeparator();

        System.out.println(new StringBuilder()
                .append("Цена пустого")
                .append("Общая стоимость корзины: ")
                .append(productBasket.getSumOfProducts()));
        printSeparator();

        name = "Мышь";
        System.out.println(new StringBuilder()
                .append("Поиск товара по названию в пустой корзине")
                .append(name)
                .append(" - ")
                .append(productBasket.checkProduct(name)));
        printSeparator();


        System.out.println("Сумма чека корзины с несколькими товарами");
        System.out.println("Окончательная стоимсоть: " + productBasket.getSumOfProducts());
        System.out.println("Поиск товара в корзине");
        printSeparator();


        Article article1 = new Article("ПопСокет.", "Это универсальный держатель для телефона.");
        Article article2 = new Article("USB-C Кабель.", "Последовательный интерфейс для подключения периферийных устройств к вычислительной технике.");
        Article article3 = new Article("Наушники.", "Новая модель и функция шумоподавления.");


        SearchEngine searchEngine = new SearchEngine();

        try {

            searchEngine.add(product1);
            searchEngine.add(product2);
            searchEngine.add(product3);
            searchEngine.add(article1);
            searchEngine.add(article2);
            searchEngine.add(article3);
        } catch (IllegalArgumentException ex) {

            System.out.println(new StringBuilder("Ошибка: " + ex.getMessage()));
            return;
        }

        String query = "Наушники";

        System.out.println(new StringBuilder()
                .append("Поиск результата ")
                .append(query)
                .append(": ")
                .append(searchEngine.search(query))
                .append("\n"));


        query = "Мышь";
        System.out.println(new StringBuilder()
                .append("Поиск результата ")
                .append(query)
                .append(": ")
                .append(searchEngine.search(query))
                .append("\n"));

        query = "Провод";
        System.out.println(new StringBuilder()
                .append("Поиск результата ")
                .append(query)
                .append(": ")
                .append(searchEngine.search(query))
                .append("\n"));

        query = "Ноутбук";
        System.out.println(new StringBuilder()
                .append("Поиск результата ")
                .append(query)
                .append(": ")
                .append(searchEngine.search(query))
                .append("\n"));


        System.out.println(new StringBuilder("Поиск результата по имени: "));

        Map<String, Searchable> searchResults = searchEngine.search(query);
        for (Map.Entry<String, Searchable> entry : searchResults.entrySet()) {
            Searchable searchResult = entry.getValue();
            if (searchResult != null) {
                System.out.println(new StringBuilder()
                        .append("Имя searchable: ")
                        .append(searchResult.getStringRepresentation()));

            }
            printSeparator();

        }


        System.out.println(new StringBuilder("Создать SimpleProduct без имени:"));
        try {
            Product product10 = new SimpleProduct(" ", 1);
        } catch (IllegalArgumentException ex) {
            System.out.println(new StringBuilder()
                    .append("Ощибка: ")
                    .append(ex.getMessage())
                    .append("\n"));
        }

        System.out.println("Создать SimpleProduct без имени:");
        try {
            Product product10 = new SimpleProduct("ПопСокет", 1);
        } catch (IllegalArgumentException ex) {
            System.out.println("Ошибка: " + ex.getMessage());
        }


        System.out.println(new StringBuilder("Создать FixPriceProduct с неверным именем:"));
        try {
            Product product10 = new FixPriceProduct("  ");
        } catch (IllegalArgumentException ex) {
            System.out.println(new StringBuilder()
                    .append("Ошибка: ")
                    .append(ex.getMessage())
                    .append("\n"));
        }

        System.out.println(new StringBuilder("Создать DiscountedProduct с неверным именем:"));
        try {
            Product product10 = new DiscountedProduct(" ", 500, 20);
        } catch (IllegalArgumentException ex) {
            System.out.println(new StringBuilder()
                    .append("Ошибка: ")
                    .append(ex.getMessage())
                    .append("\n"));
        }

        System.out.println(new StringBuilder("Создать DiscountedProduct с неверной ценой:"));
        try {
            Product product10 = new DiscountedProduct("Наушники", 3300, 40);
        } catch (IllegalArgumentException ex) {
            System.out.println(new StringBuilder()
                    .append("Ошибка: ")
                    .append(ex.getMessage())
                    .append("\n"));

        }
        System.out.println(new StringBuilder("Создать DiscountedProduct с неправильной скидкой: "));
        try {
            Product product10 = new DiscountedProduct("Наушники", 4500, 200);
        } catch (IllegalArgumentException ex) {
            System.out.println(new StringBuilder()
                    .append("Ошибка: ")
                    .append(ex.getMessage())
                    .append("\n"));

        }

        printSeparator();


        Searchable bestResult;

        query = "Загадка эрудированный";
        System.out.println(new StringBuilder()
                .append("Поиск лучших результатов по запросу ")
                .append(query)
                .append("..."));
        try {
            bestResult = searchEngine.searchMostRelevant(query);
            System.out.println(new StringBuilder()
                    .append("Поиск результата ")
                    .append(query)
                    .append(": ")
                    .append(bestResult));

        } catch (BestResultNotFound ex) {

            System.out.println(new StringBuilder()
                    .append("Ошибка: ")
                    .append(ex.getMessage())
                    .append("\n"));

            query = "Книга";
            System.out.println(new StringBuilder()
                    .append("Поиск лучших результатов по запросу ")
                    .append(query)
                    .append(" "));
        }

        try {
            bestResult = searchEngine.searchMostRelevant(query);
            System.out.println(new StringBuilder()
                    .append("Поиск результата ")
                    .append(query)
                    .append(": ")
                    .append(bestResult));
        } catch (BestResultNotFound ex) {
            System.out.println(new StringBuilder()
                    .append("Ошибка: ")
                    .append(ex.getMessage())
                    .append("\n"));
        }
    }

    public static void printSeparator() {

        System.out.println(new StringBuilder("\n____________________________________________________________________________\n"));

    }
}
