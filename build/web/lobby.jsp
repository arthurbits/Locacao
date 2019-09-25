<%@page import="Modelo.Cliente"%>
<%@page import="Modelo.Endereco"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

        <%
            // Recupera os Dados de Usuario
            String msg = (String) session.getAttribute("msg");                            
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            if(msg == null){ msg=" Bem vindo ";}
            
            // Recupera os Dados do Cliente                                        
            Cliente cliente = (Cliente) session.getAttribute("cliente");
            if (cliente == null | cliente.getNome() == null){ response.sendRedirect("dadosPessoais.jsp"); }
            // Recupera os Dados de Endereço                                       
            Endereco endereco = (Endereco) session.getAttribute("endereco");
            
            
        %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Lobby</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
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
                                            <li><a href="ControleUsuario?acao=sair" class="fa fa-power-off"> Sair </a><li>
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
                                            <a href="ControleUsuario?acao=sair" class="fa fa-power-off" > Sair </a>
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

        
       
	
        <div class="container">
            <div class="row">
                <!--
                    Painel
                -->
                
                <div class="col-sm-3">
                    <div class="left-sidebar">                           
                        <h2>Acesso</h2>
                        <div class="panel-group category-products" id="accordian"><!--category-productsr-->

                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                            <h4 class="panel-title"><a href="alterarSenha.jsp">Alterar Senha</a></h4>
                                    </div>
                                </div>
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                            <h4 class="panel-title"><a href="ControleCliente?acao=ChecarCliente"> Dados Pessoais </a></h4>
                                    </div>
                                </div>
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                            <h4 class="panel-title"><a href="index.jsp">Continuar as Compras</a></h4>
                                    </div>
                                </div>					
                          </div>
                    </div>
                </div>
                
                <!--
                    Painel FIM
                -->

                    

    <div class="col-sm-5 padding-right" > 

    <!--
        CLIENTE
    -->
             
            <div class="container">				
                <div class="step-one">
                        <h2 class="heading">Informações Pessoais</h2>
                </div>	
            </div>
             <div class="container">
                <div class="row">
                    <div class="col-md-6">                         
                    <p><label>Nome     : </label> <%= cliente.getNome() %> </p>
                    <p><label>RG       : </label><%= cliente.getRg() %></p>
                    <p><label>CPF      : </label><%= cliente.getCpf() %></p>
                    <p><label>Telefone : </label><%= cliente.getTelefone() %></p>
                    <p><label>Celular  : </label> <%= cliente.getCelular()%></p>
                    </div>
                    
                    <div class="col-md-6">                    
                    <p><label>Logradouro : </label> <%= endereco.getLogradouro() %> </p>
                    <p><label>Número     : </label> <%= endereco.getNumero() %> </p>
                    <p><label>Bairro     : </label> <%= endereco.getBairro() %> </p>
                    <p><label>Cidade     : </label> <%= endereco.getCidade() %> </p>
                    <p><label>CEP        : </label> <%= endereco.getCep() %> </p>
                    </div>
                </div>           
            </div>			
       
    <!--
        CLIENTE OFF
    -->        
    <!--				
        COMPRAS
    -->        
       <section id="cart_items">
        <div class="review-payment">
                <h2>Compras Realizadas</h2>
        </div> 
        <div class="container">
                <div class="table-responsive cart_info">
                    <table class="table table-condensed">        <!-- SE REPETE A CADA CARRINHO -->               
                        <thead>
                            <tr class="cart_menu">
                                <td class="image"><label>Data e Hora : </label> 03/09/2019  11:28:30</td>
                                <td class="description"><label>Valor : </label>R$ 1500,00</td>
                                <td class="price"><label>Forma de Pagamento  : </label> Cartão de Crédito</td>                               
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                        </thead>                     
                        <tbody>
                        <tr>                                                                        <!-- SE REPETE A CADA ITEM -->
                            <td class="cart_product">                                   <!-- IMAGEM  e Botao para o item -->
                                <a href=""><img src="imagens/campoFutebol.jpg" alt="campoFutebol.jpg" width="50px" height="50px" ></a>
                            </td>
                            <td class="cart_description">
                                <h4>Campo de Futebol </h4>                              <!-- NOME -->               
                            </td>
                            <td class="cart_description">
                                 <h4>R$ 750.0</h4>                                                  <!-- VALOR UNITÁRIO -->
                            </td>
                            <td class="cart_description">
                                 <h4> 2 </h4>                                                               <!-- QUANTIDADE -->
                            </td>
                            <td class="cart_description">
                                <h4>R$ 1500.0 </h4>                                                 <!-- TOTAL -->
                            </td>                            
                        </tr>
                        
                        </tbody>                     
                    </table>
                   
                    
                    
                    
                    
                </div>
            </div>        
       </div>   
       
        </div>
    <!--				
        COMPRAS FIM				
    -->       
                   
                            
        </br></br></br></br></br></br></br>
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

