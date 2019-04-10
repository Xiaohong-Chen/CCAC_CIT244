package sortingpormance;


public class BubbleSorter extends Sorter {
    
    /**
     * Implements the bubble sort algo as defined
     * by Daniel Liang in Edition 9 of Intro to Java Programming
     * 
     * @param arrToSort primitives to be sorted with bubble sort
     * @return the sorted array
     */

    @Override
    public int[] sort(int[] arrToSort) {
        boolean needNextPass = true;
        for (int k = 1; k < arrToSort.length && needNextPass; k++) {
            needNextPass = false;
            for (int i = 0; i < arrToSort.length - k; i++) {

                if (arrToSort[i] > arrToSort[i + 1]) {

                    int temp = arrToSort[i];
                    arrToSort[i] = arrToSort[i + 1];
                    arrToSort[i + 1] = temp;

                    needNextPass = true;
                }
            }
        }
        return arrToSort;
    }

}
