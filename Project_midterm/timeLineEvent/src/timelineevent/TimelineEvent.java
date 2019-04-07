package timelineevent;

public class TimelineEvent implements Comparable<TimelineEvent>{
    
    int year;
    String type;
    String title;
    String description;
    
    public TimelineEvent(View di) {
        
        year = di.year;
        title = di.title;
        description = di.description;
        type = di.tpye;
    }
    @Override
    public int compareTo(TimelineEvent o) {
        
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
