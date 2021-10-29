
<%@ page import="java.net.InetAddress"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.io.File" %>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="java.io.*,java.sql.*,java.util.*,java.text.*,java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*" %>
<%@ page import="connection.DataBaseConnection"%>
<%@ page import ="java.sql.ResultSet"%>
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
            $('.alert-close').on('click', function(c) {
            $('.vlcone').fadeOut('slow', function(c) {
            $('.vlcone').remove();
            });
            });
            });
        </script>
        <script>$(document).ready(function(c) {
            $('.alert-close1').on('click', function(c) {
            $('.vlctwo').fadeOut('slow', function(c) {
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
            function validate()
            {
            var fup = document.getElementById('file');
            var fileName = fup.value;
            
            if(fileName=="")
            {
            alert("Search Jpg or Jpeg images Names only");            
            return false;
            }
             
            return true;

            }
        </script>




    </head>
    <body>

        <!-- content -->
        <div class="content">

            <div class="container">
                <div class="nav-top-header">
                    <!--<h1><a href="#">Privacy Policy for User-Uploaded Images on Content Sharing Sites</a></h1>-->
                    <h1>PRIVACY FOR USER-UPLOADED IMAGES ON CONTENT SHARING SITES</h1>
                </div>


                <%
                    Integer id = (Integer) session.getAttribute("userid");
                    String name = (String) session.getAttribute("username");
                    String imagename = (String) session.getAttribute("imagename");
                    session.setAttribute("userid", id);
                    session.setAttribute("username", name);
                    session.setAttribute("imagename", imagename);
                    DataBaseConnection db = new DataBaseConnection();
                    ResultSet rs = null;
                    System.out.println(id + "," + name);
                    rs = db.Select("select * from userinsert where userid='" + id + "' and username='" + name + "'");
                    if (rs.next()) {
                        String uname = rs.getString("username");

                %>


                <div style="border-radius: 10px;width:1160px;margin-left: auto;margin-right: auto" class="navigation text-center">
                    <!-- start h_menu4 -->

                    <div class="h_menu4">
                        <a class="toggleMenu" href="">Menu</a>
                           <ul class="nav">
                            <li class="active"><a href="userhome.jsp">USER HOME</a></li>                                                
                            <li><a href="#">UPLOAD</a>
                                <ul>								
                                    <li><a href="uploadimagefolder.jsp">UPLOAD IMAGE</a></li>
                                    <li><a href="viewuploadimages.jsp">VIEW UPLOAD IMAGES</a></li>
                                </ul>
                            </li>
                            <li><a href="#">CONVERTION</a>
                                <ul>
                                    <li><a href="texttoimage.jsp">TEXT TO IMAGE</a></li>
                                    <li><a href="imagetotext.jsp">IMAGE TO TEXT</a></li>

                                </ul>
                            </li>
                            <li><a href="viewuploadimagesshare.jsp">SHARE IMAGE</a>

                            </li>  
                            <li>
                                <a href="viewsharedimages.jsp">INBOX</a>
                            </li>
                            <li><a href="#">SEARCH</a>
                                <ul>	
                                    <li><a href="contentdatasearch.jsp">CONTENT DATA SEARCH</a></li>
                                    <li><a href="metadatasearch.jsp">META DATABASED SEARCH</a></li>
                                </ul>
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
                <div class="col-md-4 content-left">
                    <!--Start Search-->


                    <!-- script for tabs -->
                    <script type="text/javascript">
                        $(function() {

                        var menu_ul = $('.menu_drop > li > ul'),
                        menu_a = $('.menu_drop > li > a');

                        menu_ul.hide();

                        menu_a.click(function(e) {
                        e.preventDefault();
                        if (!$(this).hasClass('active')) {
                        menu_a.removeClass('active');
                        menu_ul.filter(':visible').slideUp('normal');
                        $(this).addClass('active').next().stop(true, true).slideDown('normal');
                        } else {
                        $(this).removeClass('active');
                        $(this).next().stop(true, true).slideUp('normal');
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


                            <ul>
                                <font color="greytext">
                                <h2><li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Welcome to <%=uname%></li></h2<br><br>
                                </font>
                            </ul>
                            <form action="contentdatasearch.jsp"  method="post"  onsubmit="return validate();">
                                <table align="center" cellpadding = "20"> 
                                    <tr>
                                        <td>Choose File To Upload</td>
                                        <td><input type="file" name="imagename" id="file"/></td>
                                    </tr>

                                    <tr>
                                        <td>  </td><td> <input  type="submit"  size=15 type="text"  value="Search"/> </td>
                                    </tr>
                                </table>
                            </form>



                            <%


                                try {

                                    String iname5 = request.getParameter("imagename");
                                    DataBaseConnection db1 = new DataBaseConnection();

                                    rs = db1.Select("SELECT id,filename FROM imageuploadfolder where filename like'%" + iname5 + "%' and username='" + session.getAttribute("username") + "'");

                            %>
                            </p>
                            <fieldset>
                                <legend>Image</legend>
                                <table border="0"> 
                                    <%

                                        if (rs.next()) {

                                    %>     



                                    <td>
                                        <div style=""><img border="1" src="image/upload/<%=iname5%>" height="160" width="160" /></div>

                                    </td>


                                    <%
                                    } //closing while loop bracket   
                                    else {
                                        //if no record is found, simply display a no record message     
%>     
                                    Nothing.     
                                    <%         }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }

                                    %>  

                                </table> 
                            </fieldset> 





                            <div class="range">

                                <!---->
                                <script type="text/javascript" src="js/jquery-ui.min.js"></script>

                                <link rel="stylesheet" type="text/css" href="css/jquery-ui.css">

                                <script type='text/javascript'>//<![CDATA[ 
                                    $(window).load(function() {
                                    $("#slider-range").slider({
                                    range: true,
                                    min: 0,
                                    max: 6000,
                                    values: [5, 3000],
                                    slide: function(event, ui) {
                                    $("#amount").val("$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ]);
                                    }
                                    });
                                    $("#amount").val("$" + $("#slider-range").slider("values", 0) + " - $" + $("#slider-range").slider("values", 1));

                                    });//]]>  

                                </script>
                            </div>
                            <div class="bed">


                            </div>	
                        </div>

                        <div class="clearfix"></div>
                    </div>


                    <%
                        String msg = (String) session.getAttribute("msg");
                        if (msg != null) {
                    %>
                    <script>
                        var ss = '<%=msg%>';
                        alert(ss);
                    </script>
                    <%
                            session.removeAttribute("msg");
                        }
                    %>



                </div>
                <div class="clearfix"></div>


                <%
                    } else {
                        session.setAttribute("msg", "Session Out Please Login");
                        response.sendRedirect("userlogin.jsp");
                    }
                %>
            </div>


            <!-- //content -->
            <div style="height: 100px"></div>
            <div class="footer" style="width: 1000px;margin-left:auto;margin-right: auto">

<!--                <h2 style="background-color: white;color:graytext;border-radius:10px; margin-bottom: 20px;"  align="center">&copy; 2015 All Rights Reserved | Designed by Ashwin and team </h2>                               -->
            </div>
        </div>
    </div>

</body>
</html>