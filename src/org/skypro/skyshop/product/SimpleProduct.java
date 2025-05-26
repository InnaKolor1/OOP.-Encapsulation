package org.skypro.skyshop.product;

import javax.swing.text.Utilities;
import java.util.Objects;

public class SimpleProduct extends Product implements org.skypro.skyshop.search.Searchable {
    private final double price;

    public SimpleProduct(String name, double price) {
        super(name);
        if (price<=0){
            throw new IllegalArgumentException("Цена товара должна быть больше 0.");
        }
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f ₽", getName(), getPrice());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SimpleProduct that = (SimpleProduct) o;
        return Double.compare(that.price, price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), price);
    }
}