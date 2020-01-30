class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        //base case
        if(s == null){
            return result;
        }
        //recursively call the backtrack function
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    private void backtrack(List<List<String>> result, List<String> tempList, String s, int start){
        if(start == s.length()){
            result.add(new ArrayList<>(tempList));
        } else{
            for(int i = start; i< s.length() ; i++){
                if(isPalindrome(s, start, i)){
                    //add element
                    tempList.add(s.substring(start, i+1));
                    //recursive call
                    backtrack(result, tempList, s, i+1);
                    //backtracking from last node
                    tempList.remove(tempList.size()-1);
                }
            }
        }
    }
    //to check if strings are palindrome
    private boolean isPalindrome(String s, int start, int end){
        while(start < end)
            if(s.charAt(start++) != s.charAt(end--)) return false;
        return true;

    }
}