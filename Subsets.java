// TC : O(n * 2^n)
// SC : O(1)

package S30_Codes.Backtracking_2;

import java.util.ArrayList;
import java.util.List;

class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

        for(int num: nums){
            int size = ans.size();
            for(int i=0; i<size; i++){
                List<Integer> newList = new ArrayList<>(ans.get(i));
                newList.add(num);
                ans.add(newList);
            }
        }
        return ans;
    }
}