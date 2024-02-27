package Labs3;

import java.util.*;

public class Lab3part1 
{
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);

        String word1 = sc.nextLine();
        String word2 = sc.nextLine();

        sc.close();

        System.out.println(merger(word1, word2));
    }

    public static String merger(String word1, String word2)
    {
        if(word1.length() == 0 || word2.length() == 0)
        {
            return word1 + word2;
        }

        return word1.substring(0, 1) + word2.substring(0, 1) + merger(word1.substring(1), word2.substring(1));
    }
}