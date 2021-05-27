// Time Complexity :O(n*(2^n))=> O(2^n) n=length of word
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
class PalindromePartitioning {
    //list to store result
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        //initializing the result list;
        result = new ArrayList<>();
        //input is empty return empty list
        if(s==null|s.length()==0) return result;
        //call helper function to find partition
        helper(s, 0, new ArrayList<>());
        // helper(s, new ArrayList<>());

        return result;
    }

    //method to find partition
    public void helper(String s, int index, List<String> path){
        //all combination of input sring is checked
        if(index == s.length()){
            //add path to result
            result.add(new ArrayList<>(path));
            return;
        }
        // for all possible substrings
        for(int i=index; i<s.length(); i++){
            //get substring
            String subStr = s.substring(index, i+1);
            //check if substring is palindrome
            if(isPalindrome(subStr)){
                //add substring to path
                path.add(subStr);
                //recurse for next pivot
                helper(s, i+1, path);
                //backtrack
                path.remove(path.size()-1);
            }
        }
    }

    //method to find palindrome
    public boolean isPalindrome(String s){
        if(s.length()==1) return true;

        int left = 0;
        int right = s.length()-1;

        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

