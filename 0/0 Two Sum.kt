class Solution {
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = hashMapOf<Int, ArrayList<Int>>()
        // O(n) to build the hashMap
        nums.forEachIndexed { index, num -> 
            var list = map[num] ?: arrayListOf<Int>()
            list.add(index)
            map[num] = list
        }
        // O(n) to find the missing number (target - num) from hashMap
        nums.forEachIndexed { index, num -> 
            val missing = target - num
            map[missing]?.let { list ->
                list.filter { it != index }.firstOrNull()?.let { secondIndex ->
                    return intArrayOf(index, secondIndex)    
                }
            }
        }
        return intArrayOf()
    }
}