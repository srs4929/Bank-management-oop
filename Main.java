
import java.util.ArrayList;
import java.util.Scanner;

class Account
{
   String name;
   String accountnumber;
   double balance;

   Account(String name,String accountnumber,double balance)
   {
    this.name=name;
    this.accountnumber=accountnumber;
    this.balance=balance;
   }

   public void deposit(double amount)
   {
    balance+=amount;
   }
   public void withdraw(double amount)
   {
    balance-=amount;
   }

   public void display()
   {
    System.out.println("Name: "+name);
    System.out.println("Accountnumber: " +accountnumber);
    System.out.println("Balance: " +balance);

   }
}
class Bank
{  
    ArrayList<Account>accounts;
    Bank(){
    accounts=new ArrayList<Account>();
    }

    public void addAccount(Account account)
    {
        accounts.add(account);
    }


    public void removeAccount(Account account)
    {
        accounts.remove(account);
    }

    public void depositmoney(Account account,double amount)
    {
        account.deposit(amount);
    }
    
    public void withdrawmoney(Account account,double amount)
    {
        account.withdraw(amount);
    }

    public Account find(String name)
    {
        for(Account account:accounts)
        {
            if(account.name.equals(name))
            {
                     return account;
            }
        }
        return null;
    }
}

public class Main
{
    public static void main(String[] args)
    {
      Scanner scanner=new Scanner(System.in);
      Bank bank=new Bank();
      System.out.print("Enter the numbers of account you want to create:");
      int numAccount=scanner.nextInt();
      scanner.nextLine();
      for(int i=0;i<numAccount;i++)
      {
        System.out.print("Enter name for account "+( i+1)+":");
        String name=scanner.nextLine();
        System.out.print("Enter account number for account "+(i+1)+":");
        String accountnumber=scanner.nextLine();
        System.out.print("Enter inital balance for account "+(i+1)+":");
        double balance=scanner.nextDouble() ;
        scanner.nextLine() ;

        Account account=new Account(name,accountnumber,balance);
        bank.addAccount(account);

      }
      boolean exit=true;
      while(exit)
      {
        System.out.println("\nBanking System Menu:");
        System.out.println("1: Deposit");
        System.out.println("2: Withdraw");
        System.out.println("3. View Account Details");
        System.out.println("4.Exit");

        System.out.print("Choose an option");
        
        int choice=scanner.nextInt();
        scanner.nextLine();
        switch(choice)
        {
            case 1:
            System.out.print("Enter account name: ");
            String def=scanner.nextLine();
            Account deposit=bank.find(def);
            if(deposit!=null)
            {
                System.out.print("Enter amount to deposit: ");
                double amount=scanner.nextDouble();
                scanner.nextLine();
                bank.depositmoney(deposit,amount);
                System.out.println("Deposit Successful");

            }
            else
            {
                System.out.println("Account not found");
            }
            break;

            case 2:
            System.out.print("Enter account name: ");
            String withdrawaccount=scanner.nextLine();
            Account withdraw=bank.find(withdrawaccount);
            if(withdraw!=null)
            {
                System.out.print("Enter amount to withdraw: ");
                double amount=scanner.nextDouble();
                scanner.nextLine();
                bank.withdrawmoney(withdraw,amount);
                System.out.println("Withdraw Successful");

            }
            else
            {
                System.out.println("Account not found");
            }
            break;

            case 3:
            System.out.print("Enter account name to view details: ");
            String view=scanner.nextLine();
            Account viewdetails=bank.find(view);
            if(viewdetails!=null)
            {
                viewdetails.display();
            }
            else
            {
                System.out.println("Account not found");
            }
            break;

            case 4:
            exit=false;
            System.out.println("Exiting the banking system");
            break;

            default:
            System.out.println("Invalid choice,System not found");



        }


        


      }
      scanner.close() ; 

    }
}