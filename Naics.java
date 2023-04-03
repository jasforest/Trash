

import java.util.ArrayList;

public class Naics{
	
	static ArrayList<String> tempNaics = new ArrayList<>();
	
	static ArrayList<String[]> naicsCode = new ArrayList<>();
	
	static ArrayList<Integer> naicsZipcodeIndex = new ArrayList<>();
	
	static ArrayList<String> mailZipcode = new ArrayList<>();
	
	static int lowerBound = 0;
	
	static int higherBound = 0;
	
	static String[] tempStrings;
	
	public static void getNaicsCode(ArrayList<String[]> originalArrayList) {  //Insert all the naics code in an arraylist
		
		for (int i = 0; i < originalArrayList.size(); i++) {
			
			tempNaics.add(originalArrayList.get(i)[16]);
			
		}
		
		for (int i = 0; i < tempNaics.size(); i++) {
			
			tempStrings = tempNaics.get(i).split("[\\s-]+");
			
			naicsCode.add(tempStrings);
		}
		
	}
	public static void compareRange(int naicsNumber) { //find the range of the naics code and insert their indices
		
		for (int i = 0; i < naicsCode.size(); i++) {
			
			for(int j = 0; j < naicsCode.get(i).length-1; j++) {

				if(j % 2 == 0 && naicsCode.get(i).length > 1) { // if the index in even
					
					lowerBound = Integer.parseInt(naicsCode.get(i)[j]);
					
					higherBound = Integer.parseInt(naicsCode.get(i)[j+1]);
						
					if(naicsNumber >= lowerBound && naicsNumber <= higherBound) { 
						
						naicsZipcodeIndex.add(i);
						
						break;
					}
					
				}
				
			}
			
		}
		
	}
	public static int getMailZipCodeCount(ArrayList<String[]> originArrayList) {  // function that get the unique count of mail zip code
		
		ArrayList<String> tempArrayList = new ArrayList<>();
		
		for (int i = 0; i < originArrayList.size(); i++) {
			
			mailZipcode.add(originArrayList.get(i)[14]);
			
		}
		
		MyIterator<Integer> myIterator = new MyIterator<>(naicsZipcodeIndex);
		 
		 while (myIterator.hasNext()) {
			 
		        Integer element = myIterator.next();
		        	
		        int position = 0;
		        	
		        tempArrayList.add(mailZipcode.get(naicsZipcodeIndex.get(position++)));
					
		}
		      
		mailZipcode = tempArrayList;
		
		return SortInformation.getUniqueCount(mailZipcode);
		
	}
	
	
}
















