class Solution {
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        s.forEach { char ->
            if (char == '(' || char == '{' || char == '[') {
                stack.add(char)
            } else if (char == ')' || char == '}' || char == ']') {
                if (stack.isEmpty())
                    return false
                val last = stack.pop()
                val invalid = (char == ')' && last != '(') || (char == '}' && last != '{') || (char == ']' && last != '[')
                if (invalid) {
                    return false
                }
            }
        }
        return stack.isEmpty()
    }
}