package Walmart;

public class alienDictionary_leetcdoe953 {
	
public static boolean isAlienSorted(String[] words, String order) {
        
        
        int[] charIndices = new int[26];
        
        char[] orderArr = order.toCharArray();
        
        for(int i=0; i<orderArr.length; i++) {
            charIndices[orderArr[i] - 'a'] = i;
        }
        
        for(int i=0; i<words.length-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
             boolean sorted = false; 
            for(int j=0; j<Math.min(word1.length(), word2.length()); j++) {
               
                if(word1.charAt(j) != word2.charAt(j)) {
                    if(charIndices[word1.charAt(j)-'a'] > charIndices[word2.charAt(j)-'a'])
                        return false;
                    sorted = true;
                    break;
                }
            }
            
            if(sorted)
                continue;
            
            else if(word1.length() > word2.length())
                return false;
        }
        
        return true;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] words = {"hello","leetcode"};
		String order = "hlabcdefgijkmnopqrstuvwxyz";
		
		System.out.println(isAlienSorted(words, order));

	}

}
