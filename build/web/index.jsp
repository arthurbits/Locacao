<%@page import="Modelo.Endereco"%>
<%@page import="ModeloDao.EnderecoDao"%>
<%@page import="Modelo.Cliente"%>
<%@page import="ModeloDao.ClienteDao"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

             
        
        
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Principal</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
    <link href="css/responsive.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet" type="text/css"/>
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head><!--/head-->

<body>         
        
    <%
        String msg = (String) session.getAttribute("msg");                            
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if(msg == null){ msg=" Bem vindo ";}
    %>
    <!--
            Barra Superior Login
    -->
        <header id="header"><!--header-->
		
            <div class="header-middle"><!--header-middle-->
                <div class="container">
                    <div class="row">
                        <div class="col-md-12 clearfix">                            
                            
                            <% if(usuario == null || usuario.getUsuario() == null ){ %>
                                <form action="ControleUsuario" class="form-inline"  method="post"  autocomplete="on">                                                   
                                    <div class="shop-menu clearfix pull-right">
                                        <ul class="nav navbar-nav">	
                                            <li><h6><%=msg%></h6></li>                 
                                            <li><a href="cadastro.jsp"><i class="fa fa-lock"></i> Cadastre-se</a></li>
                                            <li><input type="text" name="usuario" placeholder="Usuário"></li>
                                            <li><input type="password" name="senha"  placeholder="Senha"></li>
                                            <li><input type="submit" name="acao" id="fazerLogin" value="Entrar"></li> 
                                            <li><a href="ControleCarrinho?acao=verificaCarrinho" class="btn btn-outline-success" ><i class="fa fa-shopping-cart fa-1x"></i>  Carrinho</a></li>                          
                                        </ul>                                    
                                    </div>                                      
                                </form>                   
                            <% }else if(usuario.getAtivo()==false){  %>
                                <form action="ControleUsuario" class="form-inline"  method="post"  autocomplete="on">                                                   
                                    <div class="shop-menu clearfix pull-right">
                                        <ul class="nav navbar-nav">	
                                            <li><h6><%=msg%></h6></li>                                          
                                            <li><input type="submit" class="btn btn-primary"  value="Reenviar E-mail de validação"></li>   
                                            <li><a href="sair.jsp" class="fa fa-power-off"> Sair </a><li>
                                            <li><a href="ControleCarrinho?acao=verificaCarrinho" class="btn btn-outline-success" ><i class="fa fa-shopping-cart fa-1x"></i>  Carrinho</a></li> 
                                        </ul>                                    
                                    </div>                                      
                                </form> 
                            
                            <% }else{  %>    
                                <div class="form-inline" style="text-align:right ;">  
                                       
                                    <div class="form-group">
                                        <h6><%=msg%> &nbsp &nbsp </h6>
                                    </div>
                                    
                                    

                                    <div class="form-group">
                                        <div class="shop-menu clearfix pull-right">
                                            <a href="ControleCliente?acao=ChecarCliente"  class="fa fa-home">Sua Conta</a>
                                        </div>
                                    </div>

                                    <div class="form-group">                                      
                                        <div class="shop-menu clearfix pull-right">                                          
                                            <a href="sair.jsp" class="fa fa-power-off" > Sair </a>
                                        </div>                                       
                                    </div> 
                                    
                                    <div class="form-group">                                      
                                        <div class="shop-menu clearfix pull-right">                                          
                                            <a href="ControleCarrinho?acao=verificaCarrinho" class="btn btn-outline-success" ><i class="fa fa-shopping-cart fa-1x"></i>  Carrinho</a>
                                        </div>                                       
                                    </div> 

                                </div>                                                
                            <% } %>                    
                    </div>
                </div>
            </div><!--/header-middle-->
	
		<div class="header-bottom"><!--header-bottom-->
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-9">                              
                                
                                <div class="mainmenu pull-left">
                                    <ul class="nav navbar-nav collapse navbar-collapse">
                                        <li><a href="index.jsp" class="active">Principal</a></li>

                                    </ul>
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="search_box pull-right">
                                    <input type="text" placeholder="Buscar"/>
                                </div>
                            </div>
                        </div>
                    </div>
		</div>
	</header>
    <!--        
        Barra Superior Login / FIM       
    --> 
        
        <section>
        <div class="container">
            <div class="row">
        <!--
            CATEGORIA
        -->
                <div class="col-sm-3">
                    <div class="left-sidebar">        
                                <h2>Categoria</h2>
                                <div class="panel-group category-products" id="accordian"><!--category-productsr-->
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                                <h4 class="panel-title"><a href="index.jsp">Brinquedos</a></h4>
                                        </div>
                                    </div> 
                                </div>        
                    </div>
                </div>
        <!--
            CATEGORIA FIM
        -->
                <div class="col-sm-9 padding-right">
        <!--	
                PRODUTOS
        -->
                        <%
                            // Recupera os produtos.
                            ArrayList<Produto> produtos = (ArrayList<Produto>) request.getAttribute("produtos");
                            if(produtos == null) {
                                request.getRequestDispatcher("/ControleProduto?acao=listaProdutos").forward(request, response);
                            }
                        %>
                        <div class="features_items"><!--features_items-->
                                <h2 class="title text-center"></h2>
                                <%                                      
                                    for(Produto produto : produtos){                                            
                                %>
                                <div class="col-sm-4">
                                    <div class="product-image-wrapper">
                                        <div class="single-products">
                                            <div class="productinfo text-center">
                                                    <img   src="imagens/<%=produto.getImagem()%>" alt="<%=produto.getImagem()%>" />
                                                    <h2>Valor : R$  <%=produto.getValorVenda()%></h2>
                                                    <a href="#"  class="btn btn-default add-to-cart " <i class="fa-shopping-bag"></i><%=produto.getNome()%></a>                                                   
                                                    <a href="#" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Adicionar ao Carrinho</a>
                                            </div>
                                            <div class="product-overlay">
                                                    <div class="overlay-content">
                                                            <h2>Valor : R$  <%=produto.getValorVenda()%></h2>                                                            
                                                            <a href="ControleCarrinho?acao=detalhesProduto&idProduto=<%=produto.getIdProduto()%>"  class="btn btn-default add-to-cart " <i class="fa-shopping-bag"></i><%=produto.getNome()%></a>                                                   
                                                            <a href="ControleCarrinho?acao=addProduto&idProduto=<%=produto.getIdProduto()%>" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Adicionar ao Carrinho</a>
                                                    </div>
                                            </div>
                                            
                                        </div>								
                                    </div>
                                </div>
                                <%                                   
                                   }//fim do for
                                %>
                        </div>
        <!--		
            PRODUTOS FIM 
        -->	
                </div>
            </div>
        </div>
	</section>
        <!--	
         RODAPÉ	
        -->	
            <footer id="footer">		
                <div class="footer-widget">
                    <div class="container">
                        <div class="col-md12">
                            <div class="single-widget">
                                <h2>Service</h2>
                                <ul class="nav nav-pills nav-stacked">
                                <li><h6>Online Help</h6></li>
                                <li><h6>Contact Us</h6></li>							
                            </div>
                        </div>
                    </div>
                </div>
                <div class="footer-bottom">
                    <div class="container">
                        <div class="row">
                            <p class="pull-left">Copyright © 2013 E-SHOPPER Inc. All rights reserved.</p>
                            <p class="pull-right">Designed by <span><a target="_blank" href="http://www.themeum.com">Themeum</a></span></p>
                        </div>
                    </div>
                </div>

            </footer>	
        <!--	
         RODAPÉ FIM	
        -->
	

  
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/price-range.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>
