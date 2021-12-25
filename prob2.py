class Solution:

    # backtracking with pivot
    def partition(self, s):

        result = []

        def helper(s, index, path):
            
            # base
            if index == len(s):
                result.append(path.copy())
                return


            # logic
            for i in range(index, len(s)):

                if isPalindrome(s, index, i):
                    # action
                    path.append(s[index:(i+1)])

                    # recurse
                    helper(s, i+1, path)

                    # backtrack
                    path.pop()
        
        def isPalindrome(s, l, r):
            
            while (l < r):

                if s[l] != s[r]:
                    return False
                l += 1
                r -= 1
            
            return True

        helper(s, 0, [])
        return result

    ######################
    # recursion with pivot

    # def partition1(self, s):

    #     result = []

    #     def helper(s, index, path):
            
    #         # base
    #         if index == len(s):
    #             result.append(path.copy())
    #             return


    #         # logic
    #         for i in range(index, len(s)):

    #             if isPalindrome(s, index, i):
    #                 # action
    #                 li = path.copy()
    #                 li.append(s[index:(i+1)])
                    
    #                 # recurse
    #                 helper(s, i+1, li)

    #     def isPalindrome(s, l, r):
            
    #         while (l < r):
    #             if s[l] != s[r]:
    #                 return False
    #             l += 1
    #             r -= 1
    #         return True

    #     helper(s, 0, [])
    #     return result

    #############################
    # backtracking with substring

    # def partition(self, s: str) -> List[List[str]]:
        
    #     result = []
        
    #     def helper(s, path):
            
    #         if len(s) == 0:
    #             result.append(path.copy())
    #             return
            
    #         for i in range(0, len(s)):
                
    #             if isPalindrome(s, 0, i):
    #                 # action
    #                 path.append(s[0: i+1])
    #                 # recurse
    #                 helper(s[i+1:], path)
    #                 # backtrack
    #                 path.pop()
            
    #     def isPalindrome(s, l, r):
            
    #         while(l < r):
    #             if s[l] != s[r]:
    #                 return False
    #             l += 1
    #             r -= 1
    #         return True
        
    #     helper(s, [])
    #     return result

    ##########################
    # recursion with substring

    # def partition(self, s: str) -> List[List[str]]:
        
    #     result = []
        
    #     def helper(s, path):
            
    #         if len(s) == 0:
    #             result.append(path.copy())
    #             return
            
    #         for i in range(0, len(s)):
                
    #             if isPalindrome(s, 0, i):
    #                 # action
    #                 li = path.copy()
    #                 li.append(s[0: i+1])
    #                 # recurse
    #                 helper(s[i+1:], li)
                    
            
    #     def isPalindrome(s, l, r):
            
    #         while(l < r):
    #             if s[l] != s[r]:
    #                 return False
    #             l += 1
    #             r -= 1
    #         return True
        
    #     helper(s, [])
    #     return result
