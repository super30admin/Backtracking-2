#Time complexity: o(n2)
#space complexity: o(n)
class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        def isPalindrome(start_ind, end_ind):
            while start_ind <= end_ind:
                if s[start_ind] != s[end_ind]: return False
                start_ind += 1
                end_ind -=1
            return True
        
        def dfs(start_ind, path):
            print(start_ind)
            print(path)
            if start_ind >= len(s): self.res.append(path)
                
            for l in range(len(s) - start_ind):
                print(l)
                if isPalindrome(start_ind, start_ind + l):
                    dfs(start_ind + l + 1, path + [s[start_ind:start_ind + l + 1]] )
        
        self.res = []
        dfs(0,[])
        return self.res
