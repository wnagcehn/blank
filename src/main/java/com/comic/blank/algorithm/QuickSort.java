package com.comic.blank.algorithm;

/**
 * 快速排序（解决TopK问题）
 *
 * @author ..w-chen..
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 4, 5, 2, 8, 7};
        quickQort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void quickQort(int[] arr, int low, int high) {
        if (low < high) {
            int privot = partition(arr, low, high);
            // 对左面的区域进行排序
            quickQort(arr, low, privot - 1);
            // 对右面的区域进行排序
            quickQort(arr, privot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int privot = arr[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (arr[j] <= privot) {
                swap(arr, i, j);
                i++;
            }
        }

        // 将【基准元素】与【指针i的元素】互换
        swap(arr, i, high);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
