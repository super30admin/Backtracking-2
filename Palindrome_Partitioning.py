#Time:O(2^N +N)  as we chose/unchose at each value and N for checking  a string is palindrome or not
#Space:O(N) max depth of the recursion is equal to length of list
class Solution:
    def partition(self, s: str) -> List[List[str]]:
        """
        For each character in the string we have 2 choices to create new palindrome
        substrings, first one is to join with previous substring (for(:len()))
        or another is to start a new palindrom substring (bactrack(..len()..))
        """
        if not s:
            return []
        ans = []
        def backtrack(list_val,index):
            if index == len(s):
                ans.append(list_val[:])
                return
            for i in range(index,len(s)):
                if s[index:i+1] != s[index:i+1][::-1]:
                    continue
                list_val.append(s[index:i+1])
                backtrack(list_val,i+1)
                list_val.pop()
        backtrack([],0)
        return ans