if (swal) {

	let adShown = false;



	document.getElementById("Video").addEventListener("ended", function () {

		if (introPlayed) {

			if (adShown.valueOf() == true) {
				return log("adShown is true");
			} else {
				log("adShown is false");
			}

			log("creating ad swal mixin");
			const AD = Swal.mixin({
				icon: "info",
				showCancelButton: true,
				toast: true,
				confirmButtonText: "Check it out",
				cancelButtonText: "Maybe later",
			});
			log("created ad swal mixin");


			/* if (!(await AD.fire("xMeerkat Premium", "Get lots of exclusive content!")).value) {

				return log("ad response: maybe later");


			} else {

				window.reload();
				window.location.href = "/premium";
				return log("going to xMeerkat Premium");

			}
			*/

            adShown = true;

		}


	});




} else {

	console.warn("SweetAlert2 is not loaded");

}