class Solution {
    // Time Complexity: O(m + n)
    // Space Complexity: O(m + n)
    fun mostCommonWord(paragraph: String, banned: Array<String>): String {
        val bannedSet = hashSetOf<String>()
        // O(m) where m is the length of banned
        banned.forEach { word ->
            bannedSet.add(word)
        }
        
        val table = hashMapOf<String, Int>()
        val sb = StringBuilder()
        var maxWord = ""
        var maxFreq = Int.MIN_VALUE
        // O(n) where n is the length of paragraph
        // Add " " at the end to avoid additional checking after forEach block
        (paragraph + " ").forEach { char ->
            if (char.isLetter()) {
                // Ensure case insensitive
                sb.append(char.toLowerCase())
            } else {
                // Ensure that empty string won't be added to the hashMap table
                if (sb.length > 0) {
                    val word = sb.toString()
                    sb.clear()
                    if (!bannedSet.contains(word)) {
                        table[word] = (table[word] ?: 0) + 1
                        if (table[word]!! > maxFreq) {
                            maxFreq = table[word]!!
                            maxWord = word
                        }
                    }
                }
            }
        }
        return maxWord
    }
}