class Solution {
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    fun maxProfit(prices: IntArray): Int {
        var minPrice = Int.MAX_VALUE
        var maxProfit = 0
        prices.forEach { price ->
            minPrice = Math.min(minPrice, price)
            maxProfit = Math.max(maxProfit, price - minPrice)
        }
        return maxProfit
    }
}
/*
Brute Force Approach: O(n^2)
[7,1,5,3,6,4]
7
    1   5   3   6   4 = 0
    
    1
        5   3   6   4 = 6 - 1 = 5
        
        5
            3   6   4 = 6 - 5 = 1
            
            3
                6   4 = 6 - 3 = 3
                
                6
                    4 = 0
====
Optimized Approach: O(n)
min = MAX_VALUE
7

min = 7
    1
    
min = 1
        5 = 5 - 1 = 4
        
min = 1
            3 = 3 - 1 = 2
            
min = 1
                6 = 6 - 1 = 5
                
min = 1
                    4 = 4 - 1 = 3

*/