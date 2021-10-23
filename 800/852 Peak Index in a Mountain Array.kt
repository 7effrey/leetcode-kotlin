class Solution {
    fun peakIndexInMountainArray(arr: IntArray): Int {
        // return linearSearch(arr)
        return binarySearch(arr)
    }
    
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private fun linearSearch(arr: IntArray): Int {
        for (i in 1..arr.size - 2) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1])
                return i
        }
        return -1
    }
    
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    private fun binarySearch(arr: IntArray): Int {
        var start = 1
        var end = arr.size - 2
        while (start <= end) {
            val mid = start + (end - start) / 2
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                return mid
            else if (arr[mid] > arr[mid - 1] )
                start = mid + 1
            else
                end = mid - 1
        }
        return -1
    }
}