package TicketReservation;

public class Ticket {

    //4-mesafe bilgisi(KM) , yolculuk tipi , koltuk numarası , fiyat , otobüs bilgileri
    private double distance;
    private int typeNo;
    private String seatNo;
    private double price;

    //composition:bir sınıfın başka bir sınıfın örneğine sahip olmasıdır,
    // has a ilişkisi vardır
    private Bus bus;//bu bilet hangi otobüse ait


    //param.li cons


    public Ticket(double distance, int typeNo, String seatNo, Bus bus) {
        this.distance = distance;
        this.typeNo = typeNo;
        this.seatNo = seatNo;
        this.bus = bus;
    }

    //getter
    public double getDistance() {
        return distance;
    }

    public int getTypeNo() {
        return typeNo;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public double getPrice() {
        return price;
    }

    public Bus getBus() {
        return bus;
    }

    //setter

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setTypeNo(int typeNo) {
        this.typeNo = typeNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    //5-bilet fiyatını kurallara göre hesaplama ve set etme !
    public void setPrice(int age) {
        //buradaki hesaplamalar sonucunda gerekli kosullar saglandıgında ancak deger set edilebilir
        double total = 0;

           int seatNo  = Integer.valueOf(this.seatNo);

           switch (this.typeNo) {
               case 1 : //tek yön
                   if(seatNo % 3 == 0) {
                       total = this.distance*1.2;
                   }else {
                       total = this.distance*1;
                   }
                   break;
               case 2: //çift yön
                   if(seatNo % 3 == 0) {
                       total = this.distance*1.2*2;
                   }else {
                       total = this.distance*2;
                   }
                   System.out.println("Toplam tutar :" + total);
                   total = total*0.8;//%20 indirim
                   System.out.println("Çift yön indirimli tutar :" + total);
                   break;

           }

           //yas indirimi :
        if (age < 12) {

            total = total * 0.5;
            System.out.println("12 yas indirimli tutar :" + total);

        } else if (age > 65) {

            total =total * 0.7;
            System.out.println("65 yas indirimli tutar : " + total);
        }

        this.price = total;

    }

    //6-bilet dökümü yazdıralım :
    public void printTicket(String name) {

        System.out.println("*".repeat(42));
        System.out.println("--- Bilet Detayı ---");
        System.out.println("Sayın "+name);
        System.out.println("Otobüs plakası  : "+ this.bus.getNumberPlate());
        System.out.println("Mesafe(KM)      : "+this.distance);
        System.out.println("Yolculuk tipi   : "+((this.typeNo == 1) ? "Tek Yön" : "Çift Yön"));
        System.out.println("Koltuk No       : "+this.seatNo);
        System.out.println("Toplam Tutar    : "+this.price);
        System.out.println("Keyfili yolculuklar dileriz...:)");
        System.out.println("*".repeat(42));

    }






















}
