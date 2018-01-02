<%@page import="BEAN.JefeBean"%>
<%!   JefeBean obj=new JefeBean();%>
<%obj=(JefeBean)request.getAttribute("cargar");%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
      <link rel="shortcut icon" href="<%=request.getContextPath()%>/imagenes/link1.ico" type="image/x-icon">
  <meta http-equiv=?Content-Language? content=?es?/>
  <meta name="author" content="Giampieer Mariscal">
  <meta name="owner" content="Giampieer Mariscal">
  <meta name="description" content="Login para ingrsear al menu principal del admin ,Login para ingrsear al menu principal del personal">
  <meta name="keywords" content="ejemplo de software, software libre, login">
  <meta name="robots" content="index,follow">
  <meta name="classification" content="proyecto gestion,isagen,ejemplo,practica gestion">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="theme-color" content="#009688" />
  
  <script src="https://repository.chatwee.com/scripts/31faa13855e48bbd6b6c2a640b347e10.js" type="text/javascript" charset="UTF-8"></script>

  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/dataTables.bootstrap.min.css">


  <link rel="Stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/lado22.css">
  <link rel="Stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/freelancer.min.css">
  <link rel="Stylesheet" type="text/css"href="<%=request.getContextPath()%>/css/animate.css">
  <link rel="Stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/sweetalert.css">
  <link rel="Stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/font-awesome.min.css">
  <link rel="Stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/alertify.min.css">
  <link rel="Stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/default.min.css">
  <link rel="Stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/prelodr.min.css">
  <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
  <link rel="Stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap-material-datetimepicker.css">
  <link href="<%=request.getContextPath() %>/css/icono_calendario.css" rel="stylesheet">


  
  <script type="text/javascript"src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
  <script type="text/javascript"src="<%=request.getContextPath()%>/js/jquery.dataTables.min.js"></script>
  <script type="text/javascript"src="<%=request.getContextPath()%>/js/dataTables.bootstrap.min.js"></script>
  <script  type="text/javascript"src="<%=request.getContextPath()%>/js/bootstrap.min.js" ></script>
  <script type="text/javascript"src="<%=request.getContextPath()%>/js/sweetalert.min.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/js/complementos.js"></script>
  <script type="text/javascript"src="<%=request.getContextPath()%>/js/alertify.min.js"></script>
  <script type="text/javascript"src="<%=request.getContextPath()%>/js/prelodr.min.js"></script>
  <script type="text/javascript"src="<%=request.getContextPath()%>/js/push.min.js"></script>
  <script type="text/javascript"src="<%=request.getContextPath()%>/js/wow.min.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/js/ajax.js"></script>

  <script>new WOW().init();</script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/js/moment-with-locales.min.js"></script>
  <script type="text/javascript"src="<%=request.getContextPath()%>/js/bootstrap-material-datetimepicker.js"></script>
  <script type="text/javascript">
    function googleTranslateElementInit() {
      new google.translate.TranslateElement({pageLanguage: 'es'}, 'google_translate_element');
    }
  </script><script type="text/javascript" src="<%=request.getContextPath() %>/js/traductor_google.js"></script>
  <title>Gestion de Proyectos Administrador</title>
</head>

