package business;

public class Temp {

	public static void main(String[] args) {
		String str = "a";
		StringBuilder stringBuilder = new StringBuilder("0123456789");
		stringBuilder.append(str);
		stringBuilder.ensureCapacity(16);
	}
}
