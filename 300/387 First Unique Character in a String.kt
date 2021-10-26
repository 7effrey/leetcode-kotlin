class Solution {
    // Time Complexity: O(n)
    // Space Complexity: O(1) because it only consists lowercase English letters which is 26 only
    fun firstUniqChar(s: String): Int {
        val map = hashMapOf<Char, Int>()
        // O(n) where n is the number of char in s
        s.forEach { char ->
            map[char] = (map[char] ?: 0) + 1
        }
        
        // O(n) where n is the number of char in s
        s.forEachIndexed { index, char ->
            if (map[char]!! == 1)
                return index
        }
        return -1
    }
}