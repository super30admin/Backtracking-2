//subset
//time:o(2)^n
//space:o(2)^n
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
       this.result=new ArrayList<>();
       if(nums==null || nums.length==0)
       return result;
       helper(nums, 0,  new ArrayList<>());
       return result;
    }
    private void helper(int[]nums,int i,List<Integer>path){
  //base
  if(i==nums.length) {
    result.add(new ArrayList<>(path));
  return ;
  }
  //no choose
  helper(nums,i+1,path);
  //choose
    path.add(nums[i]);
    helper(nums,i+1,new ArrayList<>(path));
    path.remove(path.size()-1);
    


        
        
    }
}


//partition palidrome
//time:o(2)^n*n
//space:o(n)
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> sub=new ArrayList<>();
        findPartition(s, 0, res, sub);
        return res;
    }

    public void findPartition(String s, int index, List<List<String>> res, List<String> sub){
        if(index==s.length()){
            res.add(new ArrayList<>(sub));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                sub.add(s.substring(index,i+1));
                findPartition(s, i+1, res, sub);
                sub.remove(sub.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int e){
        while(start<=e){
            if(s.charAt(start)!= s.charAt(e)){
                return false;
            }
            start++;
            e--;
        }
        return true;
    }
}

