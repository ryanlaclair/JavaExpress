package org.javaexpress.http;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * An ExpressResponse wraps a HttpServletResponse, and mimics the API of
 * an Express JS Response object.
 *
 * @author Ryan LaClair - rlaclair@bu.edu
 */
public class ExpressResponse {

    private HttpServletResponse response;

    /**
     * Create a new ExpressResponse.
     *
     * @param response the HttpServletResponse being wrapped
     */
    public ExpressResponse(HttpServletResponse response) {
        this.response = response;

        // set the default content type
        this.response.setContentType("text/plain");
    }

    /**
     * Append a value to a field in the HTTP response header.
     *
     * @param field the field
     * @param value the value to append
     * @return the ExpressResponse object
     */
    public ExpressResponse append(String field, String value) {
        this.response.addHeader(field, value);

        return this;
    }

    /**
     * Set the Location in the response header.
     *
     * @param path the location to set
     * @return the ExpressResponse object
     */
    public ExpressResponse location(String path) {
        set("Location", path);

        return this;
    }

    /**
     * Redirect to the specified URL.
     *
     * @param status the HTTP status to return
     * @param path the redirection path
     * @return the ExpressResponse object
     * @throws IOException
     */
    public ExpressResponse redirect(HTTPStatus status, String path) throws IOException {
        this.response.setStatus(status.getValue());
        this.response.sendRedirect(path);

        return this;
    }

    /**
     * Send the HTTP response.
     *
     * @param body the response body as a String
     * @return the ExpressResponse object
     * @throws IOException
     */
    public ExpressResponse send(String body) throws IOException {
        set("Server", "JavaExpress");

        this.response.getWriter().write(body);
        this.response.getWriter().flush();

        return this;
    }

    /**
     * Set the specified header field to the given value.
     *
     * @param field the field to be set
     * @param value the value
     * @return the ExpressResponse object
     */
    public ExpressResponse set(String field, String value) {
        this.response.setHeader(field, value);

        return this;
    }

    /**
     * Set the HTTP status for the response.
     *
     * @param status the HTTP status to set
     * @return the ExpressResponse object
     */
    public ExpressResponse status(HTTPStatus status) {
        this.response.setStatus(status.getValue());

        return this;
    }

    /**
     * Set the content-type for the response body.
     *
     * @param type the content-type
     * @return the ExpressResponse object
     */
    public ExpressResponse type(String type) {
        this.response.setContentType(type);

        return this;
    }

}
