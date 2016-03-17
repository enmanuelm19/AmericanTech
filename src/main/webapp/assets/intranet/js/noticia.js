		

$(document).ready(function() { var owl = $('.owl-carousel');
		owl.owlCarousel({ items:3, loop:true, margin:10, autoplay:true,
		autoplayTimeout:4000, autoplayHoverPause:true });
		$('.play').on('click',function(){
		owl.trigger('autoplay.play.owl',[1000]) })
		$('.stop').on('click',function(){
		owl.trigger('autoplay.stop.owl') }) });