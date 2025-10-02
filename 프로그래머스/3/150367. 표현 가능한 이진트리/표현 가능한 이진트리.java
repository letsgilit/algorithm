import java.util.*;
class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
		Arrays.fill(answer, 1);
		for (int i = 0; i < numbers.length ; i++) {
			String str = Long.toString(numbers[i], 2);

			String newStr = "";
			for (long j = 1; j < Long.MAX_VALUE; j = j*2+1) {
				if(str.length() <= j){
					long temp = j - str.length();
					newStr= "0".repeat((int)temp) +str;
					break;
				}
			}

			if (!check(newStr)) {
                answer[i] = 0;
            }

		}
		return answer;
    }
    
    public boolean check(String binary) {
		if (binary.length() == 1) return true;

		int mid = binary.length() / 2;
		char root = binary.charAt(mid);

		String left = binary.substring(0, mid);
		String right = binary.substring(mid + 1);

		// 부모가 0인데 자식에 1이 있으면 불가능
		if (root == '0') {
			if (left.contains("1") || right.contains("1")) return false;
		}

		return check(left) && check(right);
	}
}