class PalindromePartitioning {
    //Approach - BackTracking
    // Time complexity - exponential
    // Space complexity - O(n)
    // Tested in leetcode
    
    // driver function for calling recursion. 
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(result,s,new ArrayList<>(),0);
        for(List<String> list : result )
        return result;
    }
    
    //helper function, calls itsef, generate list of substrings and save intot the result list if all substrings of the list are 
    // palindrome.
    public void helper(List<List<String>> result, String s, ArrayList<String> temp, int index){
        //base case - when index is pointing to end of the string, add list to the final result list and return.
        if(index == s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }
        
        // generate all substrings and save into the temp list if the substring is palindrome, recurse, undo and check for all               // possibilities.
        for(int i=index; i<s.length(); i++){
            int len = temp.size();
            // generate substrings
            String str = s.substring(index,i+1);
            
            // if substring is palindrome then recurse for next option else return
            if(checkPalindrome(str)){
                temp.add(str);
                helper(result,s,temp,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    //  return true if the input string is palindrome
    public boolean checkPalindrome(String s){
        int i=0, j = s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}