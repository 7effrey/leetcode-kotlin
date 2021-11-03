class Solution {
    // Time Complexity: O(n+m)
    // Space Complexity: O(n+m) to store tokens1 and tokens2
    fun compareVersion(version1: String, version2: String): Int {
        // O(n)
        val tokens1 = version1.split(".")
        // O(m)
        val tokens2 = version2.split(".")
        val maxLength = Math.max(tokens1.size, tokens2.size)
        // O(max(n,m))
        for (i in 0..maxLength - 1) {
            val t1 = if (i < tokens1.size) tokens1[i].toInt() else 0
            val t2 = if (i < tokens2.size) tokens2[i].toInt() else 0
            if (t1 < t2)
                return -1
            else if (t1 > t2)
                return 1
        }
        return 0
    }
}