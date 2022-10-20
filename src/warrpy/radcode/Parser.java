/**
 * ---------------- RAD Tools ---------------- 
 * PV-Parser
 * Simple Property-Value Parser
 * This class performs a parsing operation
 * Created with Eclipse IDE
 * @author CodeWarp
 * 
 */
 
package warrpy.radcode;

import java.util.ArrayList;
public class Parser extends Files {
	
	public ArrayList<String> properties = new ArrayList<String>();
	public ArrayList<String> values = new ArrayList<String>();
	
	public boolean parse(String path) {
		String file = get_file(path);
		String property = "";
		String value = "";
		char read;
		boolean read_property = true;
		boolean comment = false;

		// Parser loop
		for (int i = 0; i < file.length(); i++) {
			read = file.charAt(i);
			// Skipping comments
			if (read == '#') {
				comment = true;
			}
			// Preparing to parsing
			if (read == '\n') {
				comment = false;
			}

			if (!comment) {
				// Saving value
				if (read == ']') {
					read_property = true;
					value = value.trim();
					values.add(value);
					value = "";
				}
				// Correcting value
				if (!read_property) {
					value += read;
				}
				// Saving property
				if (read == '[') {
					read_property = false;
					property = property.replace("\n", "");
					property = property.trim();
					properties.add(property);
					property = "";
				}
				// Correcting property
				if (read_property) {
					if (read != ']' && read != ':') {
						property += read;
					}
				}
			}
		}
		return exists;
	}
}