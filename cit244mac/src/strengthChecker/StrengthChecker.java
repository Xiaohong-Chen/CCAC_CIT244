package strengthChecker;

/**
 *The StrengthChecker class can check the strength about length and characters 
 *of a submitted password.
 *
 */

public class StrengthChecker {
    
    //declaring the value type
    private int minLength;
    private int maxLength;
    private String[] reqChars;
    private String[] lengthFeedBack;
    private String[][] reqCharsfeedBack;
    private boolean charsCheck;
    private boolean lengthCheck;
    
    /**
     * setReqPassword method can taking in an array of String that must
     * be present in any password
     * @param s submitted required password
     */
    //creating a setReqPassword method for taking in an array of String that
    //must be present in any password
    public void setReqPassword(String[] s){
        reqChars = s;
    }
    
    /**
     * setLength method can taking an int representing the minimum
     * length and an int representing the maximum length of password
     * @param min minimum length must be match
     * @param max maximum length must be match
     */
    public void setLength(int min, int max){
        minLength = min;
        maxLength = max;
    }
    
    /**
     * getErrors method can return a feedback about which element 
     * of password failed the check and print it out
     */
    public void getErrors(){
        //feedback about length check
        if(lengthCheck==false){
            System.out.println(lengthFeedBack[0]);
        //feedback about character check    
        }else if(charsCheck == false){
            for(int m= 0;m<reqChars.length;m++){
                System.out.println(reqCharsfeedBack[m][1]);
            }
        }
    }
    
    /**
     * checkPassword method can return a boolean for checking if the password
     * is met the requirement.
     * @param password submitted password
     * @return boolean for checking password if right or not
     */
    
    public boolean checkPassword(String password){
        //checking the minimum length
        lengthFeedBack = new String[1];
        if(password.length()<minLength){
            lengthFeedBack[0]="The length should larger than"+minLength;
            lengthCheck = false;
        //checking the maximum length
        }else if(password.length()>maxLength) {
            lengthFeedBack[0]="The length should less than"+ maxLength;
            lengthCheck = false;
        //checking the characters
        }else{
            lengthCheck =true;
            reqCharsfeedBack = new String[reqChars.length][2];
            for(int i =0;i<reqChars.length;i++){
                reqCharsfeedBack[i][0]=reqChars[i];
                if(password.indexOf(reqChars[i])>=0){
                    reqCharsfeedBack[i][1]=reqChars[i]+"  character is Present!";
                    charsCheck = true;
                }else{
                    reqCharsfeedBack[i][1]=reqChars[i]+"  character is not Present!";
                    charsCheck = false;
                } 
            }
        }                                        
           
        return charsCheck&&lengthCheck;
    }
    
   
}
