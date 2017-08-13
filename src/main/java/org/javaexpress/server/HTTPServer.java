package org.javaexpress.server;

import org.javaexpress.router.Router;

/**
 * @author Ryan LaClair - rlaclair@bu.edu
 */
public abstract class HTTPServer {

    private int port;
    private Router router;

    public HTTPServer(int port, Router router) {
        this.port = port;
        this.router = router;
    }

    public abstract void start() throws Exception;

    public abstract void stop() throws Exception;

    public int getPort() {
        return port;
    }

    public Router getRouter() {
        return router;
    }
}
