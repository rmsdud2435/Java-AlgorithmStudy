# Spring5-Java-AlgorithmStudy
자바를 활용하여 여러 알고리즘에 대해 코딩해보기  
이때까지 알고리즘 문제들을 여기저기 프로젝트에 풀고 지웠는데 정리할 필요성을 느꼈다.  
풀었던 모든 문제를 찾지는 못했지만 현재까지 남아있던 문제들은 옮기고 이제부터 푸는 문제에 대해 몰랐던 점 및 느낀점 혹은 추후에 헷갈릴만한 내용을 정리할 것이다.  

## 사용된 버전

>java : 1.8.X  

## 문제 출처
>https://programmers.co.kr  
>https://www.codility.com


## 몰랐던 부분, 느낀점, 추후에 헷갈릴만한 내용 

### com.algorithm.stackqueue.StackQueueAlgorithm2
* > 기능 개발  
https://programmers.co.kr/learn/courses/30/lessons/42586  

* 정수 / 정수는 내림으로 값나온다.  
  >10/3은 3이다. 단, 분모나 분자 중 하나라도 float, doulble 등이면 3.333333334으로 나온다.  
  
* Stream 자료형을 활용하면 더 짧게 코딩할 수 있다.
  >알고리즘에선 Stream형 공부필수!

### com.algorithm.hashmap.HashAlgorithm3
* > 베스트앨범  
https://programmers.co.kr/learn/courses/30/lessons/42579

* 실제 코딩에서도 많이 사용되는 HashMap에 대해서 value를 토대로 정렬하기
  
  ```java
  
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
		return list;
		
		//Collections.reverse(list); // 주석시 내림차순
	}
  
  ```
  
* Stream 자료형을 활용하면 더 짧게 코딩할 수 있다.
  > 내가 짠 솔루션 아래에 심재훈이라는 분이 Music객체를 만들고 Comparable를 상속받아 Stream형을 활용하여 풀이한 소스가 있다. 정말 뛰어난 방법이라고 생각한다. 다시금 Stream의 활용성과 저런 방법도 있구나를 느꼈다. 
