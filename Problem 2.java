// Time Complexity : O(2^N * N)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
/*
We will use for loop based recursion to solve it
*/

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {

        result = new ArrayList<List<String>>();
        helper(s,0,new LinkedList<String>());
        return result;
        
    }

    private void helper(String s, int pivot, LinkedList<String> list){
        // base case
        if(pivot>=s.length()){
            // time to add to the resulting list
            result.add(new ArrayList<String>(list));
        }

        StringBuilder current = new StringBuilder();
        //logic 
        for(int i=pivot;i<s.length();i++){
            
            current.append(s.charAt(i));
            String str = current.toString();
            // check if Palindrme, then only add to List
            if(isPalindrome(str)){ // O(s)
                list.add(str);
                // recurse
                helper(s,i+1,list);
                // backtrack
                list.removeLast();
            }

        }

    }


    private boolean isPalindrome(String s){
        if(s==null || s.isEmpty()){
            return true;
        }

        int strPtr = 0;
        int endPtr = s.length()-1;

        while(strPtr<endPtr){
            if(s.charAt(strPtr)!=s.charAt(endPtr)){
                return false;
            }
            strPtr++;
            endPtr--;
        }

        return true;
    }
}