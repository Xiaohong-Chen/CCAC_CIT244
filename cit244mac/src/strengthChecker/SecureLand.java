/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package strengthChecker;

import java.util.Scanner;

/**
 *
 * @author stellachenst
 */
public class SecureLand {
    
    //declaring the value type
    public static String[] reqChars;
    public static String[] addReqChars;
    public static String[] expandedArrays;
    
    
    //creating a method of expanding arrays
    public static void setExpandArrays(String[] addArrays){
        
        expandedArrays =new String[reqChars.length+addArrays.length];
        
        for(int n = 0;n<reqChars.length;n++){
            expandedArrays[n]=reqChars[n];
        }
        for(int l = 0;l< addArrays.length;l++){
            expandedArrays[reqChars.length]=addArrays[l];
        }
    }
    
    
    
    public static void main(String[] args){
        
     
        //initializing the StrengthChecker Class
        StrengthChecker sc = new StrengthChecker();
     
        //Set the required characters and add another characters
        reqChars = new String[2];
        addReqChars = new String[1];
        //required characters
        reqChars[0] ="!";
        reqChars[1] ="@";
        //expanding characters
        addReqChars[0]="#";
        
        //call the setExpandArrays method for expanding the Arrays.
        setExpandArrays(addReqChars);
        
        
        sc.setReqPassword(expandedArrays);
        sc.setLength(6, 8);
        
        //prompt the user to input the password
        System.out.println("Please Input Your Password!");
        Scanner userInput = new Scanner(System.in);
        String testPassword = userInput.next();
        
        //testing the password
        if (sc.checkPassword(testPassword)){
            System.out.println("Meet The Criteria!");
        }else{
            System.out.println("Fail!");
            sc.getErrors();
        }
    }

}
