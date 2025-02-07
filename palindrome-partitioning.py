# tc O(2^n * n), sc O(2^n * n).
def dfs(idx):
    # base case
    if idx == len(s):
        res.append(path[:])
        return
    
    # recursive case
    for i in range(idx, len(s)):
        string = s[idx:i+1]
        if string == string[::-1]:
            path.append(string)
            dfs(i+1)
            path.pop()

res = []
path = []
dfs(0)
return res