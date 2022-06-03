fetch(`https://raw.githubusercontent.com/xMeerkat/xMeerkat/master/Website/status.json?updated=${Date.now()}`).then(response => response.json()).then(async data => {

	eval(await (await fetch("https://unpkg.com/sweetalert2")).text());


	if (swal) {

		const Mix = Swal.mixin({
			icon: "info",
			showCancelButton: true,
			toast: false,
			confirmButtonText: "I am 18+",
			cancelButtonText: "I am not 18+",
		});


		if (!(await Mix.fire("xMeerkat", "This website is not for anyone under the age of 18.")).value) {

            document.write("");
            return document.write("<html class=\"blackbg\"><h1 class=\"white\">This website is not for anyone under the age of 18.</h1><style> .blackbg { background-color: black; } .white { color: white; }</style></html>");

		} else {

			document.getElementById("MainImg").src = "https://raw.githubusercontent.com/x-Meerkat/main-image-xmeerkat/Image/img/assets/xm.jpeg";


		}

	}


});


// Minify this => Script in index.html