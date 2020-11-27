class Solution:
    
    def check_palindrome(self, string):
        if string  == string[::-1]:
            return True
        return False
        
    def check_partition(self, s, partition, result):
        if s:
            for i in range(0,len(s)):
                #print(s[:i+1])
                if self.check_palindrome(s[:i+1]):
                    partition.append(s[:i+1])
                    self.check_partition(s[i+1:], partition, result)
                    partition.pop()
        else:
            result.append(partition[:])
                
    def partition(self, s: str) -> List[List[str]]:
        result = []
        self.check_partition(s, [], result)
        return result
            