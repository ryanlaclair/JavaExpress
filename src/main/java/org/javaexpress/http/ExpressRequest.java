package org.javaexpress.http;

import org.eclipse.jetty.server.Request;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * @author Ryan LaClair - rlaclair@bu.edu
 */
public class ExpressRequest {

    private String body;
    private String hostname;
    private HTTPMethod method;
    private Map<String, String> params;
    private String path;
    private String protocol;
    private Map<String, String[]> query;

    public ExpressRequest(Request request) throws IOException {
        this.body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        this.hostname = request.getRemoteHost();
        this.method = HTTPMethod.valueOf(request.getMethod().toUpperCase());
        this.params = new HashMap<String, String>();
        this.path = request.getPathInfo();
        this.protocol = request.getProtocol();
        this.query = request.getParameterMap();

        parseParams();
    }

    public String body() {
        return this.body;
    }

    public String hostname() {
        return this.hostname;
    }

    public HTTPMethod method() {
        return this.method;
    }

    public Map<String, String> params() {
        return this.params;
    }

    public String path() {
        return this.path;
    }

    public String protocol() {
        return this.protocol;
    }

    public Map<String, String[]> query() {
        return this.query;
    }

    private void parseParams() {
        // parse the route parameters
    }

}
