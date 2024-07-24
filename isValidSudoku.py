def isValidSudoku(board):
    rows = [set() for _ in range(9)]
    columns = [set() for _ in range(9)]
    boxes = [set() for _ in range(9)]

    for r in range(9):
        for c in range(9):
            if board[r][c] == '.':
                continue
            num = board[r][c]
            box_index = (r // 3) * 3 + (c // 3)
            
            if num in rows[r]:
                return False
            if num in columns[c]:
                return False
            if num in boxes[box_index]:
                return False

            rows[r].add(num)
            columns[c].add(num)
            boxes[box_index].add(num)
    
    return True

# Example usage:
board = [
    ["5","3",".",".","7",".",".",".","."],
    ["6",".",".","1","9","5",".",".","."],
    [".","9","8",".",".",".",".","6","."],
    ["8",".",".",".","6",".",".",".","3"],
    ["4",".",".","8",".","3",".",".","1"],
    ["7",".",".",".","2",".",".",".","6"],
    [".","6",".",".",".",".","2","8","."],
    [".",".",".","4","1","9",".",".","5"],
    [".",".",".",".","8",".",".","7","9"]
]
print(isValidSudoku(board))  # Output: True

#time = O(1)
#space = O(1)