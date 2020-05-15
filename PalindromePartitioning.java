// Time Complexity : O(n*n * 2^n) 
// Space Complexity :   O(n).
// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//the code uses recursion plus backtrack. The code follows the pattern action, recursion and backtrack. 
//Success
//Details 
//Runtime: 3 ms, faster than 54.63% of Java online submissions for Palindrome Partitioning.
//Memory Usage: 40.2 MB, less than 40.91% of Java online submissions for Palindrome Partitioning.

] public List<List<String>> partition(String s) {
        List<List<String>> result= new ArrayList<>();
        backtrack(s,result,new ArrayList<>(),0);
        return result;
    }
    
    private void backtrack(String s,List<List<String>> result, List<String> path, int start){
        //base case
        if (start==s.length()){
            result.add(new ArrayList<>(path));
        }
        //recursive section
        for (int i=start;i<s.length();i++){
            String subString= s.substring(start,i+1);//O(n)
            System.out.println(subString);
            if (isPalindrome(subString)){//O(n)
                //action
                path.add(subString);
                //recurse
                backtrack(s,result,path,i+1);
                //backtrack
                path.remove(path.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s){
        int start=0;
        int end=s.length()-1;
        while (start<end){
            if (s.charAt(start++)!=s.charAt(end--))
                return false;
        }
        return true;
    }