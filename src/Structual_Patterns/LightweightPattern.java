package Structual_Patterns;

import java.util.HashMap;
import java.util.Map;

public class LightweightPattern {
	
	public static interface CharacterDisplay {
		void display(int index);
	}
	
	public static class ConcreteCharacter implements CharacterDisplay { 
		
		private char currentCharacter; 
		
		public ConcreteCharacter(char currentCharacter) {
			this.currentCharacter = currentCharacter;
		}
		
		
		@Override
		public void display(int index) {
			System.out.println("Character: " + this.currentCharacter + " at: " + index);
		}
	}
	
	public static class LightweightCharacter {
		private Map<Character, CharacterDisplay> mapCharater = new HashMap<Character, CharacterDisplay>();
		
		public CharacterDisplay getCharacter(Character c) {
			if (!mapCharater.containsKey(c)) {
				mapCharater.put(c, new ConcreteCharacter(c));
			}
			return mapCharater.get(c);
		}
		
		
	}
	
	
	public static void main(String[] args) {
		String testStr = "ABBCCCDDD";
		char[] chars = testStr.toCharArray();
		LightweightCharacter characterFactory = new LightweightCharacter();
		for (int i = 0; i < chars.length; i++) {
			CharacterDisplay charc = characterFactory.getCharacter(chars[i]);
			charc.display(i + 1);
		}

	}

}
