/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
// time complexity : o(2^n)
class BSTIterator {
public:
    stack<TreeNode*> s;
    BSTIterator(TreeNode* root) {
        
       inorder(root);
    }
    
    int next() {
        
       TreeNode* tops =  s.top();
        s.pop();
        inorder(tops->right);
      return tops->val;
        
    }
    
    bool hasNext() {
        return !s.empty();
    }
    
    void inorder(TreeNode* root){
        while(root !=NULL) {
           s.push(root);
            root = root->left;
       }
        
    }
    
    
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */