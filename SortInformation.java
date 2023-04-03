
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class SortInformation {
	
	public static ArrayList<String> businessAccountNumber = new ArrayList<>();
	
	public static ArrayList<Integer> uniqueBusinessAccountNumber = new ArrayList<>();
	
	public static ArrayList<String> businessTypeArrayList = new ArrayList<>(); 
	
	public static ArrayList<String> getBusinessTypeArrayList = new ArrayList<>(); 

	public static ArrayList<String> neighborhoods = new ArrayList<>();
	
	public static ArrayList<String> zipcode = new ArrayList<>();
	
	public static ArrayList<Integer> zipcodeIndex = new ArrayList<>();
	
	public static ArrayList<String> naic = new ArrayList<>();
	
	public static ArrayList<Integer> naicIndex = new ArrayList<>();
	
	static int totalBusinessCount = 0;
	
	public static void getZipCode(ArrayList<String[]> originalArrayList) {  //append all the zip code into this arraylist
		
		for (int i = 0; i < originalArrayList.size(); i++) {
					
			zipcode.add(originalArrayList.get(i)[7]);  //extra number part
		}
		
	}
	
	public static void getZipCodeIndex(String userProvidedZipcode) {// extra the index of zip code requested by the user
		
		for(int i = 0; i < zipcode.size(); i++) {
			
			if(zipcode.get(i).equals(userProvidedZipcode)) {
				
				zipcodeIndex.add(i);
			}	
		}
	}
	
	
	public static void getNaics(ArrayList<String[]> originalArrayList) {

		for (int i = 0; i < originalArrayList.size(); i++) {
					
			naic.add(originalArrayList.get(i)[16]);  //extra number part
		}
		
	}
	
	public static void getNaicsIndex(String naicsCode) {
		
		for(int i = 0; i < naic.size(); i++) {
			
			if(naic.get(i).equals(naicsCode)) {
				
				naicIndex.add(i);
			}	
		}
	}

	public static void setTotalBusinessAccount(ArrayList<String[]> originalArrayList, ArrayList<Integer> zipcodeIndices) { // all the businessaccount associated with 94108 for example. 
		
		ArrayList<String> tempArraylist = new ArrayList<>();
		
		for (int i = 0; i < originalArrayList.size(); i++) {
			
			businessAccountNumber.add(originalArrayList.get(i)[1]);
			
			getBusinessTypeArrayList.add(originalArrayList.get(i)[17]);
			
		}
		
		for (int i = 0; i < zipcodeIndices.size(); i++) {
			
			tempArraylist.add(businessAccountNumber.get(zipcodeIndices.get(i)));
			
		}

		businessAccountNumber = tempArraylist;
		
		totalBusinessCount = businessAccountNumber.size();
		
	}
	public static int getBusinessType(ArrayList<Integer> zipcodeIndices) {
		
		for (int i = 0; i < zipcodeIndices.size(); i++) {
			
			getBusinessTypeArrayList.add(getBusinessTypeArrayList.get(zipcodeIndices.get(i)));
			
		}
		
		return (getUniqueCount(businessTypeArrayList));
	}
	
	public static int getUniqueCount(ArrayList<String> anyArraylist) {
		
		Map<String, Integer> countMap = new HashMap<String, Integer>();
		
        for (String element : anyArraylist) {
        	
            if (countMap.containsKey(element)) {
            	
                int count = countMap.get(element);
                
                countMap.put(element, count + 1);
                
            } else {
            	
                countMap.put(element, 1);
            }
        }

         int uniqueCount = countMap.size();
         
         return uniqueCount;

	}
	
	public static int getNeighborhoods(ArrayList<String[]> giveArrayList, ArrayList<Integer> zipcodeIndexArrayList) { //Arraylist with neighborhoods corresponds to zipcode
		
		ArrayList<String> tempArrayList = new ArrayList<>();

		for (int i = 0; i < giveArrayList.size(); i++) {
			
			neighborhoods.add(giveArrayList.get(i)[23]);
		}
		
		for (int i = 0; i < zipcodeIndexArrayList.size(); i++) {
			
			tempArrayList.add(neighborhoods.get(zipcodeIndexArrayList.get(i)));
			
		}
		neighborhoods = tempArrayList;
		
		return getUniqueCount(neighborhoods);

	}

}








