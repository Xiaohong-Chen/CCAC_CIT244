package sortingpormance;

/**
 *
 * @author xiaohong.chen
 */
public class RunTimes {
    
    public void getRunTimes(Sorter s,int[] arrToSort){
        long startTimes = java.time.Instant.now().toEpochMilli();
        s.sort(arrToSort);
        long endTimes = java.time.Instant.now().toEpochMilli();
        long runTimes = (endTimes-startTimes);
        System.out.println(runTimes);
    }
}
