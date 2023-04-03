

import java.util.ArrayList;

public class Summary {
	
	public static ArrayList<String> cloedBusinesses = new ArrayList<>();
	
	public static ArrayList<String> newBusiness = new ArrayList<>();
	
	public static int closedBusinessCount = 0;
	
	public static int newBusinessLastYear = 0;
	
	
	public static int totalBusiness(ArrayList<String[]> originalArrayList) {  
		
		return originalArrayList.size();
		
	}
	
	public static void getCloedBusinessesCount(ArrayList<String[]> originalArrayList) {
		
		for (int i = 0; i < originalArrayList.size(); i++) {
			
			cloedBusinesses.add(originalArrayList.get(i)[9]);
			
		}
		
		for (int i = 0; i < cloedBusinesses.size(); i++) {
			
			if(!cloedBusinesses.get(i).equals("")) {
				
				closedBusinessCount ++;
			}
		}
		
	}
	
	public static void getNewBusinessLastYear(ArrayList<String[]> originArrayList){
		
		for (int i = 0; i < originArrayList.size(); i++) {
			
			String[] line = originArrayList.get(i)[8].split("/");
			
			if(line[2].equals("2022")) {  
				
				newBusiness.add(line[2]);
			}
			
		}
		
		newBusinessLastYear = newBusiness.size();
		
	}

}
