/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.5
 * Generated at: 2020-06-19 05:23:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.bbs;

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
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<script src=\"http://code.jquery.com/jquery-1.9.1.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js\"></script>\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../enter.css\" media=\"all\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../home.css\">\r\n");
      out.write("<style>\r\n");
      out.write(".title {\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".title:hover {\r\n");
      out.write("\ttext-decoration: underline;\r\n");
      out.write("\tcolor: red;\r\n");
      out.write("\ttext-decoration-style: solid;\r\n");
      out.write("\ttext-decoration-color: red;\r\n");
      out.write("\ttext-decoration-thickness: 2px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".txt {\r\n");
      out.write("\ttext-overflow: ellipsis;\r\n");
      out.write("\twhite-space: nowrap;\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("link {\r\n");
      out.write("\tdisplay: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("body {\r\n");
      out.write("\tline-height: inherit;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("html, body, div, applet, object, iframe, h1, h2, h3, h4, h5, h6, p,\r\n");
      out.write("\tblockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn,\r\n");
      out.write("\tem, img, ins, kbd, q, s, samp, small, strike, sub, sup, tt, var, b, u,\r\n");
      out.write("\ti, center, dl, dt, dd, ol, ul, li, fieldset, form, label, legend, table,\r\n");
      out.write("\tcaption, tfoot, thead, article, aside, canvas, details, embed, figure,\r\n");
      out.write("\tfigcaption, footer, header, hgroup, menu, nav, output, ruby, section,\r\n");
      out.write("\tsummary, time, mark, audio, video {\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("\tborder: 0;\r\n");
      out.write("\tfont-size: inherit;\r\n");
      out.write("\tvertical-align: top;\r\n");
      out.write("\tcolor: inherit;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"divPage\">\r\n");
      out.write("\t\t<div id=\"divTop\">");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../top2.jsp", out, false);
      out.write("</div>\r\n");
      out.write("\t\t<div class=\"dropmenu\">\r\n");
      out.write("\t\t\t<ul id=\"dm_ul\" style=\"background: white; margin-bottom: 20px\">\r\n");
      out.write("\t\t\t\t<li><a id=plist href=\"../product/list.jsp\">상품리스트</a></li>&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<li>현황관리\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><a class=alist href=\"../stock/list.jsp\">재고현황</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a class=alist href=\"../sell_status/list.jsp\">판매현황</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a class=alist href=\"../order/list.jsp\">발주현황</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</li>&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t<li>등록관리\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><a class=alist href=\"../cart/cartList.jsp\">발주등록</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a class=alist href=\"../product/insert.jsp\">상품등록</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</li>&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t<li>이건어때\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><a class=alist href=\"../bbs/insert.jsp\">제안해요</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<br> <br>\r\n");
      out.write("\t\t<div class=\"relCon\">\r\n");
      out.write("\t\t\t<div class=\"proposal idea cu_idea\">\r\n");
      out.write("\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t<div class=\"info_comment\">\r\n");
      out.write("\t\t\t\t\t<span class=\"img_icon\" style=\"float: left;\"> <img\r\n");
      out.write("\t\t\t\t\t\tsrc=\"../images/information.png\" style=\"width: 85px;\">\r\n");
      out.write("\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t<dl>\r\n");
      out.write("\t\t\t\t\t\t<dt>&nbsp;알려드립니다.</dt>\r\n");
      out.write("\t\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>단순 불만 사항, 장난성 글, 욕설 및 비방, 광고글, 반복 게시물 등은 예고 없이 삭제될 수\r\n");
      out.write("\t\t\t\t\t\t\t\t\t있습니다.</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li>게시판 성격에 맞지 않는 글은 임의로 이동되거나 삭제될 수 있습니다.</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"txt_red\">유사한 아이디어가 있는지 검색 후에 작성하시기 바랍니다.</li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t</dl>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"proposal_borad\">\r\n");
      out.write("\t\t\t\t\t<div class=\"idea_search\">\r\n");
      out.write("\t\t\t\t\t\t<img\r\n");
      out.write("\t\t\t\t\t\t\tsrc=\"http://cu.bgfretail.com/images/enter/idea_search_txt.png\"\r\n");
      out.write("\t\t\t\t\t\t\talt=\"아이디어 검색\" class=\"img\">\r\n");
      out.write("\t\t\t\t\t\t<form id=\"listForm\" name=\"listForm\" action=\"/idea/idea_list.do\"\r\n");
      out.write("\t\t\t\t\t\t\tmethod=\"post\" onsubmit=\"return false;\">\r\n");
      out.write("\t\t\t\t\t\t\t<input id=\"idx\" name=\"idx\" type=\"hidden\" value=\"0\"> <input\r\n");
      out.write("\t\t\t\t\t\t\t\tid=\"pageIndex\" name=\"pageIndex\" type=\"hidden\" value=\"1\">\r\n");
      out.write("\t\t\t\t\t\t\t<input id=\"searchCondition\" name=\"searchCondition\" type=\"hidden\"\r\n");
      out.write("\t\t\t\t\t\t\t\tvalue=\"\"> <input id=\"isColleger\" name=\"isColleger\"\r\n");
      out.write("\t\t\t\t\t\t\t\ttype=\"hidden\" value=\"N\"> <span class=\"box\"\t> <select\r\n");
      out.write("\t\t\t\t\t\t\t\tid=\"selKey\" style=\"font-size: 13px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"title\" style=\"font-size: 13px\">제목</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"contents\" style=\"font-size: 13px\">내용</option>\r\n");
      out.write("\t\t\t\t\t\t\t</select> <input type=\"text\" value=\"\" id=\"txtWord\" class=\"input_text\"\r\n");
      out.write("\t\t\t\t\t\t\t\tplaceholder=\"검색어를 입력 해 주세요.\">\r\n");
      out.write("\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"button_search\"> <input type=\"button\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"btnSearch\" value=\"조회하기\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"width: 100px; height: 93px; background-color: #2569C9; border: none; color: white; padding: 15px 32px; text-align: center; text-decoration: none; display: inline-block; font-size: 16px; margin: 4px 2px; cursor: pointer; border-radius: 10px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<div style=\"font-size: 15px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t검색수: <b id=\"count\"></b>건\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div id=\"tbl\"></div>\r\n");
      out.write("\t\t\t\t\t<script id=\"temp\" type=\"text/x-handlebars-template\">\r\n");
      out.write("\t\t\t\t{{#each array}}\r\n");
      out.write("\t\t\t\t<div class=\"idea_list\" id=\"ideaTable\">\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t<span class=\"img_icon\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"../images/tfs_logo.JPG\" style=\"height:108px;\">\r\n");
      out.write("\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"box_cont\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"hidden\" class=bno value={{bno}}>\r\n");
      out.write("\t\t\t\t\t\t\t\t<strong class=\"title\"><a class=title1>{{title}}</a></strong>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p class=\"txt\">{{contents}}</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"date\">{{date}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"etc\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span class=\"info_post_state info_post_end\">작성완료</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span class=\"heart_num\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<button style=\"width:25px;\">👍</button>&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=ulike>{{ulike}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t{{/each}}\r\n");
      out.write("\t\t\t\t</script>\r\n");
      out.write("\t\t\t\t\t<div id=\"pagination\">\r\n");
      out.write("\t\t\t\t\t\t<button id=\"btnPre\">◀</button>\r\n");
      out.write("\t\t\t\t\t\t<button id=\"btnNext\">▶</button>\r\n");
      out.write("\t\t\t\t\t\t[<span id=\"curPage\"></span>/<span id=\"totPage\"></span>]\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"qweasd\">\r\n");
      out.write("\t\t\t\t\t\t<button class=\"btn_purple\" style=\"cursor: pointer;\">아이디어\r\n");
      out.write("\t\t\t\t\t\t\t작성하기</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"divFoot\" style=\"text-align: center\">");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../footer.jsp", out, false);
      out.write("</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("\t$(\".dropmenu ul li\").hover(function() {\r\n");
      out.write("\t\t$(this).find(\"ul\").stop().fadeToggle(300);\r\n");
      out.write("\t})\r\n");
      out.write("\r\n");
      out.write("\tvar key, word, order, desc, perPage, page = 1;\r\n");
      out.write("\r\n");
      out.write("\tgetList();\r\n");
      out.write("\tvar ulike;\r\n");
      out.write("\r\n");
      out.write("\t//insert로 이동\r\n");
      out.write("\t$(\".btn_purple\").on(\"click\", function() {\r\n");
      out.write("\t\tlocation.href = \"../bbs/insert.jsp\";\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\t//read로 이동\r\n");
      out.write("\t$(\"#tbl\").on(\"click\", \".title\", function() {\r\n");
      out.write("\t\tvar bno = $(this).parent().parent().parent().find(\".bno\").val();\r\n");
      out.write("\t\tlocation.href = \"../bbs/read?bno=\" + bno;\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\t//좋아요 버튼을 눌렀을 때\r\n");
      out.write("\t$(\"#tbl\").on(\"click\", \".heart_num button\", function() {\r\n");
      out.write("\t\tvar bno = $(this).parent().parent().parent().find(\".bno\").val();\r\n");
      out.write("\t\tvar ulike = $(this).parent().find(\".ulike\").html();\r\n");
      out.write("\t\tulike = parseInt(ulike) + 1;\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\ttype : \"get\",\r\n");
      out.write("\t\t\turl : \"ulike\",\r\n");
      out.write("\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\"bno\" : bno,\r\n");
      out.write("\t\t\t\t\"ulike\" : ulike\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tsuccess : function() {\r\n");
      out.write("\t\t\t\tlocation.href = \"list.jsp\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\t$(\"#btnSearch\").on(\"click\", function() {\r\n");
      out.write("\t\tpage = 1;\r\n");
      out.write("\t\tgetList();\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\t$(\"#txtWord\").keydown(function(key) {\r\n");
      out.write("\t\tif (key.keyCode == 13) {\r\n");
      out.write("\t\t\tpage = 1;\r\n");
      out.write("\t\t\tgetList();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\t$(\"#btnNext\").click(function() {\r\n");
      out.write("\t\tpage++;\r\n");
      out.write("\t\tgetList();\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\t$(\"#btnPre\").click(function() {\r\n");
      out.write("\t\tpage--;\r\n");
      out.write("\t\tgetList();\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\tfunction getList() {\r\n");
      out.write("\t\tkey = $(\"#selKey\").val();\r\n");
      out.write("\t\tword = $(\"#txtWord\").val();\r\n");
      out.write("\t\tperPage = $(\"#selPerPage\").val();\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\ttype : \"get\",\r\n");
      out.write("\t\t\turl : \"../bbs/list\",\r\n");
      out.write("\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\"key\" : key,\r\n");
      out.write("\t\t\t\t\"word\" : word,\r\n");
      out.write("\t\t\t\t\"page\" : page,\r\n");
      out.write("\t\t\t\t\"perPage\" : perPage\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tdataType : \"json\",\r\n");
      out.write("\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\tvar template = Handlebars.compile($(\"#temp\").html());\r\n");
      out.write("\t\t\t\t$(\"#tbl\").html(template(data));\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tif (data.page == 1) {\r\n");
      out.write("\t\t\t\t\t$(\"#btnPre\").attr(\"disabled\", true);\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t$(\"#btnPre\").attr(\"disabled\", false);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif (data.page == data.totPage) {\r\n");
      out.write("\t\t\t\t\t$(\"#btnNext\").attr(\"disabled\", true);\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t$(\"#btnNext\").attr(\"disabled\", false);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t$(\"#curPage\").html(data.page);\r\n");
      out.write("\t\t\t\t$(\"#totPage\").html(data.totPage);\r\n");
      out.write("\t\t\t\t$(\"#count\").html(data.count);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
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
