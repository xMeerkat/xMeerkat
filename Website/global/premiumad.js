(async () => {
	eval(await (await fetch("https://unpkg.com/sweetalert2")).text());
	PremiumAdJS();
})();

function PremiumAdJS () {

	if (swal) {

		let adShown = false;


		document.getElementById("Video").addEventListener("ended", async function () {

			if (introFinished.valueOf() === true) {

				if (adShown.valueOf() === true) {
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


				if (!(await AD.fire("xMeerkat Premium", "Get lots of exclusive content!")).value) {

					adShown = true;
					return log("ad response: maybe later");


				} else {

					adShown = true;
					window.location.href = "/premium";
					return log("going to xMeerkat Premium");

				}

			} else {
			    introFinished = true;
			}


		});


	} else {

		console.warn("SweetAlert2 is not loaded");

	}
}