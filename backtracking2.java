//1.subset
//Time Complexity -> 2^N
//Space Complexity -> N
class Solution {
    //Using 0-1 recursion
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList();
        if(nums == null || nums.length ==0) return result;
        helper(nums,0,new ArrayList<>());
        return result;
    }

    private void helper(int[] nums,int i,List<Integer> path){
        //base
        if( i == nums.length) {
           result.add(new ArrayList(path)); 
           return;
        }

        //logic
        //not choose
        helper(nums,i+1,path);
        //action
        path.add(nums[i]);
        //recurse
        //choose
        helper(nums,i+1,path);
        //backtrack
        path.remove(path.size()-1);

    }
}

class Solution {
    //Using for loop recursion
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList();
        if(nums == null || nums.length ==0) return result;
        helper(nums,0,new ArrayList<>());
        return result;
    }

    private void helper(int[] nums,int pivot,List<Integer> path){
        //base
        if( pivot > nums.length) {
           return;
        }
        result.add(new ArrayList(path));
        //logic
        for(int i = pivot;i<nums.length;i++){
            //action
            path.add(nums[i]);
            //recurse
            helper(nums,i+1,path);
            //backtrack
            path.remove(path.size()-1);
        }
    }
}

class Solution {
    //Using for loop recursion
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList();
        if(nums == null || nums.length ==0) return result;
        helper(nums,0,new ArrayList<>());
        return result;
    }

    private void helper(int[] nums,int pivot,List<Integer> path){
        //base
      //  if( pivot > nums.length) {
        //   return;
       // }
        result.add(new ArrayList(path));
        //logic
        for(int i = pivot;i<nums.length;i++){
            //action
            path.add(nums[i]);
            //recurse
            helper(nums,i+1,path);
            //backtrack
            path.remove(path.size()-1);
        }
    }
}

class Solution {
    //Using 2 loops
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList();
        if(nums == null || nums.length ==0) return result;
        result.add(new ArrayList());
        for(int i = 0;i < nums.length;i++){
            int size = result.size();
            for(int j = 0;j<size;j++){
                List<Integer> li = new ArrayList(result.get(j)); //creating a deep copy when we are fetching
                li.add(nums[i]);
                result.add(li);
            }
        }
        return result;
    }

   
}

//2.Palindrome Partioning
//Time Complexity -> 2^N
//space Complexity -> N
class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList();
        if(s == null || s.length() == 0) return result;
        helper(s,0,new ArrayList<>());
        return result;        
    }

    private void helper(String s,int pivot,List<String> path){
        //base
        if(pivot == s.length()){
            result.add(new ArrayList(path));
            return;
        }

        //logic
        for(int i = pivot; i<s.length();i++){
            String sub = s.substring(pivot, i+1);
            if(isPlaindrome(sub)){
                //action
                path.add(sub);
                //recurse
                helper(s,i+1,path);
                //backTrack
                path.remove(path.size()-1);
            }
        }

    }

    private boolean isPlaindrome(String s){
        if(s == null || s.length() == 0) return true;
        int st = 0;
        int e = s.length() - 1;
        while(st<=e){
            if(s.charAt(st)!=s.charAt(e)) return false;
            st++;
            e--;
        } 
        return true;
    }
}