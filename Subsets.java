import java.util.ArrayList;
import java.util.List;

//Time Complexity: O(n*2^n)

public class Subsets {

        List<List<Integer>> subsets;
        public List<List<Integer>> subsets(int[] nums) {
            subsets = new ArrayList<>();
            List<Integer> currentSS = new ArrayList<>();
            findSubSets(nums, 0, currentSS);
            return subsets;
        }

        public void findSubSets(int[] nums, int index, List<Integer> currentSS){
            subsets.add(new ArrayList<>(currentSS));
            for(int i=index;i<nums.length;i++){
                currentSS.add(nums[i]);
                findSubSets(nums, i+1, currentSS);
                currentSS.remove(currentSS.size()-1);
            }
        }

}
