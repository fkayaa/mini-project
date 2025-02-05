package TicketReservation;

import java.util.Scanner;

public class TicketReservationApp {
    
    public static void main(String[] args) {

        start();
    }
    
    private static void start() {

        //1-bilet ve otobüs objelerini olusturalım
        Bus bus = new Bus(33,"34 TPE 789");
        //seats : "1","2","3",....."33"

        Ticket ticket;

        Scanner scanner = new Scanner(System.in);
        int select; //çıkış için 0'ı seciniz

        do {//kullanıcıdan bilgilerini alalım
            System.out.println("Bilet rezervasyon sistemine hoşgeldiniz");

            System.out.println("Lütfen ad - soyad giriniz");
            String name = scanner.nextLine();

            System.out.println("Lütfen yasınızı giriniz");
            int age = scanner.nextInt();

            System.out.println("Lütfen gidilecek mesafeyi giriniz (KM)");
            int km = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Lütfen yolculuk tipini seçiniz");
            System.out.println("1-Tek Yön");
            System.out.println("2-Çift Yön");
            int type = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Lütfen koltuk no giriniz : ");
            System.out.println("BİLGİ : 3 ün katı numaralı koltuk numaralarının ücreti %20 daha fazladır ! ");
            System.out.println(bus.getSeats()); //koltuk noları listelenecek
            String seat = scanner.next();

            //koltuk no rezerve edilmiş olabilir veya otobüste yok
            boolean isReserved = !bus.getSeats().contains(seat);
            //TRUE : koltuk rezerve edilmiş



            //girilen degerler gecerli mi ?
            if (km > 0 && age > 0 && (type == 1 || type == 2)) {
                //bileti hazırlayalım
                ticket = new Ticket(km,type,seat,bus);
                ticket.setPrice(age);

                //satılan koltugu listeden kaldıralım:
                ticket.getBus().getSeats().remove(seat);

                //bileti yazdıralım
                ticket.printTicket(name);

            }else {

                if (isReserved) {
                    System.out.println("Sayın Yolcu seçilen koltuk rezerve edilmiş veya bu numarada koltugumuz yok");
                }else {
                    System.out.println("Hatalı veri girdiniz");
                }
            }

            System.out.println("Yeni işlem için bir sayı giriniz , ÇIKIŞ için 0 giriniz : ");
            select = scanner.nextInt();
            scanner.nextLine();

        }while (select != 0);
        System.out.println("İyi günler dileriz, yine bekleriz ...");






    }
}
