class Solution {
    // Time Complexity: O(n) where n is the length of s
    // Space Complexity: O(n) where n is numRows
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1)
            return s;

        val table = arrayListOf<StringBuilder>();
        for (i in 0..(numRows - 1)) {
            table.add(StringBuilder());
        }

        var down = true;
        var y = 0;
        s.forEachIndexed { index, element -> 
            table[y].append(element);
            if (down) y++ else y--;
            if (y == numRows) {
                y -= 2;
                down = !down;
            } else if (y == -1) {
                y += 2;
                down = !down;
            }
        }

        var result = StringBuilder();
        for (i in 0..(numRows - 1)) {
            result.append(table[i]);
        }
        return result.toString();
    }
}