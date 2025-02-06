package MiniBookStore;
//2-tüm ürünlerin işlemleri(yani tüm servislerin zorunlu olduğu kurallar)
public interface ProductService {
    void processMenu();
    void listProducts();
    void addProduct();
    void removeProduct();
    void filterProduct(String filter);
}