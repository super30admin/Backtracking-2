class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        #Time complexity: O(n * 2^n)
        #null case
        if s is None or len(s) == 0:
            return []
        
        self.res = []
        def backtrack(s,index,path):
            #base
            #if the substring left is 0, then it means the path has all palindromes
            #any list without a palindrome would anyways be kicked out because of the if condition
            if len(s) == index:
                resPath = list(path)
                self.res.append(resPath)
                return
            #logic
            #parse through the string, increasing pivot by 1
            #order of loop consideration: ['a','aa','aab']
            for i in xrange(index,len(s)):
                pre_str = s[index:i+1]
                if pre_str == pre_str[::-1]:
                    #action
                    path.append(s[index:i+1])
                    #recurse
                    backtrack(s,i+1,path)
                    #backtrack
                    path.pop()
        backtrack(s,0,[])
        return self.res
        # def backtrack(s,path):
        #     #base
        #     #if the substring left is 0, then it means the path has all palindromes
        #     #any list without a palindrome would anyways be kicked out because of the if condition
        #     if len(s) == 0:
        #         resPath = list(path)
        #         self.res.append(resPath)
        #         return
        #     #logic
        #     #parse through the string, increasing pivot by 1
        #     #order of loop consideration: ['a','aa','aab']
        #     for i in xrange(len(s)):
        #         pre_str = s[0:i+1]
        #         if pre_str == pre_str[::-1]:
        #             #action
        #             path.append(s[0:i+1])
        #             #recurse
        #             backtrack(s[i+1:],path)
        #             #backtrack
        #             path.pop()
        # backtrack(s,[])
        # return self.res