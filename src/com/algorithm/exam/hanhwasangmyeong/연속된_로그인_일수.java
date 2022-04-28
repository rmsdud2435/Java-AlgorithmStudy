package com.algorithm.exam.hanhwasangmyeong;

import java.util.Arrays;

/**
 * 
 * 문제 설명
 * 어떤 회사가 신규 앱(APP)의 출시와 함께 이벤트를 열었습니다. 
 * 즉, 이벤트 기간 내에 고객들이 앱에 접속한 기록을 검토하여 가장 길게 연속으로 접속한 평일의 수를 계산하여 상품을 지급하려고 합니다. 
 * 아래는 이벤트 기간이 05/04(월요일) ~ 05/30(토요일)인 경우, A고객이 접속한 날을 밑줄로 표시한 것입니다.
 * 
 * A고객의 5월 접속 기록
 * 일	월	화	수	목	금	토
 * 		4	5	6	7	8	9
 * 10	11	12	13	14	15	16
 * 17	18	19	20	21	22	23
 * 24	25	26	27	28	29	30
 * 
 * A고객의 가장 길게 연속으로 접속한 평일의 수는 5일입니다.(05/21, 05/22, 05/25, 05/26, 05/27)
 * 05/23에 접속하였으나, 토요일이므로 계산에 넣지 않습니다.
 * 05/24에 접속하지 않았으나, 일요일이므로 '평일 연속 접속' 기록이 끊어지지 않습니다.
 * 
 * A고객은 05/06 ~ 05/11 기간에 6일 동안 연속으로 접속했으나, 중간에 토.일요일을 제외하면 4일입니다. 
 * 따라서 A고객의 가장 길게 연속으로 접속한 평일의 수는 앞에서 구한 5일입니다.
 * 
 * 이벤트의 시작 날짜가 담겨있는 문자열 start_date, 종료 날짜가 담겨있는 문자열 end_date, 
 * A고객이 접속한 날짜들이 담겨 있는 문자열 배열 login_dates가 매개변수로 주어집니다. 
 * 이때, A고객의 가장 길게 연속으로 접속한 평일의 수를 구해서 return 하도록 solution 함수를 완성해주세요. 
 * 
 * 만약 고객이 평일에 접속한 기록이 없다면 0을 return 하도록 합니다.
 * 
 * 
 * 제한사항
 * start_date는 길이 9로 고정된 문자열로, "MM/DD DAY" 형식입니다.
 * MM/DD는 월(month)/일(day)을 나타내며, "01/01"에서 "12/31" 사이입니다.
 * DAY는 요일을 나타내며, 아래와 같이 표기합니다.
 * 월요일 : MON, 화요일 : TUE, 수요일 : WED, 목요일 : THU, 금요일 : FRI, 토요일 : SAT, 일요일 : SUN
 * end_date는 길이 5로 고정된 문자열입니다.
 * end_date는 "MM/DD" 형식이며, "01/01"에서 "12/31"사이입니다.
 * end_date는 start_date보다 같거나 늦은 날짜로만 주어집니다.
 * end_date는 start_date와 같은 년도라고 가정합니다.
 * login_dates는 길이 1 이상 365 이하의 문자열 배열이며, A고객이 접속한 날짜들이 담겨 있습니다.
 * login_dates의 원소는 길이 5로 고정된 문자열입니다.
 * login_dates의 원소는 MM/DD형식이며, "01/01"에서 "12/31"사이입니다.
 * login_dates의 원소들은 정렬되어 있지 않습니다.
 * login_dates의 원소들은 서로 다릅니다. 즉, 중복된 날짜는 주어지지 않습니다.
 * start_date~end_date 범위를 벗어나는 날짜는 주어지지 않습니다.
 * 공휴일(어린이날 등)은 존재하지 않는다고 가정합니다. 즉, 모든 월~금요일은 평일입니다.
 * 윤년은 존재하지 않는다고 가정합니다. 즉, 2월의 마지막 날은 항상 28일입니다.
 * "01/32", "13/05", "02/29" 등과 같은 잘못된 월/일은 입력으로 주어지지 않습니다.(start_date, end_date, login_dates 공통 사항)
 * 
 * 
 * 입출력 예
 * start_date	end_date	login_dates	result
 * "05/04 MON"	"05/30"	["05/26", "05/25", "05/27", "05/10", "05/11", "05/23", "05/22", "05/21", "05/06", "05/09", "05/07", "05/08"]	5
 * "05/27 SUN"	"06/16"	["05/31", "05/30", "06/01", "06/04", "06/07", "06/06", "06/09", "06/08", "06/13", "06/14", "06/10"]	4
 * 
 * 입출력 예 설명
 * 입출력 예 #1
 * 문제 예시와 같습니다.
 * 
 * 입출력 예 #2
 * A고객의 5월 접속 기록
 * 일	월	화	수	목	금	토
 * 27	28	29	30	31	
 * A고객의 6월 접속 기록
 * 일	월	화	수	목	금	토
 * 1	2
 * 3	4	5	6	7	8	9
 * 10	11	12	13	14	15	16
 * A고객의 가장 길게 연속으로 접속한 평일의 수는 4일입니다.(05/30, 05/31, 06/01, 06/04)
 * 2020년의 5월 27일은 수요일입니다. 하지만, 이벤트가 열리는 년도가 2020년이 아닐 수도 있으므로, 
 * 입력으로 주어지는 이벤트 시작 날의 요일을 기준으로 평일을 계산하여야 합니다.
 */

