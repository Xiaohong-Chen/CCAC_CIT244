package strengthChecker;

/**
 *
 * 
 */
import java.util.Scanner;

public class SecureLand {
    public static void main(String[] args){
        StrengthChecker sc = new StrengthChecker();
        
        String[] reqChars;
        reqChars = new String[2];
        reqChars[0] ="!";
        reqChars[1] ="@";
        
        sc.setReqPassword(reqChars);
        sc.setLength(6, 8);
        
        System.out.println("Please Input Your Password!");
        Scanner userInput = new Scanner(System.in);
        String testPassword = userInput.next();
        
        if (sc.checkPassword(testPassword)){
            System.out.println("Meet The Criteria!");
        }else{
            System.out.println("Fail!");
        }
    }
}
