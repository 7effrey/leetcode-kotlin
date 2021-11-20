class Solution {
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    fun twoSum(nums: IntArray, target: Int): IntArray {
        var l = 0
        var r = nums.size - 1
        while (l < r) {
            val total = nums[l] + nums[r]
            if (total == target)
                return intArrayOf(l + 1, r + 1)
            else if (total < target)
                l++
            else
                r--
        }
        return intArrayOf()
    }
}