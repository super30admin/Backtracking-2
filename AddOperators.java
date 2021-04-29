// Time Complexity : O(4^n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class AddOperators {
    public List<String> addOperators(String num, int target) {
        if(num == null || num.length() == 0) return new ArrayList();
        List<String> result = new ArrayList();
        backtrack(num, target, 0, new StringBuilder(), 0, 0, result);
        return result;
    }
    
    private void backtrack(String num, int target, int index, StringBuilder path, long val, long tail, List<String> result){
        if(index == num.length()){
            if(val == target) result.add(path.toString());
            return;
        }
        
        for(int i= index; i < num.length(); i++){
            if(i != index && num.charAt(index) == '0') break;
            long cur = Long.parseLong(num.substring(index, i+1));
            int len = path.length();
            if(index == 0){
                backtrack(num, target, i +1, path.append(cur), cur, cur, result);
                path.setLength(len);
            }else{
                backtrack(num, target, i +1, path.append('+').append(cur), val + cur, cur, result);
                path.setLength(len);
                backtrack(num, target, i +1, path.append('-').append(cur), val - cur, -cur, result);
                path.setLength(len);
                backtrack(num, target, i +1, path.append('*').append(cur), val - tail + tail  * cur, tail  * cur, result);
                path.setLength(len);
            }
        }
    }
}