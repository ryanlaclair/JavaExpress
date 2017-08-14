package org.javaexpress.router;

import org.javaexpress.http.ExpressRequest;
import org.javaexpress.http.ExpressResponse;
import org.javaexpress.http.HTTPMethod;
import org.javaexpress.http.HTTPStatus;
import org.javaexpress.server.HTTPServer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Ryan LaClair - rlaclair@bu.edu
 */
public class Router {

    private List<Route> routes = new ArrayList<Route>();

    public Router() {
    }

    public void get(String path, RouteHandler handler) {
        addRoute(new Route(path, HTTPMethod.GET, handler));
    }

    public void head(String path, RouteHandler handler) {
        addRoute(new Route(path, HTTPMethod.HEAD, handler));
    }

    public void post(String path, RouteHandler handler) {
        addRoute(new Route(path, HTTPMethod.POST, handler));
    }

    public void put(String path, RouteHandler handler) {
        addRoute(new Route(path, HTTPMethod.PUT, handler));
    }

    public void delete(String path, RouteHandler handler) {
        addRoute(new Route(path, HTTPMethod.DELETE, handler));
    }

    public void connect(String path, RouteHandler handler) {
        addRoute(new Route(path, HTTPMethod.CONNECT, handler));
    }

    public void options(String path, RouteHandler handler) {
        addRoute(new Route(path, HTTPMethod.OPTIONS, handler));
    }

    public void trace(String path, RouteHandler handler) {
        addRoute(new Route(path, HTTPMethod.TRACE, handler));
    }

    public void route(ExpressRequest req, ExpressResponse res) throws IOException {
        Route route = findRoute(req);
        if (route != null) {
            req.setRoute(route);

            RouteHandler handler = route.getHandler();
            handler.handle(req, res);
        }
        else {
            res.status(HTTPStatus.NOT_FOUND).send(HTTPStatus.NOT_FOUND.toString());
        }
    }

    private void addRoute(Route route) {
        this.routes.add(route);
    }

    private Route findRoute(ExpressRequest req) {
        for (Route route : this.routes) {
            if (route.getMethod().equals(req.method())) {
                String[] routeParts = route.getPath().split("/");
                String[] pathParts = req.path().split("/");

                if (routeParts.length == pathParts.length) {
                    for (int i=0; i<routeParts.length; i++) {
                        if ((!routeParts[i].startsWith(":")) && (!routeParts[i].equals(pathParts[i]))) {
                            return null;
                        }
                    }

                    return route;
                }
            }
        }

        return null;
    }

}
