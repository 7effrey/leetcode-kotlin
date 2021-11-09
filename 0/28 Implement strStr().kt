class Solution {
    // Time Complexity: O(n*m) where n is haystack length and m is needle length
    // Space Complexity: O(1)
    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty())
            return 0
        haystack.forEachIndexed { index, char -> 
            if (char == needle[0] && index + needle.length <= haystack.length) {
                var found = true
                for (i in 1..needle.length - 1) {
                    if (haystack[index + i] != needle[i]) {
                        found = false
                        break
                    }
                }
                if (found)
                    return index
            }
        }
        return -1
    }
}