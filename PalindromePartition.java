//Time Complexity: O(2^n)
//Solution: For loop recursion

class Solution {
    private List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
        
    }

    private void helper(String s, int pivot, List<String> path){
        //base
        if(pivot == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        
        //logic
        for(int i=pivot; i<s.length(); i++){
            String currPart = s.substring(pivot, i+1);
            if(isPalindrome(currPart, 0, currPart.length()-1)){
                //action
                path.add(currPart);
                //recurse
                helper(s, i+1, path);
                //backtrack
                path.remove(path.size()-1);
            }
        }

    }

    private boolean isPalindrome(String s, int left, int right){
        while(left< right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right --;
        }
        return true;
    }
}


//Solution: Choose/NoChoose recursion

class Solution {
    private List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        helper(s, 0, 0, new ArrayList<>(), 0);
        return result;
        
    }

    private void helper(String s, int pivot, int idx, List<String> path, int count){
        //base
        if(idx == s.length()){
            if(count == s.length()){
                result.add(new ArrayList<>(path));
            }
            return;
        }
        //logic
        //nochoose
        helper(s, pivot, idx+1, path, count);

        //choose
        String currPart = s.substring(pivot, idx+1);
        if(isPalindrome(currPart, 0, currPart.length()-1)){
            //action
            path.add(currPart);
            int newCnt = count + currPart.length();
            //recurse
            helper(s, idx+1, idx+1, path, newCnt);
            //backtrack
            path.remove(path.size()-1);
        }
    }

    private boolean isPalindrome(String s, int left, int right){
        while(left< right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right --;
        }
        return true;
    }
}