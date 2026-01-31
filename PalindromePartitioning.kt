// In this problem, we are using for loop based backtracking to find all possible palindrome partitioning of a given string. We maintain a path that represents the current partition being constructed. 
// At each step, we explore if the substring from the current pivot to the current index is a palindrome or not. If it is we add it to path and recursively call the helper with updated pivot. 
// When we reach the end of the string, we add the current path to our result list.
// Time complexity: O(n * 2^n) where n is the length of the string and 2^n is the no. of possible partitions
// Space complexity : O(n)

class Solution {
    val result = mutableListOf<List<String>>()
    fun partition(s: String): List<List<String>> {
        val path = mutableListOf<String>()
        helper(s, 0, path)
        return result
    }

    fun helper(s:String, pivot: Int, path: MutableList<String>) {
        //base
        if(pivot == s.length) {
            result.add(path.toList())
            return
        }

        for(i in pivot until s.length) {
            val subStr = s.substring(pivot, i+1)
            if(isPalindrome(subStr)) {
                path.add(subStr)

                helper(s, i + 1, path)

                path.removeAt(path.lastIndex)
            }
        }
    }

    fun isPalindrome(s: String) : Boolean {
        var left = 0 
        var right = s.length - 1
        while(left < right) {
            if(s[left] != s[right]) return false
            left++ 
            right--
        }
        return true
    } 
}