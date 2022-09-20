package me.baobo.interview.aftership;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 */
// 1. 从数组的开始进行搜索，搜索到就返回下标，搜索完没有匹配的数据，就返回 -1（时间复杂度 On，空间复杂度 O1）
// 2. 使用二分查找，使用左右两个指针，找到中间的数据，依次缩减空间，搜索到就返回下标，搜索完没有匹配的数据，就返回 -1（时间复杂度 Ologn，空间复杂度 O1）
public class Main {
    private int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // 防止mid溢出
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        Main main = new Main();
        System.out.println("main.search(nums, -1) = " + main.search(nums, -1));
        System.out.println("main.search(nums, 0) = " + main.search(nums, 0));
        System.out.println("main.search(nums, 3) = " + main.search(nums, 3));
        System.out.println("main.search(nums, 5) = " + main.search(nums, 5));
        System.out.println("main.search(nums, 9) = " + main.search(nums, 9));
        System.out.println("main.search(nums, 12) = " + main.search(nums, 12));
        System.out.println("main.search(nums, 1000) = " + main.search(nums, 1000));
    }
}


