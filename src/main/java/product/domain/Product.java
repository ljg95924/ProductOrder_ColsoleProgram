package product.domain;

import java.util.Objects;

public class Product {
    private final long number;
    private final String name;
    private final int price;
    private int stockAmount;

    private Product(long number, String name, int price, int stockAmount) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.stockAmount = stockAmount;
    }

    public static Product addProduct(long number, String name, int price, int stockAmount) {
        return new Product(number, name, price, stockAmount);
    }

    public static Product orderedProduct(long number, String name, int price, int orderAmount) {
        return new Product(number, name, price, orderAmount);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public long getNumber() {
        return number;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void minusStock(int orderAmount) {
        this.stockAmount -= orderAmount;
    }

    public boolean checkStockAmount(int orderAmount) {
        if (this.stockAmount > orderAmount && stockAmount > 0) {
            minusStock(orderAmount);
            return true;
        }
        System.out.println("재고부족Exception! 해당 제품 현재 재고량은 " + this.stockAmount);
        return false;
    }

    public void printOrderProduct() {
        System.out.println(getName() + " - " + getStockAmount() + "개");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return number == product.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return number + "   " + name + "    " + price + "   " + stockAmount;
    }
}
