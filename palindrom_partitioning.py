class Solution:
    def is_palindrome(self,palindromes):
        print("called : ",palindromes)
        for palin in palindromes:
            if len(palin) % 2 == 0:
                if palin[:int(len(palin)/2)] != palin[int(len(palin)/2):][::-1]:
                    return False
            else: 
                if palin[:int(len(palin)/2)]!= palin[int(len(palin)/2)+1:][::-1]:
                    return False
        return True
                
    def partition(self, s: str) -> List[List[str]]:
        
        self.final = []
        def recur(temp,index):
            print(temp,index)
            if index == len(s):
                if self.is_palindrome(temp):
                    self.final.append(temp)
                return
            else:
                recur(temp + [s[index]],index+1)
                val = temp[-1]
                val += s[index]
                temp.pop()
                recur(temp + [val],index+1)
        recur([s[0]],1)
        return self.final