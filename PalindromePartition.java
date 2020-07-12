// Time Complexity : O(n*2^n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


//Solution : Recursive
class Solution {
    //declare result globally
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        //initialize result
        result = new ArrayList<>();
        //no check for null or length 0 condition, 
        //as the backtracking method takes care of it
        //call backtracking method with parameters
        // string s, temp array list and index position : 0 at start
        recursive(s, new ArrayList<>(), 0);
        //return result list 
        return result;
    }
      
    private void recursive(String s, List<String> temp, int index) {
        //base condition
        //if index reaches end of string
        //then the string in temp is a possible palindrome partition
        //add it to result and return
        if(index == s.length()){
            result.add(temp);
            return; 
        }
        
        //logic 
        //iterate the string from index postion to end of string
        //index position is increased in each recursive call
        for(int i = index; i < s.length(); i++) {
            //if index to i is palidrome 
            //(parameters : string, and index and i position)
            //enter the loop
            // if not inc i and check again
            if(checkPalindrome(s, index, i)) {
                //logic
                //create new tempList with value of temp 
                //(to avoid replacement of temp data) (this extra space usage is avoided in backtrack)
                List<String> tempList = new ArrayList<>(temp);
                //if the substring is palindrom
                //add it to tempList
                tempList.add(s.substring(index, i+1));
                //recurse
                //and call the method again, with string s and index value i+1
                //this method will check palindrome partition from i+1 to end of string
                //tempList has the palindrome partitioning upto i 
                recursive(s, new ArrayList(tempList), i+1);              
            }
        }
    }
    
    //palindrome check method
    private boolean checkPalindrome(String s, int left, int right) {
        //check until left < right
        while(left < right) {
            //compare the chars at left and right, if not equal return false
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        } return true; //if all chars equal until left < right, return true
    }
    
}


/////////////


// Time Complexity : O(n*2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


//Solution : Backtracking
class Solution {
    //declare result globally
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        //initialize result
        result = new ArrayList<>();
        //no check for null or length 0 condition, 
        //as the backtracking method takes care of it
        //call backtracking method with parameters
        // string s, temp array list and index position : 0 at start
        backtracking(s, new ArrayList<>(), 0);
        //return result list 
        return result;
    }
      
    private void backtracking(String s, List<String> temp, int index) {
        //base condition
        //if index reaches end of string
        //then the string in temp is a possible palindrome partition
        //add it to result and return
        if(index == s.length()){
            result.add(new ArrayList<>(temp));
            return; 
        }
        
        //logic 
        //iterate the string from index postion to end of string
        //index position is increased in each recursive call
        for(int i = index; i < s.length(); i++) {
            //if index to i is palidrome 
            //(parameters : string, and index and i position)
            //enter the loop
            // if not inc i and check again
            if(checkPalindrome(s, index, i)) {
                //logic
                //if the substring is palindrom
                //add it to temp
                temp.add(s.substring(index, i+1));
                //recurse
                //and call the method again, with string s and index value i+1
                //this method will check palindrome partition from i+1 to end of string
                //temp has the palindrome partitioning upto i 
                backtracking(s, temp, i+1);
                //backtrack
                //remove the last added substring from temp 
                //and check for palindrome partioning from i+1
                temp.remove(temp.size()-1);              
            }
        }
    }
    
    //palindrome check method
    private boolean checkPalindrome(String s, int left, int right) {
        //check until left < right
        while(left < right) {
            //compare the chars at left and right, if not equal return false
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        } return true; //if all chars equal until left < right, return true
    }
    
}
