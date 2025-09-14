public class BankAccount {
    private double balance;
    private String userID;

    public BankAccount(double balance, String userID){
        this.balance = balance;
        this.userID = userID;
    }
    public BankAccount(){
        this.balance = 0;
        this.userID = "";
    }

    public void getBalance(){
        System.out.println(balance);
    }

    public void getUserID(){
        System.out.println(userID);
    }

    public void deposit(double number){
        if(number > 0) this.balance += number;
    }

    public void withdraw(double number){
        if(number > 0){
            if(number <= this.balance){
                this.balance -= number;
            }else{
                System.out.println("you too broke homie");
            }
        }else{
            System.out.println("Invalid input.");
        }
    }
}
