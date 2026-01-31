import java.util.Scanner;
 
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance){
        balance = initialBalance;
    }

    public double getBalance(){
         return balance;
    }

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Depisit successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount)
    {
        if (amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("Withdraw successful.");
            return true;
        } else {
            System.out.println("Insufficient balance or invalid amount.");
            return false;
        }
    }
}

public class ATMInterface {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount (1000);

        boolean exit = false;

        System.out.println("Welcome to the ATM!");

        while (!exit){

            System.out.println("\n----- ATM MENU -----");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice){

                case 1:
                    System.out.println("Current Balance: ₹" + account.getBalance());
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmont = scanner.nextDouble();
                    account.deposit(depositAmont);
                    break;
                    
                case 3:
                    System.out.println("Enter withdrawal amount: ");
                    double withdrawAccount = scanner.nextDouble();
                    account.withdraw(withdrawAccount);
                    break;
                
                
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the ATM.");
                    break;

                    default:
                        System.out.println("Invalid option. Please try again.");
            }

        }
         
        scanner.close();
        
    }
}