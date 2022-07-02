//TimeComplexity=O(2^n)
//Space Complexity=O(n)
public class PalindromePartition {
    ArrayList<List<String>> result;
    public List<List<String>> partition(String s) {

        result=new ArrayList<List<String>>();
        helper(s,0,new ArrayList<String>());
        return result;
    }

    private void helper(String s,int index,List<String>path){

        //base
        if(index==s.length()){
            result.add(new ArrayList<String>(path));
            return;
        }

        //logic

        for(int i=index;i<s.length();i++){
            String sb=s.substring(index,i+1);
            if(isPalindrome(sb)){
                path.add(sb);
                helper(s,i+1,path);
                path.remove(path.size()-1);
            }
        }
    }

    boolean isPalindrome(String sb) {
        int low=0;
        int high=sb.length()-1;
        while (low < high) {
            if (sb.charAt(low++) != sb.charAt(high--)) return false;
        }
        return true;
    }
}
