
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
			<h1>Similarity Search for Encrypted Images using Multi key in Secure Cloud</h1>
		</div>
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
		<div class="content-grids">
			<div class="col-md-4 content-left">
				<!--Start Search-->
                                                             
				
					<!-- script for tabs -->
						<script type="text/javascript">
							$(function() {
							
								var menu_ul = $('.menu_drop > li > ul'),
									   menu_a  = $('.menu_drop > li > a');
								
								menu_ul.hide();
							
								menu_a.click(function(e) {
									e.preventDefault();
									if(!$(this).hasClass('active')) {
										menu_a.removeClass('active');
										menu_ul.filter(':visible').slideUp('normal');
										$(this).addClass('active').next().stop(true,true).slideDown('normal');
									} else {
										$(this).removeClass('active');
										$(this).next().stop(true,true).slideUp('normal');
									}
								});
							
							});
						</script>
					<!-- script for tabs -->
				<div class="clearfix"></div>
			</div>
			<div class="col-md-8 cont-grids">
				<div class="content-left-grids">
					<div class="content-middle">
						
					<div class="login-form">
							<div class="login-pad">
								<h3>ADMIN LOGIN</h3>
                                                                <form action="AdminLogin" method="post" onsubmit="JavaScript:return UserValidate(true);">
                                                                    <input type="text" style="color:black" value="" placeholder="AdminName" name="adminname" id="adminname">
                                                                    <input type="password" style="color:black" value="" placeholder="PassWord" name="password" id="password"><br><br><br>
                                                                    <input type="submit" value="LOGIN">
								</form>
							</div>
							
						</div>
                                            
						<div class="range">
							
							<!---->
							 <script type="text/javascript" src="js/jquery-ui.min.js"></script>

								  <link rel="stylesheet" type="text/css" href="css/jquery-ui.css">

							<script type='text/javascript'>//<![CDATA[ 
							$(window).load(function(){
							 $( "#slider-range" ).slider({
										range: true,
										min: 0,
										max: 6000,
										values: [ 5, 3000 ],
										slide: function( event, ui ) {  $( "#amount" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
										}
							 });
							$( "#amount" ).val( "$" + $( "#slider-range" ).slider( "values", 0 ) + " - $" + $( "#slider-range" ).slider( "values", 1 ) );

							});//]]>  

							</script>
						</div>
						<div class="bed">
							

						</div>	
					</div>
                                    
					<div class="clearfix"></div>
				</div>
			
                            
							 <%
                  String msg=(String)session.getAttribute("msg");
                  if(msg!=null)
                  {%>
                 
                      <script>
                          var ss='<%=msg%>';
                          alert(ss);
                      </script>
                          
              <%  
                       session.invalidate();
                  }
                
                 
                  %>
                  
                  <script >
        function UserValidate()
        {
            var ss = document.getElementById("adminname").value;
            if (ss === "")
            {
                alert("AdminName Can't be Empty");
                document.getElementById("adminname").value.focus;
                return false;
            }
            var ss1 = document.getElementById("password").value;
            if (ss1 === "")
            {
                alert("Password Can't be Empty");
                document.getElementById("password").value.focus;
				return false;
            }
            return true;
        }
                                </script>

        </div>
			<div class="clearfix"></div>
		</div>
		
		
<!-- //content -->
<div style="height: 100px"></div>
        <div class="footer">
                
      <!--<h1 style="background-color: white;color:graytext;border-radius:10px; margin-bottom: 20px;"  align="center">&copy; 2015 All Rights Reserved | Designed by Ashwin and team </h1>-->                               
        </div>
        </div>
	</div>

</body>
</html>