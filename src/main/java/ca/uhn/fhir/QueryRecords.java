package ca.uhn.fhir;

import java.util.List;

import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Bundle.BundleEntryComponent;
import org.hl7.fhir.r4.model.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.fhir.rest.api.CacheControlDirective;

public class QueryRecords {

	private static final Logger LOG = LoggerFactory.getLogger(QueryRecords.class);
	
	private QueryFactoryBaseR4 quFactoryBaseR4 = new QueryFactoryBaseR4();
	private ConnectionProperties connectionProperties;

	public QueryRecords() {
		connectionProperties = quFactoryBaseR4.init();
	}

	public QueryRecords(CacheControlDirective cacheControlDirective) {
		connectionProperties = quFactoryBaseR4.init();
		connectionProperties.setCacheControlDirective(cacheControlDirective);
	}

	private boolean query(String... names) {

		boolean success = false;
		if (names != null) {
			Bundle response = connectionProperties.getClient()
					.search().forResource("Patient")
					.where(Patient.FAMILY.matches().values(names))
					.returnBundle(Bundle.class)
					.cacheControl(connectionProperties.getCacheControlDirective())
					.execute();
			List<BundleEntryComponent> entry = response.getEntry();
			LOG.debug("Record Size:", entry.size());
			if(entry != null || !entry.isEmpty()) {
				success = true;
			}
			
		}
		return success;
	}

	public boolean searchByName(String... names) {
		return query(names);

	}

}
