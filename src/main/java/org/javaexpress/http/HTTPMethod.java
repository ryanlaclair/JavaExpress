package org.javaexpress.http;

/**
 * @author Ryan LaClair - rlaclair@bu.edu
 */
public enum HTTPMethod {

    GET("GET"),
    HEAD("HEAD"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE"),
    CONNECT("CONNECT"),
    OPTIONS("OPTIONS"),
    TRACE("TRACE");

    private String method;

    HTTPMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return this.method;
    }

}
