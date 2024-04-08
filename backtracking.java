//time complexity O(N * 2^N) and space complexity O(N)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result= new ArrayList<>();

        helper(nums,0,new ArrayList<>());

        return result;


    }

    public void helper(int[] nums, int idx, List<Integer> sets){

        //base
        
        result.add(new ArrayList<>(sets));

        for(int i=idx;i<nums.length;i++){
            sets.add(nums[i]);
            helper(nums,i+1,sets);
            sets.remove(sets.size()-1);
        }



    }
}

//time complexity O(N * 2^N) and space complexity O(N)
class Solution {
    List<List<String>> result;
    
    public List<List<String>> partition(String s) {

        result = new ArrayList<>();

        helper(s,0,0,new ArrayList<>(),0);
        return result;
        
    }

    public void helper(String s, int pivot,int idx, List<String> path,int count){

      //base
      if(idx==s.length()){

        if(count==s.length()){
            result.add(path);
        }
        return;
      }


      String st = s.substring(pivot,idx+1);
      //logic
      helper(s,pivot,idx+1,new ArrayList<>(path),count);

      if(isPalindrome(st)){

        
        List<String> li = new ArrayList<>(path);
        li.add(st);

        helper(s,idx+1,idx+1,li,count+st.length());

        // path.remove(path.size()-1);

      }


    }

    public boolean isPalindrome(String s){

        int i=0;
        int j=s.length()-1;

        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
