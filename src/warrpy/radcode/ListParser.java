package warrpy.radcode;

public class ListParser extends Files {
	
	public String[] parse_list(String path) {
		var content = get_file(path);
		var tokenizer = new StringParser();
		String list[] = tokenizer.parse_string(content, '\n');
		return list;
	}
}