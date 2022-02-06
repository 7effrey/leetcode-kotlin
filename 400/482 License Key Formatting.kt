class Solution {
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    fun licenseKeyFormatting(s: String, k: Int): String {
        val temp = StringBuilder()
        var counter = 0
        // O(n)
        for (i in (s.length - 1) downTo 0) {
            var char = s[i]
            if (char == '-') 
                continue
            if (char >= 'a' && char <= 'z')
                char = 'A' + (s[i] - 'a')
                
            temp.append(char)
            counter++
            if (counter == k) {
                temp.append('-')
                counter = 0
            }
        }
        if (temp.length > 0 && temp[temp.length - 1] == '-')
            temp.deleteCharAt(temp.length - 1) // O(1)
        
        // O(n)
        return temp.reverse().toString()
    }
}