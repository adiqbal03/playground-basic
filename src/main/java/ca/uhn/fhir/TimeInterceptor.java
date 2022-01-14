package ca.uhn.fhir;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.fhir.rest.client.api.IClientInterceptor;
import ca.uhn.fhir.rest.client.api.IHttpRequest;
import ca.uhn.fhir.rest.client.api.IHttpResponse;

public class TimeInterceptor implements IClientInterceptor{
	private static final Logger LOG = LoggerFactory.getLogger(TimeInterceptor.class);


	@Override
	public void interceptRequest(IHttpRequest theRequest) {
	
	}

	@Override
	public void interceptResponse(IHttpResponse theResponse) throws IOException {
		String timing = " in " + theResponse.getRequestStopWatch().toString();
		LOG.info("Response Time: {}", timing);
		
		
	}

}
