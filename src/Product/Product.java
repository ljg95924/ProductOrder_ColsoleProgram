package Product;

public class Product {
    private long number;
    private String name;
    private int price;
    private int stockNum;


    public Product(long number, String name, int price, int stockNum) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.stockNum = stockNum;
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

    @Override
    public String toString() {
        return number + "   " + name + "    " + price + "   " + stockNum;
    }
}
