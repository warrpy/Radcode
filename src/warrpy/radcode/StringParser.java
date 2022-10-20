package warrpy.radcode;
import java.util.ArrayList;

public class StringParser {
	
	private String[] tokens;
	
	public String[] parse_string(String string, char separator) {
		String token = "";
		int length = string.length();
		var tokens = new ArrayList<String>();
		
		for (int i = 0; i < length; i++) {
			
			if (string.charAt(i) == separator) {
				tokens.add(token);
				token = "";
			}
			
			else {
				token += string.charAt(i);
			}
			
			if (i == length - 1) {
				tokens.add(token);
			}
		}
		
		var size = tokens.size();
		if (size != 0) {
			 size = size - 1;
		}
		
		this.tokens = new String[size];
		
		for (int i = 0; i < size; i++) {
			this.tokens[i] = tokens.get(i);
		}
		
		return this.tokens;
	}
}