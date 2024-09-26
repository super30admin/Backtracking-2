import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 */

/**
 * @author aupadhye
 *
 */

//Time complexity would be O(N X 2^N) since we have to explore two states for each and every choice.
//Space complexity would be O(N X 2^N) since we have to store those states.
public class Palindrome_Partitioning {

	/**
	 * @param args
	 */
	   boolean[][]dp;
	    List<List<String>>ret;
	    boolean reached;
	    public List<List<String>> partition(String s) {
	        dp=new boolean[s.length()][s.length()];
	        ret=new ArrayList<>();
	        for(int i=0;i<s.length();i++)dp[i][i]=true;
	        for(int i=0;i<s.length()-1;i++)if(s.charAt(i)==s.charAt(i+1))dp[i][i+1]=true;
	        for(int i=s.length()-3;i>=0;i--)
	            for(int j=i+2;j<s.length();j++)
	                if(s.charAt(i)==s.charAt(j))dp[i][j]=dp[i+1][j-1];
	        solve(s,0,new ArrayList<>());
	        return ret;
	    }
	    
	    public void solve(String s,int l,ArrayList<String>subset)
	    {
	        if(l==s.length())reached=true;
	        for(int i=l;i<s.length();i++)
	        {
	            if(dp[l][i])
	            {
	                subset.add(s.substring(l,i+1));
	                solve(s,i+1,subset);
	                if(reached)ret.add(new ArrayList(subset));
	                reached=false;
	                subset.remove(subset.size()-1);
	            }
	        }
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "aab";
		Palindrome_Partitioning p = new Palindrome_Partitioning();
		List<List<String>> result = p.partition(s);
		System.out.println(Arrays.asList(result));
	}

}
