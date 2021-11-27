/**
 * ---------------- RAD Tools ---------------- 
 * PV-Writer
 * Simple Property-Value Writer
 * This class performs distributed operations with tokens
 * Created with Eclipse IDE
 * @author Warrpy
 * 
 */



package wxrp.rad.pvwriter;

import java.util.ArrayList;

import wxrp.rad.files.Files;

public class Writer extends Files {
	
	public void write(String path, ArrayList<String> properties, ArrayList<String> values,
			ArrayList<String> comments, ArrayList<Integer> line) {
		
		String file = "";
		String property = "";
		String value = "";
			// Writer loop
			for (int i = 0; i < properties.size(); i++) {
				
				for (int j = 0; j < line.size(); j++) {
					if (i == line.get(j)) {
						file += "# " +comments.get(j) + "\n";
					}
				}
				property = properties.get(i);
				value = values.get(i);
				file += property + ": " + "[ " +value + " ]\n";
			}
			
			create_file(path, file);
	}
	
	public void write(String path, ArrayList<String> properties, ArrayList<String> values) {
		
		String file = "";
		String property = "";
		String value = "";
			// Writer loop
			for (int i = 0; i < properties.size(); i++) {
				property = properties.get(i);
				value = values.get(i);
				file += property + ": " + "[ " +value + " ]\n";
			}
			create_file(path, file);
	}
}