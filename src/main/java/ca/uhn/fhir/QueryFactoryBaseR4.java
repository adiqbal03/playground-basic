package ca.uhn.fhir;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.api.CacheControlDirective;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.client.interceptor.LoggingInterceptor;

public class QueryFactoryBaseR4 {
	private static final Logger LOG = LoggerFactory.getLogger(QueryFactoryBaseR4.class);
	private static final String URL = "http://hapi.fhir.org/baseR4";
	private ConnectionProperties props;

	public ConnectionProperties init() {
		props = new ConnectionProperties();
		try {
			FhirContext fhirContext = FhirContext.forR4();
			props.setFhirContext(fhirContext);
			IGenericClient client = fhirContext.newRestfulGenericClient(URL);
			client.registerInterceptor(new LoggingInterceptor(false));
			client.registerInterceptor(new TimeInterceptor());
			props.setClient(client);
			props.setCacheControlDirective(new CacheControlDirective().setNoCache(false));
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}

		return props;
	}

}
