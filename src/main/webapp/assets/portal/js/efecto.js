
							$(document).ready(function() {
							
								setTimeout(function(){
									
									var defaults = {
								  			containerID: 'toTop', // fading element id
											containerHoverID: 'toTopHover', // fading element hover id
											scrollSpeed: 1200,
											easingType: 'linear' 
								 		};
										
										
										$().UItoTop({ easingType: 'easeOutQuart' });
									
										
										$(".scroll").click(function(event){		
											event.preventDefault();
											$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
										});
								},100);
								
							});
							
							
							
							var arr= ["../assets/img/caney1.jpg",
							          "../assets/img/caney2.jpg",
							          "../assets/img/criollas.jpg",
							          "../assets/img/futbol.jpg",
							          "../assets/img/piscina.jpg",
							          "../assets/img/salon.jpg",
							          "../assets/img/softball.jpg",
							          "../assets/img/tennis.jpg"
							       ];


							          i = 0;
							          setInterval(function(){
							              console.log("asd")
							              $("#imagen").attr("src", arr[i]);
							              i++;
							              if (i > arr.length)
							              i = 0;
							          },1800);		
							
							
							    
							  