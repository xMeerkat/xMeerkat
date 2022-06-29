"use strict";
(async () => {
	const tld = window.location.hostname.valueOf();
	const path = window.location.pathname.valueOf();
	TLD(tld, path);
})();

function setTld (newTLD) {
    if (newTLD === "") {
        window.location.hostname = "xmeerkat.com";
    } else {
        window.location.hostname = newTLD + ".xmeerkat.com";
    }
}


function TLD (tld, path) {

    if (!tld.includes("xmeerkat.com")) {
        return console.log("Not on xMeerkat.");
    }





    if (path.startsWith("/videos/")) {
        return setTld("vids");
    } else if (path.startsWith("/user/")) {
        return setTld("profiles");
    }





    switch (path) {

        case "/":
            return setTld("");

        case "/premium":
            return setTld("premium");

        case "/videos":
        case "/videos/":
            return setTld("vids");

        default:
            return setTld("");


    }



}