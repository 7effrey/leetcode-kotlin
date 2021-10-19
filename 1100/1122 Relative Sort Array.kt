class Solution {
    // n = arr1.length
    // m = arr2.length
    // Time Complexity: O(m + n * log n)
    // Space Complexity: O(m + n)
    fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
        // Create hashMap for lookup table comparison based on the index of arr2
        val table = hashMapOf<Int, Int>()
        arr2.forEachIndexed { index, num ->
            table[num] = index
        }
        
        // Sort arr1 by using lookup table value as comparison
        return arr1.sortedWith(object: Comparator<Int> {
            override fun compare(num1: Int, num2: Int): Int {
                val val1 = table[num1] ?: -1
                val val2 = table[num2] ?: -1
                if (val1 == -1 && val2 == -1)
                    return num1 - num2
                else if (val1 == -1)
                    return val2
                else if (val2 == -1)
                    return val1
                else
                    return val1 - val2
            }

        }).toIntArray()
    }
}