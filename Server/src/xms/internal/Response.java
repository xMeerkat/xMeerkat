/*
 * Original Author: https://github.com/devashish234073/Java-Socket-Http-Server
 * This file is part of a modified version of Java-Socket-Http-Server.
 * The original Java-Socket-Http-Server is open source and is unlicensed, so here's the attibution.
 * This code was modified by gemsvidø.
 */

package xms.internal;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

public final class Response {

    private @NotNull String resp;

    public Response (@NotNull String resp, @NotNull String respCode, @NotNull String type) {
        Date date = new Date();
        String start = "HTTP/1.1 " + respCode + "\r\n"; // 200 OK
        String header = "Date: " + date + "\r\n";
        header += "Content-Type: " + type + "\r\n"; // text/html
        header += "Content-length: " + resp.length() + "\r\n";
        header += "Cache-Control: no-cache\r\n"; // NO CACHEING
        header += "\r\n";
        this.resp = start + header + resp;
    }

    public Response (@NotNull String CONSTRUCTED_RESPONSE) {
        this.resp = CONSTRUCTED_RESPONSE;
    }


    public @NotNull String toString () {
        return resp;
    }
}