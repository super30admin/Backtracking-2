// Time Complexity :O(nx2^n)
// Space Complexity : O(nx2^n)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
// this can be solved in bracktracing of chose not choose and for loop iteration


//for loop recurssion backtracking
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, 0,new ArrayList<>());
        return result;
    }

    public void helper(String s, int pivot, List<String> path){
        //base
        if(s.length()== pivot){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i=pivot;i<s.length();i++){
            String sub = s.substring(pivot,i+1);
            if(isPalendrom(sub)){
                path.add(sub);
                helper(s,i+1,path);
                path.remove(path.size()-1);
            }
        }
    }

    public boolean isPalendrom(String s){
        int low = 0;
        int high = s.length()-1;
        while(low<high){
            if(s.charAt(low) != s.charAt(high)) return false;
                low++;
                high--;
        }
        return true;
    }
}

