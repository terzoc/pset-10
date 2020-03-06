import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class Utils {
	 /**
     * Needed to obtain resources (such as words.json) from the classpath's directory
     * @return string that returns the directory in the classpath with required resources
     */
    public static String getClasspathDir() {
        String classpath = System.getProperty("java.class.path", ".");
        boolean windows = false;
        if (classpath.matches(".*\\\\.*")) {
            windows = true;
        }
        if (windows) {
            String[] splitClasspathDir = classpath.split(";");
            String classpathDirectory = "";
            for (String s : splitClasspathDir) {
                if (s.matches(".*lib\\\\.*")) {
                    classpathDirectory = s;
                }
            }
            return classpathDirectory;
        }else {
            String[] splitClasspathDir = classpath.split(":");
            String classpathDirectory = "";
            for (String s : splitClasspathDir) {
                if (s.matches(".*lib/.*")) {
                    classpathDirectory = s;
                }
            }
            return classpathDirectory;
        }
    }    

    public static Words[] sortAscending(Words[] words, ArrayList<byte[]> asciiArray) {
        for (int i = 0; i < asciiArray.size() - 1; i++) {
            for (int j = 0; j < asciiArray.size()-1-i; j++) {
                if (asciiArray.get(j)[0] > asciiArray.get(j+1)[0]) {
                    byte[] temp = asciiArray.get(j);
                    asciiArray.set(j, asciiArray.get(j+1));
                    asciiArray.set(j + 1, temp);
                    Words temp2 = words[j];
                    words[j] = words[j+1];
                    words[j+1] = temp2;
                //99% sure it will stop working if I add a one letter word
                }else if (asciiArray.get(j)[0] == asciiArray.get(j+1)[0]) {
                    if (asciiArray.get(j)[1] > asciiArray.get(j+1)[1]) { 
                        byte[] temp = asciiArray.get(j);
                        asciiArray.set(j, asciiArray.get(j+1));
                        asciiArray.set(j + 1, temp);
                        Words temp2 = words[j];
                        words[j] = words[j+1];
                        words[j+1] = temp2;
                    }
                }
            }
        }
        return words;
    }

    public static Words[] reverse(Words a[], int n) 
    { 
        Words[] b = new Words[n]; 
        int j = n; 
        for (int i = 0; i < n; i++) { 
            b[j - 1] = a[i]; 
            j = j - 1; 
        } 
        return b;
    }

	public static DefaultListModel<String> sortWordsAsc(DefaultListModel<String> listOfWords) {
		String temp;
		int n = listOfWords.getSize();
		for (int i = 0; i < n; i++) 
        {
            for (int j = i + 1; j < n; j++) 
            {
                if ((listOfWords.get(i).compareTo(listOfWords.get(j)) > 0)) 
                {
                    temp = listOfWords.get(i);
                    listOfWords.set(i, listOfWords.get(j));
                    listOfWords.set(j, temp);
                }
            }
        }
		return listOfWords;
	} 

}
