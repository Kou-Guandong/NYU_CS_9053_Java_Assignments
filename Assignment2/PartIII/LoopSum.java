
public class LoopSum {

	public static int sum100() {
		int result = 0;
		int value = 1;
		while (value <= 100){
			result += value;
			value++;
		}
		return result;
	}
	
	public static int sumN(int n) {
		int result = 0;
		int value = 1;
		while (value <= n){
			result += value;
			value++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(sum100());
		System.out.println(sumN(100));
		System.out.println(sumN(10));
	}
	
}
