package org.javaexpress.http;

/**
 * This enumeration represents the different possible HTTP methods.
 *
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

    /**
     * Create a new HTTPMethod.
     *
     * @param method the method as a String
     */
    HTTPMethod(String method) {
        this.method = method;
    }

    /**
     * Get the method String.
     *
     * @return the method
     */
    public String getMethod() {
        return this.method;
    }

}
