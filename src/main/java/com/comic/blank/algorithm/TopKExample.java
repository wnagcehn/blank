package com.comic.blank.algorithm;

import java.util.PriorityQueue;

/**
 * TopK问题（最小堆排序的解决方案）
 *
 * @author ..w-chen..
 */
public class TopKExample {

    private static int[] findTopK(int[] nums, int k) {
        if (k <= 0 || k > nums.length) {
            throw new IllegalArgumentException("Invalid value of k");
        }

        // 默认最小排前面，如果想最大的排前面，构造器可传入比较器（a, b） -> b-a
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(num);
            } else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }

        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = minHeap.poll();
        }

        return topK;
    }

    public static void main(String[] args) {
        int[] nums = {3, 20, 4, 7, 15, 10, 9};
        int k = 3;
        int[] topK = findTopK(nums, k);

        System.out.println("Top " + k + " elements:");
        for (int num : topK) {
            System.out.print(num + " ");
        }
    }

}
