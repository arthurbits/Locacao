package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Modelo.Endereco;
import ModeloDao.EnderecoDao;
import Modelo.Cliente;
import ModeloDao.ClienteDao;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Date;
import java.util.ArrayList;
import Modelo.Usuario;
import Modelo.Produto;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("             \n");
      out.write("        \n");
      out.write("        \n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"\">\n");
      out.write("    <title>Principal</title>\n");
      out.write("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"css/prettyPhoto.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"css/price-range.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"css/animate.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"css/main.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"css/responsive.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"css/main.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    <!--[if lt IE 9]>\n");
      out.write("    <script src=\"js/html5shiv.js\"></script>\n");
      out.write("    <script src=\"js/respond.min.js\"></script>\n");
      out.write("    <![endif]-->       \n");
      out.write("    <link rel=\"shortcut icon\" href=\"images/ico/favicon.ico\">\n");
      out.write("    <link rel=\"apple-touch-icon-precomposed\" sizes=\"144x144\" href=\"images/ico/apple-touch-icon-144-precomposed.png\">\n");
      out.write("    <link rel=\"apple-touch-icon-precomposed\" sizes=\"114x114\" href=\"images/ico/apple-touch-icon-114-precomposed.png\">\n");
      out.write("    <link rel=\"apple-touch-icon-precomposed\" sizes=\"72x72\" href=\"images/ico/apple-touch-icon-72-precomposed.png\">\n");
      out.write("    <link rel=\"apple-touch-icon-precomposed\" href=\"images/ico/apple-touch-icon-57-precomposed.png\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n");
      out.write("</head><!--/head-->\n");
      out.write("\n");
      out.write("<body>         \n");
      out.write("        \n");
      out.write("    ");

        String msg = (String) session.getAttribute("msg");                            
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if(msg == null){ msg=" Bem vindo ";}
    
      out.write("\n");
      out.write("    <!--\n");
      out.write("            Barra Superior Login\n");
      out.write("    -->\n");
      out.write("        <header id=\"header\"><!--header-->\n");
      out.write("\t\t\n");
      out.write("            <div class=\"header-middle\"><!--header-middle-->\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-12 clearfix\">                            \n");
      out.write("                            \n");
      out.write("                            ");
 if(usuario == null || usuario.getUsuario() == null ){ 
      out.write("\n");
      out.write("                                <form action=\"ControleUsuario\" class=\"form-inline\"  method=\"post\"  autocomplete=\"on\">                                                   \n");
      out.write("                                    <div class=\"shop-menu clearfix pull-right\">\n");
      out.write("                                        <ul class=\"nav navbar-nav\">\t\n");
      out.write("                                            <li><h6>");
      out.print(msg);
      out.write("</h6></li>                 \n");
      out.write("                                            <li><a href=\"cadastro.jsp\"><i class=\"fa fa-lock\"></i> Cadastre-se</a></li>\n");
      out.write("                                            <li><input type=\"text\" name=\"usuario\" placeholder=\"Usuário\"></li>\n");
      out.write("                                            <li><input type=\"password\" name=\"senha\"  placeholder=\"Senha\"></li>\n");
      out.write("                                            <li><input type=\"submit\" name=\"acao\" id=\"fazerLogin\" value=\"Entrar\"></li>                        \n");
      out.write("                                        </ul>                                    \n");
      out.write("                                    </div>                                      \n");
      out.write("                                </form>                   \n");
      out.write("                            ");
 }else if(usuario.getAtivo()==false){  
      out.write("\n");
      out.write("                                <form action=\"ControleUsuario\" class=\"form-inline\"  method=\"post\"  autocomplete=\"on\">                                                   \n");
      out.write("                                    <div class=\"shop-menu clearfix pull-right\">\n");
      out.write("                                        <ul class=\"nav navbar-nav\">\t\n");
      out.write("                                            <li><h6>");
      out.print(msg);
      out.write("</h6></li>                                          \n");
      out.write("                                            <li><input type=\"submit\" class=\"btn btn-primary\"  value=\"Reenviar E-mail de validação\"></li>   \n");
      out.write("                                            <li><a href=\"sair.jsp\" class=\"fa fa-power-off\"> Sair </a><li>\n");
      out.write("                                        </ul>                                    \n");
      out.write("                                    </div>                                      \n");
      out.write("                                </form> \n");
      out.write("                            \n");
      out.write("                            ");
 }else{  
      out.write("    \n");
      out.write("                                <div class=\"form-inline\" style=\"text-align:right ;\">  \n");
      out.write("                                       \n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <h6>");
      out.print(msg);
      out.write(" &nbsp &nbsp </h6>\n");
      out.write("                                    </div>\n");
      out.write("                                    \n");
      out.write("                                    \n");
      out.write("\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <div class=\"shop-menu clearfix pull-right\">\n");
      out.write("                                            <a href=\"ControleCliente?acao=ChecarCliente\"  class=\"fa fa-home\">Sua Conta</a>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                      \n");
      out.write("                                        <div class=\"shop-menu clearfix pull-right\">\n");
      out.write("                                          \n");
      out.write("                                            <a href=\"sair.jsp\" class=\"fa fa-power-off\" > Sair </a>\n");
      out.write("                                        </div>\n");
      out.write("                                       \n");
      out.write("                                    </div> \n");
      out.write("\n");
      out.write("                                </div>                                                \n");
      out.write("                            ");
 } 
      out.write("                    \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div><!--/header-middle-->\n");
      out.write("\t\n");
      out.write("\t\t<div class=\"header-bottom\"><!--header-bottom-->\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-sm-9\">                              \n");
      out.write("                                \n");
      out.write("                                <div class=\"mainmenu pull-left\">\n");
      out.write("                                    <ul class=\"nav navbar-nav collapse navbar-collapse\">\n");
      out.write("                                        <li><a href=\"index.jsp\" class=\"active\">Principal</a></li>\n");
      out.write("\n");
      out.write("                                    </ul>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-sm-3\">\n");
      out.write("                                <div class=\"search_box pull-right\">\n");
      out.write("                                    <input type=\"text\" placeholder=\"Buscar\"/>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</header>\n");
      out.write("    <!--        \n");
      out.write("        Barra Superior Login / FIM       \n");
      out.write("    --> \n");
      out.write("        \n");
      out.write("        <section>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("        <!--\n");
      out.write("            CATEGORIA\n");
      out.write("        -->\n");
      out.write("                <div class=\"col-sm-3\">\n");
      out.write("                    <div class=\"left-sidebar\">        \n");
      out.write("                                <h2>Categoria</h2>\n");
      out.write("                                <div class=\"panel-group category-products\" id=\"accordian\"><!--category-productsr-->\n");
      out.write("                                    <div class=\"panel panel-default\">\n");
      out.write("                                        <div class=\"panel-heading\">\n");
      out.write("                                                <h4 class=\"panel-title\"><a href=\"index.jsp\">Brinquedos</a></h4>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div> \n");
      out.write("                                </div>        \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("        <!--\n");
      out.write("            CATEGORIA FIM\n");
      out.write("        -->\n");
      out.write("                <div class=\"col-sm-9 padding-right\">\n");
      out.write("        <!--\t\n");
      out.write("                PRODUTOS\n");
      out.write("        -->\n");
      out.write("                        ");

                            // Recupera os produtos.
                            ArrayList<Produto> produtos = (ArrayList<Produto>) request.getAttribute("produtos");
                            if(produtos == null) {
                                request.getRequestDispatcher("/ControleProduto?acao=listaProdutos").forward(request, response);
                            }
                        
      out.write("\n");
      out.write("                        <div class=\"features_items\"><!--features_items-->\n");
      out.write("                                <h2 class=\"title text-center\"></h2>\n");
      out.write("                                ");
                                      
                                    for(Produto produto : produtos){                                            
                                
      out.write("\n");
      out.write("                                <div class=\"col-sm-4\">\n");
      out.write("                                    <div class=\"product-image-wrapper\">\n");
      out.write("                                        <div class=\"single-products\">\n");
      out.write("                                            <div class=\"productinfo text-center\">\n");
      out.write("                                                    <img   src=\"imagens/");
      out.print(produto.getImagem());
      out.write("\" alt=\"");
      out.print(produto.getImagem());
      out.write("\" />\n");
      out.write("                                                    <h2>Valor : R$  ");
      out.print(produto.getValorVenda());
      out.write("</h2>\n");
      out.write("                                                    <a href=\"#\"  class=\"btn btn-default add-to-cart \" <i class=\"fa-shopping-bag\"></i>");
      out.print(produto.getNome());
      out.write("</a>                                                   \n");
      out.write("                                                    <a href=\"#\" class=\"btn btn-default add-to-cart\"><i class=\"fa fa-shopping-cart\"></i>Adicionar ao Carrinho</a>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"product-overlay\">\n");
      out.write("                                                    <div class=\"overlay-content\">\n");
      out.write("                                                            <h2>Valor : R$  ");
      out.print(produto.getValorVenda());
      out.write("</h2>                                                            \n");
      out.write("                                                            <a href=\"ControleCarrinho?acao=detalhesProduto&idProduto=");
      out.print(produto.getIdProduto());
      out.write("\"  class=\"btn btn-default add-to-cart \" <i class=\"fa-shopping-bag\"></i>");
      out.print(produto.getNome());
      out.write("</a>                                                   \n");
      out.write("                                                            <a href=\"ControleCarrinho?acao=addProduto&idProduto=");
      out.print(produto.getIdProduto());
      out.write("\" class=\"btn btn-default add-to-cart\"><i class=\"fa fa-shopping-cart\"></i>Adicionar ao Carrinho</a>\n");
      out.write("                                                    </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            \n");
      out.write("                                        </div>\t\t\t\t\t\t\t\t\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                ");
                                   
                                   }//fim do for
                                
      out.write("\n");
      out.write("                        </div>\n");
      out.write("        <!--\t\t\n");
      out.write("            PRODUTOS FIM \n");
      out.write("        -->\t\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\t</section>\n");
      out.write("        <!--\t\n");
      out.write("         RODAPÉ\t\n");
      out.write("        -->\t\n");
      out.write("            <footer id=\"footer\">\t\t\n");
      out.write("                <div class=\"footer-widget\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <div class=\"col-md12\">\n");
      out.write("                            <div class=\"single-widget\">\n");
      out.write("                                <h2>Service</h2>\n");
      out.write("                                <ul class=\"nav nav-pills nav-stacked\">\n");
      out.write("                                <li><h6>Online Help</h6></li>\n");
      out.write("                                <li><h6>Contact Us</h6></li>\t\t\t\t\t\t\t\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"footer-bottom\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <p class=\"pull-left\">Copyright © 2013 E-SHOPPER Inc. All rights reserved.</p>\n");
      out.write("                            <p class=\"pull-right\">Designed by <span><a target=\"_blank\" href=\"http://www.themeum.com\">Themeum</a></span></p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </footer>\t\n");
      out.write("        <!--\t\n");
      out.write("         RODAPÉ FIM\t\n");
      out.write("        -->\n");
      out.write("\t\n");
      out.write("\n");
      out.write("  \n");
      out.write("    <script src=\"js/jquery.js\"></script>\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"js/jquery.scrollUp.min.js\"></script>\n");
      out.write("    <script src=\"js/price-range.js\"></script>\n");
      out.write("    <script src=\"js/jquery.prettyPhoto.js\"></script>\n");
      out.write("    <script src=\"js/main.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
