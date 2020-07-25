package problem107;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();

        Queue<TreeNode>main=new ArrayDeque<>();
        if(root==null){
            return ans;
        }
        main.add(root);

        while(main.size()>0){
            int val=main.size();
            List<Integer>an=new ArrayList<>();

            for(int i=0;i<val;i++){
                root=main.remove();

                an.add(root.val);


                if(root.left !=null){
                    main.add(root.left);
                }
                if(root.right !=null){
                    main.add(root.right);
                }

            }
            ans.add(an);



        }

        Collections.reverse(ans);
        return ans;


    }
}