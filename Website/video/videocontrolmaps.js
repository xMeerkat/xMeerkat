window.addEventListener("keydown", function (event) {

	switch (event.key) {
	
		case "ArrowLeft": { Backward(5); break; }
		case "ArrowRight": { Forward(5); break; }
		
		case "ArrowUp": { Volume(0.1); break; }
		case "ArrowDown": { Volume(-0.1); break; }
		
		case " ": { PlayPause(); break; }
		case "p": { PlayPause(); break; }
		case "P": { PlayPause(); break; }
		case "k": { PlayPause(); break; }
		case "K": { PlayPause(); break; }
		
		case "m": { MuteUnmute(); break; }
		case "M": { MuteUnmute(); break; }

		case "f": { FullscreenToggle(); break; }
		case "F": { FullscreenToggle(); break; }

	}

});