
<%@page import="connection.DataBaseConnection"%>
<%@page import ="java.sql.ResultSet"%>
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


<!--No Back word Home Page-->

<script>
        window.location.hash = "no-back-button";
        window.location.hash = "Again-No-back-button";//again because google chrome don't insert first hash into history
        window.onhashchange = function () { window.location.hash = "no-back-button"; }
</script> 

<script>
    $(window).load(
        function () {
            $('.carousel1').carouFredSel({
                auto: false,
                prev: '.prev',
                next: '.next',
                width: 220,
                items: {
                    visible: {
                        min: 3,
                        max: 3
                    },
                    height: 'auto',
                    width: 220,
                },
                responsive: true,
                scroll: 1,
                mousewheel: false,
                swipe: {
                    onMouse: false,
                    onTouch: true
                }
            });
            $('.typo').mouseenter(
                function () {
                    var temp = $(".typo>img").attr("data-href");
                    $(".typo>img").attr(
                        "src", temp
                    );
                }
            );
        });
</script>



</head>
<body>

<!-- content -->
<div class="content">
   
	<div class="container">
		<div class="nav-top-header">
			<!--<h1><a href="#">Privacy Policy for User-Uploaded Images on Content Sharing Sites</a></h1>-->
			<h1>Similarity Search for Encrypted Images using Multi key in Secure Cloud</h1>
		</div>
            
            
                               <%
                   String name=(String)session.getAttribute("name");
                   String pass=(String)session.getAttribute("pass");
                   session.setAttribute("name",name);
                   session.setAttribute("pass",pass);
                   System.out.println(name+","+pass);
                   if(name!=null&&pass!=null)
                   {
                      if(name.equalsIgnoreCase("ADMIN")&&pass.equalsIgnoreCase("ADMIN"))
           		   {
                %>

				
            
            
			<div style="border-radius: 10px;width:820px;margin-left: auto;margin-right: auto" class="navigation text-center">
				<!-- start h_menu4 -->
                               
				<div class="h_menu4">
					<a class="toggleMenu" href="">Menu</a>
					<ul class="nav">
						<li class="active"><a href="adminhome.jsp">ADMIN HOME</a></li>                                                
                                                <li><a href="viewusers.jsp">VIEW USERS</a></li>
                                                            														
                                                  <li><a href="adminviewuploadedimages.jsp">VIEW UPLOAD IMAGES</a>
							
						</li>
                                                											
                                                <li><a href="logout.jsp">LOGOUT</a></li>
					</ul>
						<script type="text/javascript" src="js/nav.js"></script>
				</div>
				<!-- end h_menu4 -->

		</div>

				<!-- end h_menu4 -->

		</div>
		<div class="clearfix"></div>
		<div class="content-grids">
                    <div>
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
                                            <center><h1>Admin Home Page</h1></center>	
                                            
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
                            
                            
				
					
			</div>
			<div class="clearfix"></div>
                        
                        
                        
                        
                             
				<%
                                String msg=(String)session.getAttribute("msg");
                                if(msg!=null)
                                {
                                    %>
                                    <script>
                                        var ss='<%=msg%>';
                                        alert(ss);
                                        </script>
                                    <%
                                    session.removeAttribute("msg");
                                }
                                %>
					
                        
                        
               <%
                    }
                        else
            {
                
               session.setAttribute("msg","Session out please login");
                response.sendRedirect("adminlogin.jsp");
                
                
            }
                   }
             else
            {
               
                
                session.setAttribute("msg","Session out please login");
                response.sendRedirect("adminlogin.jsp");
                
                
            }
                  %>
		
	</div>
	</div>
	
<!-- //content -->
<div style="height: 170px"></div>
<!--<div class="footer" style="width: 700px;margin-left:auto;margin-right: auto">
                
      <h2 style="background-color: white;color:graytext;border-radius:10px; margin-bottom: 20px;"  align="center">&copy; 2015 All Rights Reserved | Designed by ashwin and team </h2>                               
        </div>-->
        </div>


	
</body>
</html>