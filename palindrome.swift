

// Time Complexity : 
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :



        var output = [[String]]()
    func partition(_ s: String) -> [[String]] {
        if s == nil || s.count == 0 {
            return []
        }
        var str = Array(s)
        var path = [String]()
        backtracking(str,0,&path)
        return output
        
    }
    func backtracking(_ str: [Character],_ index: Int,_ path: inout [String]) {
        //print(str)
        print(index)
        
        if index >= str.count {
            output.append(path)
            
            return
        }
        for i in index..<str.count {
           var substr = str[index...i]
            if isPalindrome(substr,index,i) {
                path.append(String(substr))
                backtracking(str,i+1,&path)
                path.remove(at: path.count-1)
            }
        }
    }
    func isPalindrome(_ str: ArraySlice<Character>, _ left: Int, _ right: Int) -> Bool {
        var left = left
        var right = right
        while left <= right {
            if str[left] != str[right] {
                return false
            }
            left += 1
            right -= 1
            print(left)
            print(right)
        }
        return true
    }
