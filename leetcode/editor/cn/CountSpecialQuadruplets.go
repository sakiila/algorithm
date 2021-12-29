//给你一个 下标从 0 开始 的整数数组 nums ，返回满足下述条件的 不同 四元组 (a, b, c, d) 的 数目 ：
//
//
// nums[a] + nums[b] + nums[c] == nums[d] ，且
// a < b < c < d
//
//
//
//
// 示例 1：
//
// 输入：nums = [1,2,3,6]
//输出：1
//解释：满足要求的唯一一个四元组是 (0, 1, 2, 3) 因为 1 + 2 + 3 == 6 。
//
//
// 示例 2：
//
// 输入：nums = [3,3,6,4,5]
//输出：0
//解释：[3,3,6,4,5] 中不存在满足要求的四元组。
//
//
// 示例 3：
//
// 输入：nums = [1,1,1,3,5]
//输出：4
//解释：满足要求的 4 个四元组如下：
//- (0, 1, 2, 3): 1 + 1 + 1 == 3
//- (0, 1, 3, 4): 1 + 1 + 3 == 5
//- (0, 2, 3, 4): 1 + 1 + 3 == 5
//- (1, 2, 3, 4): 1 + 1 + 3 == 5
//
//
//
//
// 提示：
//
//
// 4 <= nums.length <= 50
// 1 <= nums[i] <= 100
//
// Related Topics 数组 枚举 👍 66 👎 0

package main

// 1995 统计特殊四元组
// 2021-12-29 15:37:57
// 思路：哈希表存储 nums[d]−nums[c]
func main() {
}

//leetcode submit region begin(Prohibit modification and deletion)
func countQuadruplets(nums []int) (ans int) {
	cnt := map[int]int{}
	for b := len(nums) - 3; b > 0; b-- {
		for d := b + 2; d < len(nums); d++ {
			cnt[nums[d]-nums[b+1]]++
		}
		for a := 0; a < b; a++ {
			if cnt[nums[a]+nums[b]] > 0 {
				ans += cnt[nums[a]+nums[b]]
			}
		}
	}
	return
}

//leetcode submit region end(Prohibit modification and deletion)
