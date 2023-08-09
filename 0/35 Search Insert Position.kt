class Solution {
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    fun searchInsert(nums: IntArray, target: Int): Int {
        var l = 0;
        var r = nums.size - 1;
        var mid = 0;
        while (l <= r) {
            if (l == r) {
                if (target > nums[l]) 
                    return l + 1;
                else if (target < nums[l])
                    return l;
            }
            mid = (l + r) / 2;
            if (nums[mid] == target)
                return mid;
            else if (target > nums[mid]) 
                l = mid + 1;
            else if (target < nums[mid])
                r = mid - 1; 
        }
        return mid;
    }
}