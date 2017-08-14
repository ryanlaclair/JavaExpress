package org.javaexpress;

import org.javaexpress.router.RouteHandler;
import org.javaexpress.router.Router;
import org.javaexpress.server.HTTPServer;
import org.javaexpress.server.JettyHTTPServer;

/**
 * This class holds the main JavaExpress server and router. It is designed to
 * mimic the Express JS API.
 *
 * @author Ryan LaClair - rlaclair@bu.edu
 */
public class JavaExpress {

    private HTTPServer server;
    private Router router = new Router();

    /**
     * Create the HTTP server and listen on the specified port for incoming
     * connections.
     *
     * @param port the port to listen on for connections
     * @throws Exception
     */
    public void listen(int port) throws Exception {
        this.server = new JettyHTTPServer(port, this.router);
        this.server.start();
    }

    /**
     * Add a GET route to the Router list.
     *
     * @param path the Route URL
     * @param handler the RouteHandler
     */
    public void get(String path, RouteHandler handler) {
        router.get(path, handler);
    }

    /**
     * Add a HEAD route to the Router list.
     *
     * @param path the Route URL
     * @param handler the RouteHandler
     */
    public void head(String path, RouteHandler handler) {
        router.head(path, handler);
    }

    /**
     * Add a POST route to the Router list.
     *
     * @param path the Route URL
     * @param handler the RouteHandler
     */
    public void post(String path, RouteHandler handler) {
        router.post(path, handler);
    }

    /**
     * Add a PUT route to the Router list.
     *
     * @param path the Route URL
     * @param handler the RouteHandler
     */
    public void put(String path, RouteHandler handler) {
        router.put(path, handler);
    }

    /**
     * Add a DELETE route to the Router list.
     *
     * @param path the Route URL
     * @param handler the RouteHandler
     */
    public void delete(String path, RouteHandler handler) {
        router.delete(path, handler);
    }

    /**
     * Add a CONNECT route to the Router list.
     *
     * @param path the Route URL
     * @param handler the RouteHandler
     */
    public void connect(String path, RouteHandler handler) {
        router.connect(path, handler);
    }

    /**
     * Add an OPTIONS route to the Router list.
     *
     * @param path the Route URL
     * @param handler the RouteHandler
     */
    public void options(String path, RouteHandler handler) {
        router.options(path, handler);
    }

    /**
     * Add a TRACE route to the Router list.
     *
     * @param path the Route URL
     * @param handler the RouteHandler
     */
    public void trace(String path, RouteHandler handler) {
        router.trace(path, handler);
    }

    /**
     * Get the Router.
     *
     * @return the router
     */
    public Router router() {
        return this.router;
    }

}
