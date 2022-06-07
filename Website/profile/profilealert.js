function log (message) {
	return console.log("[xMeerkat => from alert.js] " + message);
}





log("alert.js loaded");

fetch(`https://raw.githubusercontent.com/xMeerkat/xMeerkat/master/Website/status.json?updated=${Date.now()}`).then(response => response.json()).then(async data => {


	eval(await (await fetch("https://unpkg.com/sweetalert2")).text());
	log("loaded sweetalert2");

	if (swal) {
		log("swal is loaded");




		/* ALRAEDY DECLARED ADULT */
		if (docCookies.getItem("xMeerkat-adult") === "true") {

			log("adult cookie is true");


			log("creating swal mixin");
			const Mix = Swal.mixin({
				icon: "success",
				showCancelButton: true,
				toast: false,
				confirmButtonText: "Proceed",
				cancelButtonText: "I am not 18+",
			});
			log("created swal mixin");




			if (!(await Mix.fire("xMeerkat", "Welcome back!")).value) {

				log("user is not 18+");

				docCookies.setItem("xMeerkat-adult", "false");

				log("Redirecting user to the xMeerkat child safety notice");
				return window.location = "https://github.com/orgs/xMeerkat/discussions/3";


			} else {

				log("user is 18+");
				docCookies.setItem("xMeerkat-adult", "true");

				log("setting the main image");
				document.getElementById("ProfilePFP").src = REAL_PROFILE_PFP;
				return log("set the main image");

			}




		}
		/* END ALRAEDY DECLARED ADULT */




		/* PREVIOUSLY DECLARED BELOW 18 */
		else if (docCookies.getItem("xMeerkat-adult") === "false") {


			log("adult cookie is false");


			log("creating swal mixin");
			const Mix = Swal.mixin({
				icon: "warning",
				showCancelButton: true,
				toast: false,
				confirmButtonText: "I am not 18+",
				cancelButtonText: "I am 18+",
			});
			log("created swal mixin");




			if (!(await Mix.fire("Child safety on xMeerkat", "xMeerkat is NOT for kids. If you are below 18, please do not go on xMeerkat. If you are a parent, please do not permit your child to go on xMeerkat. (You have previously declared yourself as below 18).")).value) {

				log("user is 18+");

				docCookies.setItem("xMeerkat-adult", "true");

				log("setting the main image");
				document.getElementById("ProfilePFP").src = REAL_PROFILE_PFP;
				return log("set the main image");



			} else {


				log("user is not 18+");

				docCookies.setItem("xMeerkat-adult", "false");

				log("Redirecting user to the xMeerkat child safety notice");
				return window.location = "https://github.com/orgs/xMeerkat/discussions/3";


			}


		}
		/* PREVIOUSLY DECLARED BELOW 18 */


		/* NOT SET */
		else if (docCookies.getItem("xMeerkat-adult") == null || docCookies.getItem("xMeerkat-adult") === "null") {

			log("creating swal mixin");

			const Mix = Swal.mixin({
				icon: "info",
				showCancelButton: true,
				toast: false,
	   			confirmButtonText: "I am 18+",
	   			cancelButtonText: "I am not 18+",
	   		});
			log("created swal mixin");


			log("checking if user is 18+");

			if (!(await Mix.fire("xMeerkat", "This website is not for anyone under the age of 18.")).value) {

				log("user is not 18+");

				docCookies.setItem("xMeerkat-adult", "false");

				log("Redirecting user to the xMeerkat child safety notice");
				return window.location = "https://github.com/orgs/xMeerkat/discussions/3";

			} else {

				log("user is 18+");
				docCookies.setItem("xMeerkat-adult", "true");

				log("setting the main image");
				document.getElementById("ProfilePFP").src = REAL_PROFILE_PFP;
				return log("set the main image");

			}

		}
		/* NOT SET */


		/* OTHERWISE */
		else {

			console.warn("[xMeerkat => from alert.js] Adult cookie seems to have been tampered with.");

			log("creating swal mixin");

			const Mix = Swal.mixin({
				icon: "warning",
				showCancelButton: true,
				toast: false,
	   			confirmButtonText: "I am 18+",
	   			cancelButtonText: "I am not 18+",
	   		});
			log("created swal mixin");


			log("checking if user is 18+");

			if (!(await Mix.fire("xMeerkat", "The adult cookie storage seems to have been tampered with. Please refrain from tampering with xMeerkat's cookie storage. Anyways, this website is not for anyone under the age of 18.")).value) {

				log("user is not 18+");

				docCookies.setItem("xMeerkat-adult", "false");

				log("Redirecting user to the xMeerkat child safety notice");
				return window.location = "https://github.com/orgs/xMeerkat/discussions/3";

			} else {

				log("user is 18+");
				docCookies.setItem("xMeerkat-adult", "true");

				log("setting the main image");
				document.getElementById("ProfilePFP").src = REAL_PROFILE_PFP;
				return log("set the main image");

			}



		}
		/* OTHERWISE */



	}
});


// Minify this => Script in index.html