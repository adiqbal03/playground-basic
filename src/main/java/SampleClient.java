import java.util.List;

import ca.uhn.fhir.QueryRecords;
import ca.uhn.fhir.ReadDataFile;
import ca.uhn.fhir.rest.api.CacheControlDirective;

public class SampleClient {

	public static void main(String[] theArgs) {

		ReadDataFile file = new ReadDataFile();
		List<String> readNames = file.readNames();

		if (!readNames.isEmpty()) {
			QueryRecords queryRecords = new QueryRecords();
			for (int i = 0; i < 2; i++) {
				queryRecords.searchByName(readNames.toArray(new String[readNames.size()]));
			}
			queryRecords = new QueryRecords(new CacheControlDirective().setNoCache(true));
			queryRecords.searchByName(readNames.toArray(new String[readNames.size()]));

		}

	}

}
