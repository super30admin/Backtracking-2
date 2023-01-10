#time complexity: O(N*(2^N))
#space complexity: O(N)
#ran on leetcode: Yes
#loop through s. Break at a index and recurse from index+1 if string  forms a palindrome , to form the next substring. Backtrack and add the character at index to string and recurse.
class Solution:
    def rec(self,s,index,palindromes,res):
        if(index>=len(s)):
            self.ans.append(res[:])
            return
        st=[]
        for i in range(index,len(s)):
            if( ( ( (index+1,i-1) in palindromes or index+1>i-1 ) and s[index]==s[i]) or index==i):
                palindromes.add((index,i))
                res.append(s[index:i+1])
                self.rec(s,i+1,palindromes,res)
                del(res[-1])


    def partition(self, s: str) -> List[List[str]]:
        palindromes=set()
        self.ans=[]
        self.rec(s,0,palindromes,[])
        return self.ans
