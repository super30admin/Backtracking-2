# Time Complexity : O(4^n)
# Space Complexity : O(n)

# Approach:
# In this approach, we use a depth-first search (DFS) to explore all possible combinations of operators and operands.
# We start from the first digit and recursively add operators between the digits.
# We keep track of the current calculation and the last operand to handle multiplication correctly.
# When we reach the end of the string, we check if the current calculation matches the target.
# If it does, we add the current expression to the result list.
# We also handle edge cases such as leading zeros in the operands.

class Solution:
    def addOperators(self, num: str, target: int):
        # Calculate the length of the input string
        n = len(num)
        # Initialize an empty list to store the results
        res = []
        # Define a recursive function to perform DFS
        # pivot: current index in the string
        # calc: current calculation value
        # tail: last operand used in the calculation
        def dfs(pivot, calc, tail, path):
            # If we reach the end of the string, check if the current calculation matches the target
            if pivot == n:
                # If it matches, add the current expression to the result list
                if calc == target:
                    res.append(path)
            # If we haven't reached the end, we need to explore all possible combinations
            for i in range(pivot, n):
                # Get the current substring from pivot to i+1
                string = num[pivot:i+1]
                # Convert it to an integer
                curr = int(string)
                # Check for leading zeros
                # If the current substring has leading zeros and is not the first digit, skip it
                if num[pivot] == '0' and i != pivot:
                    break
                # If we are at the first digit, we can only use it as is
                elif pivot == 0:
                    dfs(i+1, curr, curr, path+string)
                # If we are not at the first digit, we can use it with different operators
                # We can add '+' or '-' or '*' operators
                else:
                    # Add the current substring with '+' or '-' or '*' operator
                    dfs(i+1, calc+curr, curr, path+ "+" +string)
                    dfs(i+1, calc-curr, -curr, path+ "-" +string)
                    # For multiplication, we need to adjust the calculation
                    # We subtract the last operand and add the new one
                    # This is because multiplication has higher precedence than addition and subtraction
                    dfs(i+1, (calc-tail) + (tail*curr), tail*curr, path+ "*" +string)
        # Start the DFS from the first digit
        dfs(0, 0, 0, '')
        # Return the result list
        return res