public class 연속된_로그인_일수 {

	public static void main(String[] args) {
		
		
		//String start_date = "05/04 MON";
		//String end_date = "05/30";
		//String[] login_dates = {"05/26", "05/25", "05/27", "05/10", "05/11", "05/23", "05/22","05/21", "05/06", "05/09", "05/07", "05/08"};
		
		String start_date = "05/27 SUN";
		String end_date = "06/16";
		String[] login_dates = {"05/31", "05/30", "06/01", "06/04", "06/07", "06/06", "06/09", "06/08", "06/13", "06/14", "06/10"};
		
		System.out.println(solution(start_date, end_date, login_dates));

	}
	
	public static int solution(String start_date, String end_date, String[] login_dates) {

		int[] monthDay = {31,28,31,30,31,30,31,31,30,31,30,31};
		String[] weekDay = {"MON","TUE","WED","THU","FRI","SAT","SUN"};
		int maxCount = 0;
		
		String[] startDate = start_date.split(" ");
		int weekCount = 0;
		for(int i = 0; i < weekDay.length; i ++) {
			if(startDate[1].equals(weekDay[i])) {
				weekCount = i;
			}
		}
		
		Arrays.sort(login_dates);
		
		String[] currentDate = startDate[0].split("/");
		int currentMonth = Integer.parseInt(currentDate[0]);
		int currentDay = Integer.parseInt(currentDate[1]);
		
		int loginDateCount = 0;
		String[] loginDate = login_dates[loginDateCount].split("/");
		int loginMonth = Integer.parseInt(loginDate[0]);
		int logintDay = Integer.parseInt(loginDate[1]);
		
		String[] endDate = end_date.split("/");
		int endMonth = Integer.parseInt(endDate[0]);
		int endDay = Integer.parseInt(endDate[1]);
		
		int currentCount = 0;
		while(true) {
			if(currentMonth == loginMonth && currentDay == logintDay) {
				if(weekCount%7 < 5) {
					currentCount++;
				}
				loginDateCount++;
				if(loginDateCount >= login_dates.length ) {
					maxCount = GetMaxCount(maxCount, currentCount);
					break;
				}else {					
					loginDate = login_dates[loginDateCount].split("/");
					loginMonth = Integer.parseInt(loginDate[0]);
					logintDay = Integer.parseInt(loginDate[1]);
					
				}
			}else {
				if(weekCount%7 < 5) {
					maxCount = GetMaxCount(maxCount, currentCount);
					currentCount = 0;
				}
			}
			
			if(currentMonth == endMonth && currentDay == endDay) {
				maxCount = GetMaxCount(maxCount, currentCount);
				break;
			}else {				
				currentDate = GetNextDay(currentMonth, currentDay, monthDay).split("/");
				currentMonth = Integer.parseInt(currentDate[0]);
				currentDay = Integer.parseInt(currentDate[1]);
				weekCount++;
			}
			
		}
		
		return maxCount;
	}
	
	public static String GetNextDay(int currentMonth, int currentDay, int[] monthDay) {
		if(currentDay==monthDay[currentMonth-1]) {
			currentMonth ++;
			currentDay = 1;
		}else {
			currentDay++;
		}
		return Integer.toString(currentMonth) + "/" + Integer.toString(currentDay);
	}
	
	public static int GetMaxCount(int maxCount, int currentCount) {
		if(maxCount < currentCount) {
			return currentCount;
		}else {
			return maxCount;
		}
	}
}
