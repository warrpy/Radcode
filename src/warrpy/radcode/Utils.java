package warrpy.radcode;

public class Utils {
	
	public String get_home() {
		return System.getProperty("user.home");
	}
	
	public String[] parse_string(String string, char separator) {
		StringParser util = new StringParser();
			return util.parse_string(string, separator);
	}
	
	public String encrypt(String text, int key) {
		char code[] = text.toCharArray();
		String encoded = "";
		key = Math.abs(key); // decoding protection.
			for (char c: code) {
				c += key;
				encoded += c;
			}
			return encoded;
	}
	
	public String decrypt(String text, int key) {
		char code[] = text.toCharArray();
		String decoded = "";
			for (char c: code) {
				c -= key;
				decoded += c;
			}
			return decoded;
	}
	
	public void radcode() {
		System.out.println("Radcode Utilities Library v2.0");
	}
}