<body id="page-top" class="index " onload="ingresarmenu('<%= obj.getID()%>'),cargarinactividad()" >

    <div id="wrapper" >
        
    <div class="overlay" >
      <nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
        <ul class="nav sidebar-nav">
          <li class="sidebar-brand">
            <a class="navbar-brand" href="javascript:cargar('<%=request.getContextPath()%>','Jefe',12)"  >ADMIN</a>
          </li>
          <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#"  > BIENVENIDO: <%= obj.getID()%>  </a>          
            <ul class="dropdown-menu" role="menu">
              <li class="dropdown-header">Seleccione</li>
              <li><a  id="menu" href="javascript:cargar('<%=request.getContextPath()%>','Jefe',10,'cod='+ <%=obj.getCODJEFE()%>   )">Actualizar Datos</a></li>
              <li><a  id="menu" href="javascript:cargar('<%=request.getContextPath()%>','Jefe',14,'cod='+ <%=obj.getCODJEFE()%>    )">Cambiar  Password</a></li>
            </ul>
          </li>
          <li class="dropdown">
            <a   class="dropdown-toggle"  data-toggle="dropdown" href="#">PROYECTO</a>
            <ul class="dropdown-menu" role="menu">
              <li class="dropdown-header">Seleccione</li>
              <li><a  id="menu"  href="javascript:MenuOpciones('<%=request.getContextPath()%>','Proyecto',1,'')"> Nuevo  </a></li>
              <li><a   id="menu"href="javascript:MenuOpciones('<%=request.getContextPath()%>','Requisito',1,'')">Requisito</a> </li>
              <li><a id="menu"  href="javascript:MenuOpciones('<%=request.getContextPath()%>','Problema',1,'')">Problema</a></li>
              <li><a   id="menu" href="javascript:MenuOpciones('<%=request.getContextPath()%>','Objetivo',1,'')">Objetivos</a></li>
            </ul>
          </li>
          <li class="dropdown">
            <a  class="dropdown-toggle" data-toggle="dropdown" href="#">PERSONAL</a>
            <ul class="dropdown-menu" role="menu">
              <li class="dropdown-header">Seleccione</li>
              <li><a   id="menu" href="javascript:MenuOpciones('<%=request.getContextPath()%>','Jefe',1,'')">Jefe</a></li>
              <li><a   id="menu" href="javascript:MenuOpciones('<%=request.getContextPath()%>','Personal',1,'')">Colaboradores</a></li>
            </ul>
          </li>
          <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">SEGUIMIENTO</a>
            <ul class="dropdown-menu" role="menu">
              <li class="dropdown-header">Seleccione</li>
              <li><a id="menu" href="javascript:MenuOpciones('<%=request.getContextPath()%>','Reuniones',1,'')">Reuniones</a></li>
              <li><a id="menu" href="javascript:MenuOpciones('<%=request.getContextPath()%>','Cambios',1,'')">Cambios</a></li>
              <li><a  id="menu" href="javascript:MenuOpciones('<%=request.getContextPath()%>','Interesados',1,'')">Interesados</a></li>
              <li><a  id="menu" href="javascript:MenuOpciones('<%=request.getContextPath()%>','Riesgos',1,'')">Riesgos</a></li>
              <li><a   id="menu"href="javascript:MenuOpciones('<%=request.getContextPath()%>','Solucion',1,'')">Solucion</a></li>
            </ul>
          </li>
          <li class="dropdown">
            <a  class="dropdown-toggle" data-toggle="dropdown" href="#">CRONOGRAMA</a>
            <ul class="dropdown-menu" role="menu">
              <li class="dropdown-header">Seleccione</li>
              <li><a  id="menu"href="javascript:MenuOpciones('<%=request.getContextPath()%>','Actividades',1,'')">Actividades</a></li>
              <li><a  id="menu" href="javascript:MenuOpciones('<%=request.getContextPath()%>','ControldeCalidad',1,'')">Control de Calidad</a></li>
            </ul>
          </li>
          <li class="dropdown">
            <li><a  id="cerrar"   href="javascript:cerrarsesion('<%=request.getContextPath()%>')">CERRAR SESION</a></li>
          </li>
        </ul>
      </nav>
    </div>
    
    <div id="page-content-wrapper">
      <button type="button" class="hamburger is-closed animated bounceInLeft " data-toggle="offcanvas">
        <span class="hamb-top"></span>
        <span class="hamb-middle"></span>
        <span class="hamb-bottom"></span>
      </button>

              
          <nav id="mainNav"  class="navbar navbar-default navbar-fixed-top navbar-custom">
              <div id="barra_material_design" class="load-bar" style="display:none">
              <div class="bar"></div>
              <div class="bar"></div>
              <div class="bar"></div>
             </div>
            <div class="container">
                
              <div class="navbar-header page-scroll">
                  
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                  <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="#contact"  >BIENVENIDO: <%= obj.getID()%>  </a>
                <!--llama el reloj-->
                <a class="navbar-brand "href="#page-top"  id="tick2" > </a>
              </div>
                
              <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                  <li class="hidden">
                    <a href="#page-top"></a>
                  </li>
                  <li class="page-scroll">
                    <a href="#contact" >Gestion de Proyectos</a>
                  </li>
                </ul>
              </div>
            </div>
          </nav>
          <header class="animated fadeInDown" >
            <div class="container">
              <div aria-busy="true" aria-label="Loading, please wait." class="header1"role="progressbar"></div>
              <div class="row">
                <div class="col-lg-12">
                  <img class="img-responsive" src="<%=request.getContextPath()%>/imagenes/profile.png" alt="Administrador WEB">
                  <div class="intro-text">
                    <span class="name">EMPRESA </span>
                    <hr class="star-light">
                    <span class="skills">Energia Productiva</span>
                  </div>
                </div>
              </div>
            </div>
    
                  
          </header>

          <section id="contact" >
            <div class="container anchoformulario" >
              <div class="row">
                <div class="col-lg-12 text-center">
                  <h3 class="tituloblanco">SISTEMA DE GESTION DE PROYECTOS</h3>
                  <hr class="star-primary">
                </div>
              </div>
              <div class="row" id="carrusel">
                <div class="carousel fade-carousel slide  container wow animated zoomIn"  data-ride="carousel" data-interval="4000" id="bs-carousel">
                  <div class="overlay"></div>
                  <ol class="carousel-indicators">
                    <li data-target="#bs-carousel" data-slide-to="0" class="active"></li>
                    <li data-target="#bs-carousel" data-slide-to="1"></li>
                    <li data-target="#bs-carousel" data-slide-to="2"></li>
                  </ol>
                  <div class="carousel-inner">
                    <div class="item slides active">
                      <div class="slide-1"></div>
                      <div class="hero" >
                        <hgroup >
                          <h1>ISAGEN</h1>        
                          
                        </hgroup>
                      </div>
                    </div>
                    <div class="item slides">
                      <div class="slide-2"></div>
                      <div class="hero">    
                        
                      </div>
                    </div>
                    <div class="item slides">
                      <div class="slide-3"></div>
                      <div class="hero">        
                        
                      </div>
                    </div>
                  </div> 
                </div> 
              </div>
            </div>
          </section>
  
          <!-- Footer -->
          <footer class="text-center animated fadeInUp">
            <div class="footer-above">
              <div class="container">
                <div class="row">
                  <div class="footer-col col-md-4">
                  </div>
                  <div class="footer-col col-md-4">
                    <h3>Enlaces</h3>
                    <ul class="list-inline">
                      <li class="wow animated bounceInLeft">
                        <a href=https://www.isagen.com.co target="_blank" class="btn-social btn-outline"><i class="fa fa-google" aria-hidden="true" style="padding: 10px"></i></a>
                      </li>
                      <li class=" wow animated bounceInUp">
                        <a href=https://www.facebook.com/IsagenEnergiaProductiva/?fref=ts target="_blank" class="btn-social btn-outline"><i class="fa fa-facebook" aria-hidden="true" style="padding: 10px"></i></a>
                      </li>
                      <li class="wow animated bounceInRight">
                        <a  href=https://www.youtube.com/user/ISAGENVideos target="_blank" class="btn-social btn-outline"><i class="fa fa-youtube-play" aria-hidden="true" style="padding: 10px"></i></a>
                      </li>
                    </li>
                  </ul>
                </div>
                <div class="footer-col col-md-4">
                </div>
              </div>
              <center class=" wow animated bounceInUp"><img src="https://www.cerotec.net/contador.php?t=5&s=2&i=99254" alt="Contador de visitas y estadísticas"> </center><br>
            </div>
            
          </div>
          
          <div class="footer-below">
            <div class="container">
              <div class="row">
                <div class="col-lg-12">
                  <!--traductor-->
                  <div id="google_translate_element" class="wow animated bounceInUp" ></div>
                  <audio controls autoplay loop  class="wow animated bounceInUp audio"  >
                    <source SRC="<%=request.getContextPath()%>/imagenes/musica01.mp3" type="audio/mp3">
                    </audio> 
                  </div>
                  
                </div>
              </div>
            </div>
          </footer>
        
    </div>
 
  </div>
                         
  <script type="text/javascript"src="<%=request.getContextPath() %>/js/jquery.easing.min.js"></script>
  <script type="text/javascript"src="<%=request.getContextPath()%>/js/freelancer.min.js"></script>
</body>
</html>
