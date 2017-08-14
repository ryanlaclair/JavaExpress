package org.javaexpress.router;

import org.javaexpress.http.ExpressRequest;
import org.javaexpress.http.ExpressResponse;
import org.javaexpress.http.HTTPMethod;
import org.javaexpress.http.HTTPStatus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements an HTTP request router. It is used to build a list of
 * Routes that the server is to respond to. It then locates the Route and calls
 * the RouteHandler when an incoming request is received. It is designed to mimic
 * the Express JS API.
 *
 * @author Ryan LaClair - rlaclair@bu.edu
 */
public class Router {

    private List<Route> routes = new ArrayList<Route>();

    /**
     * Add a GET request Route.
     *
     * @param path the Route URL
     * @param handler the RouteHandler
     */
    public void get(String path, RouteHandler handler) {
        addRoute(new Route(path, HTTPMethod.GET, handler));
    }

    /**
     * Add a HEAD request Route.
     *
     * @param path the Route URL
     * @param handler the RouteHandler
     */
    public void head(String path, RouteHandler handler) {
        addRoute(new Route(path, HTTPMethod.HEAD, handler));
    }

    /**
     * Add a POST request Route.
     *
     * @param path the Route URL
     * @param handler the RouteHandler
     */
    public void post(String path, RouteHandler handler) {
        addRoute(new Route(path, HTTPMethod.POST, handler));
    }

    /**
     * Add a PUT request Route.
     *
     * @param path the Route URL
     * @param handler the RouteHandler
     */
    public void put(String path, RouteHandler handler) {
        addRoute(new Route(path, HTTPMethod.PUT, handler));
    }

    /**
     * Add a DELETE request Route.
     *
     * @param path the Route URL
     * @param handler the RouteHandler
     */
    public void delete(String path, RouteHandler handler) {
        addRoute(new Route(path, HTTPMethod.DELETE, handler));
    }

    /**
     * Add a CONNECT request Route.
     *
     * @param path the Route URL
     * @param handler the RouteHandler
     */
    public void connect(String path, RouteHandler handler) {
        addRoute(new Route(path, HTTPMethod.CONNECT, handler));
    }

    /**
     * Add an OPTIONS request Route.
     *
     * @param path the Route URL
     * @param handler the RouteHandler
     */
    public void options(String path, RouteHandler handler) {
        addRoute(new Route(path, HTTPMethod.OPTIONS, handler));
    }

    /**
     * Add a TRACE request Route.
     *
     * @param path the Route URL
     * @param handler the RouteHandler
     */
    public void trace(String path, RouteHandler handler) {
        addRoute(new Route(path, HTTPMethod.TRACE, handler));
    }

    /**
     * Route the incoming request.
     *
     * @param req the incoming request
     * @param res the outgoing response
     * @throws IOException
     */
    public void route(ExpressRequest req, ExpressResponse res) throws IOException {
        Route route = findRoute(req);

        // the Route exists in the list
        if (route != null) {
            req.setRoute(route);

            RouteHandler handler = route.getHandler();
            handler.handle(req, res);
        }
        // the Route does not exist, send a NOT FOUND response
        else {
            res.status(HTTPStatus.NOT_FOUND).send(HTTPStatus.NOT_FOUND.toString());
        }
    }

    /**
     * Add a Route to the list.
     *
     * @param route the Route to be added
     */
    private void addRoute(Route route) {
        this.routes.add(route);
    }

    /**
     * Find a Route in the list.
     *
     * @param req the incoming request
     * @return the Route if found, otherwise null
     */
    private Route findRoute(ExpressRequest req) {
        for (Route route : this.routes) {
            if (route.getMethod().equals(req.method())) {
                String[] routeParts = route.getPath().split("/");
                String[] pathParts = req.path().split("/");

                // the routes must have the same number of parts
                if (routeParts.length == pathParts.length) {
                    for (int i=0; i<routeParts.length; i++) {

                        // check if all non-parameter route parts are equal
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
