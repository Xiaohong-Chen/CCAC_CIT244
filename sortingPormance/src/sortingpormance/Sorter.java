package sortingpormance;

/**
 *
 * @author seanc
 */
public class Sorter {

    public int[] bubbleSort(int[] arrToSort) {
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

    public int[] mergeSort(int[] arrToSort) {
        if (arrToSort.length > 1) {
            int[] firstHalf = new int[arrToSort.length / 2];
            System.arraycopy(arrToSort, 0, firstHalf, 0, arrToSort.length / 2);
            mergeSort(firstHalf);

            int secondHalfLength = arrToSort.length - arrToSort.length / 2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(arrToSort, arrToSort.length / 2, secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);
            merge(firstHalf, secondHalf, arrToSort);
        }
        return arrToSort;
    }

    public void merge(int[] arr1, int[] arr2, int[] temp) {

        int cursor1 = 0;
        int cursor2 = 0;
        int cursor3 = 0;

        while (cursor1 < arr1.length && cursor2 < arr2.length) {
            if (arr1[cursor1] < arr2[cursor2]) {
                temp[cursor3++] = arr1[cursor1++];
            } else {
                temp[cursor3++] = arr2[cursor2++];
            }
        }

        while (cursor1 < arr1.length) {
            temp[cursor3++] = arr1[cursor1++];
        }

        while (cursor2 < arr2.length) {
            temp[cursor3++] = arr2[cursor2++];
        }
    }

}
