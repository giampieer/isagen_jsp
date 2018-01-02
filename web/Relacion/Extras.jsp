
<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="utf-8">
    <meta http-equiv=?Content-Language? content=?es?/>
    <meta name="author" content="Giampieer Mariscal">
    <meta name="classification" content="proyecto gestion,isagen,ejemplo,practica gestion">
    <meta name="keywords" content="proyecto gestion,isagen,ejemplo,practica,gestion">
    <META NAME="robots" content="index,follow">
        <META NAME="distribution" content="global">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <!--adaptar el bootstrap para android--> 
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <meta name="description" content="Gestion de proyectos">
            <meta name="twitter:site" content="@miweb"/>
            <meta property="article:publisher" content="https://www.facebook.com/miweb"/>

            <!--sitemap-->
            <urlset
            xmlns="http://www.sitemaps.org/schemas/sitemap/0.9"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://www.sitemaps.org/schemas/sitemap/0.9
            http://www.sitemaps.org/schemas/sitemap/0.9/sitemap.xsd">

        </urlset>

        <script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
        <script  src="<%=request.getContextPath()%>/js/bootstrap.min.js" ></script>


        <!--animacion-->
        <link rel="Stylesheet" type="text/css"href="<%=request.getContextPath()%>/css/animate.css">

        <!--principal-->
        <link rel="Stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/lado22.css">
        <!--diseño template-->
        <link rel="Stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/freelancer.min.css">
        <!--color barra chrome android-->
        <meta name="theme-color" content="#009688" />
        <title>Enlaces</title>
    </head>
    <body class="bd">
        <br>
        <div class="container animated fadeInDown" style="max-width: 500px;width: 96%;background-color: #006699;border-radius: 7px">
            <div class="row titulocontenedor" >
                <div class="col-lg-12 text-center" >
                    <h3>Enlace Pagina Web</h3>
                    <hr class="star-primary">
                </div>
            </div>
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <form name="form"  action="ReporteRequsitoServlet">	
                        <div class="row control-group" > 
                            <br>
                            <div><center>
                                <img  style="max-width: 200px;width: 96%;height: 200px" src=" <%=request.getContextPath()%>/imagenes/googleqr.png"  >  
                            </center></div>
                        </div>
                    </form>
                    <br> </div>
                </div>
            </div>

            <br>

            <div class="container animated fadeInUp" style="max-width: 500px;width: 96%;background-color: #006699;border-radius: 7px">
                <div class="row titulocontenedor" >
                    <div class="col-lg-12 text-center" >
                        <h3>Enlace Andriod</h3>
                        <hr class="star-primary">
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
                        <form name="form"  action="ReporteRequsitoServlet">	
                            <div class="row control-group" > 
                                <br>
                                <div><center>
                                    <img style="max-width: 200px;width: 96%;height: 200px" src=" <%=request.getContextPath()%>/imagenes/androidqr.png"  >  
                                </center></div>
                            </div>
                        </form><br> 
                    </div>
                </div>
            </div>
            <br>
        </body>
        </html>
