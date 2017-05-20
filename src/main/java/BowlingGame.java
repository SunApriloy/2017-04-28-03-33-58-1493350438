public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
		int result[] = new int[21];
		boolean one[] = new boolean[21], two[] = new boolean[21];
		int l = bowlingCode.length();
		int k = 0, t = 0;
		for (int i = 0; i < 21; i++) {
			result[i] = -1;
			one[i] = false;
			two[i] = false;
		}
		boolean mark = true;
		for (int i = 0; i < l; i++) {
			char c = bowlingCode.charAt(i);
			switch (c) {
			case '|':
				t++;
				if (t == 11)
					mark = false;
				k--;
				break;
			case 'X':
				result[k] = 10;
				two[k] = true && mark;
				break;
			case '/':
				result[k] = 10 - result[k - 1];
				one[k] = true && mark;
				break;
			case '-':
				result[k] = 0;
				break;
			default:
				result[k] = c - 48;
			}
			k++;
		}
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += result[i];
			if (one[i])
				sum += result[i + 1];
			if (two[i])
				sum += result[i + 1] + result[i + 2];
		}
		while (bowlingCode.charAt(--l) != '|') {
			sum -= result[--k];
		}
		return sum;
    }
}
