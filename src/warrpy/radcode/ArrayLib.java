package warrpy.radcode;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class ArrayLib {
	
	public int AZ = 1, ZA = 2;
	private int remove_c, set_c, get_c, swap_c;
	
	// Removes [idx] element from list model.
	public void remove(DefaultListModel<String> list_model, int index) {
		remove_c += 1;
		if (!((list_model.size() - 1) < index) && !(index < 0)) {
			list_model.remove(index);
		}
		else {
			error("remove()", remove_c);
		}	
	}
	
	public void remove(ArrayList<String> list_model, int index) {
		remove_c += 1;
		if (!((list_model.size() - 1) < index) && !(index < 0)) {
			list_model.remove(index);
		}
		else {
			error("remove()", remove_c);
		}	
	}
	// Sets element in list model to [idx].
	public void set(DefaultListModel<String> list_model, int index, String element) {
		set_c += 1;
		if (!((list_model.size() - 1) < index) && !(index < 0)) {
			list_model.set(index, element);
		}
		else {
			error("set()", set_c);
		}
	}
	
	public void set(ArrayList<String> list_model, int index, String element) {
		set_c += 1;
		if (!((list_model.size() - 1) < index) && !(index < 0)) {
			list_model.set(index, element);
		}
		else {
			error("set()", set_c);
		}
	}
	// Gets element from [idx].
	public String get(DefaultListModel<String> list_model, int index) {
		get_c += 1;
		String value = "";
		if (!((list_model.size() - 1) < index) && !(index < 0)) {
			value = list_model.get(index);
		}
		else {
			error("get()", get_c);
		}
		return value;
	}
	
	public String get(ArrayList<String> list_model, int index) {
		get_c += 1;
		String value = "";
		if (!((list_model.size() - 1) < index) && !(index < 0)) {
			value = list_model.get(index);
		}
		else {
			error("get()", get_c);
		}
		return value;
	}
	// Swaps the elements in list model.
	public void swap(DefaultListModel<String> list_model, int index_from, int index_to) {
		swap_c += 1;
		if (!((list_model.size() - 1) < index_from) && !(index_from < 0)) {
			if (!((list_model.size() - 1) < index_to) && !(index_to < 0)) {
				String value_from = list_model.get(index_from);
				String value_to = list_model.get(index_to);
				list_model.set(index_to, value_from);
				list_model.set(index_from, value_to);
			}
			else {
				error("swap()", swap_c);
			}
		}
		else {
			error("swap()", swap_c);
		}
	}
	
	public void swap(ArrayList<String> list_model, int index_from, int index_to) {
		swap_c += 1;
		if (!((list_model.size() - 1) < index_from) && !(index_from < 0)) {
			if (!((list_model.size() - 1) < index_to) && !(index_to < 0)) {
				String value_from = list_model.get(index_from);
				String value_to = list_model.get(index_to);
				list_model.set(index_to, value_from);
				list_model.set(index_from, value_to);
			}
			else {
				error("swap()", swap_c);
			}
		}
		else {
			error("swap()", swap_c);
		}
	}
	// Fills the array with another array.  
	public void fill(DefaultListModel<String> list_model, ArrayList<String> array_list) {
		for (String i : array_list) {
			list_model.addElement(i);
		}
	}
	
	public void fill(ArrayList<String> array_list, DefaultListModel<String> list_model) {
		array_list.clear();
		for (int i = 0; i < list_model.size(); i++) {
			array_list.add(list_model.get(i));
		}
	}
	
	public void fill(DefaultListModel<String> list_model, String[] array) {
		for (String i : array) {
			list_model.addElement(i);
		}
	}
	// Fills the array with another array with element filtering.
	public void fill(DefaultListModel<String> list_model, String[] array, String[] except) {
		boolean skip = false;	
		for (String i : array) {
			skip = false;
			for (String s: except) {
				if (i.equals(s)) {
					skip = true;
				}
			}
			if (!skip) {
				list_model.addElement(i);
			}
		}
	}
	
	public void fill(ArrayList<String> array_list_to_fill, ArrayList<String> array_list) {
		for (String s: array_list) {
			array_list_to_fill.add(s);
		}
	}
	
	public void fill(ArrayList<String> array_list_to_fill, ArrayList<String> array_list, String[] except) {
		boolean skip = false;	
		for (String i : array_list) {
			skip = false;
			for (String s: except) {
				if (i.equals(s)) {
					skip = true;
				}
			}
			if (!skip) {
				array_list_to_fill.add(i);
			}
		}
	}
	
	public void fill(ArrayList<String> array_list_to_fill, String[] array, String[] except) {
		boolean skip = false;	
		for (String i : array) {
			skip = false;
			for (String s: except) {
				if (i.equals(s)) {
					skip = true;
				}
			}
			if (!skip) {
				array_list_to_fill.add(i);
			}
		}
	}
	// Fills an array with another array0 if each element of the array0 is not equal to [except]. 
	public void fill(ArrayList<String> array_list, String[] array, String except) {
		for (String s: array) {
			if (!s.equals(except)) {
				array_list.add(s);
			}
		}
	}
	
	public void fill(DefaultListModel<String> list_model, String[] array, String except) {
		for (String s: array) {
			if (!s.equals(except)) {
				list_model.addElement(s);
			}
		}
	}
	
	public void fill(ArrayList<String> array_list_to, ArrayList<String> array_list_from,  String except) {
		for (String s: array_list_from) {
			if (!s.equals(except)) {
				array_list_to.add(s);
			}
		}
	}
	
	public void fill(ArrayList<String> array_list, String[] array) {
		for (String s: array) {
			array_list.add(s);
		}
	}
	// Arranges elements.
	public void arrange(DefaultListModel<String> list_model, ArrayList<String> array, int az_za) {
		if (az_za == 1) {
			array.sort(null);
			list_model.removeAllElements();
			fill(list_model, array);
		}
		if (az_za == 2) {
			array.sort(null);
			list_model.removeAllElements();
			for (int i = array.size() - 1; i >= 0; i--) {
				list_model.addElement(array.get(i));
			}
		}
	}

	public void arrange(ArrayList<String> array_list_from, ArrayList<String> array_list_to, int az_za) {
		if (az_za == 1) {
			array_list_from.sort(null);
			array_list_to.clear();
			fill(array_list_to, array_list_from);
		}
	}
	
	
	public String[] list2array(DefaultListModel<String> list) {
		String[] array = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				array[i] = list.get(i);
			}
		return array;
	}
	
	public DefaultListModel<String> array2list(String[] array) {
		var list = new DefaultListModel<String>();
			fill(list, array);
		return list;
	}
	
	public String[] list2array(ArrayList<String> list) {
		String[] array = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				array[i] = list.get(i);
			}
		return array;
	}
		
	public String charr2str(char array[]) {
		var str = "";
		for (char c: array) {
			str += c;
		}
		return str;
	}
	
	private void error(String method, int call) {
		System.out.println("[E]: index out of bounds in call: '"+method+"' +["+call+"]");
	}
}
