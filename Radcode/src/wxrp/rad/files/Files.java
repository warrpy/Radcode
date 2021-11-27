package wxrp.rad.files;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import wxrp.rad.arraylib.ArrayLib;

public class Files {
	
	private FileWriter file_writer;
	private FileReader file_reader;
	private File file_processor;
	public boolean exists;
	
	public void create_file(String path, String list) {
		try {
			file_writer = new FileWriter(path);
			file_writer.write(list);
			file_writer.close();
			
		} catch(Exception e) {
			System.out.println("[IO]: Error");
			return;
		}		
	}
	
	public String get_file(String path) {
		String file = "";
		
		try {
			file_reader = new FileReader(path);
			int i;
			while ((i = file_reader.read()) != -1) {
				file += (char) i;
			}
			
			file_reader.close();
			exists = true;
			
			} catch (Exception e) {
				System.out.println("[IO]: Error");
				exists = false;
			}
		return file;
	}
	
	public boolean file_exists(String path) {
			get_file(path);
			return exists;
	}
	
	public boolean mkdir(String path) {
		file_processor = new File(path);
		return file_processor.mkdir();
	}
	
	public String[] get_files(String path) {
		file_processor = new File(path);
			return file_processor.list();
	}
	
	public String[] get_folders(String path) {
		file_processor = new File(path);
		var list = new ArrayList<String>();
			for (File f: file_processor.listFiles()) {
				if (f.isDirectory()) {
					list.add(f.getName());
				}
			}
			var lib = new ArrayLib();
			return lib.list2array(list);
	}
	
	public void rename(String name, String new_name) {
		file_processor = new File(name);
		file_processor.renameTo(new File(new_name));
	}
}