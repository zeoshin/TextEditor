package spelling;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Pattern;

/**
 * A class that implements the Dictionary interface using a LinkedList
 *
 */
public class DictionaryLL implements Dictionary 
{

	private LinkedList<String> dict;
	
    // TODO: Add a constructor
	public DictionaryLL() {
		dict = new LinkedList<String>();
	}

    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
    public boolean addWord(String word) {
    	// TODO: Implement this method
    	if (!Pattern.matches("[a-z]+(')*(s|t|re)*", word.toLowerCase())) return false;
    	boolean isNewWord = !isWord(word.toLowerCase());
    	if (isNewWord) dict.add(word.toLowerCase());
        return isNewWord;
    }


    /** Return the number of words in the dictionary */
    public int size()
    {
        // TODO: Implement this method
        return dict.size();
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {
        //TODO: Implement this method
    	return dict.contains(s.toLowerCase());
    }
    
    public void printout(){
    	for (int i = 0; i < dict.size(); i++) {
    		System.out.println(dict.get(i));
    	}
    }
}
