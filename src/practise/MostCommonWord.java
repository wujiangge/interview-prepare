package practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


// June
public class MostCommonWord {
	
	public static void main(String []args){
		Set<String> exclusives = new HashSet<>();
		exclusives.add("a");
		exclusives.add("is");
		exclusives.add("as");
		exclusives.add("the");
		exclusives.add("and");
		
		String sentence1 = "white rose's is a flower red rose aslo is a flower."; // [rose, flower]
		String sentence2 = "I am Jack and my father is Jimmy. I like wearing Jack and Jone's."; // [I, Jack]
		
		printList(getWords(sentence1, exclusives));
		printList(getWords(sentence2, exclusives));
	}
	
	public static void printList(List<String> words){
		for(String str : words){
			System.out.println(str+ ",");
		}
	}
	
	public static List<String> getWords(String sentence, Set<String> exclusives){
		List<String> result = new ArrayList<>();
		Map<String, Integer> tmp = new HashMap<>();
		String [] words = sentence.trim().split("([\\s|,|.|']\\s*)");
		System.out.println(Arrays.toString(words));
		for(int i = 0; i < words.length; i ++){
			if(exclusives.contains(words[i])){
				continue;
			}
			if(tmp.get(words[i]) != null){
				tmp.put(words[i], tmp.get(words[i]) + 1);
				if(result.contains(words[i]) || tmp.get(result.get(0)) < tmp.get(words[i])){
					 result.clear();
					 result.add(words[i]);
				}else if(tmp.get(result.get(0)) == tmp.get(words[i])){
					 result.add(words[i]);
				 }
			}else{
				tmp.put(words[i], 1);
				if(result.isEmpty()){
					result.add(words[i]);
				}
			}
		}
		return result;
	}
}
