/*
 * Original Author: https://github.com/devashish234073/Java-Socket-Http-Server
 * This file is part of a modified version of Java-Socket-Http-Server.
 * The original Java-Socket-Http-Server is open source and is unlicensed, so here's the attibution.
 * This code was modified by gemsvidø.
 */

package xms.internal;

import org.jetbrains.annotations.NotNull;
import xms.MAPS;
import xms.analytics.Reqs;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public final @NotNull class Server {

    private @NotNull Integer PORT;
    private @NotNull ServerSocket server;
    private Socket client;
    private @NotNull Mappings mappings;

    public Server (@NotNull Integer PORT, @NotNull Mappings mappings) throws IOException {
        this.PORT = PORT;
        server = new ServerSocket(PORT);
        this.mappings = mappings;
    }

    public @NotNull Request accept () throws IOException {

        Reqs.Companion.increm(1);

        client = server.accept();
        InputStream is = client.getInputStream();
        int c;
        StringBuilder raw = new StringBuilder();
        do {
            c = is.read();
            raw.append((char) c);
        } while (is.available() > 0);

        final Request request = new Request(raw.toString());
        return request;
    }

    public void shut () throws IOException {
        server.close();
    }

    private @NotNull Response getResponse (@NotNull Request req) {
        AbstractResponse respAbs = mappings.getMap(req.getMethod() + "_" + req.getUrl());
        if (respAbs == null) {
            return MAPS.getResponse_404();
        }
        final Response resp = respAbs.getResponse(req);
        return resp;
    }

    public void sendResponse (@NotNull Request req) throws IOException {
        Response resp = getResponse(req);
        OutputStream out = client.getOutputStream();
        out.write(resp.toString().getBytes());
    }

}