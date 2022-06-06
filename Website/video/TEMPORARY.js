let introPlayed = false;

	document.getElementById("Video").src = "https://raw.githubusercontent.com/xMeerkat/ugc-assets/master/assets/videos/4fa3816f/video.mp4";

	document.getElementById("Video").addEventListener("ended", function () {

		if (!introPlayed) {

			document.getElementById("Video").controls = "controls";
			document.getElementById("Video").src = REAL_VIDEO_URL;
			document.getElementById("Video").play();
			introPlayed = true;
		}

	}, true);


	await new Promise(r => setTimeout(r, 100));
	document.getElementById("Video").play();