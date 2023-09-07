// TC = 2^n
// SC = n

// Here we are using backtraking approach. We will find the substring first then check that 
//Substring is palindrome or not if yes then we will add that in path. do recursong and backtracking.


class PalindromeSubstring{

    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
    }

    private void helper(String s, int pivote, List<String> path){
        //base
        if(pivote == s.length()){
            result.add(new ArrayList<>(path));
        }

        //logic
        for(int i = pivote; i<s.length(); i++){
            String sbstr = s.substring(pivote, i+1);
            if(isPalindrome(sbstr)){
                //action
                path.add(sbstr);
                //recurse
                helper(s, i+1, path);
                //backtrack
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}