package com.algorithm.hashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HashAlgorithm3 {
	
	/*
	 * 문제
	 * 
	 * 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다.
	 * 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
	 * 1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
	 * 2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
	 * 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
	 * 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
	 * 
	 * 제한사항
	 * 
	 * genres[i]는 고유번호가 i인 노래의 장르입니다.
	 * plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
	 * genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
	 * 장르 종류는 100개 미만입니다.
	 * 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
	 * 모든 장르는 재생된 횟수가 다릅니다.
	 * 
	 * 
	 * 출처 : https://programmers.co.kr/learn/courses/30/lessons/42579
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};

		myAnswer(genres, plays);
	}
	
	//내 답안
	public static int[] myAnswer(String[] genres, int[] plays) {
		
	    HashMap<String, Integer> totalPlayed = new HashMap<String, Integer>(); 						//각 장르의 총 play 회수를 담을 해시맵 
	    HashMap<String, ArrayList<Integer>> bestPlayes = new HashMap<String, ArrayList<Integer>>(); //각 장르의 1,2 위의 id를 담을 해시맵	    	
	    
	    for(int i = 0; i < plays.length; i++){
	    	//이미 한번나온 장르이면
	    	if(totalPlayed.containsKey(genres[i])){
	    		totalPlayed.put(genres[i], totalPlayed.get(genres[i]).intValue() + plays[i]);
	    		
	    		ArrayList<Integer> tempArray = bestPlayes.get(genres[i]);
	    		//이미 2위까지 나온 장르이면
	    		if(tempArray.size() > 1){
	    			//1위보다 현재의 노래 플레이 횟수가 높으면
	    			if(plays[tempArray.get(0).intValue()] < plays[i]){
	    				tempArray.remove(1);
	    				tempArray.add(0,i);
	    			//2위보다 현재의 노래 플레이 횟수가 높으면
	    			}else if(plays[tempArray.get(1).intValue()] < plays[i]){
	    				tempArray.remove(1);
	    				tempArray.add(1,i);
	    			}
	    		// 아직 1위만 존재하는 장르이면
	    		}else{
	    			//1위보다 플레이 횟수가 낮으면
	    			if(plays[tempArray.get(0).intValue()] > plays[i]){
	    				tempArray.add(i);
	    			//1위보다 플레이 횟수가 높으면
	    			}else{	 
	    				tempArray.add(0,i);
	    			}
	    			
	    		}
	    		bestPlayes.put(genres[i], tempArray);
	    	//처음 나온 장르이면
	    	}else{
	    		totalPlayed.put(genres[i], plays[i]);
	    			
	    		ArrayList<Integer> tempArray = new ArrayList<Integer>();
	    		tempArray.add(i);
	    		bestPlayes.put(genres[i], tempArray);
	    	}
	    }
 		  
	    //총 횟수를 토대로 내림정렬한 장르뽑기
	    ArrayList<String> rank = sortByValue(totalPlayed);
	    
	    //ArrayList를 int[]형으로 바꾸기 위한 임시 변수
	    ArrayList<Integer> tempArrayList = new ArrayList<Integer>();
	    
	    //장르명을 토대로 루프
	    for(String var : rank){
	    	//장르명을 통해서 각 장르의 1,2위를 뽑아 임시 배열에 추가
	    	ArrayList<Integer> tempArrayList2 = bestPlayes.get(var);
	    	for(Integer a : tempArrayList2){	    		
	    		tempArrayList.add(a);
	    	}
	    }

	  //ArrayList를 int[]로 변형
	    int[] answer = new int[tempArrayList.size()];
	    for(int i = 0; i < tempArrayList.size() ; i++){
	    	answer[i] = tempArrayList.get(i);
	    }
	    return answer;
	}
	
	//Value를 토대로 Key를 정렬하여 뽑는 함수
	public static <String>ArrayList sortByValue(final Map map) {

		ArrayList<String> list = new ArrayList();
		list.addAll(map.keySet());

		Collections.sort(list,new Comparator() {
			public int compare(Object o1,Object o2) {
				Object v1 = map.get(o1);
				Object v2 = map.get(o2);

				return ((Comparable) v2).compareTo(v1);
			}

		});
		
		//Collections.reverse(list); // 주석시 내림차순
		
		return list;
	}
	
	// 맘에 들었던 모범답안 by 심재훈님
	public class Music implements Comparable<Music> {

		private int 	played;
		private int 	id;
		private String 	genre;

		public Music(String genre, int played, int id) {
			this.genre = genre;
			this.played = played;
			this.id = id;
		}

		@Override
		public int compareTo(Music other) {
			if (this.played == other.played)
				return this.id - other.id;
			return other.played - this.played;
		}

		public String getGenre() {
			return genre;
		}
	}

	public int[] solution(String[] genres, int[] plays) {
		return IntStream.range(0, genres.length).mapToObj(i -> new Music(genres[i], plays[i], i))
				.collect(Collectors.groupingBy(Music::getGenre)).entrySet().stream()
				.sorted((a, b) -> sum(b.getValue()) - sum(a.getValue()))
				.flatMap(x -> x.getValue().stream().sorted().limit(2)).mapToInt(x -> x.id).toArray();
	}

	private int sum(List<Music> value) {
		int answer = 0;
		for (Music music : value) {
			answer += music.played;
		}
		return answer;
	}
}