class Solution:
    def partition(self, s: str) -> List[List[str]]:
        if s == None or s == "":
            return []
        #chars  = s.split()
        self.result = []
        self.recursion(s,[], 0)
        return self.result
    
    def recursion(self, chars : str, pal :List[str], index : int ) ->None:
        if index == len(chars):
            self.result.append(pal)
            return
        
        for i in range(index, len(chars)):
            sub = chars[index : i +1]
            #print(self.ispalindrom(sub))
            if self.ispalindrom(sub):
                pal.append(sub)
                self.recursion(chars, pal, i +1 )
                pal.pop()
        # for i in range(index, len(chars)):
        #     sub = chars[index : i +1]
        #     #print(self.ispalindrom(sub))
        #     if self.ispalindrom(sub):
        #         newList = [num for num in pal]
        #         newList.append(sub)
        #         self.recursion(chars, newList, i +1 )
    
    def ispalindrom(self, chrs : str ) -> bool:
        if chrs == chrs[::-1]:
            return True
        else:
            return False

        