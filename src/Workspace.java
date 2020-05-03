/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/
import java.util.*;
// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class Workspace {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int count = 0;
        for(int i = 0; i < input.length(); i++) {
            String current = input.substring(i) + input.substring(0, i);
            if(isBalance(current)) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean isBalance(String current) {
        int low = 0;
        for(int i = 0; i < current.length(); i++) {
            char a = current.charAt(i);
            if(a == '(') {
                low++;
            } else {
                if(low < 1) {
                    return false;
                }
                low--;
            }   
        }
        return low==0;
    }
}
