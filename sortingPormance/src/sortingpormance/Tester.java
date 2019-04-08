package sortingpormance;

/**
 *
 * @author seanc
 */
public class Tester {

    Tester() {

        Sorter s = new Sorter();
        int[] bubSortSampleArr = {4, 6, 7, 3, 4, 6, 7, 8,};
        int[] merSortSampleArr = {4, 6, 7, 3, 4, 6, 7, 8,};

        
        int[] afterBubSort = s.bubbleSort(bubSortSampleArr);
        System.out.println("BUBBLE SORT:");
        for (int m = 0; m < afterBubSort.length; m++) {
            System.out.print(afterBubSort[m] + ", ");
        }

        System.out.println("");

        int[] afterMerSort = s.bubbleSort(merSortSampleArr);
        System.out.println("MERGE SORT:");
        for (int m = 0; m < afterMerSort.length; m++) {
            System.out.print(afterMerSort[m] + ", ");
        }
        System.out.println("");
        
        System.out.println("++"+checkSort(merSortSampleArr));
        

    }

    public boolean checkSort(int[] arr) {
        
        boolean check = false;
        
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] <= arr[i+1]) {
                check = true;
                System.out.println("true");
                
            } else {
                check = false;
                System.out.println("false");
                break;
                
            }
        }
        return check;
    }
}
