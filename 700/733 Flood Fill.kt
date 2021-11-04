class Solution {
    // Time Complexity: O(m * n)
    // Space Complexity: O(m * n)
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        val color = image[sr][sc]
        // To avoid infinite looping because newColor == color
        if (color == newColor)
            return image
        
        val yMax = image.size
        val xMax = image[0].size
        
        val queue = LinkedList<Pair<Int, Int>>()
        queue.add(Pair(sr, sc))
        
        while (queue.isNotEmpty()) {
            val (y, x) = queue.removeFirst()
            
            if (image[y][x] != color)
                continue
            image[y][x] = newColor

            if (y > 0 && image[y - 1][x] == color)
                queue.add(Pair(y - 1, x))
            if (y < yMax - 1 && image[y + 1][x] == color)
                queue.add(Pair(y + 1, x))
            if (x > 0 && image[y][x - 1] == color)
                queue.add(Pair(y, x - 1))
            if (x < xMax - 1 && image[y][x + 1] == color)
                queue.add(Pair(y, x + 1))
        }
        
        return image
    }
}