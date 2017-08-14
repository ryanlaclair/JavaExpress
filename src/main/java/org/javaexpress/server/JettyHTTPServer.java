package org.javaexpress.server;

import org.eclipse.jetty.server.Server;
import org.javaexpress.router.Router;

/**
 * A Jetty implementation for a HTTPServer subclass.
 *
 * @author Ryan LaClair - rlaclair@bu.edu
 */
public class JettyHTTPServer extends HTTPServer {

    private Server server;

    /**
     * Create a new JettyHTTPServer object.
     *
     * @param port the server port to listen on
     * @param router the router to use for incoming requests
     */
    public JettyHTTPServer(int port, Router router) {
        super(port, router);
    }

    /**
     * Start the server.
     *
     * @throws Exception
     */
    @Override
    public void start() throws Exception {
        this.server = new Server(getPort());
        this.server.setHandler(new JettyHTTPServerHandler(getRouter()));
        this.server.start();
    }

    /**
     * Stop the server.
     *
     * @throws Exception
     */
    @Override
    public void stop() throws Exception {
        if (this.server != null) {
            this.server.stop();
        }
    }

}
