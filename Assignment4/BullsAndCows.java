import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {
	public String getHint(String secret, String guess) {
		int bull=0,cow = 0;
		char[] sec = secret.toCharArray();
		char[] gue = guess.toCharArray();
		int[] table = new int[10];
		
		for (int i=0;i<sec.length;i++) {
			if (sec[i] == gue[i]) {
				bull++;
			} else {
				if (table[sec[i]-'0']++<0) {
					cow++;
				}
				if (table[gue[i]-'0']-->0) {
					cow++;
				}
			}
		}
		return bull+"A"+cow+"B";
	}
	
	public static void main(String[] args) {
		System.out.println(new BullsAndCows().getHint("1122", "1222")); 
	}
}
