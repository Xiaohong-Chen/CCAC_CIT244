package Interfaces;

import java.util.Arrays;




interface CanProcess {
    abstract public long processDate(byte[] b);
}

class NoComputerType{
    
}

class Mainframe extends Computer{
    
    
}


class Computer implements Comparable<Computer>,CanProcess {
    
    int year;
    int kbRam;
    int hrtz;
    String manufacturer;
    
    public long processDate(byte[]b){
        return 11111111;
    }
    
    /**
     * No Arg Constructor
     */
    Computer(){
        
    }
    /**
     * Generate a fully populated Computer Object
     * @param yr Year of release 
     * @param kb Kilobytes of ram
     * @param hz Hertz
     * @param m  Manufacturer
     */
    Computer(int year, int kbRam, int hrtz, String m){
        this.year = year;
        this.kbRam= kbRam;
        this.hrtz = hrtz;
        manufacturer = m;
    }

    
    @Override
    public int compareTo(Computer o) {
        
        
        if (o==null){
            throw new NullPointerException();
        }else if(this.hrtz >o.hrtz){
            return -1;
        }else if(this.hrtz == o.hrtz){
            return 0;
        }else {
            return 1;
        }        
    }
    
    
}



public class ClonePractice {
    public static void main(String[] args){
        Integer[] intArray = new Integer[5];
        
        intArray[0]=8;
        intArray[1]=32;
        intArray[2]=56;
        intArray[3]=1;
        intArray[4]=90;
        
      
        for(int i =0; i<intArray.length;i++){
            System.out.println(intArray[i]);
        }
        
        System.out.println("After Sort!");
        Arrays.sort(intArray);
        
        for(int i =0; i<intArray.length;i++){
            System.out.println(intArray[i]);
        }
        
        
        Computer[] pcArray = new Computer[5];
        
        pcArray[0]= new Computer(1975, 256, 2, "IMASI");
        pcArray[1]= new Computer(2016, 8000000, 3400, "Dell");
        pcArray[2]= new Computer(2018, 3200000, 2, "Alienware");
        
        System.out.println("After Soft:");
        
        
        
        
    }
}

