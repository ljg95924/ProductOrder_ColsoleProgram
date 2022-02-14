package product.dao;

public class Product {
    private long number;
    private String name;
    private int price;
    private int stockAmount;


    public Product(long number, String name, int price, int stockAmount) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.stockAmount = stockAmount;
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

    public void setStockAmount(int stockAmount) {
        if (stockAmount <= 0) {
            System.out.println("재고부족Exception! 해당 제품 현재 재고량은 " + this.stockAmount);
        } else {
            this.stockAmount = stockAmount;
        }

    }

    public int getStockAmount() {
        return stockAmount;
    }

    @Override
    public String toString() {
        return number + "   " + name + "    " + price + "   " + stockAmount;
    }
}
