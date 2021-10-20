package com.programmers.devops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * A카드사 홈페이지에 가입된 아이디들은 다음과 같은 형태를 갖추고 있습니다.
 *
 * 모든 아이디는 S+N 형식입니다.
 * S는 알파벳 소문자(a ~ z)로 구성된 문자열로 길이는 3 이상 6 이하입니다.
 * N는 숫자(0~9)로 구성된 문자열로 길이는 0 이상 6 이하입니다.
 * N의 길이가 0이 될 수도 있다는 것은, N이 비어있는 널(null) 문자열이 될 수도 있다는 의미입니다.
 * N의 길이가 1 이상이면, N의 첫자리는 "0"이 될 수 없습니다.
 * 즉, "034" , "06", "0", "09040", "000"과 같은 문자열은 N이 될 수 없습니다.
 * 위의 규칙에 부합하는, 올바른 아이디의 예를 들어보면 다음과 같습니다.
 * "ace", "hahaa512", "sunfri1", "aaaaaa900000", "abcde10101"
 *
 * 위의 규칙에 위배되는, 잘못된 아이디의 예를 들어보면 다음과 같습니다.
 *
 * 아이디	부적합 사유
 * "ac"	S의 길이가 3 미만입니다.
 * "Ange1004"	S에 알파벳 소문자가 아닌 문자가 포함되어 있습니다.
 * "1004angel"	S+N 형식이 아닙니다.(N+S형식은 허용하지 않습니다.)
 * "aaaaa1aaaaa"	S+N 형식이 아닙니다.(S+N+S 형식은 허용하지 않습니다.)
 * "triger0145"	N의 첫자리가 "0"이 될 수 없습니다.
 * "abcdefg733"	S의 길이가 6을 초과합니다.
 * "zzzzz4954951"	N의 길이가 6을 초과합니다.
 *
 * 이미 홈페이지에 가입된 아이디들의 목록(registered_list)과, 신규회원이 사용하기를 원하는 아이디(new_id)가 있다면, 아래와 같은 방법으로 신규회원에게 아이디를 추천해주려고 합니다.
 * 
 * new_id가 registered_list에 포함되어 있지 않다면, new_id를 추천하고 종료합니다.
 * new_id가 registered_list에 포함되어 있다면,
 * 
 * 2-1. new_id를 두 개의 문자열 S와 N으로 분리합니다.
 * 2-2. 문자열 N을 10진수 숫자로 변환한 값을 n이라고 합니다.(단, N이 비어있는 null 문자열이라면, n은 0이 됩니다.)
 * 2-3. n에 1을 더한 값(n+1)을 문자열로 변환한 값을 N1라고 합니다.
 * 2-4. new_id를 S+N1로 변경하고 1.로 돌아갑니다.
 * 
 * 이미 가입된 아이디들의 목록 registered_list와 신규회원이 사용하기를 원하는 아이디 new_id가 매개변수로 주어집니다..
 * 이때 설명한 방법을 적용했을 때, 신규회원에게 추천되는 아이디를 return 하도록 solution 함수를 완성해주세요.
 * 
 * 제한사항
 * new_id는 올바른 S+N 형식의 아이디(문자열)입니다.
 * registered_list는 길이가 1 이상 100,000 이하인 문자열 배열입니다.
 * registered_list의 각 원소는 올바른 S+N 형식의 아이디(문자열)입니다.
 * registered_list에 중복된 원소는 없습니다.(즉, 모두 서로 다른 아이디입니다.)
 * 문제에서 설명된 방법을 적용하여 return 되는 추천 아이디는 항상 올바른 S+N 형식임이 보장됩니다.
 * 즉, 추천 아이디를 결정하는 방법을 수행하면서 N 부분의 자릿수가 6을 초과하는 경우의 입력은 주어지지 않습니다.
 * 
 * 입출력 예
 * registered_list	new_id	result
 * ["card", "ace13", "ace16", "banker", "ace17", "ace14"]	"ace15"	"ace15"
 * ["cow", "cow1", "cow2", "cow3", "cow4", "cow9", "cow8", "cow7", "cow6", "cow5"]	"cow"	"cow10"
 * ["bird99", "bird98", "bird101", "gotoxy"]	"bird98"	"bird100"
 * ["apple1", "orange", "banana3"]	"apple"	"apple"
 * 
 * 입출력 예 설명
 * 
 * 입출력 예 #1
 * registered_list에 new_id("ace15")가 포함되지 않았으므로, "ace15"가 추천 아이디입니다.
 * 
 * 입출력 예 #2
 * registered_list에 new_id("cow")가 포함되어 있으므로, 다음과 같이 new_id를 바꾸는 과정을 거칩니다.
 * "cow" ⇒ "cow1" ⇒ "cow2" ⇒ "cow3" ⇒ "cow4" ⇒ "cow5" ⇒ "cow6" ⇒ "cow7" ⇒ "cow8" ⇒ "cow9" ⇒ "cow10"
 * "cow10"은 registered_list에 포함되지 않았으므로, "cow10"가 추천 아이디입니다.
 * 
 * 입출력 예 #3
 * registered_list에 new_id("bird98")가 포함되어 있으므로, 다음과 같이 new_id를 바꾸는 과정을 거칩니다.
 * "bird98" ⇒ "bird99" ⇒ "bird100"
 * "bird100"은 registered_list에 포함되지 않았으므로, "bird100"가 추천 아이디입니다.
 * 
 * 입출력 예 #4
 * registered_list에 new_id("apple")가 포함되지 않았으므로, "apple"가 추천 아이디입니다
 * 
 * 문제 설명
 * 공휴일과 사용할 수 있는 연차의 개수가 주어졌을 때, 가장 길게 휴가를 떠날 수 있는 날은 며칠인지 계산하려고 합니다.
 * 
 * 일	월	화	수	목	금	토
 * 1	2
 * 3	4	5	6	7	8	9
 * 10	11	12	13	14	15	16
 * 17	18	19	20	21	22	23
 * 24	25	26	27	28	29	30
 * 예를 들어, 휴가를 떠날 수 있는 달의 1일이 금요일이고, 그 달에 공휴일이 5일(6, 21, 23, 27, 28일) 존재하고, 사용할 수 있는 연차가 4개라고 가정해보겠습니다. 연차 4개를 22, 25, 26, 29일에 사용한다면, 주말과 공휴일, 연차를 활용하여 21일 ~ 30일까지 10일간 휴가를 떠날 수 있습니다.
 * 
 * 주말(토.일요일)과 공휴일은 겹칠 수도 있습니다.
 * 휴가를 떠날 수 있는 날은 1일부터 30일까지 입니다.
 * 아무리 늦어도 30일에는 휴가를 종료해야 합니다. 위 달력에서 30일이 토요일이므로, 다음 달의 첫날(1일)은 일요일입니다. 하지만, 30일에 휴가가 종료됩니다.
 * 아무리 빨라도 1일부터 휴가를 떠날 수 있습니다. 즉, 전달의 마지막 날이 주말이더라도 휴가를 더 일찍 떠날 수 없습니다.
 * 사용할 수 있는 연차의 개수 leave, 연차를 쓸 수 있는 달의 첫날 요일을 나타내는 day, 공휴일이 담겨 있는 holidays가 매개변수로 주어집니다. 이때, 가장 휴가를 길게 떠날 수 있는 기간을 구해서 return 하도록 solution 함수를 완성해주세요.
 * 
 * 제한사항
 * leave는 1 이상 30 이하인 정수입니다.
 * day는 길이 3인 알파벳 대문자로 구성된 문자열로, 다음 7가지 중 하나입니다.
 * 월요일 : MON, 화요일 : TUE, 수요일 : WED, 목요일 : THU, 금요일 : FRI, 토요일 : SAT, 일요일 : SUN
 * holidays는 길이 1 이상 30 이하인 정수 배열입니다.
 * holidays에는 중복된 원소가 없습니다.
 * holidays의 원소는 1 이상 30 이하인 자연수입니다.
 * holidays의 원소는 오름차순으로 정렬되어 있습니다.
 * 
 * 입출력 예
 * leave	day	holidays	result
 * 4	"FRI"	[6, 21, 23, 27, 28]	10
 * 3	"SUN"	[2, 6, 17, 29]	8
 * 30	"MON"	[1, 2, 3, 4, 28, 29, 30]	30
 * 입출력 예 설명
 * 입출력 예 #1
 * 문제 예시와 같습니다.
 * 
 * 입출력 예 #2
 * 
 * 일	월	화	수	목	금	토
 * 1	2	3	4	5	6	7
 * 8	9	10	11	12	13	14
 * 15	16	17	18	19	20	21
 * 22	23	24	25	26	27	28
 * 29	30					
 * 연차를 3개를 3, 4, 5일에 사용하면 1일부터 8일까지 휴가를 다녀올 수 있습니다.
 * 
 * 입출력 예 #3
 * 사용할 수 있는 휴가가 30개이므로, 공휴일이나 주말에 상관없이 1일부터 30일까지 휴가를 다녀올 수 있습니다.
 **/
