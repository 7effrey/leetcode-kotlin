class Solution {
    // Time Complexity: O(2^(2n))
    // Space Complexity: O(2^(2n)) to store String combinations in a list
    fun generateParenthesis(n: Int): List<String> {
        val list = arrayListOf<String>()
        recursiveParenthesis(n, n, "", list)
        return list
    }
    
    private fun recursiveParenthesis(openCounter: Int, closeCounter: Int, current: String, list: ArrayList<String>) {
        if (openCounter == 0 && closeCounter == 0) {
            list.add(current)
            return
        }
        if (openCounter > 0)
            recursiveParenthesis(openCounter - 1, closeCounter, current + "(", list)
        if (closeCounter > 0 && closeCounter > openCounter)
            recursiveParenthesis(openCounter, closeCounter - 1, current + ")", list)
    }
    /**
        n = 1 -> 4 = 2 ^ 2*n
            (           )
        ((      ()  )(      ))
        
        n = 2 -> 16 = 2 ^ 2*n
                                        (                                                                           )
                            ((                                          ()                                  )(              ))
                (((                     (()                     ()(                 ())                 )((     )((     ))(     )))
        ((((            ((()    (()(            (())    ()((        ()()    ())(        ()))          
    */
}