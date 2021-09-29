class Solution {
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        // return topKFrequentQuickSort(words, k)
        return topKFrequentPriorityQueue(words, k)
    }
    
    // O(n log k)
    private fun topKFrequentPriorityQueue(words: Array<String>, k: Int): List<String> {
        val map = hashMapOf<String, Int>()
        // O(w) where w is the length of words array
        words.forEach { word ->
            map[word] = (map[word] ?: 0) + 1
        }
        
        // Heap with k + 1 size in ascending order for frequency and descending order for words with same frequency
        val heap = PriorityQueue<Pair<String, Int>>(Comparator { (w1, c1), (w2, c2) ->
            if (c1 == c2) {
                w1.compareTo(w2) * -1
            } else
                c1 - c2
        })
        
        // O(u) where is the length of unique words
        map.forEach {
            // O(log k)
            heap.add(Pair(it.key, it.value))
            // O(log k)
            if (heap.size > k) {
                heap.remove(heap.peek())
            }
        }
        
        // O(k)
        val list = LinkedList<String>()
        while (heap.isNotEmpty()) {
            list.addFirst(heap.poll().first)
        }
        return list
        
    }
    
    // O(n log n)
    private fun topKFrequentQuickSort(words: Array<String>, k: Int): List<String> {
        val map = hashMapOf<String, Int>()
        // O(w) where w is the length of words array
        words.forEach { word ->
            map[word] = (map[word] ?: 0) + 1
        }
        // O(u) where u is the length of unique words
        return map.toList()
            // O(u.log u) for quick sort
            .sortedWith(Comparator { (w1, c1), (w2, c2) ->
                if (c1 == c2) {
                    // O(l) where l is the min length of w1 / w2
                    w1.compareTo(w2)
                } else
                    // O(1)
                    c2 - c1
            })
            // O(1)
            .take(k)
            // O(k)
            .map { it.first }
        
    }
}