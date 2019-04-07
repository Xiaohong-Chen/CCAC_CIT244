package timelineevent;

public class ComputerComponent extends TimelineEvent{
    
    int modelNumber;
    int releaseYear;
    double retailPriceIn2018;
    String manufacturer;

    public ComputerComponent(View di) {
        
        super(di);
        modelNumber = di.modelNumber;
        releaseYear = di.releaseYear;
        retailPriceIn2018 = di.retailPriceIn2018;
        manufacturer = di.manufacturer;
        
    }
    
    
    
    
    
    
    
}
