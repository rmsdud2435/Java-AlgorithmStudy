package com.algorithm.study.programmers.bfs;

import java.awt.Point;

/**
 * 
 * 문제 설명
 * 
 * ROR 게임은 두 팀으로 나누어서 진행하며, 상대 팀 진영을 먼저 파괴하면 이기는 게임입니다. 
 * 따라서, 각 팀은 상대 팀 진영에 최대한 빨리 도착하는 것이 유리합니다.
 * 
 * 지금부터 당신은 한 팀의 팀원이 되어 게임을 진행하려고 합니다. 
 * 다음은 5 x 5 크기의 맵에, 당신의 캐릭터가 (행: 1, 열: 1) 위치에 있고, 상대 팀 진영은 (행: 5, 열: 5) 위치에 있는 경우의 예시입니다.
 * bfs_algo_1_01.png
 * 위 그림에서 검은색 부분은 벽으로 막혀있어 갈 수 없는 길이며, 흰색 부분은 갈 수 있는 길입니다. 캐릭터가 움직일 때는 동, 서, 남, 북 방향으로 한 칸씩 이동하며, 
 * 게임 맵을 벗어난 길은 갈 수 없습니다.
 * 
 * 아래 예시는 캐릭터가 상대 팀 진영으로 가는 두 가지 방법을 나타내고 있습니다.
 * 첫 번째 방법은 11개의 칸을 지나서 상대 팀 진영에 도착했습니다.
 * bfs_algo_1_02.png 
 * 
 * 두 번째 방법은 15개의 칸을 지나서 상대팀 진영에 도착했습니다.
 * bfs_algo_1_03.png 
 * 
 * 위 예시에서는 첫 번째 방법보다 더 빠르게 상대팀 진영에 도착하는 방법은 없으므로, 이 방법이 상대 팀 진영으로 가는 가장 빠른 방법입니다.
 * 만약, 상대 팀이 자신의 팀 진영 주위에 벽을 세워두었다면 상대 팀 진영에 도착하지 못할 수도 있습니다. 
 * 예를 들어, 다음과 같은 경우에 당신의 캐릭터는 상대 팀 진영에 도착할 수 없습니다.
 *  bfs_algo_1_04.png bfs_algo_1_04.png
 *  
 * 게임 맵의 상태 maps가 매개변수로 주어질 때, 
 * 캐릭터가 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값을 return 하도록 solution 함수를 완성해주세요. 
 * 단, 상대 팀 진영에 도착할 수 없을 때는 -1을 return 해주세요.
 * 
 * 
 * 제한사항
 * maps는 n x m 크기의 게임 맵의 상태가 들어있는 2차원 배열로, n과 m은 각각 1 이상 100 이하의 자연수입니다.
 * n과 m은 서로 같을 수도, 다를 수도 있지만, n과 m이 모두 1인 경우는 입력으로 주어지지 않습니다.
 * maps는 0과 1로만 이루어져 있으며, 0은 벽이 있는 자리, 1은 벽이 없는 자리를 나타냅니다.
 * 처음에 캐릭터는 게임 맵의 좌측 상단인 (1, 1) 위치에 있으며, 상대방 진영은 게임 맵의 우측 하단인 (n, m) 위치에 있습니다.
 * 
 * 
 * 입출력 예
 * maps																answer
 * [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]	11
 * [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]	-1
 * 
 * 입출력 예 설명
 * 입출력 예 #1
 * 주어진 데이터는 다음과 같습니다.
 * bfs_algo_1_05.png
 * 캐릭터가 적 팀의 진영까지 이동하는 가장 빠른 길은 다음 그림과 같습니다.
 * bfs_algo_1_06.png
 * 따라서 총 11칸을 캐릭터가 지나갔으므로 11을 return 하면 됩니다.
 * 
 * 입출력 예 #2
 * 문제의 예시와 같으며, 상대 팀 진영에 도달할 방법이 없습니다. 따라서 -1을 return 합니다.
 *
 * 출처: 프로그래머스 - https://school.programmers.co.kr/learn/courses/30/lessons/1844
 */

import java.util.*;

public class 단어변환 {
	
    public static void main(String[] args) {
    	// numbers			target	return
    	// [1, 1, 1, 1, 1]	3		5
    	// [4, 1, 2, 1]		4		2
    	단어변환 obj = new 단어변환();
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        String begin1 = "hit";
        String target1 = "cog";
        String[] words1 = {"hot","dot","dog","log","lot","cog"};
		System.out.println( obj.solution(begin1, target1, words1));
		//int[][] maps2 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
		//System.out.println( obj.solution(maps2));
	}

    private HashMap<String, int> wordCntMap = new HashMap<String, int>();

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        init(words);
        
