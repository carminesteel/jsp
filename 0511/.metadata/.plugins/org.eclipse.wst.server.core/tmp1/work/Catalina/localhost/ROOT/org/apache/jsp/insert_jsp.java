/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.5
 * Generated at: 2020-05-22 02:14:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class insert_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<link rel=\"stylesheet\" href=\"home.css\"/>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<title>한빛 미디어</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id = \"page\">\r\n");
      out.write("\t\t<div id = \"header\">");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("</div>\r\n");
      out.write("\t\t<div id = \"center\">\r\n");
      out.write("\t\t\t<div id = \"menu\">");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "menu.jsp", out, false);
      out.write("</div>\r\n");
      out.write("\t\t\t<div id = \"content\">\r\n");
      out.write("\t\t\t<!-- 여기에 출력할 내용 작성 시작 -->\r\n");
      out.write("\t\t\t\t<h2>[회원가입]</h2>\r\n");
      out.write("\t\t\t\t<form name=\"ufrm\">\r\n");
      out.write("\t\t\t\t\t<table width=500>\r\n");
      out.write("\t\t\t\t\t\t<tr class=row>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=title>아이디</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"text\" name=\"id\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=title>비밀번호</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"password\" name=\"pass\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=title>이름</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"text\" name=\"name\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" value=\"저장\">\r\n");
      out.write("\t\t\t\t\t<input type=\"reset\" value=\"취소\">\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t<!-- 여기에 출력할 내용 작성 종료 -->\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id = \"footer\">");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("\t$(ufrm).submit(function(e){\r\n");
      out.write("\t\te.preventDefault();\r\n");
      out.write("\t\tif(!confirm(\"저장하시겠습니까?\")) return;\r\n");
      out.write("\t\tvar id=$(ufrm.id).val();\r\n");
      out.write("\t\tvar pass=$(ufrm.pass).val();\r\n");
      out.write("\t\tvar name=$(ufrm.name).val();\r\n");
      out.write("\t\tif(id==\"\"||pass==\"\"||name==\"\"){\r\n");
      out.write("\t\t\talert(\"모든 데이터를 입력하세요\");\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\ttype:\"post\",\r\n");
      out.write("\t\t\t\turl:\"/user/insert\",\r\n");
      out.write("\t\t\t\tdata:{\"id\":id,\"pass\":pass,\"name\":name},\r\n");
      out.write("\t\t\t\tdataType:\"json\",\r\n");
      out.write("\t\t\t\tsuccess:function(data){\r\n");
      out.write("\t\t\t\t\tif(data.count==0){\r\n");
      out.write("\t\t\t\t\t\talert(\"등록되었습니다\");\r\n");
      out.write("\t\t\t\t\t\tlocation.href=\"/user/list\"\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\talert(\"이미 등록된 회원입니다.\");\r\n");
      out.write("\t\t\t\t\t\t$(ufrm.id).focus();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t}\r\n");
      out.write("\t})\r\n");
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
