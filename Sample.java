//Time Complexity:O(2^N)
//Space Complexity:O(2^N)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result=new ArrayList();
        backtrack(nums,new ArrayList<Integer>(),0);
        return result;
    }
    private void backtrack(int[]nums,ArrayList<Integer> temp,int index)
    {
        result.add(new ArrayList(temp));
        for(int i=index;i<nums.length;i++)
        {
            temp.add(nums[i]);
            backtrack(nums,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
-------------------------------------------------------------------------------------

class Solution {        

    List<List<String>> result;

    public List<List<String>> partition(String s) {

        result = new ArrayList<>();

        backtrack(s, 0, new ArrayList<>());

        return result;

    }

    private void backtrack(String s,int start, List<String> temp){

        // base case

        if(start >= s.length()){

            System.out.println("Adding this to res"+temp);
            result.add(new ArrayList<>(temp));

        }

        // logic 

        for(int i = start; i < s.length(); i++){

            if(isPalindrome(s, start, i)){

                System.out.println(s.substring(start, i+1));
                temp.add(s.substring(start, i+1));
                
                System.out.println("Starting new Backtrack now ");
                backtrack(s, i+1, temp); 
                 System.out.println("Finished Backtrack now ");
                

                temp.remove(temp.size() - 1);

            }

        }

    }    private boolean isPalindrome(String s, int l, int r){

        if(l==r) return true;

        while(l < r){

            if(s.charAt(l) != s.charAt(r)) return false;

            l++; r--;

        }

        return true;

    }

}
------------------------------------------------------------------------