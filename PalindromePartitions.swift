//
//  PalindromPartitions.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 4/7/26.
//

class PalindromePartition {
    
    init() {
        
    }
    
    /*
     time complexity - n * 2^n (since at every position, we have choice to choose or not choose so, exponent of 2.) We are checking for each and every string if it is palindrome or not. Hence, multiple by n
     */
    func partition(_ s: String) -> [[String]] {
        var result = [[String]]()
        var path = [String]()
        let sArr = Array(s)
        helper(sArr: sArr, start: 0, path: &path, result: &result)
        return result
    }

    //for loop based recursion
    func helper(sArr: [Character], start: Int, path: inout [String], result: inout [[String]]) {

        //base
        //if we reached end of string then add in the result
        if (start == sArr.count) {
            result.append(path)
            return
        }

        for i in start..<sArr.count {

            //take substring from start to i and check if it is palindrom. If yes, then make further call
            let current = Array(sArr[start...i])
            if (isPalindrome(sArr: current)) {
                path.append(String(current))
                helper(sArr: sArr, start: i + 1, path: &path, result: &result)
                path.removeLast()
            }
        }
    }

    private func isPalindrome(sArr: [Character]) -> Bool {
        var i = 0
        var j = sArr.count - 1
        while (i < j) {
            if (sArr[i] == sArr[j]) {
                i += 1
                j -= 1
            } else {
                return false
            }
        }
        return true
    }

}
