package sortingpormance;

import java.util.Random;

/**
 *
 * @author seanc
 */
public class Tester {

    Tester() {

        Sorter b = new BubbleSorter();
        Sorter m = new MergeSorter();
        //int[] bubSortSampleArr = {4, 6, 7, 3, 4, 6, 7, 8,};
        //int[] merSortSampleArr = {4, 6, 7, 3, 4, 6, 7, 8,};
        
        int[] arr = getRanArr(30000);
        int[] bubSortSampleArr = arr;
        int[] merSortSampleArr = arr;

        
        int[] afterBubSort = b.sort(bubSortSampleArr);
        System.out.println("BUBBLE SORT:");
        for (int n = 0; n < afterBubSort.length; n++) {
            System.out.print(afterBubSort[n] + ", ");
        }

        System.out.println("");

        int[] afterMerSort = m.sort(merSortSampleArr);
        System.out.println("MERGE SORT:");
        for (int n = 0; n < afterMerSort.length; n++) {
            System.out.print(afterMerSort[n] + ", ");
        }
        System.out.println("");
        
        System.out.println("++"+checkSort(merSortSampleArr));
        
        RunTimes r= new RunTimes();
        
        r.getRunTimes(b, arr);
        

    }

    public boolean checkSort(int[] arr) {
        
        boolean check = false;
        
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] <= arr[i+1]) {
                check = true;
                //System.out.println("true");
                
            } else {
                check = false;
                //System.out.println("false");
                break;
                
            }
        }
        return check;
    }
    
    public int[] getRanArr(int arrSize){
        
        int[] randomArr = new int[arrSize]; 
        
        Random r = new Random();
        
        for(int i = 0;i<arrSize;i++){
            randomArr[i]=r.nextInt(1000);
        }
        
        return randomArr;
    }
}
