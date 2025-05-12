package org.skypro.skyshop.product;

import java.util.Objects;

public class DiscountedProduct extends Product {
    private final double price;
    private final int discount;

    public DiscountedProduct(String name, double price, int discount) {
        super(name);
        this.price = price;
        this.discount = discount;
    }

    private double calculateDiscountedPrice() {
        return price - (price * discount / 100);
    }

    @Override
    public double getPrice() {
        return calculateDiscountedPrice();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return String.format("Sale! %s: %.2f ₽ (%d%%)", getName(), getPrice(), discount);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountedProduct that = (DiscountedProduct) o;
        return Double.compare(that.price, price) == 0 && discount == that.discount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), price, discount);
    }
}