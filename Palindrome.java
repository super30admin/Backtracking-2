//Time complexity is O(N*2^N)
//Space complexity is O(N)
class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        helper(s, 0, new ArrayList());
        return result;
    }
    public void helper(String s, int index, List<String> li){
        int n = s.length();
        if(n==index){
            result.add(new ArrayList(li));
            return;
        }
        for(int i=index;i<s.length();i++){
            String sub = s.substring(index, i+1);
            if(ispalin(sub)){
                List<String> temp = new ArrayList(li);
                temp.add(sub);
                helper(s, i+1, temp);
            }
        }
    }
    public boolean ispalin(String s){
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i=i+1;
            j=j-1;
        }
        return true;
    }
}