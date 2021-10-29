<%-- 
    Document   : index
    Created on : Jul 21, 2015, 9:59:07 AM
    Author     : chiranjeevi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>IMAGE PRIVACY</title>
	<!--fonts-->
		<link href='http://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
		<link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900,200italic,300italic,400italic,600italic,700italic,900italic' rel='stylesheet' type='text/css'>
	<!--//fonts-->
		<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
		<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
	<!-- for-mobile-apps -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="Crazy Fashions UI Kit Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
		Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- //for-mobile-apps -->
	<!-- js -->
		<script type="text/javascript" src="js/jquery.min.js"></script>
	<!-- js -->
	<!-- script for close -->
	<script>
		$(document).ready(function(c) {
			$('.alert-close').on('click', function(c){
				$('.vlcone').fadeOut('slow', function(c){
					$('.vlcone').remove();
				});
			});	  
		});
	</script>
	<script>$(document).ready(function(c) {
			$('.alert-close1').on('click', function(c){
				$('.vlctwo').fadeOut('slow', function(c){
					$('.vlctwo').remove();
				});
			});	  
		});
	</script>
	<!-- //script for close -->
<!-- script for etalage -->
<!-- FlexSlider -->
  <script defer src="js/jquery.flexslider.js"></script>
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />

	<script>
// Can also be used with $(document).ready()
$(window).load(function() {
  $('.flexslider').flexslider({
    animation: "slide",
    controlNav: "thumbnails"
  });
});
</script>

<!-- //script for etalage -->
</head>
<body>
<!-- content -->
<div class="content">
	<div class="container">
		<div class="nav-top-header">
			<!--<h1><a href="#">Privacy Policy for User-Uploaded Images on Content Sharing Sites</a></h1>-->
			<h1>PRIVACY FOR USER-UPLOADED IMAGES ON CONTENT SHARING SITES</h1>
		</div>
            <!--<div style="float:left;width:75px;height: 40px">-->

		<div style="border-radius: 10px;width: 900px;margin-left: auto;margin-right: auto" class="navigation text-center">
				<!-- start h_menu4 -->
                                <div class="h_menu4" style="text-align: center">
					<a class="toggleMenu" href="">Menu</a>
                                        <ul class="nav">
                                                <li class="active"><a href="index.jsp">HOME</a></li>
                                                <li><a href="userlogin.jsp">USER LOGIN</a></li>
                                                <li><a href="adminlogin.jsp">ADMIN LOGIN</a></li>
						<li><a href="aboutus.jsp">ABOUT US</a></li>
						<li><a href="contactus.jsp">CONTACT US</a></li>
                                        </ul>
				<script type="text/javascript" src="js/nav.js"></script>
				</div>
				<!-- end h_menu4 -->

		</div>
		<div class="clearfix"></div>
	
		<div class="grid_3">
			
			<div class="col-md-3 grid-right">
				
			</div>
			<div class="clearfix"></div>	
		</div>
		<div class="slider-bottom">
			<!-- responsiveslides -->
						<script src="js/responsiveslides.min.js"></script>
							<script>
								// You can also use "$(window).load(function() {"
								$(function () {
								 // Slideshow 4
								$("#slider3").responsiveSlides({
									auto: true,
									pager: true,
									nav: false,
									speed: 500,
									namespace: "callbacks",
									before: function () {
								$('.events').append("<li>before event fired.</li>");
								},
								after: function () {
									$('.events').append("<li>after event fired.</li>");
									}
									});
									});
							</script>
			<!-- responsiveslides -->
					<div  id="top" class="callbacks_container">
						<ul class="rslides" id="slider3">
							
							<li>
								<div class="slider-grids">
									<div class="slider-middle">
									
                                                                            <h4><p align="justify">The increasing volume of images users share through social sites, maintaining privacy has become a major problem,
                                                                                as demonstrated by a recent wave of publicized incidents where users inadvertently shared personal information. In light of these
                                                                                incidents, the need of tools to help users control access to their shared content is apparent.</p></h4><br>
                                                                                <h4><p align="justify">Toward addressing this need, we propose an Adaptive Privacy Policy Prediction (A3P) system to help users compose privacy settings for their images. We examine the role of
                                                                                social context, image content, and meta data as possible indicators of users’ privacy preferences. We propose a two-level framework
                                                                                which according to the user’s available history on the site, determines the best available privacy policy for the user’s images being
                                                                                uploaded. </p></h4>
									
									</div>
									<div class="slider-right text-center">
										
									</div>
									<div class="clearfix"></div>
								</div>
							</li>
							
							
						</ul>
                                            </div>
                        
                                        </div>
<!--footer-->                
<div style="height: 100px"></div>
<!--      <div>
      <h1 style="background-color: white;color:graytext;border-radius:10px; margin-bottom: 20px;"  align="center">&copy; 2015 All Rights Reserved | Designed by Ashwin and team</h1>                               
        </div>-->
</div>                                                                                     	
  </div> 
    
<!-- //content -->
</body>
</html>