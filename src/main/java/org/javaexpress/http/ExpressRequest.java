package org.javaexpress.http;

import org.javaexpress.router.Route;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * An ExpressRequest wraps a HttpServeletRequest, and mimics the API of
 * an Express JS Request object.
 *
 * @author Ryan LaClair - rlaclair@bu.edu
 */
public class ExpressRequest {

    private HttpServletRequest request;
    private Route route = null;

    /**
     * Create a new ExpressRequest.
     *
     * @param request the HttpServletRequest being wrapped
     */
    public ExpressRequest(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * Set the route found for the request.
     *
     * @param route the route
     */
    public void setRoute(Route route) {
        this.route = route;
    }

    /**
     * Get the request body.
     *
     * @return a String containing the request body
     * @throws IOException
     */
    public String body() throws IOException {
        return this.request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
    }

    /**
     * Get the hostname from where the request originated.
     *
     * @return the String hostname
     */
    public String hostname() {
        return this.request.getRemoteHost();
    }

    /**
     * Get the HTTP method of the request.
     *
     * @return the method
     */
    public HTTPMethod method() {
        return HTTPMethod.valueOf(this.request.getMethod().toUpperCase());
    }

    /**
     * Get the properties mapped to the named route parameters.
     *
     * @return the parameters
     */
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

    /**
     * Get the path part of the request URL.
     *
     * @return the path
     */
    public String path() {
        return this.request.getPathInfo();
    }

    /**
     * Get the request protocol (either http or https).
     *
     * @return the protocol
     */
    public String protocol() {
        return this.request.getProtocol();
    }

    /**
     * The properties matched to the URL query string in the route.
     *
     * @return the query string properties
     */
    public Map<String, String[]> query() {
        return this.request.getParameterMap();
    }

}
