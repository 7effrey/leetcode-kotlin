class Solution {
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    fun maxArea(height: IntArray): Int {
        var l = 0
        var r = height.size - 1
        var maxArea = 0
        while (l < r) {
            val nl = height[l]
            val nr = height[r]
            val curMaxArea = Math.min(nl, nr) * (r - l)
            maxArea = Math.max(maxArea, curMaxArea)
            if (nl < nr)
                l++
            else
                r--
        }
        return maxArea
    }   
}