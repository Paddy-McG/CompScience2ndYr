import java.util.Scanner;

//  Checking to see if a number is a prime
public class Lab1_03_10_23
{
    public static void main(String [] args)
    {   
        // Asking the user which type of input he would like to enter

        System.out.println("1. To check if a single number is a prime press 1");
        System.out.println("2. To check if a range of numbers are prime press 2");
        System.out.println("To exit press any other number");

        Scanner sc = new Scanner(System.in);

        int choice = sc.nextInt();

        if(choice == 1)
        {
            System.out.println("Please enter the digit you would like to test");
            int num1 = sc.nextInt();
            single(num1);
        } else if(choice == 2)
        {
            System.out.println("Please enter the first digit you would like to check the range of");
            int num1 = sc.nextInt();
            System.out.println("Please enter the second digit you would like to check the range of");
            int num2 = sc.nextInt();
            range(num1, num2);
        } else 
        {
            System.out.println("You have exited");
        }

        sc.close();
    }

    public static void single(int num)
    {
        boolean prime = true;
        for(int i = 2; i < num; i ++)
        {
            if(num % i == 0)
            {
                prime = false;
            } 
        }

        if(prime == false)
        {
            System.out.println(num + " is not a prime number");
        }
        else {
            System.out.println(num + " is a prime number");
        }
    }

    public static void range(int num1, int num2)
    {
        boolean prime = true;

        System.out.print("The prime numbers in the range[" + num1 + "," + num2 + "]:");

        for(int i = num1; i <= num2; i ++)
        {
            for(int j = 2; j < i; j ++)
            {
                if(i % j == 0)
                {
                    prime = false;
                }
            }
            if(prime == true)
            {
                System.out.print(i + " ");
            }
            prime = true;
        }
    }
}