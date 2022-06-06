/*
 * Original Author: https://github.com/devashish234073/Java-Socket-Http-Server
 * This file is part of a modified version of Java-Socket-Http-Server.
 * The original Java-Socket-Http-Server is open source and is unlicensed, so here's the attibution.
 * This code was modified by gemsvidø.
 */

package xms.internal;

import org.jetbrains.annotations.NotNull;
import xms.premium.pTokenStorage;

import java.util.HashMap;
import java.util.Iterator;

public final class Request {

    private final String req;
    private String method = null;
    private String url = null;
    private String httpVersion = null;
    private final HashMap<String, String> attributes;
    public final Boolean isPremiumReq;


    public Request (String req) {
        this.req = req;
        attributes = new HashMap<>();
        parse();

        isPremiumReq = pTokenStorage.isValidToken(attributes.getOrDefault("token", ""));
    }

    private void parse () {
        String[] temp = req.split("\r\n");
        String firstLine = temp[0];
        String[] firstLineSplit = firstLine.split(" ");

        if (firstLineSplit.length == 3) {
            method = firstLineSplit[0];
            httpVersion = firstLineSplit[2];

            if (method.equals("POST")) {
                url = firstLineSplit[1];
                setAttributes(temp[temp.length-1]);
            } else if (method.equals("GET")) {
                String[] arr=firstLineSplit[1].split("[?]");
                if (arr.length == 2) {
                    url = arr[0];
                    setAttributes(arr[1]);
                } else {
                    url = firstLineSplit[1];
                }
            } else {
                url = firstLineSplit[1];
            }
        }
    }

    public @NotNull Iterator getAttributeIterator () {
        return attributes.keySet().iterator();
    }

    private void setAttributes (@NotNull String rawAttributes) {
        String[] attribs=rawAttributes.split("&");
        for(int i = 0; i < attribs.length; i++){
            String[] attr=attribs[i].split("=");
            if (attr.length==2) {
                setAttribute(attr[0],attr[1].replace("+"," "));
            }
        }
    }

    public @NotNull String getAttribute (@NotNull String key) {
        String ret = attributes.get(key);
        if(ret == null) {
            return "null";
        }
        return ret;
    }

    public void setAttribute (@NotNull String key, @NotNull String value) {
        attributes.put(key, value);
    }

    public String getMethod () {
        assert method != null;
        return method;
    }

    public @NotNull String getHttpVersion () {
        assert httpVersion != null;
        return httpVersion;
    }

    public String getUrl () {
        assert url != null;
        return url;
    }

    public @NotNull String toString () {
        assert req != null;
        return req;
    }
}