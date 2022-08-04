// Time Complexity : O(2^N)
// Space Complexity : O(2^N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//TC - 2^N
//SC - 2^N

var result [][]string

func partition(s string) [][]string {
    if len(s) == 0{
        return [][]string{}
    }
    
    result = [][]string{}
    
    helper1(s,0,[]string{})
    helper2(s,[]string{})
    return result
}

func helper1(s string,index int,path []string){
    
    if index == len(s){
        new := []string{}
        new = append(new,path...)
        result = append(result,new)
    }
    
    //logic
    for i:=index;i<len(s);i++{
        if palindrome(s,index,i){
            path = append(path,string(s[index:i+1]))
            
            helper1(s,i+1,path)
            
            path = path[:len(path)-1]
        }
          
    }
}

//without index

func helper2(s string,path []string){
    
    if len(s) == 0{
        new := []string{}
        new = append(new,path...)
        result = append(result,new)
    }
    
    //logic
    for i:=0;i<len(s);i++{
        if palindrome(s,0,i){
            path = append(path,string(s[0:i+1]))
            
            helper2(s[i+1:],path)
            
            path = path[:len(path)-1]
        }
          
    }
}

func palindrome(s string,left,right int) bool{
    for left <= right{
        if s[left] != s[right]{
            return false
        }
        left++
        right--
    }
    
    return true
}
