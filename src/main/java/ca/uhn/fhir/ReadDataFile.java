package ca.uhn.fhir;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadDataFile {

	private List<String> list;

	public List<String> readNames() {

		
		try {
			InputStream resourceAsStream = getClass().getResourceAsStream("Names.txt");
			if(resourceAsStream != null) {
				list = new ArrayList<String>();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));

			String strLine;
			while ((strLine = bufferedReader.readLine()) != null) {
				list.add(strLine);
			}
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		return list;
	}

}
