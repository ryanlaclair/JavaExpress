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

    public ExpressResponse append(String field, String value) {
        this.response.addHeader(field, value);

        return this;
    }

    public ExpressResponse location(String path) {
        set("Location", path);

        return this;
    }

    public ExpressResponse redirect(HTTPStatus status, String path) throws IOException {
        this.response.setStatus(status.getValue());
        this.response.sendRedirect(path);

        return this;
    }

    public ExpressResponse send(String body) throws IOException {
        set("Server", "JavaExpress");

        this.response.getWriter().write(body);
        this.response.getWriter().flush();

        return this;
    }

    public ExpressResponse status(HTTPStatus status) {
        this.response.setStatus(status.getValue());

        return this;
    }

    public ExpressResponse set(String field, String value) {
        this.response.setHeader(field, value);

        return this;
    }

    public ExpressResponse type(String type) {
        this.response.setContentType(type);

        return this;
    }

}
