package org.javaexpress.router;

import org.javaexpress.http.ExpressRequest;
import org.javaexpress.http.ExpressResponse;
import org.javaexpress.http.HTTPMethod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        System.out.println("ROUTING...");

        Route route = findRoute(req);
        if (route != null) {
            RouteHandler handler = route.getHandler();

            handler.handle(req, res);
        }
        else {
            // route not found
            System.out.println("Route not found");
        }
    }

    private void addRoute(Route route) {
        this.routes.add(route);
    }

    private Route findRoute(ExpressRequest req) {
        for (Route route : this.routes) {
            if ((route.getMethod().equals(req.method())) &&
                    (route.getPath().equals(req.path()))) {
                return route;
            }
        }

        return null;
    }

}
