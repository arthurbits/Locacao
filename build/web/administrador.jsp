
<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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
    
        <title>ADM</title>
    </head>
    <body>
        <footer>
           
            <div class="col-md-5">
                <%                                                
                    Usuario usuario = (Usuario) session.getAttribute("usuario");
                    if(usuario==null){
                        response.sendRedirect("index.jsp");
                    }
                    if(!usuario.getCredencial().equals("Administrador")){ 
                        response.sendRedirect("index.jsp");
                    }
                %>
                <h4>Página do Administrador</h4>
            </div>

            <div class="col-md-2">
                <a href="sair.jsp" class="w3-btn">Sair</a>
            </div>
                
        </footer>
                
                
                
        <div class="col-md-5">            
            <a href="" class="w3-btn">Locação</a>
            <a href="" class="w3-btn">Cadastro de Itens</a>
            <a href="" class="w3-btn">Cadastro de Funcionários</a>
        </div>        
        </br></br></br></br></br></br></br>
        
        <div class="col-md-12">
            <div class="cart__header__title">
            <h1 class="cart-title">Carrinho</h1>
            </div>
        <div class="cities">
            <p class="empty-info">Para adicionar produtos ao carrinho, procure pelo produto em nosso site e cliqueno botão "Comprar" na página do produto.</p>
            <a id="back-to-store" href="/" class="btn btn-default update">voltar para a loja</a>
        </div>
        </div>        
    </body>
</html>
