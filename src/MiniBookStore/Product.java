package MiniBookStore;
//1-a-tüm productlar için ortak olan özellikler

//POJO:plain old java object
//-field->private
//-paramli/siz constructor
//getter-setter
//toString
public class Product {
    private static int counter=0;
    private int id;
    private String name;
    private double price;
    private int stock;

    //default
    public Product(){}

    //paramli const
    public Product(String name, double price, int stock) {
        counter++;
        this.id = counter;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    //getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    //setter

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}