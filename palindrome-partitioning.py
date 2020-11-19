class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        if s=='':
            return []
        result=[]
        def palindrome(s):
            # print(s)
            if s==s[::-1]:
                return True
        def recc(s,index,path):
            if index==len(s):
                result.append(list(path))
            # print(result)
            for i in range(index,len(s)):
                if palindrome(s[index:i+1])==True:
                    path.append(s[index:i+1])
                    # print(path)
                    recc(s,i+1,path)
                    path.pop()
        recc(s,0,[])
        return result