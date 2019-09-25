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
            String clienteMsg = (String) session.getAttribute("clienteMsg");                            
            Cliente cliente = (Cliente) session.getAttribute("cliente");
            
            // Recupera os Dados de Endereço
            String enderecoMsg = (String) session.getAttribute("enderecoMsg");                            
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
        
       <div class="shop-menu clearfix pull-right">
            <a href="ControleCliente?acao=ChecarCliente"  class="fa fa-home"> Teste Comando </a>
        </div>
    
    
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

        
       
	<section>
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
                                                <h4 class="panel-title"><a href="index.jsp">Continuar as Compras</a></h4>
                                        </div>
                                    </div>							
                                    
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h4 class="panel-title"><a href="lobby.jsp" > Sua Conta </a></h4>
                                        </div>
                                    </div>

                                </div>

                    </div>
                </div>
                
                <!--
                    Painel FIM
                -->

                    

                    <div class="col-sm-9 padding-right" id="DadosPessoaisEEndereco"> 

                    <!--
                        Dados Pessoais 	
                    -->
                    <div class="col-sm-9 padding-right">
                        <%
                            if(clienteMsg == null){ clienteMsg=" ";}
                            if(cliente == null| cliente.getIdCliente() == 0 | cliente.getNome() == null){
                        %>
                        <div id="dadosClienteVazio">                            
                            <form method="post" action="ControleCliente" >
                                <h2> Dados Pessoais</h2>                               
                            </form>                            
                            
                            <form method="post" action="ControleCliente" >
                                                                  
                                <div class="form-group col-md-12">
                                  <label >Nome</label>
                                  <input type="text" class="form-control"  placeholder="Nome" name="nome" required="required">
                                </div>                                  
                                                               
                                <div class="form-row">
                                    <div class="form-group  col-md-6">
                                      <label >RG</label>
                                      <input type="number" class="form-control"  placeholder="Digite apenas números" name="rg" required="required">
                                    </div>


                                    <div class="form-group  col-md-6">
                                      <label >CPF</label>
                                      <input type="number" class="form-control"  placeholder="Digite apenas números" name="cpf" required="required">
                                    </div>
                                    
                                </div>
                                
                                <div class="form-row">
                                    <div class="form-group  col-md-6">
                                      <label >Telefone</label>
                                      <input type="number" class="form-control"  placeholder="Digite apenas números" name="telefone" required="required">
                                    </div>


                                    <div class="form-group  col-md-6">
                                      <label >Celular</label>
                                      <input type="number" class="form-control"  placeholder="Digite apenas números" name="celular" required="required">
                                    </div>
                                    
                                </div>                               
                                <div class="form-group  col-md-6">                          
                                   
                                    <input type="submit" name="acao"  class="btn btn-primary" id="CadastroCliente" value="Cadastrar" >
                                    
                                </div>
                                
                                <h6><%=clienteMsg%></h6>
                                
                            </form>
                        </div>            
                        <%  
                            }else{
                        %>
                        <div id="dadosClienteExistente">                            
                            <form method="post" action="ControleCliente" >
                                <h2> Dados Pessoais</h2>                               
                            </form>                            
                            
                            <form method="post" action="ControleCliente" >
                                                                  
                                <div class="form-group col-md-12">
                                  <label >Nome</label>
                                  <input type="text" class="form-control"  value="<%=cliente.getNome()%>" name="nome" required="required">
                                </div>                                  
                                                               
                                <div class="form-row">
                                    <div class="form-group  col-md-6">
                                      <label >RG</label>
                                      <input type="text" class="form-control"  value="<%=cliente.getRg()%>" name="rg" required="required">
                                    </div>


                                    <div class="form-group  col-md-6">
                                      <label >CPF</label>
                                      <input type="text" class="form-control"  value="<%= cliente.getCpf() %>" name="cpf" required="required">
                                    </div>
                                    
                                </div>
                                
                                <div class="form-row">
                                    <div class="form-group  col-md-6">
                                      <label >Telefone</label>
                                      <input type="text" class="form-control"  value="<%= cliente.getTelefone() %>" name="telefone" required="required">
                                    </div>


                                    <div class="form-group  col-md-6">
                                      <label >Celular</label>
                                      <input type="text" class="form-control"  value="<%= cliente.getCelular() %>" name="celular" required="required">
                                    </div>
                                    
                                </div>                               
                                <div class="form-group  col-md-6">                          
                                   
                                    <input type="submit" name="acao"  class="btn btn-primary" value="Salvar">
                                    
                                </div>
                                
                                <h6><%=clienteMsg%></h6>
                            </form>
                        </div>
                        
                    </div>
                    <!--							
                        Dados Pessoais 	FIM
                    -->            
                    
                    <!--			
                        Endereço
                    -->
                    <div class="col-sm-9 padding-right">       
                        <%
                            if(enderecoMsg == null){ enderecoMsg=" ";}
                            if(endereco == null | endereco.getIdEndereco() == 0 | endereco.getLogradouro() == null){    
                        %>    
                        <div id="dadosEnderecoVazio">
                            
                            <form method="post" action="ControleEndereco">
                                </br></br>
                                <h2> Dados Endereço</h2>                               
                            </form> 
                            
                            <form method="post" action="ControleEndereco" >
                                                                  
                                <div class="form-group col-md-12">
                                  <label >Rua/Avenida/Viela </label>
                                  <input type="text" class="form-control"  placeholder="Rua" name="logradouro" required="required">
                                </div>                                  
                                                               
                                <div class="form-row">
                                    <div class="form-group  col-md-6">
                                      <label >Número</label>
                                      <input type="number" class="form-control"  placeholder="nº" name="numero" required="required">
                                    </div>


                                    <div class="form-group  col-md-6">
                                      <label >CEP</label>
                                      <input type="number" class="form-control"  placeholder="CEP" name="cep" required="required">
                                    </div>
                                    
                                </div>
                                
                                <div class="form-row">
                                    <div class="form-group  col-md-6">
                                      <label >Bairro</label>
                                      <input type="text" class="form-control"  placeholder="Bairro"  name="bairro" required="required">
                                    </div>


                                    <div class="form-group  col-md-6">
                                      <label >Cidade</label>
                                      <input type="text" class="form-control"  placeholder="Cidade" name="cidade" required="required">
                                    </div>
                                    
                                </div>                               
                                <div class="form-group  col-md-6">                          
                                   
                                    <input type="submit" name="acao"  class="btn btn-primary" id="CadastroEndereco" value="Cadastrar">
                                    
                                </div>
                                
                                <h6><%=enderecoMsg%></h6>
                                
                            </form>
                        </div>
                        <%
                            }else{
                        %>    
                        <div id="dadosEnderecoExistente">
                            
                            <form method="post" action="ControleEndereco">
                                </br></br>
                                <h2> Dados Endereço</h2>                               
                            </form> 
                            <form method="post" action="ControleEndereco" >
                                                                  
                                <div class="form-group col-md-12">
                                  <label >Rua/Avenida/Viela </label>
                                  <input type="text" class="form-control"  value="<%= endereco.getLogradouro() %>" name="logradouro" required="required">
                                </div>                                  
                                                               
                                <div class="form-row">
                                    <div class="form-group  col-md-6">
                                      <label >Número</label>
                                      <input type="text" class="form-control"  value="<%= endereco.getNumero() %>" name="numero" required="required">
                                    </div>


                                    <div class="form-group  col-md-6">
                                      <label >CEP</label>
                                      <input type="text" class="form-control"  value="<%= endereco.getCep() %>" name="cep" required="required">
                                    </div>
                                    
                                </div>
                                
                                <div class="form-row">
                                    <div class="form-group  col-md-6">
                                        <label >Bairro</label>
                                      <input type="text" class="form-control" value="<%= endereco.getBairro() %>"  name="bairro" required="required">
                                    </div>


                                    <div class="form-group  col-md-6">
                                      <label >Cidade</label>
                                      <input type="text" class="form-control"  value="<%= endereco.getCidade() %>" name="cidade" required="required">
                                    </div>
                                    
                                </div>                               
                                <div class="form-group  col-md-6">                          
                                   
                                    <input type="submit" name="acao"  class="btn btn-primary" value="Salvar" >
                                    
                                </div>
                                
                                <h6><%=enderecoMsg%></h6>
                                
                            </form>
                        </div>
                        
                        <%
                            }}
                        %>
                    </div>
                    <!--							
                        Endereço 	FIM
                    -->            
                                
                    </div>            
            </div>
        </div>
	</section>
                            
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

