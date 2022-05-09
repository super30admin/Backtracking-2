
//For loop recursion with backtracking
class Solution {

    //Time Complexity: 0(2^n) where n is the size of the string
    //Space Complexity: 0(n)  where n is the length of the string
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while coding: No

    //In brief, explain your code

    List <List<String>> result; //declaring result to return result
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0){
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());    //passing string, index and path to the recursive method
        return result;
    }
    public void helper(String s, int index, List <String> path){
        //base
        if(index == s.length()){    //we will capture the pallindrome when index is out of bounds
            result.add(new ArrayList<>(path));  //create a new list as backtracking will leave us with an empty list
            return;
        }
        //logic
        for(int i = index; i < s.length(); i++){
            if(isPallindrome(s, index, i)){     //check at every recursion if its a pallindrome or not
                //action
                path.add(s.substring(index, i+1));  //add the substring
                //recurse
                helper(s, i+ 1, path);
                //backtrack
                path.remove(path.size() - 1);
            }
        }
    }
    public boolean isPallindrome(String s, int start, int end){//to check if the string is pallindrome or not
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}