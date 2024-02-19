import java.util.*;

public class Lab2part2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();

        sc.close();

        System.out.println(Attendance(s1, 0, 0));
    }

    public static String Attendance(String s1, int abs, int lateNrow) {
        if (s1.length() == 1) {
            if (s1.charAt(0) == 'L') {
                lateNrow++;
            } else if (s1.charAt(0) == 'A') {
                abs++;
            }

            if (abs >= 2)
                return "FAIL";
            else if (lateNrow >= 3)
                return "FAIL";
            else
                return "PASS";
        }

        if (abs >= 2)
            return "FAIL";
        else if (lateNrow >= 3)
            return "FAIL"; 

        if (s1.charAt(0) == 'L') {
            return Attendance(s1.substring(1), abs, lateNrow + 1); // Adds 1 to the lates in a row
        } else if (s1.charAt(0) == 'A') {
            return Attendance(s1.substring(1), abs + 1, 0); // Resents the lates and adds 1 to the total absences
        } else {
            return Attendance(s1.substring(1), abs, 0); // Resets the lates in a row 
        }
    }
}
