package org.javaexpress.http;

import org.eclipse.jetty.server.Request;
import org.javaexpress.router.Route;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Ryan LaClair - rlaclair@bu.edu
 */
public class ExpressRequest {

    private Request request;
    private Route route = null;

    public ExpressRequest(Request request) {
        this.request = request;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public String body() throws IOException {
        return this.request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
    }

    public String hostname() {
        return this.request.getRemoteHost();
    }

    public HTTPMethod method() {
        return HTTPMethod.valueOf(this.request.getMethod().toUpperCase());
    }

    public Map<String, String> params() {
        Map<String, String> params = new HashMap<String, String>();

        String[] routeParts = route.getPath().split("/");
        String[] pathParts = path().split("/");

        for (int i=0; i<routeParts.length; i++) {
            if (routeParts[i].startsWith(":")) {
                params.put(routeParts[i].substring(1), pathParts[i]);
            }
        }

        return params;
    }

    public String path() {
        return this.request.getPathInfo();
    }

    public String protocol() {
        return this.request.getProtocol();
    }

    public Map<String, String[]> query() {
        return this.request.getParameterMap();
    }

}
