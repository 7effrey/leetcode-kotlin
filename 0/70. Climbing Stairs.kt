class Solution {
    private val array: IntArray = IntArray(46);

    // Time Complexity: O(n)
    // Space Complexity: O(n + 45) ~ O(n) -> fixed array for memoization and memory footprint
    fun climbStairs(total: Int): Int {
        if (total == 1 || total == 0)
            return 1;
        if (total < 0)
            return 0;
        if (array[total] > 0)
            return array[total];

        val total1 = climbStairs(total - 1);
        val total2 = climbStairs(total - 2);
        array[total] = total1 + total2;
        return array[total];
    }
}