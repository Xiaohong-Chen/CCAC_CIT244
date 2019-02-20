package strengthChecker;

/**
 *
 * 
 */
public class StrengthChecker {
    
    private int minLength;
    private int maxLength;
    private String[] reqChars;
    private String[][] feedBack;
    private boolean charsCheck;
    private boolean lengthCheck;
    
    public void setReqPassword(String[] s){
        reqChars = s;
    }
    
    public void setLength(int min, int max){
        minLength = min;
        maxLength = max;
    }
    
    public void Errors(){
    
    }
    
    public boolean checkPassword(String password){
        
        
            
            for(int i=0;i<reqChars.length;i++){
                feedBack[i][0]=reqChars[i];
                if(password.indexOf(reqChars[i])>=0){
                    
                    charsCheck = true;
                }else{
                    
                    charsCheck = false;
                }
            }
        
        return charsCheck;
    }
    
    
}
