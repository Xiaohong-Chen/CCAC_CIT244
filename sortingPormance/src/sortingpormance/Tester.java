package sortingpormance;

import java.util.Random;
import java.util.Scanner;

public class Tester {

    Tester() {
        //prompt the user to input the specific size Array
        System.out.println("Input the Array Size you want to test: ");
        Scanner userInput = new Scanner(System.in);
        int arrSize = userInput.nextInt();
        
        //get a random Array
        int[] arr = getRanArr(arrSize);

        //initialize the Sorter
        Sorter b = new BubbleSorter();
        Sorter m = new MergeSorter();

        //clone the array to be sorted
        int[] merArrForRunTimes = arr.clone();
        int[] bubArrForRunTimes = arr.clone();

        //get the runtime of each sort algo    
        long bt = displayRunTimes(b, bubArrForRunTimes);
        long mt = displayRunTimes(m, merArrForRunTimes);
        
        //display the result
        System.out.println("");
        System.out.println("Test case description:              " + arrSize + " value aray with random int values");
        System.out.println("Time performance for bubble sort:   " + bt);
        System.out.println("Time performance for merge  sort:   " + mt);
        if (bt<mt){
            System.out.println("Describe the results of the test:   " +"Bubble Sort is faster than Merge Sort" );
        }else if(bt>mt){
            System.out.println("Describe the results of the test:   " +"Merge Sort is faster than Bubble Sort" );
        }else{
            System.out.println("Describe the results of the test:   " +"Trying with a bigger size Array");
        }

    }

    public void testSort(String nameOfSort, Sorter s, int[] arrToSort) {

        int[] afterSortArr = s.sort(arrToSort);
        displayArr(nameOfSort, afterSortArr);

    }

    public boolean checkSort(int[] arr) {

        boolean check = false;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                check = true;
            } else {
                check = false;
                break;
            }
        }
        return check;
    }

    public int[] getRanArr(int arrSize) {

        int[] randomArr = new int[arrSize];

        Random r = new Random();

        for (int i = 0; i < arrSize; i++) {
            randomArr[i] = r.nextInt(1000);
        }
        return randomArr;
    }

    public long displayRunTimes(Sorter s, int[] arrToSort) {


        long startTimes = java.time.Instant.now().toEpochMilli();
        s.sort(arrToSort);
        long endTimes = java.time.Instant.now().toEpochMilli();
        long runTimes = (endTimes - startTimes);
        
        return runTimes;

    }

    public void displayArr(String nameOfSort, int[] sortedArr) {
        System.out.println("");
        System.out.println("--------------------------------------------------");
        System.out.println(nameOfSort + ": ");
        for (int n = 0; n < sortedArr.length; n++) {
            System.out.print(sortedArr[n] + ", ");
        }

    }
}
