class Solution {
    // Time Complexity: O(n * m) where m is the length of String
    // Space Complexity: O(n)
    fun countAndSay(n: Int): String {
        if (n == 1)
            return "1";
        val string = countAndSay(n - 1);
        val builder = StringBuilder();
        var current = string[0];
        var counter = 0;
        string.forEachIndexed { index, element ->
            if (current != element) {
                builder.append(counter.toString());
                builder.append(current.toString());

                current = element;
                counter = 1;
            } else {
                counter++;
            }
        }
        builder.append(counter.toString());
        builder.append(current.toString());
        return builder.toString();
    }
}