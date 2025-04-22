class Solution {

    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s, 0, new ArrayList<>());
        return result;
        
    }

    private void helper(String s, int pivot, List<String> path){

        if(pivot == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }


        for(int i = pivot; i < s.length(); i++)
        {
            String sub = s.substring(pivot, i+1);
            if(isPalindrome(sub))
            {
                path.add(sub);
                helper(s, i + 1, path);
                path.remove(path.size()-1);
                

            }
            
        }
        

    }
    public boolean isPalindrome(String s) {
         int low = 0;
         int high = s.length()-1;
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
}