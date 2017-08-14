package org.javaexpress.router;

import org.javaexpress.http.ExpressRequest;
import org.javaexpress.http.ExpressResponse;

import java.io.IOException;

/**
 * This is an interface designed to mimic the Express JS callbacks used to
 * handle route requests. It can be implemented with Java8 lambda functions
 * to give the same feel as a JavaScript callback function.
 *
 * @author Ryan LaClair - rlaclair@bu.edu
 */
public interface RouteHandler {

    /**
     * Handle a request to a Route.
     *
     * @param req the ExpressRequest object
     * @param res the ExpressResponse object
     * @throws IOException
     */
    public void handle(ExpressRequest req, ExpressResponse res) throws IOException;

}
