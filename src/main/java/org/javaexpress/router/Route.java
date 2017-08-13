package org.javaexpress.router;

import org.javaexpress.http.HTTPMethod;

/**
 * @author Ryan LaClair - rlaclair@bu.edu
 */
public class Route {

    private String path;
    private HTTPMethod method;
    private RouteHandler handler;

    public Route(String path, HTTPMethod method, RouteHandler handler) {
        this.path = path;
        this.method = method;
        this.handler = handler;
    }

    public String getPath() {
        return path;
    }

    public HTTPMethod getMethod() {
        return method;
    }

    public RouteHandler getHandler() {
        return handler;
    }

}
