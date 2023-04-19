class Solution {
    
    private int[] nodeArray;
    private int maxCnt;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        nodeArray = new int[n];
        bfs(1,edge,0);
        System.out.println(nodeArray.toString());
        
        return answer;
    }
    
    private void bfs(int nodeNum, int[][] edge, int currentCnt){
        currentCnt++;
        for(int i = 0; i < edge.length; i++){
            int[] vertex = edge[i];
            if(vertex[0] == nodeNum){
                if((nodeArray[vertex[1]] != 0) && (nodeArray[vertex[1]] <  currentCnt){
                    nodeArray[vertex[1]] = currentCnt;
                    bfs(vertex[1], edge, currentCnt);
                }
            }
        }
    }
    
    private void initNodeArray(int[] nodeArray){
        for(int i = 0; i < nodeArray.length ; i++){
            nodeArray[i] = 0;
        }
    }

}
