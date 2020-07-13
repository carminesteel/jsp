/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.5
 * Generated at: 2020-06-05 07:40:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.professors;

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
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<link rel =\"stylesheet\" href=\"../home.css\">\r\n");
      out.write("\t<script src=\"http://code.jquery.com/jquery-1.9.1.js\"></script>\r\n");
      out.write("\t<script src=\"https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js\"></script>\r\n");
      out.write("\t<title>학사관리 시스템</title>\r\n");
      out.write("\t\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"divPage\">\r\n");
      out.write("\t\t<div id=\"divTop\">");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../header.jsp", out, false);
      out.write("</div>\r\n");
      out.write("\t<div id=\"divCenter\">\r\n");
      out.write("\t\t<div id=\"divMenu\">");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../menu.jsp", out, false);
      out.write("</div>\r\n");
      out.write("\t\t<div id=\"divContent\">\r\n");
      out.write("\t\t\t<!-- 여기에 내용 등록 시작--------------------------------------------->\r\n");
      out.write("\t\t\t<div id=\"divHeader\"><h2>교 수 등 록</h2></div>\r\n");
      out.write("\t\t\t<form name=\"frm\" action=\"insert\" method=\"post\">\r\n");
      out.write("\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td width=100 class=\"title\" width=150>교수번호</td>\r\n");
      out.write("\t\t\t\t\t\t<td width=100><input type=\"text\" name=\"pcode\" value=\"\"size=10></td>\r\n");
      out.write("\t\t\t\t\t\t<td width=100 class=\"title\" width=150>교수학과</td>\r\n");
      out.write("\t\t\t\t\t\t<td width=100>\r\n");
      out.write("\t\t\t\t\t\t\t<select name=\"dept\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<option>전산</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option>전자</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option>건축</option>\r\n");
      out.write("\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td width=100 class=\"title\" width=150>임용일자</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"yy\" value=\"\" maxlength=4 size=2>년\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"MM\" value=\"\" maxlength=4 size=2>월\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"dd\" value=\"\" maxlength=4 size=2>일\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td width=100 class=\"title\" width=150>교수이름</td>\r\n");
      out.write("\t\t\t\t\t\t<td width=100><input type=\"text\" name=\"pname\" value=\"\" size=10></td>\r\n");
      out.write("\t\t\t\t\t\t<td width=100 class=\"title\" width=150>교수급여</td>\r\n");
      out.write("\t\t\t\t\t\t<td><input type=\"text\" name=\"salary\" value=\"\" maxlength=12/></td>\r\n");
      out.write("\t\t\t\t\t\t<td width=100 class=\"title\" width=150>교수직급</td>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"radio\" name=\"title\" value=\"정교수\">정교수\r\n");
      out.write("\t\t\t\t\t\t<input type=\"radio\" name=\"title\" value=\"부교수\">부교수\r\n");
      out.write("\t\t\t\t\t\t<input type=\"radio\" name=\"title\" value=\"조교수\">조교수\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t </tr>\r\n");
      out.write("\t\t\t\t </table>\r\n");
      out.write("\t\t\t\t <div id=\"pagination\">\r\n");
      out.write("\t\t\t\t <input type=\"submit\" value=\"저장\">\r\n");
      out.write("\t\t\t\t <input type=\"reset\" value=\"취소\">\r\n");
      out.write("\t\t\t </div>\r\n");
      out.write("\t\t\t</form>\t\t\t \r\n");
      out.write("\t\t\t<!-- 여기에 내용 등록 종료--------------------------------------------->\r\n");
      out.write("\t\t\t<div id=\"divBottom\">");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../footer.jsp", out, false);
      out.write("</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("\t$(frm).submit(function(e){\r\n");
      out.write("\t\talert(\"dd\")\r\n");
      out.write("\t\te.preventDefault();\r\n");
      out.write("\t\tif(!confirm(\"새로운 교수를 등록하시겠습니까?\")) return;\r\n");
      out.write("\t\tvar pcode=$(frm.pcode).val();\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\ttype:\"get\",\r\n");
      out.write("\t\t\turl:\"/professors/ck\",\r\n");
      out.write("\t\t\tdata:{\"pcode\":pcode},\r\n");
      out.write("\t\t\tdataType:\"json\",\r\n");
      out.write("\t\t\tsuccess:function(data){\r\n");
      out.write("\t\t\t\tif(data.count==1){\r\n");
      out.write("\t\t\t\t\talert(\"이미 사용한 코드입니다\");\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\tfrm.submit();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t})\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("</html>\r\n");
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
