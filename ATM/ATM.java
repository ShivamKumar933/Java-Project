import java.util.Scanner;


public class ATM{
    private static class Users{
        int balance;
        int pin;
        String name;

        public void setBalance(int balance) {
            this.balance = balance;
        }
        public void setPin(int pin) {
            this.pin = pin;
        }
        public void setName(String name){
            this.name = name;
        }
        public int getBalance() {
            return balance;
        }
    }

    int balance;

    static Users user = new Users();
    static{
        user.setBalance(10000);
        user.setPin(1234);
        user.setName("Shivam");
    }

    public void start(){
        boolean temp = logIn();

        while (!temp) {
            temp = logIn();
        }

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\t-----------------------------------------");
            System.out.println("\t-------------------ATM-------------------");
            System.out.println("\t-----------------------------------------");

            System.out.println("\n\t\tEnter 1 : Withdraw Money");
            System.out.println("\n\t\tEnter 2 : Check Balance");
            System.out.println("\n\t\tEnter 3 : Deposit Money ");
            System.out.println("\n\t\tEnter 4 : Fast Cash");
            System.out.println("\n\t\tAny other key to Exit");

            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    showBalance();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    fastCash();
                    break;

                default:
                    System.exit(0);
                    break;
            }
        }
        
    }

    private void fastCash(){
        Scanner sc = new Scanner(System.in);

        System.out.println("\n\t-----------------------------------------");
        System.out.println("\t-----------------FASTCASH----------------");
        System.out.println("\t-----------------------------------------");
        System.out.println("\n\tEnter 1 : 1000\t\tEnter 4 : 25000");
        System.out.println("\n\tEnter 2 : 5000\t\tEnter 5 : 50000");
        System.out.println("\n\tEnter 3 : 10000\t\tEnter 6 : 100000");
        System.out.println("\n\n\tEnter 0 : Main Menu");
        System.out.println("\n\n\tEnter Any Other Number To Exit");
        System.out.println("\n\n\t\tEnter Your Choice");
        int choice = sc.nextInt();

        balance = user.balance;
        switch(choice){
            case 0:
            break;
            case 1 :
                if(1000>balance){
                    System.out.println("\n\tNot Sufficient Balance Please Enter A Valid Amount");
                    fastCash();
                }
                else{
                    user.balance -= 1000;
                    System.out.println("\n\t\tRS.1000 Successfully withdrawed");
                }
            break;
            case 2 :
                if(5000>balance){
                    System.out.println("\n\tNot Sufficient Balance Please Enter A Valid Amount");
                    fastCash();
                }
                else{
                    user.balance -= 5000;
                    System.out.println("\n\t\tRS.5000 Successfully withdrawed");
                }
            break;
            case 3 :
                if(10000>balance){
                    System.out.println("\n\tNot Sufficient Balance Please Enter A Valid Amount");
                    fastCash();
                }
                else{
                    user.balance -= 10000;
                    System.out.println("\n\t\tRS.10000 Successfully withdrawed");
                }
            break;
            case 4 :
                if(25000>balance){
                    System.out.println("\n\tNot Sufficient Balance Please Enter A Valid Amount");
                    fastCash();
                }
                else{
                    user.balance -= 25000;
                    System.out.println("\n\t\tRS.25000 Successfully withdrawed");
                }
            break;
            case 5 :
                if(50000>balance){
                    System.out.println("\n\tNot Sufficient Balance Please Enter A Valid Amount");
                    fastCash();
                }
                else{
                    user.balance -= 50000;
                    System.out.println("\n\t\tRS.50000 Successfully withdrawed");
                }
            break;
            case 6 :
                if(100000>balance){
                    System.out.println("\n\tNot Sufficient Balance Please Enter A Valid Amount");
                    fastCash();
                }
                else{
                    user.balance -= 100000;
                    System.out.println("\n\t\tRS.100000 Successfully withdrawed");
                }
            break;

            default:
                System.exit(0);
        }
    }

    private void deposit(){
        Scanner sc = new Scanner(System.in);

        System.out.println("\n\t-----------------------------------------");
        System.out.println("\t-----------------DEPOSIT-----------------");
        System.out.println("\t-----------------------------------------");
        System.out.println("\n\t\tEnter the amount : ");
        int p = sc.nextInt();

        if(p>0){
            user.balance += p;
            System.out.println("\n\t\tMoney successfully Deposited");
        }
        else{
            System.out.println("Enter valid Amount");
            deposit();
        }
    }
 
    private void showBalance(){
        Scanner sc = new Scanner(System.in);

        System.out.println("\n\t-----------------------------------------");
        System.out.println("\t-----------------BALANCE-----------------");
        System.out.println("\t-----------------------------------------");

        System.out.println("\n\t\tCurrent Balance : "+ user.getBalance());

        System.out.println("\n\tEnter 1 : Main menu");
        System.out.println("\n\tEnter any other number to Exit");

        int choice = sc.nextInt();
        if(choice==1){
            return;
        }
        else{
            System.exit(0);
        }
    }
 
    private boolean checkIsTrue(String n, int p){
        if(user.name.equalsIgnoreCase(n) && user.pin == p)
            return true;
        return false;
    }
 
    private boolean logIn(){
        System.out.println("\t-----------------------------------------");
        System.out.println("\t-----------------LOGIN-------------------");
        System.out.println("\t-----------------------------------------");

        Scanner sc = new Scanner(System.in);
        System.out.println("\tEnter your name : ");
        String n = sc.next();
        System.out.println("\tEnter the pin");
        int p = sc.nextInt();

        boolean temp = checkIsTrue(n, p);

        if(temp==false){
            System.out.println("\t\tWrong Name or Pin");
            return false;
        }
        System.out.println("\n\t\tSuccessfully logged in");
        return true;
    }

    private void withdraw(){
        System.out.println("\t-----------------------------------------");
        System.out.println("\t----------------WithDraw-----------------");
        System.out.println("\t-----------------------------------------");
        Scanner sc = new Scanner(System.in);
        
        int balance = user.balance;
        System.out.println("\n\t\tCurrent Balance : "+ balance);
        System.out.println("\n\tEnter how much money you want to withdraw");
        System.out.println("\n\t(Amount should be >= 500 ,And <= 10000 And Multiple of 100)");
        int amount = sc.nextInt();

        if(amount > balance){
            System.out.println("\tNot sufficient Balance Please enter a valid amount");
            withdraw();
        }
        else if(amount>=500 && amount<=10000 && amount%100==0){
            user.balance = balance - amount;
            balance = user.balance;
            System.out.println("\t" + amount + " withdrawed remaining balance is : "+balance);
        }
        else{
            System.out.println("\n\tPlease Enter A Valid Amount");
            withdraw();
        }   
        
    }
}
