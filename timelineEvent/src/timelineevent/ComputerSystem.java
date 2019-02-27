package timelineevent;

import java.util.Scanner;

public class ComputerSystem extends ComputerComponent{
    
    /*
     int modelNumber;
    int releaseYear;
    double retailPriceIn2018;
    String manufacturer;
    */
    
    String reasonOfchoosing;
    ComputerSystem(){
        
    }
    
    ComputerSystem(int modelNumber,int releaseYear,double retailPriceIn2018,String manufacturer,String reasonOfchoosing){
        
        this.modelNumber = modelNumber;
        this.releaseYear = releaseYear;
        this.retailPriceIn2018=retailPriceIn2018;
        this.manufacturer = manufacturer;
        this.reasonOfchoosing = reasonOfchoosing;
        
    }
    
    
    
    public ComputerSystem factory(){
        
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please Input The Model Number");
        int mn = userInput.nextInt();
        System.out.println("Please Input The Release Year");
        int ry = userInput.nextInt();
        System.out.println("Please Input The Retail Price In 2018");
        double rp = userInput.nextDouble();
        System.out.println("Please Input The Maufacturer");
        String mf = userInput.next();
        System.out.println("Please Input The Reason Of Choosing");
        String rc = userInput.next();
        
        ComputerSystem cs = new ComputerSystem(mn,ry,rp,mf,rc);
        
        return cs;
    }
}
