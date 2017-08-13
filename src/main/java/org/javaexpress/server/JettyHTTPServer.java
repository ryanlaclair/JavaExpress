package org.javaexpress.server;

import org.eclipse.jetty.server.Server;
import org.javaexpress.router.Router;

/**
 * @author Ryan LaClair - rlaclair@bu.edu
 */
public class JettyHTTPServer extends HTTPServer {

    private Server server;

    public JettyHTTPServer(int port, Router router) {
        super(port, router);
    }

    @Override
    public void start() throws Exception {
        this.server = new Server(getPort());
        this.server.setHandler(new JettyHTTPServerHandler(getRouter()));
        this.server.start();
    }

    @Override
    public void stop() throws Exception {
        if (this.server != null) {
            this.server.stop();
        }
    }

}
