class Solution {
    // Time Complexity: O(n log n)
    // Space Complexity: O(n)
    fun reorderLogFiles(logs: Array<String>): Array<String> {
        val map = hashMapOf<String, Pair<String?, Int>>()
        // O(n)
        logs.forEachIndexed { index, log ->
            val startContentIndex = log.indexOfFirst { it == ' ' }
            if (startContentIndex != -1) {
                val content = log.substring(startContentIndex + 1, log.length)
                if (content[0].isDigit()) {
                    map[log] = Pair(null, index)
                } else {
                    map[log] = Pair(content, -1)
                }
            }
        }
        // O(n log n)
        logs.sortWith(object: Comparator<String> {
            override fun compare(l1: String?, l2: String?): Int {
                val (c1, i1) = map[l1]!!
                val (c2, i2) = map[l2]!!
                return if (i1 == -1 && i2 == -1) {
                    // .compareTo() may do characters checking with O(m) where m is the length of log
                    val cResult = c1!!.compareTo(c2!!, true)
                    if (cResult != 0)
                        cResult
                    else
                        l1!!.compareTo(l2!!, true)
                } else if (i1 == -1) {
                    -1
                } else if (i2 == -1) {
                    1
                } else {
                    i1 - i2
                }
            }

        })
        return logs
    }
}