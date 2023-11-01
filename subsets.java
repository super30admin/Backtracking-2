class Solution {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        helper(s,0, new ArrayList<>());
        return result;
    }

    private void helper(String s, int pivot, List<String> path){

        if(pivot == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i= pivot; i<s.length(); i++){

            String sub = s.substring(pivot, i+1);
            if(isPalindrome(sub)){
                path.add(sub);
                helper(s, i+1, path);
                path.remove(path.size()-1);
            }
        }

    }


    private boolean isPalindrome(String s){
        int start=0;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}


/*
TC : O(n*2^n)
SC : O(n)


 */