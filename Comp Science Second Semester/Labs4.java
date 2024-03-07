import java.util.Scanner;

public class Labs4 {
    public static void main(String [] args)
    {
        linkList linkedList = new linkList();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter words to add to the linked list. Enter 'END' to finish:");

        String input;

        while (true) 
        {
            System.out.print("Enter a word: ");
            input = sc.nextLine();

            if (input.equals("END")) {
                break;
            }

            linkedList.insertHead(input);
        }
        sc.close();

        linkedList.display();
    }
}
