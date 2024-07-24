def palindromePartitioning(s):
    def isPalindrome(sub):
        return sub == sub[::-1]

    def backtrack(start, path):
        if start == len(s):
            result.append(path[:])
            return
        
        for end in range(start + 1, len(s) + 1):
            if isPalindrome(s[start:end]):
                path.append(s[start:end])
                backtrack(end, path)
                path.pop()
    
    result = []
    backtrack(0, [])
    return result

# Example usage:
s = "aab"
print(palindromePartitioning(s))
# Output: [["a","a","b"],["aa","b"]]
