class Solution {
    
    private val list: ArrayList<List<String>> = arrayListOf<List<String>>()
    
    fun partition(s: String): List<List<String>> {
        list.clear()
        partitioning(s, 0, s.length, arrayListOf<String>())
        return list
    }
    
    private fun partitioning(s: String, start: Int, end: Int, temp: ArrayList<String>) {
        if (start >= end) {
            list.add(temp)
        }
        // O(n)
        for (i in start + 1..end) {
            // O(2^n)
            if (isPalindrome(s, start, i)) {
                val newList = ArrayList<String>(temp)
                newList.add(s.substring(start, i))
                partitioning(s, i, end, newList)
            }
        }
    }
    
    // O(end - start)
    private fun isPalindrome(s: String, start: Int, end: Int): Boolean {
        var i = start
        var j = end - 1
        while (i <= j) {
            if (s[i++] != s[j--])
                return false
        }
        return true
    }
}