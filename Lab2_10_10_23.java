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

        if(check(s1))
        {
            System.out.println("The number you entered is VALID");
        } else
        {
            System.out.println("The number you entered is NOT VALID");
        }
    }

    public static boolean check(String s1)
    {
        int tot = 0;
        int num = 0;

        for(int i = s1.length()-1; i >= 0; i--)
        {
            num = Integer.parseInt(s1.charAt(i) + "");

            if(i % 2 != 0)
            {
                num *= 2;
                if(num >= 10)
                {
                    num -= 9;
                }
            }
            tot += num;
        }

        if(tot % 10 == 0)
        {
            System.out.println(tot);
            return true;
        } else {
            System.out.println(tot);
            return false;
        }
    }
}