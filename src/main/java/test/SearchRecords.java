package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import ca.uhn.fhir.QueryRecords;
import ca.uhn.fhir.ReadDataFile;
import ca.uhn.fhir.rest.api.CacheControlDirective;

public class SearchRecords {

	@Test
	public void testReadDataFile() {
		
		ReadDataFile file = new ReadDataFile();
		List<String> readNames = file.readNames();
		assertNotNull(readNames);
	}
	
	@Test
	public void testSearchRecords() {
		
		ReadDataFile file = new ReadDataFile();
		List<String> readNames = file.readNames();
		assertNotNull(readNames);

		if (!readNames.isEmpty()) {
			QueryRecords queryRecords = new QueryRecords();
			for (int i = 0; i < 2; i++) {
				boolean status = queryRecords.searchByName(readNames.toArray(new String[readNames.size()]));
				assertTrue(status);
			}
			queryRecords = new QueryRecords(new CacheControlDirective().setNoCache(true));
			boolean status = queryRecords.searchByName(readNames.toArray(new String[readNames.size()]));
			assertTrue(status);

		}

	}


}
