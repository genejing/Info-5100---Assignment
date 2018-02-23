
public class SwapAdjacentinLRString {
	public boolean canTransform(String start, String end) {
        int s = 0, e = 0;
        int len = start.length();
        while(s < len && e < len) {
            while( s < len && start.charAt(s) == 'X') {
                s++;
            }
            while(e< len && end.charAt(e) == 'X') {
                e++;
            }
            if (s==len && e==len) {
                return true;
            } 
            
            if (s==len || e==len) {
                return false;
            }
            
            if (start.charAt(s) != end.charAt(e)) {
                return false;
            }
            if (start.charAt(s) == 'R' && s > e) {
                return false;
            }
            if (start.charAt(s) == 'L' && s < e) {
                return false;
            }
            s++;
            e++;
        }
        return true;
    }
	
	public static void main(String[] args) {
		SwapAdjacentinLRString sal = new SwapAdjacentinLRString();
		System.out.println(sal.canTransform("RXXLRXRXL", "XRLXXRRLX"));  // true
	}
}
