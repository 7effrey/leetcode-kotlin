class Solution {
    fun maxAbsoluteSum(nums: IntArray): Int {
        var lastMaxOptimum = 0
        var lastMinOptimum = 0
        var max = Int.MIN_VALUE
        var min = Int.MAX_VALUE
        nums.forEach { num ->
            lastMaxOptimum = if (lastMaxOptimum + num >= num) {
                lastMaxOptimum + num
            } else {
                num
            }
            max = Math.max(max, lastMaxOptimum)
            lastMinOptimum = if (lastMinOptimum + num <= num) {
                lastMinOptimum + num
            } else {
                num
            }
            min = Math.min(min, lastMinOptimum)
        }
        return Math.max(Math.abs(max), Math.abs(min))
    }
}
/*
2    -5  1   -4  3   -2

Brute Force: O(n^2) 
2 = 2
2 -5 = 3
2 -5 1 = 2
2 -5 1 -4 = 6
2 -5 1 -4 3 = 3
2 -5 1 -4 3 -2 = 5

-5 = 5
-5 1 = 4
-5 1 -4 = 8
-5 1 -4 3 = 5
-5 1 -4 3 -2 = 7

1 = 1
1 -4 = 3
1 -4 3 = 0
1 -4 3 -2 = 2

-4 = 4
-4 3 = 1
-4 3 -2 = 3

3 = 3
3 -2 = 1

-2 = 2

Dynamic Programming: O(n)
2    -5  1  -4  3   -2
0+2 or 2
0+2 or 2
    2+(-5) or -5
    2+(-5) or -5
        -3+1 or 1
        -5+1 or 1
            1+(-4) or -4
            -4+(-4) or -4
                -3+3 or 3
                -8+3 or 3
                    3+(-2) or -2
                    -5+(-2) or -2
maxAbsSum = max(abs(3), abs(-8)) = 8

*/
