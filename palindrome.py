# As taught in class using backtrcking to solve the problem
# Time Complexity: Exponential
# Space Complexity: O(n)
result = list()
def partition(s):
    if s is None:
        return
    helper(s,[],0)
    return result

def helper(s, temp, index):
    if (index == len(s)):
        result.append(list(temp))
        return
    for i in range(index,len(s)):
        
        if(isPalindrome(s,index,i)):
            temp2 = list(temp)
            temp2.append(s[index:i+1])
            print(temp2)
            helper(s,temp2,i+1)


def isPalindrome(curr,left,right):
    left = 0
    right = len(curr) - 1
    while(left < right):
        if (curr[left]  != curr[right]):
            return False
        left = left + 1
        right = right - 1
    return True

st = "aaa"
partition(st)
print(result)
