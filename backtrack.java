//problem1
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        this.res=new ArrayList<>();
        helper(nums,0,new ArrayList<>());
        return res;
    }
    public void helper(int[] nums,int pivot,List<Integer> path){
        res.add(new ArrayList<>(path));
        for(int i=pivot;i<nums.length;i++){
            path.add(nums[i]);
            helper(nums,i+1,path);
            path.remove(path.size()-1);
        }
    }
}
//problem2
class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
         this.ans=new ArrayList<>();
        helper(s,0,new ArrayList<>());
        return ans;
    }
    public void helper(String s,int pivot,List<String> path){
        //base
        if(pivot==s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }


        //logic
        for(int i=pivot;i<s.length();i++){
            String curr=s.substring(pivot,i+1);
            if(isplaindrome(curr)){
                path.add(curr);
                helper(s,i+1,path);
                path.remove(path.size()-1);
            }
        }
    }
    public boolean isplaindrome(String s){
        int l=0;
        int r=s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
