class Solution {
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    fun totalFruit(fruits: IntArray): Int {
        var max = 0
        val map = hashMapOf<Int, Int>()
        val mapLastIndex = hashMapOf<Int, Int>()
        fruits.forEachIndexed { index, num ->
            map[num] = (map[num] ?: 0) + 1
            mapLastIndex[num] = index
            
            if (map.size > 2) {
                val prevNum = fruits[index - 1]
                
                val removedKey = map.keys.first { it != num && it != prevNum }
                map.remove(removedKey)
                val lastRemovedKeyIndex = mapLastIndex[removedKey]!!
                mapLastIndex.remove(removedKey)
                
                map[prevNum] = index - 1 - lastRemovedKeyIndex
            }
            
            max = Math.max(max, map.values.sum())
        }
        
        return max
    }
}