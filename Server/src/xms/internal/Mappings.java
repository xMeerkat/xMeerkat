/*
 * Original Author: https://github.com/devashish234073/Java-Socket-Http-Server
 * This file is part of a modified version of Java-Socket-Http-Server.
 * The original Java-Socket-Http-Server is open source and is unlicensed, so here's the attibution.
 * This code was modified by gemsvidø.
 */

package xms.internal;

import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class Mappings {

    private final HashMap<String, AbstractResponse> urlMappings;

    public Mappings () {
        urlMappings = new HashMap<String, AbstractResponse>();
    }

    protected AbstractResponse getMap (String key){
        return urlMappings.get(key);
    }

    public void addMap (String method, String url, AbstractResponse resp){
        urlMappings.put(method + "_" + url, resp);
    }

    public void addMap (String method, String url, String filepath, String code, String type) throws IOException {
        urlMappings.put(method+"_"+url, new AbstractResponse() {
            @Override
            public Response getResponse(Request req) {
                StringBuilder res = new StringBuilder();
                try{
                    FileReader fr = new FileReader(filepath);
                    int c;
                    for(c = fr.read(); c!=-1; c=fr.read()) {
                        res.append((char) c);
                    }
                } catch (FileNotFoundException fnfe){
                    return new Response("<html><body><p>Unable to find resource ["+url+"]</p></body></html>", "500 Internal Server Error", "text/html");
                } catch (IOException ioe){
                    return new Response("<html><body><p>Unable to read resource ["+url+"]</p></body></html>", "500 Internal Server Error", "text/html");
                }
                res = new StringBuilder(replaceRequestAttribute(res.toString(), req));


                Response resp = new Response(res.toString(), code, type);
                // code = 200 OK"
                // type = "text/html"
                return resp;
            }
        });
    }

    private @NotNull String replaceRequestAttribute (@NotNull String res, @NotNull Request req){
        Iterator itr = req.getAttributeIterator();
        while(itr.hasNext()) {
            String key = (String) itr.next();
            String val = req.getAttribute(key);
            res = res.replace("${"+key+"}",val);
        }
        return res;
    }

    private @NotNull Integer indexOfAfter (@NotNull String str, @NotNull String toSearch, @NotNull Integer after){
        str = str.substring(after);
        return after + str.indexOf(toSearch);
    }
}