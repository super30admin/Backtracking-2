class Solution:
    def partition(self, s: str) -> List[List[str]]:
        d = {}
        
        def part(string):
            if not string:
                return [[]]
            if string in d:
                return d[string]
            result = []
            for i in range(len(string)):
                if string[:i+1] == string[i::-1]:
                    for a in part(string[i+1:]):
                        result.append([string[:i+1]] + a)
            d[string] = result
            return result
        
        return part(s)
