class Solution {
    // Time Complexity: O(m*n)
    // Space Complexity: O(m*n)
    fun shiftGrid(grid: Array<IntArray>, k: Int): List<List<Int>> {
        val m = grid.size // 3
        val n = grid[0].size // 3
        
        // Use modulo to avoid O(k*m*n) to simulate every step
        val x = k.rem(n) // 4 % 3 = 1
        val yBef = (k / n + 1).rem(m) // 2
        val yAft = (k / n).rem(m) // 1
        
        val result = arrayListOf<ArrayList<Int>>()
        for (i in 0..m - 1) { // 0 | 1
            val list = arrayListOf<Int>()
            for (j in 0..n - 1) {
                val t = (n - x + j).rem(n) // (3 - 1 + 0) % 3 = 2 | 0 | 1
                val s = if (j < x) // 0 < 1 = true | false
                    (m - yBef + i).rem(m) // (3 - 2 + 0) % 3 = 1
                else
                    (m - yAft + i).rem(m) // (3 - 1 + 0) % 3 = 2
                list.add(grid[s][t]) // [1][2] = 6 | [2][0] = 7 | [2][1] = 8 
            }
            result.add(list) // [6,7,8]
        }
        return result
    }
}