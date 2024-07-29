//Problem1
//TC O(2^n)
//SC O(n)
class Solution {
    List<List<Integer> >result;
    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null || nums.length==0) return new ArrayList<>();
        result=new ArrayList<>();
        recurse(nums,0,new ArrayList<>());
        return result;

    }
    private void recurse(int nums[], int index,List<Integer> path)
    {
        if(index>nums.length) return;
        if(nums.length==index)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        // case 0 dont take
        recurse(nums,index+1,new ArrayList<>(path));

        // case 1 take
        path.add(nums[index]);
        recurse(nums,index+1, new ArrayList<>(path));
    }
}
//Problem2
//TC O(2^n)
//SC O(n)

class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        result = new ArrayList<>();
        backtrack(s, new ArrayList<>());

        return result;
        
    }

    private void backtrack(String s, List<String> path) {
        //base
        if(s.length() == 0) {
            result.add(new ArrayList<>(path));
        }

        //logic
        for(int i = 0; i < s.length(); i++) {
            if(isPalindrome(s, 0, i)) {
                //action
                path.add(s.substring(0, i+1));
                //recurse
                backtrack(s.substring(i+1), path);
                //remove
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }


        return true;
    }
}