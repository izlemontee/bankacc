package src.java;

public class FixedDepositAccount extends BankAccount {

    private float interest = 3;
    private Integer duration = 6;
    private boolean interestChanged = false;
    private boolean durationChanged = false;
    private boolean isClosed = false;

    public FixedDepositAccount(String accountName, float balance){
        super(accountName, balance);
        System.out.printf("Balance: $%.2f\n",balance);
    }
    public FixedDepositAccount(String accountName, float balance,float interest){
        super(accountName, balance);
        this.interest = interest;
    }
    public FixedDepositAccount(String accountName, float balance, float interest, Integer duration){
        super(accountName, balance);
        this.interest = interest;
        this.duration = duration;
    }

    //@Override
    public void withdraw(){
        System.out.println("Withdraw denied.");

    }

    public void deposit(){
        System.out.println("Deposit denied.");

    }

    //getBalance() should return the
    // balance plus the interest viz if 
    //interest is 3 and balance is 100, the getBalance() should return 103
    public float getBalance(){
        System.out.printf("Interest: %.2f\n",interest);
        System.out.printf("Balance: %.2f\n",balance);
        float interestEarned = interest * balance /100;

        return balance + interestEarned;
        //return balance;
    }

    public float changeInterest (float interest){
        if(interestChanged){
            throw new IllegalArgumentException("Interest rate already changed.");
        }
        else{
            this.interest = interest;
            interestChanged = true;
        }
        return interest;
    }

    public Integer changeDuration (Integer duration){
        if(durationChanged){
            throw new IllegalArgumentException("Duration already changed.");
        }
        else{
            this.duration = duration;
            durationChanged = true;
        }
        return duration;
    }
    public String getname(){return accountName;}
    public boolean getDurationChanged(){return durationChanged;}
    public boolean getInterestChanged(){return interestChanged;}

    
}
