class Solution {
    // Time complexity: O(s)
    // Space complexity: O(j)
    fun numJewelsInStones(jewels: String, stones: String): Int {
        val table = hashSetOf<Char>()
        // O(j)
        jewels.forEach { char ->
            table.add(char)
        }
        
        var counter = 0
        // O(s)
        stones.forEach { char ->
            if (table.contains(char))
                counter++
        }
        return counter
    }
}