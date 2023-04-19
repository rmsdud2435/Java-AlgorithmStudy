class Solution {
    
    private int[] nodeArray;
    private int maxCnt;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        nodeArray = new int[n];
        bfs()
        System.out.println(nodeArray);
        
        return answer;
    }
    
    private int bfs(int nodeNum, int[][] edge, int currentCnt){
        for(int i = 0; i < edge.length; i++){
            int[] vertex = edge[i];
            if(vertex[0] == nodeNum){
                if(checkNode(vertex[1], currentCnt){
                    
                }
            }
        }
        
        return 0;
    }
    
    private void initNodeArray(int[] nodeArray){
        for(int i = 0; i < nodeArray.length ; i++){
            nodeArray[i] = 0;
        }
    }

}
