# Radcode
Java RAD (Rapid Development) library that simplifies the development of complex applications.

Radcode contains the following classes:
  - ArrayLib: class that performs various operations with arrays.
  - Files: simplified input-output interaction.
  - ListParser / ListWriter: class for reading / saving data as a list. 
  - PV (Property-Value) Parser / PV-Writer: class for reading / storing property-value type data.
  - Net: class for downloading files.
  - Zipper: class for zip/unzip files.
  - Utils: class for simple utilities (get home location, decoding/encoding text, string parser)
  
-------------------------------------------------------------------------------------------------

Radcode API
- ArrayLib
```java
remove(DefaultListModel<String> arg) void 
// Safe removing the element
remove(ArrayList<String> arg) void

set(DefaultListModel<String> arg) void 
// Safe setting the element
set(ArrayList<String> arg) void

get(DefaultListModel<String> arg, int index) String
// Safe getting the element
get(ArrayList<String> arg, int index) String

swap(DefaultListModel<String> arg, int swap_from, int swap_to) void
// Swappping the element
swap(ArrayList<String> arg, int swap_from, int swap_to) void

fill(DefaultListModel<String> to_fill, ArrayList<String> fill_from) void
// Filling the element
fill(ArrayList<String> to_fill, DefaultListModel<String> fill_from) void

fill(DefaultListModel<String> to_fill, String[] fill_from) void

fill(DefaultListModel<String> to_fill, String[] fill_from, String except) void

fill(ArrayList<String> to_fill, ArrayList<String> fill_from) void

fill(ArrayList<String> to_fill, ArrayList<String> fill_from, String[] except) void

fill(ArrayList<String> to_fill, String[] fill_from, String[] except) void

fill(ArrayList<String> to_fill, String[] fill_from, String except) void

fill(ArrayList<String> list_to, ArrayList<String fill_from,  String except) void

fill(ArrayList<String> fill_from, String[] to_fill) void

arrange(DefaultListModel<String> list_model, ArrayList<String> array, int az_za) void
// Change the sequence of elements
arrange(ArrayList<String> array_list_from, ArrayList<String> array_list_to, int az_za)

list2array(DefaultListModel<String> list) String[]
// Type conversion
array2list(String[] array) DefaultListModel<String>

list2array(ArrayList<String> list) String[]

charr2str(char array[]) String
```
- Files
```java
create_file(String path, String list) void

get_file(String path) String

file_exists(String path) boolean

mkdir(String path) boolean

get_folders(String path) String[]

rename(String name, String new_name) void
```
- ListParser / ListWriter
```java
parse_list(String path) String[]

write_list(String path, String[] list) void
```
- PV-Parser / PV-Writer
```java
parse(String path) boolean

write(String path, ArrayList<String> properties, ArrayList<String> values, ArrayList<String> comments, ArrayList<Integer> line) void

write(String path, ArrayList<String> properties, ArrayList<String> values) void
```
- Zipper
```java
zip(Path source) throws IOException void

unzip(Path source, Path target, String entry_name) throws IOException void
```
- Utils
```java
get_home() String

parse_string(String string, char separator) String

encrypt(String text, int key) String

String decrypt(String text, int key) String
```
