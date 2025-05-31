package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;



public class ProductBasket {
    private final List<Product> basket = new ArrayList<>();
    private final List<Product> deletedProducts = new LinkedList<>();

    public void addProduct(Product product) {
        basket.add(product);
    }

    public List<Product> deleteProductsByName(String name) {
        Iterator<Product> iterator = basket.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product != null && Objects.equals(product.getName(), name)) {
                deletedProducts.add(product);
                iterator.remove();
            }
        }
        return deletedProducts;
    }

    public void printDeletedProducts() {
        StringBuilder sb = new StringBuilder("Список удаленных продуктов");
        if (!deletedProducts.isEmpty()) {
            for (Product product : deletedProducts) {
                sb.append(product).append("\n");
            }
        } else {
            sb.append("Список пуст");
        }
        System.out.println(sb.toString());
    }

    public double getSumOfProducts() {
        double sum = 0;
        for (Product product : basket) {
            if (product != null) {
                sum += product.getPrice();
            }
        }
        return sum;
    }

    private boolean basketIsNotEmpty() {
        return !basket.isEmpty();
    }

    public void printProductBasket() {
        if (!basketIsNotEmpty()) {
            System.out.println("Корзина пуста");
            return;
        }
        StringBuilder sb = new StringBuilder();
        double sum = 0;
        int specialGoods = 0;

        for (Product product : basket) {
            if (product != null) {
                sb.append(product).append("\n");
                sum += product.getPrice();
                if (product.isSpecial()) {
                    specialGoods++;
                }
            }
        }

        sb.append("--------------------------------------------------\n")
                .append(String.format("Итого: %.2f ₽\n", sum))
                .append(String.format("Специальные товары: %d\n", specialGoods));

        System.out.println(sb.toString());
    }

    public boolean checkProduct(String name) {
        for (Product product : basket) {
            if (product != null && Objects.equals(product.getName(), name)) {
                return true;
            }
        }
        return false;
    }

    public void cleanBasket() {
        basket.clear();
    }
}