/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.5
 * Generated at: 2020-06-19 06:39:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.bbs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class update_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("jar:file:/C:/data/jsp/0511/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/semiProject/WEB-INF/lib/standard.jar!/META-INF/fmt.tld", Long.valueOf(1098678690000L));
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1589249478582L));
    _jspx_dependants.put("jar:file:/C:/data/jsp/0511/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/semiProject/WEB-INF/lib/standard.jar!/META-INF/fn.tld", Long.valueOf(1098678690000L));
    _jspx_dependants.put("jar:file:/C:/data/jsp/0511/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/semiProject/WEB-INF/lib/standard.jar!/META-INF/c.tld", Long.valueOf(1098678690000L));
  }

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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("\t<script src=\"http://code.jquery.com/jquery-1.9.1.js\"></script>\r\n");
      out.write("\t<script src=\"https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js\"></script>\r\n");
      out.write("\t<title>편의점 관리시스템</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../enter.css\" media=\"all\" />\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"../home.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"divPage\">\r\n");
      out.write("\t<div id=\"divTop\">");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../top.jsp", out, false);
      out.write("</div>\r\n");
      out.write("\t\t<div class=\"dropmenu\">\r\n");
      out.write("\t\t\t<ul id=\"dm_ul\" style=\"background: white; margin-bottom: 20px\">\r\n");
      out.write("\t\t\t\t<li><a id=plist href=\"/semiProject/product/list.jsp\">상품리스트</a></li>&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<li>현황관리\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><a class=alist href=\"/semiProject/stock/list.jsp\">재고현황</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a class=alist href=\"/semiProject/sell_status/list.jsp\">판매현황</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a class=alist href=\"/semiProject/order/list.jsp\">발주현황</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</li>&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t<li>등록관리\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><a class=alist href=\"/semiProject/cart/cartList.jsp\">발주등록</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a class=alist href=\"/semiProject/product/insert.jsp\">상품등록</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</li>&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t<li>이건어때\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><a class=alist href=\"/semiProject/bbs/insert.jsp\">제안해요</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<div class=\"relCon\">\r\n");
      out.write("\t\t<!-- 아이디어 게시판-view -->\r\n");
      out.write("\t\t<div class=\"idea_list\">\r\n");
      out.write("\t\t\t<br><br>\r\n");
      out.write("\t\t\t<!-- view영역 -->\r\n");
      out.write("\t\t\t<!-- 2018-01-12이거어때 -->\r\n");
      out.write("\t\t\t<div class=\"idea_view\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t<div class=\"cont_box\">\r\n");
      out.write("\t\t\t\t\t<div class=\"head_cont\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.bno}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" id=\"idididid\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${company_id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t제목: <input type=\"text\" id=\"tt\" size=50 value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"detail_box\">\r\n");
      out.write("\t\t\t\t\t<!-- 2018-04-04 추가 -->\r\n");
      out.write("\t\t\t\t\t\t<textarea style=\"width:700px;height:300px;\" id=\"cc\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.contents}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</textarea>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"btnNormal\">\r\n");
      out.write("\t\t\t\t<button style= \"background-color: #2569C9;\r\n");
      out.write("  border: none;\r\n");
      out.write("  color: white;\r\n");
      out.write("  padding: 5px 12px;\r\n");
      out.write("  text-align: center;\r\n");
      out.write("  text-decoration: none;\r\n");
      out.write("  display: inline-block;\r\n");
      out.write("  font-size: 16px;\r\n");
      out.write("  margin: 4px 2px;\r\n");
      out.write("  cursor: pointer;\r\n");
      out.write("  border-radius:10px;\"><a href=\"list.jsp\" style=text-decoration:none;font-color:white>목록</a></span>\r\n");
      out.write("\t\t\t\t<button id=\"bbsupdate\" style= \"background-color: #2569C9;\r\n");
      out.write("  border: none;\r\n");
      out.write("  color: white;\r\n");
      out.write("  padding: 5px 12px;\r\n");
      out.write("  text-align: center;\r\n");
      out.write("  text-decoration: none;\r\n");
      out.write("  display: inline-block;\r\n");
      out.write("  font-size: 16px;\r\n");
      out.write("  margin: 4px 2px;\r\n");
      out.write("  cursor: pointer;\r\n");
      out.write("  border-radius:10px;\">수정</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"divFoot\" style=\"text-align: center\">");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../footer.jsp", out, false);
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("<script>\r\n");
      out.write("\tvar bno=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.bno}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("\t\r\n");
      out.write("\t$(\".dropmenu ul li\").hover(function() {\r\n");
      out.write("\t\t$(this).find(\"ul\").stop().fadeToggle(300);\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#bbsupdate\").on(\"click\",function(){\r\n");
      out.write("\t\tif(!confirm(\"수정하시겠습니까?\")) return;\r\n");
      out.write("\t\tvar title=$(\"#tt\").val();\r\n");
      out.write("\t\tvar contents=$(\"#cc\").val();\r\n");
      out.write("\t\tvar company_id=$(\"#idididid\").val();\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\ttype:\"post\",\r\n");
      out.write("\t\t\turl:\"update\",\r\n");
      out.write("\t\t\tdataType:\"json\",\r\n");
      out.write("\t\t\tdata:{\"company_id\":company_id,\"title\":title,\"contents\":contents,\"bno\":bno},\r\n");
      out.write("\t\t\tsuccess:function(data){\r\n");
      out.write("\t\t\t\tif(data.count==1){\r\n");
      out.write("\t\t\t\t\talert(\"수정되었습니다!\");\r\n");
      out.write("\t\t\t\t\tlocation.href=\"/semiProject/bbs/read?bno=\"+bno;\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\talert(\"권한이 없습니다!\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
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
