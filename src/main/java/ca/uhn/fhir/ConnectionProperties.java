package ca.uhn.fhir;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.api.CacheControlDirective;
import ca.uhn.fhir.rest.client.api.IGenericClient;

public class ConnectionProperties {
	
	private FhirContext fhirContext;
	private IGenericClient client;
	private CacheControlDirective cacheControlDirective;
	
	public FhirContext getFhirContext() {
		return fhirContext;
	}
	public void setFhirContext(FhirContext fhirContext) {
		this.fhirContext = fhirContext;
	}
	public IGenericClient getClient() {
		return client;
	}
	public void setClient(IGenericClient client) {
		this.client = client;
	}
	public CacheControlDirective getCacheControlDirective() {
		return cacheControlDirective;
	}
	public void setCacheControlDirective(CacheControlDirective cacheControlDirective) {
		this.cacheControlDirective = cacheControlDirective;
	}
	
	

}
