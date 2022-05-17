package com.javastroger.demo.datastructure;

import lombok.val;

public class BinarySearchDemo {


    /**
     * 二分查找, 需要数组为有序
     *
     * @return
     */
    public static int binarySearch() {

        int[] arr = {1, 3, 4, 7, 9, 10};
        int target = 9;
        int mind = (arr.length - 1) >> 1;

        while (true) {

            if (arr[mind] == target) {
                return mind;
            }

            if (arr[mind] > target) {
                mind = mind - 1;
            }

            if (arr[mind] < target) {
                mind = mind + 1;
            }

            if (mind < 0 || mind > arr.length -1) {
                return -1;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(binarySearch());
    }
}
