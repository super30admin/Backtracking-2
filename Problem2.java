// Time Complexity : O(2^N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

//For loop based recursion, backtracking

class Problem2 {

    //will be returning a list of list
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s==null || s.length() ==0) return result;

        helper(s, new ArrayList<>());

        return result;


    }

    private void helper(String s, List<String> path){
        //base case
        if(s.length() ==0){
            result.add(new ArrayList<>(path));

            return;
        }

        //logic for recursion
        for(int i=0; i<s.length(); i++){

            String sub = s.substring(0, i+1);
            if(isPalindrome(sub)){

                //action
                path.add(sub);

                //recursion
                helper(s.substring(i+1), path);

                //backtrack
                path.remove(path.size()-1);


            }
        }


    }

    //function to check if the string is a palindrome or not
    private boolean isPalindrome(String s){

        int start;
        int end;
        start =0;
        end = s.length()-1;

        while(start < end){

            if(s.charAt(start) != s.charAt(end))
            {
                return false;
            }
            start++;
            end--;

        }
        return true;
    }

}