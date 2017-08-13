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
 * @author Ryan LaClair - rlaclair@bu.edu
 */
public class JettyHTTPServerHandler extends AbstractHandler {

    private Router router;

    public JettyHTTPServerHandler(Router router) {
        this.router = router;
    }

    @Override
    public void handle(String s, Request request, HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse) throws IOException, ServletException {

        ExpressRequest req = new ExpressRequest(request);
        ExpressResponse res = new ExpressResponse(httpServletResponse);

        this.router.route(req, res);
    }
}
