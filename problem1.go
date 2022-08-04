// Time Complexity : O(2^N)
// Space Complexity : O(2^N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//TC - Exponential 2^N
//SC - Exponential 2^N

var result [][]int
func subsets(nums []int) [][]int {
    if len(nums) == 0{
        return [][]int{}
    }
    
    result = [][]int{}
    
    
    helper(nums,0,[]int{})
    
    return result
}

//Recursive
func helper(nums []int,index int, path []int){
    if index == len(nums){
        curr := []int{}
        curr = append(curr,path...)
        result = append(result,curr)
        return
    }
    
    
    //logic
    //0 case
    helper(nums,index+1,path)
    // 1 case     
    path = append(path,nums[index])
    helper(nums,index+1,path)
    path = path[:len(path)-1]
}

//forloop

func helper(nums []int,index int, path []int){
    //base
    
    
    //logic
    curr := []int{}
    curr = append(curr,path...)
    result = append(result,curr)
    
    for i:=index;i<len(nums);i++{
        path = append(path,nums[i])
        
        helper(nums,i+1,path)
        
        path = path[:len(path)-1]
    }
    
}

//Iterative
func subsets(nums []int) [][]int {
    if len(nums) == 0{
        return [][]int{}
    }
    
    result = [][]int{}
    result = append(result,[]int{})
    
    for i:=0;i<len(nums);i++{
        size := len(result)
        for j:=0;j<size;j++{
            new := []int{}
            new = append(new,result[j]...)
            new = append(new,nums[i])
            result = append(result,new)
        }
    }
    
    //helper(nums,0,[]int{})
    
    return result
}

