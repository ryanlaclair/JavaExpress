package org.javaexpress.router;

import org.javaexpress.http.HTTPMethod;

/**
 * This class holds a HTTP route to be responded to by the server.
 *
 * @author Ryan LaClair - rlaclair@bu.edu
 */
public class Route {

    private String path;
    private HTTPMethod method;
    private RouteHandler handler;

    /**
     * Create a new Route object.
     *
     * @param path the path
     * @param method the HTTP method
     * @param handler the RouteHandler for the Route
     */
    public Route(String path, HTTPMethod method, RouteHandler handler) {
        this.path = path;
        this.method = method;
        this.handler = handler;
    }

    /**
     * Get the path.
     *
     * @return the String path
     */
    public String getPath() {
        return path;
    }

    /**
     * get the HTTP method.
     *
     * @return the HTTP method
     */
    public HTTPMethod getMethod() {
        return method;
    }

    /**
     * Get the RouteHandler.
     *
     * @return the RouteHandler
     */
    public RouteHandler getHandler() {
        return handler;
    }

}
