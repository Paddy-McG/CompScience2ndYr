import java.util.*;

public class Lab2part1
{
    
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the total Loan amount");
        double loanTot = sc.nextDouble();

        System.out.println("Please enter the anual interest rate");
        double interest = sc.nextDouble() / 12;

        System.out.println("Please enter the monthly repayment");
        double monRepay = sc.nextDouble();

        sc.close();

        System.out.println("It takes " + loanTerm(loanTot, interest, monRepay) + " months to pay of the loan");

    }

    public static int loanTerm(double loan, double interest, double repay)
    {
        if(repay > loan) return 1;

        return loanTerm((loan-repay)*(1+interest), interest, repay) + 1;
    }
}