package wxrp.rad.listwriter;

import wxrp.rad.files.Files;

public class ListWriter extends Files {
	public void write_list(String path, String[] list) {
		var content = "";
			for (String s : list) {
				content += s + "\n";
			}
			create_file(path, content);
	}
}
