

// Time Complexity : 
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :



    var output = [[Int]]()
    func subsets(_ nums: [Int]) -> [[Int]] {
        if nums == nil || nums.count == 0 {
            return []
        }
        var subset = [Int]()
        backtracking(nums,0,&subset)
        return output
    }
    func backtracking(_ nums: [Int],_ index:Int, _ subset: inout [Int]) {
        //var subset = subset
        output.append(subset)
        if index > nums.count-1 {
            return
        }
        for i in index..<nums.count {
            subset.append(nums[i])
            backtracking(nums,i+1,&subset)
            subset.remove(at: subset.count-1)
        }
    }
