//给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
//
//
//
// 示例 1:
//
//
//输入: num = 100
//输出: "202"
//
//
// 示例 2:
//
//
//输入: num = -7
//输出: "-10"
//
//
//
//
// 提示：
//
//
// -10⁷ <= num <= 10⁷
//
// Related Topics 数学 👍 142 👎 0

package main

// 504 七进制数
// 2022-03-07 11:27:06
// 思路：除法竖式
func main() {
}

//leetcode submit region begin(Prohibit modification and deletion)
func convertToBase7(num int) string {
	if num == 0 {
		return "0"
	}
	negative := num < 0
	if negative {
		num = -num
	}
	var res []byte
	for num > 0 {
		res = append(res, byte(num%7)+'0')
		num /= 7
	}
	if negative {
		res = append(res, '-')
	}
	for i, j := 0, len(res)-1; i < j; i, j = i+1, j-1 {
		res[i], res[j] = res[j], res[i]
	}
	return string(res)
}

//leetcode submit region end(Prohibit modification and deletion)
