class Solution:
    def partition(self, s: str) -> List[List[str]]:
        result = []

        def is_palindrome(string):
            return string == string[::-1]

        def helper(pivot, path):
            #base case
            if pivot ==len(s):
                result.append(path[:])

            #logic
            for i in range(pivot, len(s)):
                substring = s[pivot:i+1]
                if is_palindrome(substring):
                    path.append(substring)
                    helper(i+1, path)
                    path.pop()
        
        helper(0,[])
        return result
        