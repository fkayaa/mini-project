package MiniBookStore;

import java.util.Scanner;

public class MiniBookStoreApp {
    public static void main(String[] args) {
        start();
    }
    //1-product ,book, notebook classlarını oluşturalım

    private static void start() {

        //10-kategori menüsü
        Scanner scanner=new Scanner(System.in);
        System.out.println("--- Mini Book Store ---");
        int select;

        do {
            System.out.println("Ürün Yönetim Paneli");
            System.out.println("1-Kitaplar");
            System.out.println("2-Defterler");
            System.out.println("0-ÇIKIŞ");
            System.out.println("Seçiminiz : ");
            select= scanner.nextInt();

            //1 veya 2 seçilirse servis(productservice) objesi gerekli
            ProductService service;
            if (select==1 || select==2){
                service=select==1 ? new BookService() : new NotebookService();
                service.processMenu();
            } else if (select==0) {
                System.out.println("İyi günler..");
            }else {
                System.out.println("Hatalı giriş!");
            }
        }while (select!=0);




    }
}