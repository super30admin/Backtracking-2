/*
    approach: backtracking and for-loop recursion
    time: o(2^n) x o(n)
        - the extra o(n) is from creating a deep copy of path in each recursion
    space: o(n) from recursion stack + o(n) for each path at each recursion
*/
// func subsets(nums []int) [][]int {
//     out := [][]int{}
//     var dfs func(start int, path []int)
//     dfs = func(start int, path []int) {
//         // base
            
//         newL := make([]int, len(path))
//         copy(newL, path)
//         out = append(out, newL)
        
//         // logic
//         for i := start; i < len(nums); i++ {
//             path = append(path, nums[i])
//             dfs(i+1,path)
//             path = path[:len(path)-1]
//         }
//     }
//     dfs(0, nil)
//     return out
// }

/*
    approach: make a copy of list each time and append nums[i] to it.
    - start with out array with an empty array { {} }
    - then for each ith number, loop over all the lists we have so far in output array
    - make a deep copy of each list
    - add ith number
    - save this new list to output array 
    time: o(2^n) x o(n) 
        - the largest nested loop will be for the last ith number in nums array
        - that loop will run o(2^n-1) iterations
        - the extra o(n) is for deep copy
    space: ??? PR reviewer - help ??  I want to say its o(1) because each deep copy is part of the output .. 
*/
func subsets(nums []int) [][]int {
    out := [][]int{{}}
    for i := 0; i < len(nums); i++ {
        for _, list := range out {
            newL := make([]int, len(list))
            copy(newL, list)
            newL = append(newL, nums[i])
            out = append(out, newL)
        }
    }
    return out
}