        bfs(begin, target, words);
        return answer;
    }

    private void init(String[] words){
        for(String word : words){
            wordCntMap.put(word,0);
        }
    }
    private int bfs(String begin, String target, String[] words){
        Queue<String> queue = new LinkedList<String>();

        queue.add(begin);
        while(queue.isEmpty()){
            String currentWord = queue.poll();
            int currentCnt = wordCntMap.get(currentWord)+1;
            for(String word : words){
                if(word.equals(target)){
                    return currentCnt;
                }else if( wordCntMap.get(word) == 0 || currentCnt < wordCntMap.get(word)  ){
                    char[] charArray1 = currentWord.toCharArray();
                    char[] charArray2 = word.toCharArray();
                    int checkCnt = 0;
                    boolean checkVal = true;
                    for(int i = 0; i < charArray2.length; i++){
                        if(charArray1.length != charArray2.length){
                            checkVal = false;
                            break;
                        }else if( charArray1[i] != charArray2[i] && check == 0){
                            check++;
                        }else if(charArray1[i] != charArray2[i] && check == 1){
                            checkVal = false;
                            break;
                        }
                    }

                    if(checkVal){
                        wordCntMap.put(word, currentCnt);
                        queue.add(word);
                    }
                }
            }
        }
        return 0;
    }
}


/*

    private int dfs(String begin, String target, String[] words, int count, ArrayList<String> usedWords){
        int currentCnt = count + 1;
        ArrayList<String> currentUsedWords = new ArrayList<String>();
        for(String usedWord : usedWords){
            currentUsedWords.add(usedWord);
        }

        for(String word: words){
                if(word.equals(target)){
                    return currentCnt;
                }else if(!usedWords.contains(word)){
                    char[] charArray1 = currentWord.toCharArray();
                    char[] charArray2 = word.toCharArray();
                    int checkCnt = 0;
                    boolean checkVal = true;
                    for(int i = 0; i < charArray2.length; i++){
                        if(charArray1.length != charArray2.length){
                            checkVal = false;
                            break;
                        }else if( charArray1[i] != charArray2[i] && check == 0){
                            check++;
                        }else if(charArray1[i] != charArray2[i] && check == 1){
                            checkVal = false;
                            break;
                        }
                    }

                    if(checkVal){
                        dfs(word, words, currentCnt, currentUsedWords);
                    }else{
                        return 0;
                    }

                }
            }

    }
}






import java.util.*;

class Solution {
    
    private ArrayList<String> usedWords = new ArrayList<String>();
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        return dfs(begin, target, words,0, new ArrayList<String>());
    }
    
    private int dfs(String source, String target, String[] words, int count, ArrayList<String> usedWords){
        int currentCnt = count + 1;
        ArrayList<String> currentUsedWords = new ArrayList<String>();
        for(String usedWord : usedWords){
            currentUsedWords.add(usedWord);
        }

        for(String word: words){
            if(word.equals(target)){
                return currentCnt;
            }else if(!currentUsedWords.contains(word)){
                char[] charArray1 = source.toCharArray();
                char[] charArray2 = word.toCharArray();
                int checkCnt = 0;
                boolean checkVal = true;
                for(int i = 0; i < charArray2.length; i++){
                    if(charArray1.length != charArray2.length){
                        checkVal = false;
                        break;
                    }else if( charArray1[i] != charArray2[i] && checkCnt == 0){
                        checkCnt++;
                    }else if(charArray1[i] != charArray2[i] && checkCnt == 1){
                        checkVal = false;
                        break;
                    }
                }

                if(checkVal){
                    currentUsedWords.add(word);
                    return dfs(word, target, words, currentCnt, currentUsedWords);
                }
            }
        }
        return 0;
    }
}

------------------------------------answer----------------------------------
import java.util.*;

class Solution {
    
    private HashMap<String, Integer> wordCntMap = new HashMap<String, Integer>();
    
    public int solution(String begin, String target, String[] words) {
        init(words);
        return bfs(begin, target, words);
    }
    
    private void init(String[] words){
        for(String word : words){
            wordCntMap.put(word,0);
        }
    }
    
    private int bfs(String begin, String target, String[] words){
        Queue<String> queue = new LinkedList<String>();

        queue.add(begin);
        while(!queue.isEmpty()){
            String currentWord = queue.poll();
            int currentCnt = wordCntMap.getOrDefault(currentWord, 0);
            currentCnt++;
            for(String word : words){
                if(wordCntMap.get(word) == 0 || currentCnt < wordCntMap.get(word)){
                    boolean moveFlag = checkValdion(currentWord, word);
                    if(moveFlag){
                        if(word.equals(target)){
                            return currentCnt;
                        }else{
                            wordCntMap.put(word, currentCnt);
                            queue.add(word);
                        }
                    }  
                }
            }
        }
        return 0;
    }
    
    private boolean checkValdion(String prevWord, String afterWord){
        char[] charArray1 = prevWord.toCharArray();
        char[] charArray2 = afterWord.toCharArray();
        
        int checkCnt = 0;
        boolean checkVal = true;
        for(int i = 0; i < charArray2.length; i++){
            if(charArray1.length != charArray2.length){
                return false;
            }else if( charArray1[i] != charArray2[i] && checkCnt == 0){
                checkCnt++;
            }else if(charArray1[i] != charArray2[i] && checkCnt == 1){
                return false;
            }
        }
        
        return true;
    }
    
}







*/