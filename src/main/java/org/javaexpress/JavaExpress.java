package org.javaexpress;

import org.javaexpress.router.RouteHandler;
import org.javaexpress.router.Router;
import org.javaexpress.server.HTTPServer;
import org.javaexpress.server.JettyHTTPServer;

/**
 * @author Ryan LaClair - rlaclair@bu.edu
 */
public class JavaExpress {

    private HTTPServer server;
    private Router router = new Router();

    public void listen(int port) throws Exception {
        this.server = new JettyHTTPServer(port, this.router);
        this.server.start();
    }

    public void get(String path, RouteHandler handler) {
        router.get(path, handler);
    }

    public void head(String path, RouteHandler handler) {
        router.head(path, handler);
    }

    public void post(String path, RouteHandler handler) {
        router.post(path, handler);
    }

    public void put(String path, RouteHandler handler) {
        router.put(path, handler);
    }

    public void delete(String path, RouteHandler handler) {
        router.delete(path, handler);
    }

    public void connect(String path, RouteHandler handler) {
        router.connect(path, handler);
    }

    public void options(String path, RouteHandler handler) {
        router.options(path, handler);
    }

    public void trace(String path, RouteHandler handler) {
        router.trace(path, handler);
    }

}
