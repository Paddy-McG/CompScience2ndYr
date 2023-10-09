import java.util.Scanner;

public class Lab2_10_10_23
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);

        String s1;
        int len;

        // Taking the input in and making sure it has between 4-30 Digits if not it runs again

        do 
        {
            System.out.println("Please enter the number you would like to test between 4-30 digits");
            s1 = sc.nextLine();
            len = s1.length();
        } while (len < 4 || len > 30);
        sc.close();

        //Sending the string off to be split into 2 doubles that we can work with

        double d1 = splitingUpFirst(s1);
        double d2 = splittingSecTime(s1);

        int num = addingDigs(d1) + multDig(d2);
        if(num % 10 == 0)
        {
            System.out.println(num);
            System.out.println("The number you entered is VALID");
        } else {
            System.out.println(num);
            System.out.println("The number you entered is NOT VALID");
        }
    }

    public static double splitingUpFirst(String s1)
    {
        int len = s1.length();
        double d1;
        String s2 = "";

        if(len % 2 == 0)
        {
            for(int i = 1; i < (s1.length()); i++)
            {
                s2 += s1.substring(i, i+1);
                i++;
            }
        } else {
            for(int i = 0; i < (s1.length()); i++)
            {
                s2 += s1.substring(i, i+1);
                i++;
            }
        }

        d1 = Double.parseDouble(s2);
        return d1;
    }

    public static double splittingSecTime(String s1)
    {
        int len = s1.length();
        double d1;
        String s2 = "";

        if(len % 2 == 0)
        {
         for(int i = 0; i < (s1.length()); i++)
            {
                s2 += s1.substring(i, i+1);
                i++;
            }   
        } else {
            
            for(int i = 1; i < (s1.length()); i++)
            {
                s2 += s1.substring(i, i+1);
                i++;
            }
        }

        d1 = Double.parseDouble(s2);
        return d1;
    }

    public static int addingDigs(double d1)
    {
        int num1 = 0;
        do{
            num1 += d1 % 10;
            d1 /= 10;
        }while(d1 > 0);
        System.out.println(num1);
        return num1;
    }
    
    public static int multDig(double d1)
    {
        int num1 = 0;
        System.out.println(d1);
        int num3 = (int)Math.round(d1);
        double tot = 0;
        do{
            tot = (num3 % 10) * 2;
            System.out.println(tot);
            if(tot >= 10)
            {
                num1 += tot - 9;
                System.out.println(num1);
            } else {
                num1 += tot;
                System.out.println(num1);
            }
            num3 /= 10;
        }while(num3 > 0);
        System.out.println(num1);
        return num1;
    }
}