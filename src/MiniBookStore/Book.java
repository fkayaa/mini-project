package MiniBookStore;
//1-b-bookun öz: product öz+authorName+publisher

public class Book extends Product{

    private String authorName;
    private String publisher;

    //paramli const
    public Book(String name, double price, int stock, String authorName, String publisher) {
        super(name, price, stock);
        this.authorName = authorName;
        this.publisher = publisher;
    }

    //getter-setter
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

}