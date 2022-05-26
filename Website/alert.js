fetch(`https://raw.githubusercontent.com/xMeerkat/xMeerkat/master/Website/status.json?updated=${Date.now()}`).then(response => response.json()).then(async data => {

                if (data.offline == true) {
                    eval(await (await fetch("https://unpkg.com/sweetalert2")).text());

                    if (swal) {
                        swal.fire({
                            title: "xMeerkat",
                            html: "Please note that this site is NOT FOR KIDS.",
                            icon: "info"
                        });
                    }

                } else {

                    eval(await (await fetch("https://unpkg.com/sweetalert2")).text());

                    if (swal) {
                        swal.fire({
                            title: "xMeerkat",
                            html: "Please note that this site is NOT FOR KIDS.",
                            icon: "info"
                        });
                    }

                }
});