import java.util.*;

class AlgorithmTest1 {
    public int solution(int leave, String day, int[] holidays) {
        int answer = -1;
        
        ArrayList<Integer> holidaysArray = new ArrayList<Integer>();
        for(int holyday: holidays){
            holidaysArray.add(holyday);
        }
        holidaysArray = getWeekend(holidaysArray, day);
        
        int longest = 0;
        for(int i = 1; i < 31; i++){
            int count = leave;
            int currentDay = i;
            int tempDay = 0;
            while(count > -1 && currentDay <= 30){
                if(holidaysArray.contains(currentDay)){
                    tempDay ++;
                }else{
                    if(count != 0){
                        tempDay ++;
                    }
                    count --;
                }
                currentDay ++;
            }
            if(tempDay > longest){
                longest = tempDay;
            }
        }
        
        System.out.println(holidaysArray);
        return longest;
    }
    
    public ArrayList<Integer> getWeekend(ArrayList<Integer> holidaysArray, String day){
        switch(day){
            case "MON" : 
                holidaysArray = checkDupl(holidaysArray,6);
                holidaysArray = checkDupl(holidaysArray,7);
                holidaysArray = checkDupl(holidaysArray,13);
                holidaysArray = checkDupl(holidaysArray,14);
                holidaysArray = checkDupl(holidaysArray,20);
                holidaysArray = checkDupl(holidaysArray,21);
                holidaysArray = checkDupl(holidaysArray,27);
                holidaysArray = checkDupl(holidaysArray,28);
                break;
            case "TUE" : 
                holidaysArray = checkDupl(holidaysArray,5);
                holidaysArray = checkDupl(holidaysArray,6);
                holidaysArray = checkDupl(holidaysArray,12);
                holidaysArray = checkDupl(holidaysArray,13);
                holidaysArray = checkDupl(holidaysArray,19);
                holidaysArray = checkDupl(holidaysArray,20);
                holidaysArray = checkDupl(holidaysArray,26);
                holidaysArray = checkDupl(holidaysArray,27);
                break;
            case "WED" : 
                holidaysArray = checkDupl(holidaysArray,4);
                holidaysArray = checkDupl(holidaysArray,5);
                holidaysArray = checkDupl(holidaysArray,11);
                holidaysArray = checkDupl(holidaysArray,12);
                holidaysArray = checkDupl(holidaysArray,18);
                holidaysArray = checkDupl(holidaysArray,19);
                holidaysArray = checkDupl(holidaysArray,25);
                holidaysArray = checkDupl(holidaysArray,26);
                break;            
            case "THU" : 
                holidaysArray = checkDupl(holidaysArray,3);
                holidaysArray = checkDupl(holidaysArray,4);
                holidaysArray = checkDupl(holidaysArray,10);
                holidaysArray = checkDupl(holidaysArray,11);
                holidaysArray = checkDupl(holidaysArray,17);
                holidaysArray = checkDupl(holidaysArray,18);
                holidaysArray = checkDupl(holidaysArray,24);
                holidaysArray = checkDupl(holidaysArray,25);
                break;            
            case "FRI" : 
                holidaysArray = checkDupl(holidaysArray,2);
                holidaysArray = checkDupl(holidaysArray,3);
                holidaysArray = checkDupl(holidaysArray,9);
                holidaysArray = checkDupl(holidaysArray,10);
                holidaysArray = checkDupl(holidaysArray,16);
                holidaysArray = checkDupl(holidaysArray,17);
                holidaysArray = checkDupl(holidaysArray,23);
                holidaysArray = checkDupl(holidaysArray,24);
                holidaysArray = checkDupl(holidaysArray,30);
                break;            
            case "SAT" : 
                holidaysArray = checkDupl(holidaysArray,1);
                holidaysArray = checkDupl(holidaysArray,2);
                holidaysArray = checkDupl(holidaysArray,8);
                holidaysArray = checkDupl(holidaysArray,9);
                holidaysArray = checkDupl(holidaysArray,15);
                holidaysArray = checkDupl(holidaysArray,16);
                holidaysArray = checkDupl(holidaysArray,22);
                holidaysArray = checkDupl(holidaysArray,23);
                holidaysArray = checkDupl(holidaysArray,29);
                holidaysArray = checkDupl(holidaysArray,30);
                break;            
            case "SUN" : 
                holidaysArray = checkDupl(holidaysArray,1);
                holidaysArray = checkDupl(holidaysArray,7);
                holidaysArray = checkDupl(holidaysArray,8);
                holidaysArray = checkDupl(holidaysArray,14);
                holidaysArray = checkDupl(holidaysArray,15);
                holidaysArray = checkDupl(holidaysArray,21);
                holidaysArray = checkDupl(holidaysArray,22);
                holidaysArray = checkDupl(holidaysArray,28);
                holidaysArray = checkDupl(holidaysArray,29);
                break;
        }
        
        return holidaysArray;
    }
    
    public ArrayList<Integer> checkDupl(ArrayList<Integer> holidaysArray, Integer day){
        if(!holidaysArray.contains(day)){
            holidaysArray.add(day);
        }
        return holidaysArray;
    }
}