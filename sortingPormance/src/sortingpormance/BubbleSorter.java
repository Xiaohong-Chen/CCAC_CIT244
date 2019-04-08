/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingpormance;

/**
 *
 * @author xiaohong.chen
 */
public class BubbleSorter extends Sorter {

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
