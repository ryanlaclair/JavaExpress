package org.javaexpress.router;

import org.javaexpress.http.ExpressRequest;
import org.javaexpress.http.ExpressResponse;

import java.io.IOException;

/**
 * @author Ryan LaClair - rlaclair@bu.edu
 */
public interface RouteHandler {

    public void handle(ExpressRequest req, ExpressResponse res) throws IOException;

}
