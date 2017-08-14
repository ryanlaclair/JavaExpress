package org.javaexpress.server;

import org.javaexpress.router.Router;

/**
 * An abstract HTTP server that has a port and router.
 *
 * @author Ryan LaClair - rlaclair@bu.edu
 */
public abstract class HTTPServer {

    private int port;
    private Router router;

    /**
     * Create a new HTTPServer.
     *
     * @param port the port to listen for connections on
     * @param router the router to use to route requests
     */
    public HTTPServer(int port, Router router) {
        this.port = port;
        this.router = router;
    }

    /**
     * Start the server. To be implemented by subclasses.
     *
     * @throws Exception
     */
    public abstract void start() throws Exception;

    /**
     * Stop the server. To be implemented by subclasses.
     *
     * @throws Exception
     */
    public abstract void stop() throws Exception;

    /**
     * Get the server port.
     *
     * @return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * Get the server Router.
     *
     * @return the Router
     */
    public Router getRouter() {
        return router;
    }

}
