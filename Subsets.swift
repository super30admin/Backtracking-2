//
//  Subsets.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 4/7/26.
//

class Subsets {
    
    init() {
        
    }
    
    //using 0-1 recursion
    /*
     time complexity - 2^n
     n - no of elements in array
     */
    func subsets(_ nums: [Int]) -> [[Int]] {
        var result = [[Int]]()
        var path = [Int]()
        findSubsets(nums, i: 0, path: &path, result: &result)
        return result
    }

    private func findSubsets(_ nums: [Int], i: Int, path: inout [Int], result: inout [[Int]]) {

        //base
        if (i == nums.count) {
            result.append(path)
            return
        }

        //no choose
        findSubsets(nums, i: i + 1, path: &path, result: &result)

        //choose
        path.append(nums[i])
        findSubsets(nums, i: i + 1, path: &path, result: &result)
        path.removeLast()
    }
    
    //MARK: For-loop based recursion
    //using for-loop based recursion
    func subsetsUsingForLoop(_ nums: [Int]) -> [[Int]] {
        var result = [[Int]]()
        var path = [Int]()
        findSubsetsUsingForLoop(nums, start: 0, path: &path, result: &result)
        return result
    }

    /*
     In for-loop recursion, every node itself represents a valid subset. We must record subset at each node. Not just leaf nodes.
     */
    private func findSubsetsUsingForLoop(_ nums: [Int], start: Int, path: inout [Int], result: inout [[Int]]) {

        //base
        result.append(path)

        //logic
        for i in start..<nums.count {
            path.append(nums[i])
            findSubsetsUsingForLoop(nums, start: i + 1, path: &path, result: &result)
            path.removeLast()
        }
    }
    
    //MARK: without recursion
    /*
     iniitally keep subset as []
     now, multiple it with all the numbers then it will become [] , [1], [2], [3]
     again multiple by 1, 2, 3 -> [], [1], [2], [3], [1, 2], [2, 3]
     then for
     
     one loop on result
     another loop on elements of array. Create deep copy of all the elements inside the result
     */
    
    func subsetsUsingIterativeApproach(_ nums: [Int]) -> [[Int]] {
        var result = [[Int]]()
        result.append([])
        for i in 0..<nums.count {
            let rSize = result.count
            for j in 0..<rSize {
                print("result[j] \(result[j])")
                var li = result[j]
                li.append(nums[i])
                print("li \(li)")
                result.append(li)
                print("result \(result)")
            }
        }
        return result
    }
}
