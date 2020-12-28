# Approach: Backtracking

# Here we will use backtracking solution. That means we will put first queen in the first cell in first row. We will move to second column and of all places in which queen can be placed we will put at first postition. Move again to next row. Carry out the same operation. In between if you reach a path where you can not place the queen in any of cell in row, then backtrack. Go to previous row, adjust queens place(following the conditinons) and again move ahead. We will keep doing this untill we reach a solution. 

# Now we wont stop if a solution is reached. Remember we need to find out all the solutions. So we backtrack and go on to find another part. 

# Time complexity: O(n!). There is N possibilities to put the first queen, not more than N (N - 2) to put the second one, not more than N(N - 2)(N - 4) for the third one etc. In total that results in \mathcal{O}(N!)O(N!) time complexity.

# Space complexity: O(n*n + n) ~ O(n*n)

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.result = []
        self.board = [ [ 0 for i in range(n) ] for j in range(n) ]

        if n == 0:
            return self.result
        
        self.backtrack(0, n)
        return self.result
        
    def backtrack(self, row, n):
        # base
        if row == n:
            temp = []
            
            for i in range(n):
                string = ""
                for j in range(n):
                    if self.board[i][j] == 1:
                        string += 'Q'
                    else:
                        string += '.'
                        
                temp.append(string)
            
            self.result.append(temp)
            return
        
        # Logic
        for i in range(n):
            if(self.safeMove(row, i, n)):                
                # Action
                self.board[row][i] = 1
                
                # Recurse
                self.backtrack(row + 1, n)
            
                # Backtrack
                self.board[row][i] = 0
            
    def safeMove(self, row, col, n):
        
        # Checking the column   
        for i in range(row, -1, -1):
            if self.board[i][col] == 1:
                return False
            
        i = row
        j = col
        
        # Upper left
        while i >= 0 and j >= 0:
            if self.board[i][j] == 1:
                return False
            
            i -= 1
            j -= 1
        
        i = row
        j = col

        # Upper right
        while i >= 0 and j < n:
            if self.board[i][j] == 1:
                return False
            
            i -= 1
            j += 1
        
        return True
            
        