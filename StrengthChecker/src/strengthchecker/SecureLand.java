/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strengthchecker;

import java.util.Scanner;
/**
 *
 * @author xiaohong.chen
 */
public class SecureLand {
    
    
    public static void main(String[] args){
        
        StrengthChecker sc = new StrengthChecker();
        
        //prompt the user to input the password
        System.out.println("Pleas Enter you password and press Enter");
        
        Scanner userInput = new Scanner(System.in);
        String inputPassword = userInput.next();
        
        
        
        sc.setLength(6, 8);
        if(sc.checkPassword(inputPassword)){
            System.out.println("RIGHT");
        }else{
            System.out.println("WRONG!");
        }
        
    }
}
