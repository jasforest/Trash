

import java.io.IOException;

public class RunCode {

	public static void main(String[] args) throws IOException {
		
		BufferReader.bufferFile("BusinessData.csv");
		
		while(ProcessUserInput.done == false) {
			
			ProcessUserInput.getInput();
			
			if(ProcessUserInput.done != true) {
				
				ProcessUserInput.execute();
				
				ProcessUserInput.resetVariables();
			}
			
			
			
		}
		
	}

}
