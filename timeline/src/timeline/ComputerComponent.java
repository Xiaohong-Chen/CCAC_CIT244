package timeline;


public class ComputerComponent implements Comparable<ComputerComponent>{
    
    public String modelNum;
    public String releaseYear;
    public String RetailPrice;
    public String manufacturer;
    public String importantSpec;

    ComputerComponent() {
        
    }

    public ComputerComponent(String modelNum, String releaseYear, String RetailPrice, String manufacturer, String importantSpec) {
        this.modelNum = modelNum;
        this.releaseYear = releaseYear;
        this.RetailPrice = RetailPrice;
        this.manufacturer = manufacturer;
        this.importantSpec = importantSpec;
    }

    @Override
    public int compareTo(ComputerComponent c) {
        if(c==null){
            throw new NullPointerException();
        }else if(this.releaseYear>c.releaseYear){
            return 1;
        }else{
            return -1;
        }
    
    }
    
    
}
