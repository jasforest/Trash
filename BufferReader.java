

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class BufferReader {

	public static ArrayList<String[]> csvData = new ArrayList<>();
	 
	public static void bufferFile(String fileName) throws IOException {
			
		BufferedReader br = null;

		String line = "";
       
        String csvDelimiter = ",";

	try {
		
		br = new BufferedReader(new FileReader(fileName));
		
		 line = br.readLine();
		 
		while((line = br.readLine()) != null) {
			
			 line = br.readLine();
				
			 String[] csvRow = line.split(csvDelimiter + "(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);  //keeps the comma inside double quotation
			 
			 for (int j = 0; j < csvRow.length; j++) {
				 
		            csvRow[j] = csvRow[j].replaceAll("\"", "");
		        }
	         
	         csvData.add(csvRow);// csvData will store all the information
			
		}
		 
				 
		} catch (IOException e) {
			
			e.printStackTrace();
	
		}
		
		br.close();

	 }

}
