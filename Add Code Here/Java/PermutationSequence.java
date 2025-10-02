class Solution {
    public String getPermutation(int n, int k) {
       int[] arr = new int[n];
       for(int i = 0;i<n;i++){
        arr[i] = i+1;
       }    
       List<String> ans = new ArrayList<>();
       boolean[] isVisited = new boolean[n];
       backtrack(arr,ans,new StringBuilder(),isVisited);
       return ans.get(k-1);
    }

    public void backtrack(int[] arr,List<String> ans,StringBuilder curr,boolean[] isVisited){
        if(curr.length()==arr.length){
            ans.add(curr.toString());
            return;
        }

        for(int i = 0;i<arr.length;i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                curr.append(arr[i]);
                backtrack(arr,ans,curr,isVisited);
                curr.deleteCharAt(curr.length()-1);
                isVisited[i] = false;
            }
        }
    }

}
