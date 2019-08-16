package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Modelo.Endereco;
import Modelo.Cliente;
import java.util.List;
import java.util.ArrayList;
import Modelo.Usuario;
import Modelo.ItemDeCompra;
import Modelo.CarrinhoDeCompra;

public final class carrinho_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");

    String msg = (String) session.getAttribute("msg");                            
    Usuario usuario = (Usuario) session.getAttribute("usuario");
    if(msg == null){ msg=" Bem vindo ";} 
    CarrinhoDeCompra carrinho = (CarrinhoDeCompra) session.getAttribute("carrinho");     

      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"\">\n");
      out.write("    <title>Cart | E-Shopper</title>\n");
      out.write("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"css/prettyPhoto.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"css/price-range.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"css/animate.css\" rel=\"stylesheet\">\n");
      out.write("\t<link href=\"css/main.css\" rel=\"stylesheet\">\n");
      out.write("\t<link href=\"css/responsive.css\" rel=\"stylesheet\">\n");
      out.write("    <!--[if lt IE 9]>\n");
      out.write("    <script src=\"js/html5shiv.js\"></script>\n");
      out.write("    <script src=\"js/respond.min.js\"></script>\n");
      out.write("    <![endif]-->       \n");
      out.write("    <link rel=\"shortcut icon\" href=\"images/ico/favicon.ico\">\n");
      out.write("    <link rel=\"apple-touch-icon-precomposed\" sizes=\"144x144\" href=\"images/ico/apple-touch-icon-144-precomposed.png\">\n");
      out.write("    <link rel=\"apple-touch-icon-precomposed\" sizes=\"114x114\" href=\"images/ico/apple-touch-icon-114-precomposed.png\">\n");
      out.write("    <link rel=\"apple-touch-icon-precomposed\" sizes=\"72x72\" href=\"images/ico/apple-touch-icon-72-precomposed.png\">\n");
      out.write("    <link rel=\"apple-touch-icon-precomposed\" href=\"images/ico/apple-touch-icon-57-precomposed.png\">\n");
      out.write("</head><!--/head-->\n");
      out.write("\n");
      out.write("<body>\n");
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
 if(usuario == null ){ 
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
      out.write("                                            <li><a href=\"sair.jsp\" class=\"fa fa-power-off\" > Sair </a></li>\n");
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
      out.write("                                    </div>                                    \n");
      out.write("                                    \n");
      out.write("\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <div class=\"shop-menu clearfix pull-right\">\n");
      out.write("                                            <a href=\"ControleCliente?acao=ChecarCliente\"  id=\"SuaConta\" class=\"fa fa-home\" >Sua Conta</a>\n");
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
      out.write("            Barra Superior Login / FIM       \n");
      out.write("    -->\n");
      out.write("\t\n");
      out.write("    <!--\n");
      out.write("        CARRINHO\n");
      out.write("    -->\n");
      out.write("\t          \n");
      out.write("        <section id=\"cart_items\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"table-responsive cart_info\">\n");
      out.write("                    <table class=\"table table-condensed\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr class=\"cart_menu\">\n");
      out.write("                                <td class=\"image\">Item</td>\n");
      out.write("                                <td class=\"description\"></td>\n");
      out.write("                                <td class=\"price\">Preço</td>\n");
      out.write("                                <td class=\"quantity\">Quantidade</td>\n");
      out.write("                                <td class=\"total\">Total</td>\n");
      out.write("                                <td></td>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>     \n");
      out.write("                        \n");
      out.write("                        ");

                            for(ItemDeCompra item : carrinho.getItens()){
                        
      out.write("\n");
      out.write("                        <tbody>\n");
      out.write("                        <tr>\n");
      out.write("                            <td class=\"cart_product\">\n");
      out.write("                                <a href=\"\"><img src=\"imagens/");
      out.print(item.getProduto().getImagem());
      out.write("\" alt=\"");
      out.print(item.getProduto().getImagem());
      out.write("\"></a>\n");
      out.write("                            </td>\n");
      out.write("                            <td class=\"cart_description\">\n");
      out.write("                                <h4>");
      out.print(item.getProduto().getNome() );
      out.write("</h4>                                \n");
      out.write("                            </td>\n");
      out.write("                            <td class=\"cart_price\">\n");
      out.write("                                <p>");
      out.print(item.getProduto().getValorLocacao() );
      out.write("</p>\n");
      out.write("                            </td>\n");
      out.write("                            <td class=\"cart_quantity\">\n");
      out.write("                                <div class=\"cart_quantity_button\">\n");
      out.write("                                    <a class=\"cart_quantity_up\" href=\"ControleCarrinho?acao=addProduto&idProduto=");
      out.print(item.getProduto().getIdProduto());
      out.write("\"> + </a>\n");
      out.write("                                    <input class=\"cart_quantity_input\" type=\"text\" name=\"quantity\" value=\"");
      out.print(item.getQuantidade());
      out.write("\" readonly autocomplete=\"off\" size=\"2\">\n");
      out.write("                                    <a class=\"cart_quantity_down\" href=\"ControleCarrinho?acao=diminuiProduto&idProduto=");
      out.print(item.getProduto().getIdProduto());
      out.write("\"> - </a>\n");
      out.write("                                </div>\n");
      out.write("                            </td>\n");
      out.write("                            <td class=\"cart_total\">\n");
      out.write("                                <p class=\"cart_total_price\">R$ ");
      out.print(item.getTotal());
      out.write("</p>\n");
      out.write("                            </td>\n");
      out.write("                            <td class=\"cart_delete\">\n");
      out.write("                                <a href=\"ControleCarrinho?acao=removeProduto&idProduto=");
      out.print(item.getProduto().getIdProduto());
      out.write("\" class=\"cart_quantity_delete\"><i class=\"fa fa-times\"></i></a>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        </tbody>\n");
      out.write("                        ");

                            }
                        
      out.write("\n");
      out.write("\n");
      out.write("                            \n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\t</section> <!--/#cart_items-->        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("    <!--\n");
      out.write("        CARRINHO FIM\n");
      out.write("    -->\n");
      out.write("\t\n");
      out.write("    <!--\n");
      out.write("            OPÇÕES\n");
      out.write("    -->\t\n");
      out.write("            <section id=\"do_action\">\n");
      out.write("\t\t<div class=\"container\">\n");
      out.write("\t\t\t<div class=\"heading\">\n");
      out.write("\t\t\t\t<h3>O que gostaria de fazer agora ?</h3>\t\t\t\t\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"row\">\n");
      out.write("                            <div class=\"col-sm-6\">\t\t\t\t\t\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-sm-6\">\n");
      out.write("                                <div class=\"total_area\">\n");
      out.write("                                    <ul>\t\t\t\t\t\t\t\n");
      out.write("                                        <li>Total<span> R$ ");
      out.print(carrinho.calculaTotal() );
      out.write("</span></li>\n");
      out.write("\n");
      out.write("                                    </ul>\n");
      out.write("                                        <div class=\"row\">\n");
      out.write("                                            \t\t\t\t\n");
      out.write("                                            <a class=\"btn btn-default update\" href=\"ControleCarrinho?acao=cancelaCompra\">Cancelar Locação</a>\n");
      out.write("                                            <a class=\"btn btn-default update\" href=\"index.jsp\">Continuar Alugando</a>                                       \n");
      out.write("                                            <a class=\"btn btn-default check_out\" href=\"ControleCarrinho?acao=FinalizaLocacao\">Finalizar Locação </a>\t\t\t\t\t\t\t\n");
      out.write("                                            \n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</section>\n");
      out.write("    <!--\n");
      out.write("            OPÇÕES\n");
      out.write("    -->\n");
      out.write("\t\n");
      out.write("    <!--\t\n");
      out.write("     RODAPÉ\t\n");
      out.write("    -->\t\n");
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
      out.write("    <!--\t\n");
      out.write("     RODAPÉ FIM\t\n");
      out.write("    -->\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\n");
      out.write("\n");
      out.write("    <script src=\"js/jquery.js\"></script>\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"js/jquery.scrollUp.min.js\"></script>\n");
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
