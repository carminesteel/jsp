/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.5
 * Generated at: 2020-06-19 06:34:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.stock;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>재고</title>\r\n");
      out.write("<script src=\"http://code.jquery.com/jquery-3.1.1.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../home.css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("   <div id=\"divPage\" style=\"background:#F2F2F2;\">\r\n");
      out.write("   <div id=\"divTop\">");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../top2.jsp", out, false);
      out.write("</div>\r\n");
      out.write("   <div class=\"dropmenu\">\r\n");
      out.write("\t\t\t\t<ul id=\"dm_ul\" style=\"background:#F2F2F2\">\r\n");
      out.write("\t\t\t\t\t<li><a id=plist href=\"/semiProject/product/list.jsp\">재고리스트</a></li>&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<li>현황관리\r\n");
      out.write("\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a class=alist href=\"/semiProject/stock/list.jsp\">재고현황</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a class=alist href=\"/semiProject/sell_status/list.jsp\">판매현황</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a class=alist href=\"/semiProject/order/list.jsp\">발주현황</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t<li>등록관리\r\n");
      out.write("\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a class=alist href=\"/semiProject/cart/cartList.jsp\">발주등록</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a class=alist href=\"/semiProject/product/insert.jsp\">상품등록</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t<li><a href=\"/semiProject/bbs/list.jsp\" style=text-decoration:none;color:#2569C9>이거어때?</a>\r\n");
      out.write("\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a class=alist href=\"/semiProject/bbs/insert.jsp\">제안해요</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("      <div id=\"divMenu\"></div>\r\n");
      out.write("      <div id=\"divHeader\">\r\n");
      out.write("         <h2>재 고 현 황</h2>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div id=\"divCondition\">\r\n");
      out.write("         \r\n");
      out.write("      </div>\r\n");
      out.write("       <table id=\"tbl\"></table>    \r\n");
      out.write("         <script id=\"temp\" type=\"text/x-handlebars-template\">  \r\n");
      out.write("           <tr class=\"title\">          \r\n");
      out.write("          \t<td width=100>StoreNumber</td>    \r\n");
      out.write("\t\t\t<td width=100>CategoryCode</td>\r\n");
      out.write("\t\t\t<td width=100>상품코드</td>\r\n");
      out.write("\t\t\t<td width=250>상품명</td>\r\n");
      out.write("\t\t\t<td width=100>제조일자</td>\r\n");
      out.write("\t\t\t<td width=100>유통기한</td>\r\n");
      out.write("\t\t\t<td width=100>수량</td>\r\n");
      out.write("\t\r\n");
      out.write("          </tr>       \r\n");
      out.write("         {{#each array}}       \r\n");
      out.write("          <tr class=\"row\">       \r\n");
      out.write("             <td class=\"cvs_code\">{{cvs_code}}</td>   \r\n");
      out.write(" \r\n");
      out.write("\t\t\t <td class=\"category_code\">{{category_code}}</td>\r\n");
      out.write("\t\t\t <td class=\"cvs_code\">{{product_code}}</td>     \r\n");
      out.write("\t\t\t <td class=\"cvs_code\">{{product_name}}</td>\r\n");
      out.write("\t\t\t <td class=\"cvs_code\">{{product_date}}</td>\t\r\n");
      out.write("\t\t\t <td class=\"cvs_code\">{{product_exp}}</td>\r\n");
      out.write("\t\t\t <td class=\"cvs_code\">{{stock}}</td>\r\n");
      out.write("           </tr>      \r\n");
      out.write("           {{/each}}\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t<div id=\"pagination\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<button id=\"btnPre\">◀</button>\r\n");
      out.write("\t\t\t<button id=\"btnNext\">▶</button>\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t[<span id=\"curPage\"></span>/<span id=\"totPage\"></span>]\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t   <div id=\"divFoot\" style=\"text-align: center\">");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../footer.jsp", out, false);
      out.write("</div>   \r\n");
      out.write("   </div>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("var url=\"list\";\r\n");
      out.write("\r\n");
      out.write("$(\".dropmenu ul li\").hover(function(){\r\n");
      out.write("\t$(this).find(\"ul\").stop().fadeToggle(300);\r\n");
      out.write("})\r\n");
      out.write("</script>\r\n");
      out.write("<script src=\"../home.js\"></script>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
