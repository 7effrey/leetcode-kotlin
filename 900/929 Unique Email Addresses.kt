class Solution {
    // Time Complexity: O(n * l) where n is the number of emails and l is the max length of chars in email
    // Space Complexity: O(n * l)
    fun numUniqueEmails(emails: Array<String>): Int {
        val table = hashSetOf<String>()
        val sb = StringBuilder()
        emails.forEach { email ->
            var plus = false
            var domain = false
            var i = 0
            while (i < email.length) {
                val char = email[i]
                if (char == '.') {
                    if (domain) {
                        sb.append(char)
                    }
                } else if (char == '+') {
                    plus = true
                } else if (char == '@') {
                    domain = true
                    plus = false
                    sb.append(char)
                } else {
                    if (!plus) {
                        sb.append(char)    
                    }
                }
                i++
            }
            table.add(sb.toString())
            sb.clear()
        }
        return table.size
    }
}