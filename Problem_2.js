
/**
 * @param {string} s
 * @return {string[][]}
 */
var partition = function(s) {
    let results = [];
    const isPalindrome=(s)=>{
        let start = 0;
        let end = s.length-1;

        while(start<end){
            if(s[start] != s[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    const partitionBacktracking = (s, pivot, path) => {
        //base
        if(pivot === s.length){
            results.push([...path]);
            return; 
        }
        //recursion
        for(let i=pivot; i<s.length; i++){
                let substr = s.slice(pivot, i+1);
                if(isPalindrome(substr)){   
                    path.push(substr);

                    partitionBacktracking(s, i+1, path);
                    path.pop();
                }
        }
    }

     partitionBacktracking(s, 0, []);
     return results;   
};