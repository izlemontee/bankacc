package src.java;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    private float amt;
    private String date;
    private String time;
    private boolean add;

    public Transaction(float amt, String date, String time, boolean add){
        this.amt = amt;
        this.date = date;
        this.time = time;
        this.add = add;
    }


    public float getAmt(){return amt;}
    public void description(){
        if(add){
            System.out.printf("%f added on %s at %s.\n",amt,date,time);
        }
        else{
            System.out.printf("%f deducted on %s at %s.\n",amt,date,time);
        }



    }
    
}
