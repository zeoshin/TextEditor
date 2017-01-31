package spelling;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.regex.Pattern;

/**
 * @author UC San Diego Intermediate MOOC team
 *
 */
public class DictionaryBST implements Dictionary 
{
   private TreeSet<String> dict;
	
    // TODO: Implement the dictionary interface using a TreeSet.  
 	// You'll need a constructor here
	public DictionaryBST() {
		dict = new TreeSet<String>();
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
    	Iterator<String> iterator = dict.iterator();
    	String current = "";
    	while(iterator.hasNext()) {
    		current = iterator.next();
    		System.out.println(current);
    	}
    }

}
