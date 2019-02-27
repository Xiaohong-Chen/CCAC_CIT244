package timelineevent;

import java.util.Scanner;



/**
 *  Model -- data Model
 * 
 */

public class MainLand {
    
    public static void main(String[] args){
        
        boolean controlLoop = true;
        
        while(controlLoop){
            
            //prompt 
            System.out.println("-------------------------------------------");
            System.out.println("------------1.COMPUTER SYSTEM  ------------");
            System.out.println("------------2.COMPUTER HARDWARE------------");
            System.out.println("------------3.HUMAN INTEREST   ------------");

            Scanner userInput = new Scanner(System.in);

            int timelineType = userInput.nextInt();

            if(timelineType ==1){
                
                
                ComputerSystem o = new ComputerSystem();
                ComputerSystem cs =o.factory();
                System.out.println(cs.year+"--"+cs.manufacturer+"--");
                
                                
            }else if(timelineType==2){
                
            }else if(timelineType==3){

            }else if(timelineType==4){
                System.out.println("Exit...");
                controlLoop = false;
            }else{
                System.out.println("Please Input The Valid Value");
            }
        }
    }
    
    
}
