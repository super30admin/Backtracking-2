import java.util.ArrayList;
import java.util.List;

class Problem2 {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.result = new ArrayList<>();
        recurHelper(s,0,new ArrayList<>());
        return result;
    }
    //TC:2^N
    //SC : O(N)
    void recurHelper(String s,int p ,List<String> path){
        //base condition
        if(p==s.length()){
            result.add(new ArrayList<>(path));
            return ;
        }

        for(int i=p;i<s.length();i++){
            String inclStr = s.substring(p,i+1);
            if(isPalindromic(inclStr)){
                path.add(inclStr);
                recurHelper(s,i+1,path);
                path.remove(path.size()-1);
            }

        }
    }
    //TC:O(N)
    boolean isPalindromic(String input){
        int l=0;
        int r = input.length()-1;
        while(l<r){
            if(input.charAt(l) != (input.charAt(r))){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}