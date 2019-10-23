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

실행 시간이 얼마 걸리지 않는 Job 테스트를 위한 메소드


### SimpleService의 sleepFor10seconds()

실행 시간이 오래 걸리는 Job 테스트를 위한 메소드

### simpleCronTrigger Bean 객체

@DisallowConcurrentExecution을 활용하여 중복제거.  
만약, 이미 실행되고 있다면 배치 대기열에 추가 후 이전 배치 끝나자 마자 바로 실행

### simpleCronTrigger2 Bean 객체

JobExecutionContext 객체를 활용하여 중복제거.  
만약, 이미 실행되고 있다면 로직 실행하지 않고 다음 배치 시간을 디다림
