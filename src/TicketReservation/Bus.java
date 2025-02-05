package TicketReservation;

import java.util.ArrayList;
import java.util.List;

public class Bus {

   // 2-plaka, koltuk sayısı, koltuk numaraları:özellik,alan,field

    private String numberPlate;

    private int numberOfSeat;

    private List<String> seats = new ArrayList<>();

    //3-param.li constructor:otobüs obj sini olustururken aynı zamanda fieldlerini set edebiliriz
    //Parametreli constructor olusturdugumuz icin olusturdugumuz  objeye parametreler ekledik.
    // Bu objeyle constructorlarin özelliklerini kullanacagiz

    public Bus(int numberOfSeat, String numberPlate) {
        this.numberOfSeat = numberOfSeat;
        this.numberPlate = numberPlate;
        for (int i =1; i <= numberOfSeat; i++){
            this.seats.add(String.valueOf(i));
            //this.seats.add(i + "");
        }
    }


    //getter-setter


    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public List<String> getSeats() {
        return seats;
    }

    public void setSeats(List<String> seats) {
        this.seats = seats;
    }
}
