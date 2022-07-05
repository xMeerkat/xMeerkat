"use strict";
/* Video controls */


var volumecache = new Number();
var fullscreencache = new Boolean(false);

/* Fullscreen */
async function Fullscreen () {

	var elem = document.getElementById("Video");

	if (elem.requestFullscreen) {
		elem.requestFullscreen();
	}
	else if (elem.mozRequestFullScreen) {
		elem.mozRequestFullScreen();
	}
	else if (elem.webkitRequestFullscreen) {
		elem.webkitRequestFullscreen();
	}
	else if (elem.msRequestFullscreen) {
		elem.msRequestFullscreen();
	}
	else {
		console.error("Fullscreen not supported");
	}

	fullscreencache = true;

}


/* Exit fullscreen */
async function FullscreenExit () {

	if (document.exitFullscreen) {
		document.exitFullscreen();
	}
	else if (document.mozCancelFullScreen) {
		document.mozCancelFullScreen();
	}
	else if (document.webkitExitFullscreen) {
		document.webkitExitFullscreen();
	}
	else if (document.msExitFullscreen) {
		document.msExitFullscreen();
	}
	else {
		console.error("Fullscreen not supported");
	}

	fullscreencache = false;

}


/* Toggle fullscreen */
async function FullscreenToggle () {

	if (fullscreencache) {
		FullscreenExit();
	} else {
		Fullscreen();
	}
}


/* Play */
async function Play () {

	var elem = document.getElementById("Video");
	elem.play();
}


/* Pause */
async function Pause () {

	var elem = document.getElementById("Video");
	elem.pause();
}


/* PlayPause */
async function PlayPause () {

	var elem = document.getElementById("Video");
	if (elem.paused) {
		Play();
	} else {
	   Pause();
	}
}


/* Set Volume */
async function Volume (volume) {


	var set;

	if (volume < 0) {
		set = 0;
	}
	else if (volume > 1) {
		set = 1;
	} else {
		set = volume;
	}


	var elem = document.getElementById("Video");
	elem.volume = set;
	volumecache = set;
}


/* Get Volume */
async function GetVolume () {

	var elem = document.getElementById("Video");
	return elem.volume;
}


/* Mute */
async function Mute () {
	volumecache = document.getElementById("Video").volume;
	Volume(0);
}


/* Unmute */
async function Unmute () {

	Volume(volumecache);
}


/* MuteUnmute */
async function MuteUnmute () {

	var elem = document.getElementById("Video");

	if (elem.muted) {
		Unmute();
	} else {
		Mute();
	}
}


/* Forward in video time */
async function Forward (time) {

	var elem = document.getElementById("Video");
	elem.currentTime += time;
}


/* Backward in video time */
async function Backward (time) {

	var elem = document.getElementById("Video");
	elem.currentTime -= time;
}

console.log("Video controls loaded");