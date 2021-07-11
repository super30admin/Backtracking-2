class Solution {
    List<String> path;
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        this.path = new ArrayList<>();
        this.res = new ArrayList<>();
        backtrack(s, 0);
        return res;
    }
    
    public void backtrack(String s, int index){
        //base
        if(index == s.length()){
            res.add(new ArrayList<>(path));
        }
        
        //logic
        for(int i=index; i<s.length(); i++){
            String temp = s.substring(index, i+1);
            path.add(temp);
            if(isPalindrome(temp) == true){
                backtrack(s, i+1);
            }
            path.remove(path.size()-1);
        }
    }
    
    public boolean isPalindrome(String s){
        if(s.length() % 2 == 0){
            int low = 0;
            int high = s.length() - 1;
            while(low < high){
                if(s.charAt(low) != s.charAt(high))
                    return false;
                low++;
                high--;
            }
            return true;
        }
        else{
            int low = 0;
            int high = s.length() - 1;
            while(low <= high){
                if(s.charAt(low) != s.charAt(high))
                    return false;
                low++;
                high--;
            }
            return true;
        }
    }
}
