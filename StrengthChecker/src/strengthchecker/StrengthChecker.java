package strengthchecker;

import java.util.Arrays;

public class StrengthChecker {

    private int minLength;
    private int maxLength;
    
    
    private String[] requiredChars;
    
    public void setRealChars(String[] requiredChars){  
        
        this.requiredChars = requiredChars;
        
    }
    
    public void setLength(int min, int max){
        minLength = min;
        maxLength = max;
    }
    
    boolean checkPassword(String st){
        if(st.length()<minLength){
            return false;
        }else if (st.length()>maxLength){
            return false;
        }else{
            return true;
        }
    }
    
    public void feedbackArray(){
        
        String[][] feedback = new String[3][];
        
        feedback[0][0]="!";
        feedback[0][1]="The First Character is Correct!";
        feedback[0][2]="The First Character is Wrong!!!";
        
        feedback[1][0]="@";
        feedback[1][1]="The Second Character is Correct!";
        feedback[1][2]="The Second Character is Wrong!!!";
        
        feedback[2][0]="#";
        feedback[2][1]="The Third Character is Correct!";
        feedback[2][2]="The Third Character is Wrong!!!";
      
    }
}
