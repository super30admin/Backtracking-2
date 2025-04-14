class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        backtrack(nums, 0, list);
        return result;
    }
    private void backtrack(int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        backtrack(nums, index+1, list);
        list.add(nums[index]);
        backtrack(nums, index+1, list);
        list.remove(list.size()-1);
    }
}


class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> path = new ArrayList<>();
        if (s == null) {
            return result;
        }
        recurse(s, 0, path);
        return result;
    }
    private void recurse(String s, int index, List<String> path) {
        if (index == s.length()) {
            result.add(new ArrayList<>(path));
        }
        for(int i=index;i<s.length();i++) {
            if(isPalindrome(s, index, i)) {
                path.add(s.substring(index, i+1));
                recurse(s, i+1, path);
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s, int l, int r) {
        while(l<r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }
}
