package org.javaexpress.server;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.javaexpress.http.ExpressRequest;
import org.javaexpress.http.ExpressResponse;
import org.javaexpress.router.Router;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * A handler class for incoming connections to the JettyHTTPServer, which
 * is a subclass of the Jetty AbstractHandler.
 *
 * @author Ryan LaClair - rlaclair@bu.edu
 */
public class JettyHTTPServerHandler extends AbstractHandler {

    private Router router;

    /**
     * Create a new JettyHTTPServerHandler.
     *
     * @param router the router to use to handle the incoming request
     */
    public JettyHTTPServerHandler(Router router) {
        this.router = router;
    }

    /**
     * Handle the incoming connection to the server.
     *
     * @param s the target of the request
     * @param request the original Request object
     * @param httpServletRequest the HttpServeletRequest received
     * @param httpServletResponse the HttpServeletResponse to be sent
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void handle(String s, Request request, HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse) throws IOException, ServletException {

        ExpressRequest req = new ExpressRequest(request);
        ExpressResponse res = new ExpressResponse(httpServletResponse);

        this.router.route(req, res);
    }
}
