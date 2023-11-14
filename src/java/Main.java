package src.java;

import java.io.Console;
import java.util.*;

import java.time.LocalDate;
import java.time.LocalTime;


public class Main {

    public static final String STOP = "stop";
    public static final String OPEN = "open";
    public static final String CLOSE = "close";
    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    //public List<BankAccount> accounts =  new LinkedList<BankAccount>();
    public static Map<String,BankAccount> accounts = new HashMap<String,BankAccount>();

    public static void main(String[] args){
        Console cons = System.console();
        boolean stop = false;
        BankAccount ba = null;
        while(!stop){
            String input = cons.readLine(">");
            input = input.toLowerCase();
            String[] inputSplit = input.split(" ");
            String cmd = inputSplit[0];
            switch(cmd){
                case STOP:
                stop = true;
                break;
                case OPEN:
                {
                    String name = inputSplit[1];
                    if(accounts.containsKey(name)){
                        System.out.println("Account exists.");
                    }
                    else{
                        if(inputSplit.length > 2){
                            String balString = inputSplit[2];
                            float bal = Float.parseFloat(balString);
                            ba = new BankAccount(name,bal);
                        }
                        else{
                            ba = new BankAccount(name);           
                        }
                        accounts.put(name,ba);
                        boolean status = false;
                        //set the close status
                        ba.setStatus(status);
                        System.out.println("Account opened.");
                    }
                    break;
                }
                case CLOSE:{
                    String name = inputSplit[1];
                    if(!accounts.containsKey(name)){
                        System.out.println("Account does not exist.");
                    }
                    //close the account
                    else{
                        ba = accounts.get(name);
                        boolean status = false;
                        ba.setStatus(status);
                        System.out.println("Account closed.");
                    }
                    break;
                }
                case DEPOSIT:{
                    if(accounts.containsKey(inputSplit[1])){
                        //get the account
                        ba = accounts.get(inputSplit[1]);
                        //get the open/close status
                        boolean isClosed = ba.getStatus();
                        System.out.printf("Close status: %s\n",isClosed);
                        if(isClosed){
                            throw new IllegalArgumentException("Account is already closed.");
                        }
                        else{                       //get date time
                            String ld = LocalDate.now().toString();
                            String time = LocalTime.now().toString();
                            //enter amount
                            float amt = Float.parseFloat(inputSplit[2]);
                            System.out.printf("Deposit made at %s and %s\n",ld,time);
                            //make new transaction object
                            boolean add = true;
                            //add to bank account
                            Transaction t = new Transaction(amt,ld,time,add);
                        }
                    }
                    else{
                        System.out.println("Account does not exist.");
                    }
                    break;
                }
                case WITHDRAW:{
                    //get date time
                    String ld = LocalDate.now().toString();
                    String time = LocalTime.now().toString();
                    //enter amount
                    float amt = Float.parseFloat(inputSplit[1]);
                    System.out.printf("Deposit made at %s and %s\n",ld,time);
                    //make new transaction object
                    boolean add = false;
                    //add to bank account
                    Transaction t = new Transaction(amt,ld,time,add);
                    break;
                }




                

                
                

                default:
                System.out.println("Invalid command.");
                break;
            }
            
        }
        System.out.println("Bye");
    }
    
}
