import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ProcessUserInput {
	
	static String[] sentence;
	
	static ArrayList<String[]> history = new ArrayList<>();
	
	public static Queue<String> historyQueue = new LinkedList<>();

	static String type;
	
	static String code;
	
	static boolean done;
	
	public static void getInput() throws IOException {

		Scanner request = new Scanner(System.in);
		
		System.out.println("Enter command: ");
		
		String command = request.nextLine();
		
		sentence = command.split(" ");
		
		if(sentence[0].equals("quit")) {
			
			done = true;
			
			System.out.println("Done");

		}
		
		else if(sentence.length == 1) {
			
			type = sentence[0];
		}
		else {
			
			type = sentence[0];  //what type of content user wants
			
			code = sentence[1]; // zip code or NAICS code
			
		}
		
		history.add(sentence);
		
		recordHistory(command);

	}
	
	public static void recordHistory(String line) {
		
		historyQueue.add(line);
		
	}
	
	public static void showHistory() {
		
		while(historyQueue.size() > 1) {
			
			System.out.println(historyQueue.remove());
			
		}
		
	}
	
	public static void execute() throws IOException { 
		
		
		if(!type.equals("summary") && !type.equals("history")) {
			
			SortInformation.getZipCode(BufferReader.csvData);

			SortInformation.getZipCodeIndex(history.get(history.size()-1)[1]);
			
		}else {
			
			Summary.totalBusiness(BufferReader.csvData);
			
			Summary.getCloedBusinessesCount(BufferReader.csvData);
			
			Summary.getNewBusinessLastYear(BufferReader.csvData);
			
		}
		
		if(history.get(history.size()-1).length == 3 && type.equals("NAICS")) {
		
			Naics.getNaicsCode(BufferReader.csvData);
			
			Naics.compareRange(Integer.parseInt(code));
			
			SortInformation.getNeighborhoods(BufferReader.csvData, Naics.naicsZipcodeIndex);
			
		}
		
		else if(history.get(history.size()-1).length == 3 && type.equals("Zip")){
			
			SortInformation.setTotalBusinessAccount(BufferReader.csvData, SortInformation.zipcodeIndex);
			
			SortInformation.getBusinessType(SortInformation.zipcodeIndex);
			
			SortInformation.getNeighborhoods(BufferReader.csvData, SortInformation.zipcodeIndex);
			
			
		}else if(sentence[0].equals("history")) {
			
			showHistory();
			
		}
		
		printResult();
		
	}
	
	public static void printResult() {
		
		if(type.equals("NAICS")) {
			
			System.out.println("Total businesses: " + Naics.naicsZipcodeIndex.size());
			
			System.out.println("Code: " + Naics.getMailZipCodeCount(BufferReader.csvData));
			
			System.out.println("Neighborhoods: " + SortInformation.getUniqueCount(SortInformation.neighborhoods));
			
		}
		else if(type.equals("Zip")) {
			
			System.out.println("Total businesses: " + SortInformation.totalBusinessCount);
			
			System.out.println("Business type: " + SortInformation.getUniqueCount(SortInformation.businessAccountNumber));
			
			System.out.println("Neighborhoods: " + SortInformation.getUniqueCount(SortInformation.neighborhoods));
			
		}else if(type.equals("summary")) {
			
			System.out.println("total business: "+ Summary.totalBusiness(BufferReader.csvData));
			
			System.out.println("Closed business: " + Summary.closedBusinessCount);
			
			System.out.println("New business last year: " + Summary.newBusinessLastYear);
			
		}else {
			
			showHistory();
			
		}
	}
	
	public static void resetVariables() {
		
		SortInformation.businessAccountNumber = new ArrayList<>();
			
		SortInformation.uniqueBusinessAccountNumber = new ArrayList<>();
		
		SortInformation.zipcode = new ArrayList<>();
		
		SortInformation.zipcodeIndex = new ArrayList<>();
		
		SortInformation.neighborhoods = new ArrayList<>(); 
		
		SortInformation.naic = new ArrayList<>();
		
		SortInformation.businessTypeArrayList = new ArrayList<>();
		
		SortInformation.getBusinessTypeArrayList = new ArrayList<>();
		
		SortInformation.totalBusinessCount = 0;
		
		Naics.mailZipcode = new ArrayList<>();
		
		Naics.tempNaics = new ArrayList<>();
		
		Naics.naicsZipcodeIndex = new ArrayList<>();
		
		Naics.naicsCode = new ArrayList<>();
		
		Summary.cloedBusinesses = new ArrayList<>();
		
		Summary.closedBusinessCount = 0;
		
		Summary.newBusinessLastYear = 0;

	}
}
