$(function() {
	var playVideo = $('video');
	var playPause = $('.playPause'); //播放和暂停
	var currentTime = $('.timebar .currentTime'); //当前时间
	var duration = $('.timebar .duration'); //总时间
	var progress = $('.timebar .progress-bar'); //进度条
	var volumebar = $('.volumeBar .volumewrap').find('.progress-bar');

	var maxTime = 1;
	var time = maxTime;
	$('body').on('keydown mousemove mousedown', function(e){
		time = maxTime;
	});
	var intervalId = setInterval(function(){
		time--;
		if(time <= 0) {
			ShowInvalidLoginMessage();
			clearInterval(intervalId);
		}
	}, 1000);
	function ShowInvalidLoginMessage(){
		if (!playVideo[0].paused) {
			playPause.toggleClass('playIcon');
			playVideo[0].pause();
			$('.playTip').removeClass('glyphicon-pause').addClass('glyphicon-play').fadeIn();
		}
		if(confirm('你已经看了'+maxTime+'秒了,是否休息一下')) {
			window.location.href = "homepage.html";
		}
	}
	//获取 视频源
	$.getUrlParam = function (name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null) return unescape(r[2]);
		return null;
	};
	var videosrc = $.getUrlParam('dv');
	$('.videoName').html(videosrc);
	playVideo.attr('src','video/'+videosrc+'.mp4'); //chome需要绝对路径，否则currenttime会无效，http://localhost:63342/videoPlayer/
	//适应屏幕
	resizeBannerImage();
	window.onresize=resizeBannerImage;//当窗口改变宽度时执行此函数
	function resizeBannerImage() {
		var w = $('.playContent').width();
		$('.barrage').css('left',w/4);
		$('.barrage .text').css('left',w/8);
		var dwidth = $(window).width();
		//console.log(dwidth);
		if(parseInt(dwidth)<=490){
			$('.currentTime').css('display', 'none');
			$('.duration').css('display', 'none');
			$('.playPause').css('display', 'none');
			$('.otherControl,.timebar').css('width','100%');
			$('.otherControl').css('background','url(images/playheader.jpg) repeat-x');
			$('.progress:eq(0)').css('width','80%');
		}
		else if(parseInt(dwidth) < 1550 && parseInt(dwidth)>490){
			$('.currentTime').css('display', 'none');
			$('.duration').css('display', 'none');
			$('.playPause').css('display', '');
			$('.timebar').css('width','calc(100vw / 65 * 30)');
			$('.otherControl').css({
				'background':'none',
				'width':'15rem'
			});
			$('.progress:eq(0)').css('width','calc(80vw / 65 * 30)');
		}else {
			$('.currentTime').css('display', '');
			$('.duration').css('display', '');
			$('.playPause').css('display', '');
			$('.timebar').css('width','calc(100vw / 65 * 30)');
			$('.otherControl').css({
				'background':'none',
				'width':'15rem'
			});
			$('.progress:eq(0)').css('width','calc(80vw / 65 * 30)');
		}
	}

	/*	获取blob值 兼容性 */
	//选取本地视频
	$('#file').on('change',function () {
		onInputFileChange();
	}).on('click',function () {
		if (!playVideo[0].paused) {
			playPause.toggleClass('playIcon');
			playVideo[0].pause();
			$('.playTip').removeClass('glyphicon-pause').addClass('glyphicon-play').fadeIn();
		}
	});

	playVideo[0].volume = 0.4; //初始化音量
	playPause.on('click', function() {
		playControl();
	});
	$('.playContent').on('click', function() {
		playControl();
	})/*.hover(
		function() {
		$('.turnoff').stop().animate({
			'right': 0
		}, 500);},
		function() {
		$('.turnoff').stop().animate({
			'right': -40
		}, 500);
	})*/;
	$(document).click(function() {
		$('.volumeBar').hide();
	});
	playVideo.on('loadedmetadata', function() {
		duration.text(formatSeconds(playVideo[0].duration));
	});
	playVideo.on('timeupdate', function() {
		currentTime.text(formatSeconds(playVideo[0].currentTime));
		progress.css('width', 100 * playVideo[0].currentTime / playVideo[0].duration + '%');
	});
	playVideo.on('ended', function() {
		$('.playTip').removeClass('glyphicon-pause').addClass('glyphicon-play').fadeIn();
		playPause.toggleClass('playIcon');
	});
	$('.barrage').hide();
	$(document).keyup(function(event){
		event = event || window.event;
			if(event.keyCode == 32){
				playControl();
			}else if(event.keyCode == 27){
				$('.fullScreen').removeClass('cancleScreen');
			}else if(event.keyCode == 13){
				$('.barrage').toggle();
				$(".barrage .text").focus();
			}
		event.stopPropagation();
		event.preventDefault();
	});
	//倍速
	$('#speed ul li a').on('click',function () {
		$('#speed a:first').html("<strong>" + this.rel + "X</strong>");
		playVideo[0].playbackRate = this.rel;
	});
	//全屏
	$('.fullScreen').on('click', function() {
		if ($(this).hasClass('cancleScreen')) {
			$(this).removeClass('cancleScreen');
		} else {
			if (playVideo[0].requestFullscreen) {playVideo[0].requestFullscreen();}
			else if (playVideo[0].mozRequestFullScreen) {playVideo[0].mozRequestFullScreen();}
			else if (playVideo[0].webkitRequestFullscreen) {playVideo[0].webkitRequestFullscreen();}
			else if (playVideo[0].msRequestFullscreen) {playVideo[0].msRequestFullscreen();}
			$(this).addClass('cancleScreen');
		}
		return false;
	});
	//时间控制
	$('.timebar .progress').mousedown(function(e) { //点击进度条
		e = e || window.event;
		updatebar(e.pageX);
	});
	$('.glyphicon-backward').on('click',function () { //快退10s
		playVideo[0].currentTime -= 10;
	});
	$('.glyphicon-forward').on('click',function () { //快进10s
		playVideo[0].currentTime += 10;
	});
	$(document).keydown(function(event){ //键盘左右控制快进
		event = event || window.event;
		if(event.keyCode == 37){
			playVideo[0].currentTime -= 10;
		}else if (event.keyCode == 39){
			playVideo[0].currentTime += 10;
		}
	});
	var updatebar = function(x) {
		var maxduration = playVideo[0].duration; //Video 
		var positions = x - progress.offset().left; //点击位置
		var percentage = 100 * positions / $('.timebar .progress').width();//进度条百分比
		//Check within range
		if (percentage > 100) {
			percentage = 100;
		}
		if (percentage < 0) {
			percentage = 0;
		}
		//Update progress bar and video currenttime
		progress.css('width', percentage + '%');
		playVideo[0].currentTime = maxduration * percentage / 100;
		//console.log(positions+ '  ' +maxduration+ '  ' +percentage);
	};
	//音量
	$('.volume').on('click', function(e) { //鼠标点击位置 控制音量
		e = e || window.event;
		$('.volumeBar').toggle();
		e.stopPropagation();
		hide_bar(e);
	});
	$('.volumeBar').on('click mousewheel DOMMouseScroll', function(e) { //鼠标滚轮控制音量
		e = e || window.event;
		volumeControl(e);
		e.stopPropagation();
		hide_bar(e);
		return false;
	});
	$(document).keydown(function(event){ //键盘上下控制音量
		event = event || window.event;
		var p = 0;
		if(event.keyCode == 38){
			$('.volumeBar').show();
			p = playVideo[0].volume*100 + 5;
			volumeControl_in(p);
		}else if (event.keyCode == 40){
			$('.volumeBar').show();
			p = playVideo[0].volume*100 - 5;
			volumeControl_in(p);
		}
		hide_bar(event);
		event.stopPropagation();
	});
	//音量控制
	function hide_bar(event) {
		lastTime = event.timeStamp;
		//无 操作 1s消失
		setTimeout(function () {
			if (lastTime - event.timeStamp == 0) {
				$('.volumeBar').fadeOut("slow");
			}
		}, 1500);
	}
	function volumeControl_in(percentage) {
		if (percentage < 0) {
			percentage = 0;
			$('.otherControl .volume').attr('class', 'volume glyphicon glyphicon-volume-off');
		}
		if (percentage > 50) {
			$('.otherControl .volume').attr('class', 'volume glyphicon glyphicon-volume-up');
		}
		if (percentage > 0 && percentage <= 50) {
			$('.otherControl .volume').attr('class', 'volume glyphicon glyphicon-volume-down');
		}
		if (percentage >= 100) {
			percentage = 100;
		}
		$('.volumewrap .progress-bar').css('height', percentage + '%');
		playVideo[0].volume = percentage / 100;
	}
	function volumeControl(e) {
		e = e || window.event;
		var eventype = e.type;
		var delta = (e.originalEvent.wheelDelta && (e.originalEvent.wheelDelta > 0 ? 1 : -1)) || (e.originalEvent.detail && (e.originalEvent.detail > 0 ? -1 : 1));
		var positions = 0;
		var percentage = 0;
		if (eventype == "click") {
			positions = volumebar.offset().top - e.pageY;
			percentage = 100 * (positions + volumebar.height()) / $('.volumeBar .volumewrap').height();
		} else if (eventype == "mousewheel" || eventype == "DOMMouseScroll") {
			percentage = 100 * (volumebar.height() + delta) / $('.volumeBar .volumewrap').height();
		}
		volumeControl_in(percentage);
		e.stopPropagation();
		e.preventDefault();
	}
	//播放 暂停
	function playControl() {
			playPause.toggleClass('playIcon');
			if (playVideo[0].paused) {
				playVideo[0].play();
				$('.playTip').removeClass('glyphicon-play').addClass('glyphicon-pause').fadeOut();
			} else {
				playVideo[0].pause();
				$('.playTip').removeClass('glyphicon-pause').addClass('glyphicon-play').fadeIn();
			}
		}
});
//秒转时间
function formatSeconds(value) {
	value = parseInt(value);
	var time;
	if (value > -1) {
		hour = Math.floor(value / 3600);
		min = Math.floor(value / 60) % 60;
		sec = value % 60;
		day = parseInt(hour / 24);
		if (day > 0) {
			hour = hour - 24 * day;
			time = day + "day " + hour + ":";
		} else time = hour + ":";
		if (min < 10) {
			time += "0";
		}
		time += min + ":";
		if (sec < 10) {
			time += "0";
		}
		time += sec;
	}
	return time;
}
function onInputFileChange() {
	var file = document.getElementById('file').files[0];
	var url = URL.createObjectURL(file);
	//console.log(url);
	document.getElementById("playVideo").src = url;
}