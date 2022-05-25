package xms.internal;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

public final class Response {

    private String resp = null;

    public Response (String resp, String respCode, String type) {
        Date date = new Date();
        String start = "HTTP/1.1 " + respCode + "\r\n"; // 200 OK
        String header = "Date: " + date.toString() + "\r\n";
        header += "Content-Type: " + type + "\r\n"; // text/html
        header += "Content-length: " +resp.length() + "\r\n";
        header += "\r\n";
        this.resp = start + header + resp;
    }

    public @NotNull String toString () {
        return resp;
    }
}