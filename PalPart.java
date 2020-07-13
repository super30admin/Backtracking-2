// Time Complexity : O(n* 2^n) n is length of array
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class PalPart {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result  = new ArrayList<>();
        //if(s.length()==0) return result;
        //String strin = s;
        getResult(s,0,new ArrayList<>());
        return result;
    }
    
    private void getResult(String s,int start, List<String> list)
    {
        if(start>=s.length()){
            result.add(new ArrayList<>(list));
            //return;
        }
       
        for(int part=start;part<s.length();part++)
        {
            if(isPal(s,start,part)){
                list.add(s.substring(start,part+1));
                getResult(s,part+1,list);
                list.remove(list.size()-1);
            }
        }
    }
    
    private boolean isPal(String str, int begin, int end){
        if(str.length()==0||begin==end) return true; 
        
        while(begin<end){
            if(str.charAt(begin)!=str.charAt(end))
            return false;
        
            begin++;
            end--;
        }
        
        return true;
        
    }
}