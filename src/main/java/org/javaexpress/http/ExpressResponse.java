package org.javaexpress.http;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ryan LaClair - rlaclair@bu.edu
 */
public class ExpressResponse {

    private HttpServletResponse response;

    public ExpressResponse(HttpServletResponse response) {
        this.response = response;
    }

    public void append(String field, String value) {
        this.response.addHeader(field, value);
    }

    public void location(String path) {
        set("Location", path);
    }

    public void redirect(HTTPStatus status, String path) throws IOException {
        this.response.setStatus(status.getValue());
        this.response.sendRedirect(path);
    }

    public void send(String body) throws IOException {
        set("Server", "JavaExpress");

        this.response.getWriter().write(body);
        this.response.getWriter().flush();
    }

    public void sendStatus(HTTPStatus status) {
        this.response.setStatus(status.getValue());
    }

    public void set(String field, String value) {
        this.response.setHeader(field, value);
    }

    public void type(String type) {
        this.response.setContentType(type);
    }

}
