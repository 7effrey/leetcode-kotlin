class Solution {
    // Time Complexity: O(m*n*3^l)
    // Space Complexity: O(m*n)
    fun exist(board: Array<CharArray>, word: String): Boolean {
        // O(m)
        board.forEachIndexed { y, charArray ->
            // O(n)
            charArray.forEachIndexed { x, char ->
                // O(3^l)
                if (search(board, y, x, word, 0, hashSetOf<Pair<Int, Int>>()))
                    return true
            }
        }
        return false
    }
    
    private fun search(board: Array<CharArray>, y: Int, x: Int, word: String, index: Int, path: HashSet<Pair<Int, Int>>): Boolean {
        // Handle out of bounds
        if (y < 0 || x < 0 || y >= board.size || x >= board[0].size)
            return false
        // Handle incorrect char
        if (board[y][x] != word[index])
            return false
        val current = Pair(y, x)
        // Handle traversing to the same cell twice
        if (path.contains(current))
            return false
        if (index == word.length - 1)
            return true 
        path.add(current)
        val u = search(board, y - 1, x, word, index + 1, path)
        val d = search(board, y + 1, x, word, index + 1, path)
        val l = search(board, y, x - 1, word, index + 1, path)
        val r = search(board, y, x + 1, word, index + 1, path)
        path.remove(current)
        return u || d || l || r
    }
}