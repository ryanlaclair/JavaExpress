package org.javaexpress.http;

/**
 * This enumeration represents the different possible HTTP status codes.
 *
 * @author Ryan LaClair - rlaclair@bu.edu
 */
public enum HTTPStatus {

    CONTINUE(100, "Continue"),
    SWITCHING_PROTOCOLS(101, "Switching Protocols"),
    OK(200, "OK"),
    CREATED(201, "Created"),
    ACCEPTED(202, "Accepted"),
    NO_CONTENT(204, "No Content"),
    RESET_CONTENT(205, "Reset Content"),
    MULTIPLE_CHOICES(300, "Multiple Choices"),
    MOVED_PERMANENTLY(301, "Moved Permanently"),
    FOUND(302, "Found"),
    MOVED_TEMPORARILY(302, "Moved Temporarily"),
    SEE_OTHER(303, "See Other"),
    USE_PROXY(305, "Use Proxy"),
    SWITCH_PROXY(306, "Switch Proxy"),
    TEMPORARY_REDIRECT(307, "Temporary Redirect"),
    BAD_REQUEST(400, "Bad Request"),
    PAYMENT_REQUIRED(402, "Payment Required"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
    NOT_ACCEPTABLE(406, "Not Acceptable"),
    REQUEST_TIMEOUT(408, "Request Timeout"),
    CONFLICT(409, "Conflict"),
    GONE(410, "Gone"),
    LENGTH_REQUIRED(411, "Length Required"),
    UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),
    EXPECTATION_FAILED(417, "Expectation Failed"),
    UPGRADE_REQUIRED(426, "Upgrade Required"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    NOT_IMPLEMENTED(501, "Not Implemented"),
    BAD_GATEWAY(502, "Bad Gateway"),
    SERVICE_UNAVAILABLE(503, "Service Unavailable"),
    GATEWAY_TIMEOUT(504, "Gateway Timeout"),
    HTTP_VERSION_NOT_SUPPORTED(505, "HTTP Version not supported");

    private int value;
    private String reason;

    /**
     * Create a new HTTPStatus.
     *
     * @param value the value
     * @param reason the String reason
     */
    HTTPStatus(int value, String reason) {
        this.value = value;
        this.reason = reason;
    }

    /**
     * Get the status value.
     *
     * @return the value
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Get the status reason.
     *
     * @return a String of the reason
     */
    public String getReason() {
        return this.reason;
    }


    /**
     * A String representation of the HTTPStatus.
     *
     * @return the String representation
     */
    @Override
    public String toString() {
        return this.value + " - " + this.reason;
    }

}
