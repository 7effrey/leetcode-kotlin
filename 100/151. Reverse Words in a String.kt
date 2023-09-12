class Solution {
    // Time Complexity: O(2 * n) where n is the length of the s
    // Space Complexity: O(2 * n) where n is the length of the s
    fun reverseWords(s: String): String {
        val sb = StringBuilder();
        var end = s.length - 1;
        for (i in (s.length - 1) downTo -1) {
            if (i == -1 || s[i] == ' ') {
                if (i + 1 <= s.length - 1) {
                    val word = reverseWord(s, i + 1, end);
                    if (word.length > 0) {
                        if (sb.length != 0) 
                            sb.append(' ');
                        sb.append(word);
                    }
                }
                end = i - 1;
            }
        }
        return sb.toString();
    }

    private fun reverseWord(s: String, start: Int, end: Int): StringBuilder {
        val sb = StringBuilder();
        if (start < 0 || end >= s.length)
            return sb
        for (i in start..end) {
            sb.append(s[i]);
        }
        return sb;
    }
}