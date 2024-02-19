import java.util.*;

public class Lab1 {
    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);


        System.out.print("Please enter the total number of Mafia: ");
        int maf = sc.nextInt();

        sc.close();

        double totMafWins = 0;
        

        for(int i =0; i < 10000; i++)
        {
            int mafia = maf;
            int players = 22;

            while(mafia > 0 && players > 2*mafia)
            {
                players = players - mafia;
                int [] Guess = new int [players];

                int traitGuess = (int) Math.floor(Math.random()*(players - mafia)) + mafia;
                    
                for(int j = 0; j < mafia; j++)
                {
                    Guess[j] = traitGuess;
                }

                for(int j = mafia; j < players; j++)
                {
                    Guess [j] = (int) Math.floor(Math.random()*(players-1)); // Not going to vote for themselves
                }

                if(MafvotedOut(Guess, mafia))
                {
                    mafia = mafia - 1;
                    players = players - 1;
                } else {
                    players = players - 1;
                } 
            }

            if(mafia > 0) totMafWins = totMafWins + 1;
        }

        System.out.println("The Chances of " + maf + " winning is " + (totMafWins/10000)*100 + "%");
    }

    // Will Check to see if a mafia or a civillian will be voted out
    public static boolean MafvotedOut(int[] guess, int maf) 
    {
        int[] tot = new int[guess.length];

        // Adds up the total votes for each player
        for (int i = 0; i < tot.length; i++) 
        {
            tot[guess[i]] = tot[guess[i]] + 1;
        }

        int numOut = 0;
        int countOut = 0;
        int SharedOut = 0;

        for (int i = 0; i < tot.length; i++) {
            if (tot[i] > countOut) {
                numOut = i;
                countOut = tot[i];
            }
        }

        // Checks to see if there are multiple of a same vote
        for (int i = 0; i < tot.length; i++) {
            if (tot[i] == countOut) {
                SharedOut++;
            }
        }

        // Deciding if a Mafia is being voted out
        if (SharedOut == 1 && numOut < maf) 
        {
            return true;
        } else if (SharedOut > 1 && maf > 0) // If more than 1 person got the same most votes picks at random who is voted out
        {
            int out = (int) Math.ceil(Math.random() * SharedOut);
            int pos = 1;

            // Checking to see if the randomly voted out player is a mafia
            for (int i = 0; i < tot.length; i++) 
            {
                if (guess[i] == countOut && pos == out && i < maf) 
                {
                    return true;
                } else if (guess[i] == countOut && pos != out) 
                {
                    pos = pos + 1;
                }
            }
            return false;
        } else {
            return false;
        }
    }
}
