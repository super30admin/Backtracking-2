/*
    approach: backtracking + for-loop recursion
/*
    The idea here is to create every possible substr and try finding other combinations that are also substr and saving them.
    
    0/1 recursion does not work in this case because we do not have a "not-choose" case. We have to select all chars and create a substr that is a palindrome.
    
    Since we need to form every single palindrome combination, it feels like we should use a for loop based recursion here.
    
    appraoch: for loop based recursion
    - In each iteration, we need to create a substr to start with and try all other possible combinations.
    - How do we create that substr... ?
    - If we are using a for loop based recursion,
    - then there will always be a ptr telling us where to start our for loop from. Let that ptr be "start".
    - Then forming of substr will be $start:i+1 (+1 to include the ith char)
    - if the formed substr is a palindrome, only then
        - Add the substr to our paths ( action )
            - We have added a VALID palindrome partition, now try forming other combinations.
        - And then recurse with start position moved forward by 1 (since we are not using the same char as that would be incorrect) with updated paths.
        - The base case will be responsible for adding each path to a result list ONLY when we have used all chars (i.e when start goes out of bounds)
        
                    s
                    ii(backToParent) newSubStr 'aa', and its valid so recurse with 'aa' and i and s will be at i+1(last idx) - ['aa','b']
                    aab
                    / 
    ('a')          /  
                  ii(backToParent) newSubStr 'ab' and its not a valid palindrome, so exit from here early 
                  s   
                 aab
                /
    ('a','a')  /
                i i(backToParent - nothing left - for loop exits)
                s
              aab
            /
('a','a',b)/
             i
             s
          aab
          [save result]
          
    - time: 2o(n) * 2^n
        2o(n) == subStr formation o(n) + isPalindrome o(n)
    - space: o(n), where n is the lenght of str. In recursion stack, we will end up pausing at worse n calls if str = 'aaa' ( with single splits )
*/
func partition(s string) [][]string {
    out := [][]string{}
    var dfs func(start int, path []string)
    dfs = func(start int, path []string) {
        // base
        if start == len(s) {
            newL := make([]string, len(path))
            copy(newL, path)
            out = append(out, newL)
            return
        }
        
        // logic
        for i := start; i < len(s); i++ {
            subStr := s[start:i+1]
            if !isPalindrome(subStr) {continue}
            path = append(path, subStr)
            dfs(i+1, path)
            path = path[:len(path)-1]
        }
    }
    dfs(0, nil)
    return out
    
}

func isPalindrome(s string) bool {
    left := 0
    right := len(s)-1
    for left < right {
        if s[left] == s[right] {
            left++
            right--
        } else {
            return false
        }
    }
    return true
}
