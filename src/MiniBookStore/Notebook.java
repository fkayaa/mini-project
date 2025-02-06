package MiniBookStore;
//1-c-notebookun öz: product öz+sheets+brand
public class Notebook extends Product{

    private int sheets;
    private String brand;

    //paramli const

    public Notebook(String name, double price, int stock, int sheets, String brand) {
        super(name, price, stock);
        this.sheets = sheets;
        this.brand = brand;
    }


    //getter-setter

    public int getSheets() {
        return sheets;
    }

    public void setSheets(int sheets) {
        this.sheets = sheets;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}