package MiniBookStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

//2-a-ProductService i implemente et ve metodları book a uygun şekilde doldur
public class BookService implements ProductService{

    Scanner inp=new Scanner(System.in);

    //3-kitapları saklamak için list oluşturalım
    List<Book> bookList=new ArrayList<>();

    //4-başlangıçta kayıtlı kitaplar olsun:test için
    public BookService(){
        Book book1=new Book("Vadideki Zambak",150.0,25,"Balzac","Penguin");
        Book book2=new Book("Suç ve Ceza",150.0,12,"Dostoyevski","Penguin");
        Book book3=new Book("Sefiller",125.0,15,"V.Hugo","Dream");
        this.bookList.add(book1);
        this.bookList.add(book2);
        this.bookList.add(book3);
    }


    //5-bookla ilgili işlemleri gösteren menü
    @Override
    public void processMenu() {

        int select;

        do {
            System.out.println("----------------------------------------------");
            System.out.println("1-Kitapları Listele");
            System.out.println("2-Kitap Ekle");
            System.out.println("3-Kitap Sil");
            System.out.println("4-Yayınevine göre filtrele");
            System.out.println("0-Geri Dön");
            System.out.println("Seçiminiz: ");
            select=inp.nextInt();
            inp.nextLine();
            switch (select){
                case 1:
                    listProducts();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    listProducts();
                    removeProduct();
                    break;
                case 4:
                    System.out.println("Yayınevi : ");
                    String pub=inp.nextLine();
                    filterProduct(pub);
                    break;
                case 0:
                    System.out.println("Ana menüye yönlendiriliyorsunuz...");
                    break;
                default:
                    System.out.println("Hatalı giriş!");
                    break;
            }

        }while (select!=0);

    }

    //6-kitapları yazdırma
    @Override
    public void listProducts() {
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("%-2s | %-20s | %-15s | %-10s | %-10s | %-5s \n","ID","Kitap Adı","Yazar","Yayınevi","Fiyat","Stok");
        for (Book book:this.bookList){
            System.out.printf("%-2s | %-20s | %-15s | %-10s | %-10s | %-5s \n",
                    book.getId(),book.getName(),book.getAuthorName(),
                    book.getPublisher(),book.getPrice(),book.getStock());
        }
        System.out.println("------------------------------------------------------------------------");

    }

    //7-kullanıcıdan alınan bilgilere göre listeye kitap ekleme
    //exercise: ISBN nosu olsaydı? bu kitap mevcut mu?
    //evet:yeni kitap eklenmez, stok artırılır
    //hayır:yeni kitap oluşturulur
    @Override
    public void addProduct() {
        System.out.println("Kitap adı : ");
        String bookname=inp.nextLine();
        System.out.println("Yazar adı : ");
        String author=inp.nextLine();
        System.out.println("Yayınevi  : ");
        String pub=inp.nextLine();
        System.out.println("Fiyat     : ");
        double price= inp.nextDouble();
        System.out.println("Stok     : ");
        int stock= inp.nextInt();

        Book newBook=new Book(bookname,price,stock,author,pub);
        this.bookList.add(newBook);

    }

    //8-kullanıcıdan id al, kitabı bulalım, listeden sil
    @Override
    public void removeProduct() {

        boolean isExist=false;
        System.out.println("Kitap id : ");
        int id=inp.nextInt();
        for (Book book:this.bookList){
            if (book.getId()==id){
                isExist=true;
                this.bookList.remove(book);
                System.out.println("Kitap silindi.");
                break;
            }
        }
        if (!isExist){
            System.out.println("Kitap bulunamadı!");
        }

    }

    //9-tüm kitapların yayınevlerini kontrol edip, filtre ile aynı ise yazdır
    @Override
    public void filterProduct(String filter) {

        System.out.println("------------------------------------------------------------------------");
        System.out.printf("%-2s | %-20s | %-15s | %-10s | %-10s | %-5s \n","ID","Kitap Adı","Yazar","Yayınevi","Fiyat","Stok");
        for (Book book:this.bookList){
            if (book.getPublisher().equalsIgnoreCase(filter)) {
                System.out.printf("%-2s | %-20s | %-15s | %-10s | %-10s | %-5s \n",
                        book.getId(), book.getName(), book.getAuthorName(),
                        book.getPublisher(), book.getPrice(), book.getStock());
            }
        }
        System.out.println("------------------------------------------------------------------------");

    }
}