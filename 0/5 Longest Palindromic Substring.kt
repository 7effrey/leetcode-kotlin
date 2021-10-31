class Solution {
    // Time Complexity: O(n^2) where n is the s.length
    // Space Complexity: O(1)
    fun longestPalindrome(s: String): String {
        var maxLeft = 0
        var maxRight = 0
        // O(n)
        for (i in 0..s.length - 1) {
            // O(n)
            val (l1, r1) = getLongestPalindromeLengthIndex(s, i, i)
            // Adjusting the initial position for double chars in the middle "bb" / "caad"
            // O(n)
            val (l2, r2) = getLongestPalindromeLengthIndex(s, i, i + 1)
            
            if (r1 - l1 > maxRight - maxLeft) {
                maxRight = r1
                maxLeft = l1
            }
            if (r2 - l2 > maxRight - maxLeft) {
                maxRight = r2
                maxLeft = l2
            }
        }
        // O(n)
        return s.substring(maxLeft, maxRight + 1)
    }
    
    private fun getLongestPalindromeLengthIndex(s: String, l: Int, r: Int): Pair<Int, Int> {
        // Validating parameter to ensure that it's palindrome before doing additional looping
        var left = if (l < 0) 0 else l
        var right = if (r >= s.length) s.length - 1 else r
        if (s[left] != s[right])
            return Pair(left, left)
            
        while (left - 1 >= 0 && right + 1 <= s.length - 1 && s[left - 1] == s[right + 1]) {
            left--
            right++
        }
        return Pair(left, right)
    }
}