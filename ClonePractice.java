package interfaces;

import java.util.Arrays;
//Creating the Computer class and a four-argument constructor
//implement Comparable inside Computer
class Computer implements Comparable<Computer>{
    
    int year;
    int kbRam;
    int hrtz;
    String manufacturer;
    
    /**
     * No Arg Constructor
     */
    Computer(){
        
    }
    /**
     * @param year Year of release
     * @param kbRam Kilobytes of ram
     * @param hrtz Hertz  
     * @param manufacturer 
     */
    Computer(int year, int kbRam, int hrtz,String manufacturer){
        this.year = year;
        this.kbRam = kbRam;
        this.hrtz = hrtz;
        this.manufacturer = manufacturer;
    }
    
    //comparing with year of Computer by Overriding the compareTo method 
    @Override
    public int compareTo(Computer o) {
        
        if(o==null){
            throw new NullPointerException();
        }else if(this.year> o.year){
            return -1;
        }else if(this.year ==o.year){
            return 0;
        }else{
            return 1;
        }
    }    
    
}

//main method
public class ClonePractice {
    
    public static void main(String[] args){
        
        //Arrays sort
        Integer[] intArray = new Integer[5];
        
        intArray[0]=8;
        intArray[1]=32;
        intArray[2]=56;
        intArray[3]=1;
        intArray[4]=90;
        
        for(int i=0; i<intArray.length;i++){
            System.out.println(intArray[i]);
        }
        
        System.out.println("------------------After Sort------------------");
        
        Arrays.sort(intArray);
        
        for(int i=0; i<intArray.length;i++){
            System.out.println(intArray[i]);
        }
        
        //Testing Computer Arrays with Arrays.sort
        Computer[] pcArray = new Computer[3];
        pcArray[0] = new Computer(1975,256,2,"IMASI"); 
        pcArray[1] = new Computer(2018,32000000,3400,"Alienware");
        pcArray[2] = new Computer(2016,8000000,3400,"Dell"); 
        
        for(int i=0; i<pcArray.length;i++){
            System.out.println(pcArray[i].year + "--" + pcArray[i].kbRam + "--" + pcArray[i].hrtz + "--" + pcArray[i].manufacturer);
        }
        
        System.out.println("------------------After Sort------------------");
        
        Arrays.sort(pcArray);
        
        for(int i=0; i<pcArray.length;i++){
            System.out.println(pcArray[i].year + "--" + pcArray[i].kbRam + "--" + pcArray[i].hrtz + "--" + pcArray[i].manufacturer);
        }
        
    }
}