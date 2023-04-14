class Solution {
    
    int[] nodeArray;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        nodeArray = new int[n];
        System.out.println(nodeArray);
        
        return answer;
    }
    
    private void initNodeArray(int[] nodeArray){
        for(int i = 0; i < nodeArray.length ; i++){
            nodeArray[i] = 0;
        }
    }

}
