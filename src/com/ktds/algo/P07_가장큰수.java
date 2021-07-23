import java.util.Arrays;
import java.util.Comparator;

public class P07_가장큰수 {
    public String solution(int[] numbers) {
    	// 1단계 : 정수 배열을 문자열 배열로 변경
    	// 2단계 : 정렬 규칙을 새로 정의 : s1 + s2 비교 s2 + s1 큰 값이 되도록 정렬
        String answer = "";
        String[] strArr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
			strArr[i] = ""+numbers[i]; // String.valueOf(numbers[i]);
		}
        Arrays.sort(strArr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return (s2+s1).compareTo(s1+s2); // 2개를 더해서 더 큰쪽이 우선 순위가 되도록 설정
			}
		});
        for (int i = 0; i < strArr.length; i++) {
			answer += strArr[i];
		}
        return answer;
    }// solution
    public static void main(String[] args) {
    	// numbers	return
    	// [6, 10, 2]	"6210"
    	// [3, 30, 34, 5, 9]	"9534330"
		P07_가장큰수 obj = new P07_가장큰수();
		int[] numbers = {6, 10, 2};
		System.out.println(obj.solution(numbers));
		int[] numbers2 = {3, 30, 34, 5, 9};
		System.out.println(obj.solution(numbers2));
	}// main
}// end