package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class UpdateDesignation extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
PrintWriter pw=null;
String title="";
int code=0;
try
{
pw=response.getWriter();
response.setContentType("text/html");
title=request.getParameter("title");
if(title==null)
{
    sendBackView(response);
    return;

}
try{
code=Integer.parseInt(request.getParameter("code"));
}catch(NumberFormatException nfe)
{
    sendBackView(response);
    return;
}
DesignationDTO designation=new DesignationDTO();
designation.setCode(code);
designation.setTitle(title);
DesignationDAO designationDAO;
designationDAO=new DesignationDAO();
designationDAO.update(designation);


pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='eng'>");
pw.println("<head>");
pw.println("<title> HR Application </title>");
pw.println("</head>");
pw.println("<body>");
pw.println("<!-- Main container starts here -->");
pw.println("<div style='width:90hw;height:auto;border:1px solid black'>");

pw.println("<!-- Header Starts Here -->");
pw.println("<div style='margin:5px;width:90hw;height:auto;border:1px solid black'>");
pw.println("<img src='/styleone/images/logo.png' style='float:left'><div style='margin-top:40px;margin-bottom:40px;font-size:20pt'>Thinking Machines </div>");
pw.println("</div> <!-- Header ends Here -->");

pw.println("<!-- content section starts here -->");
pw.println("<div style='width:90hw;height:70vh;margin:5px;border:1px solid white'> ");

pw.println("<!-- Left Pannel -->");
pw.println("<div style='height:60vh;margin:5px;float:left;padding:5px;border:1px solid black'>");
pw.println("<a href='/styleone/designationView'> Designations </a><br>");
pw.println("<a href='/styleone/employeeView'> Employee </a>");
pw.println("</div>");

pw.println("<!-- right pannel -->");
pw.println("<div style='height:60vh;margin-left:105px;margin-top:5px;margin-bottom:5px;margin-right:5px;padding:5px;border:1px solid black'>");
pw.println("<h3>Notification<h3> ");
pw.println("Designation Updated <br><br>");
pw.println("<form action='/styleone/designationView'>");
pw.println("<button type='submit'>Ok</button>");
pw.println("</form>");
pw.println("</div>");
pw.println("</div>");
pw.println("<!-- content section ends here -->");


pw.println("<!-- Footer starts here -->");
pw.println("<div style='width:90hw;height:auto;margin:5px; text-align:center;border:1px solid white'>");
pw.println("&copy; thinking machines");
pw.println("</div>");
pw.println("<!-- Footer Ends here -->");

pw.println("</div> <!-- Main container ends here -->");
pw.println("</body>");
pw.println("</html>");



}catch(DAOException daoexception)
{
   
    pw.println("<!DOCTYPE HTML>");
    pw.println("<html lang='eng'>");
    pw.println("<head>");
    pw.println("<meta charset='utf-8'>");
    pw.println("<title> HR Application </title>");
    pw.println("<script>");
    pw.println("function validateForm(frm)");
    pw.println("{");
    pw.println("var title=frm.title.value.trim();");
    pw.println("var titleErrorSection=document.getElementById('titleErrorSection');");
    pw.println("titleErrorSection.innerHTML='';");
    pw.println("if(title.length==0)");
    pw.println("{");
    pw.println("titleErrorSection.innerHTML='required';");
    pw.println("frm.title.focus();");
    pw.println("return false;");
    pw.println("}");
    pw.println("return true;");
    pw.println("}");
    pw.println("function cancelButton()");
    pw.println("{");
    pw.println("document.getElementById('cancelButtonForm').submit();");
    pw.println("}");
    pw.println("</script>");
    pw.println("</head>");
    pw.println("<body>");
    pw.println("<!-- Main container starts here -->");
    pw.println("<div style='width:90hw;height:auto;border:1px solid black'>");
    pw.println("<!-- Header Starts Here -->");
    pw.println("<div style='margin:5px;width:90hw;height:auto;border:1px solid black'>");
    pw.println("<img src='/styleone/images/logo.png' style='float:left'><div style='margin-top:40px;margin-bottom:40px;font-size:20pt'>Thinking Machines </div>");
    pw.println("</div> <!-- Header ends Here -->");
    pw.println("<!-- content section starts here -->");
    pw.println("<div style='width:90hw;height:70vh;margin:5px;border:1px solid white'>");
    pw.println("<!-- Left Pannel -->");
    pw.println("<div style='height:60vh;margin:5px;float:left;padding:5px;border:1px solid black'>");
    pw.println("<b> Designations </b></a><br>");
    pw.println("<a href='/styleone/employeeView'> Employee </a><br>");
    pw.println("<a href='/styleone/index.html'>Home</a><br>");
    pw.println("</div>");
    pw.println("<!-- right pannel -->");
    pw.println("<div style='height:60vh;margin-left:105px;margin-top:5px;margin-bottom:5px;margin-right:5px;padding:5px;border:1px solid black'>");
    pw.println("<h2>Update Designation</h2>");
    pw.println("<form method='post' action='/styleone/updateDesignation' onsubmit='return validateForm(this)'>");
    pw.println("<div style='color:red'>'"+daoexception.getMessage()+"'</div>");
    pw.println("<b>Designations</b>");
    pw.println("<input type='hidden' id='code' name='code' value='"+code+"'>");
    pw.println("<input type='text' id='title' name='title' maxlength='35' size='36' value='"+title+"'>");
    pw.println("<span id='titleErrorSection' style='color:red'></span><br>");
    pw.println("<button type='submit'>Update</button>");
    pw.println("<button type='button' onclick='cancelButton()'>Cancel</button>");
    pw.println("</form>");
    pw.println("</div>");
    pw.println("</div>");
    pw.println("<!-- content section ends here -->");
    pw.println("<!-- Footer starts here -->");
    pw.println("<div style='width:90hw;height:auto;margin:5px; text-align:center;border:1px solid white'>");
    pw.println("&copy; thinking machines");
    pw.println("</div>");
    pw.println("<!-- Footer Ends here -->");
    pw.println("</div> <!-- Main container ends here -->");
    pw.println("<form id='cancelButtonForm' action='/styleone/designationView'></form>>");
    pw.println("</body>");
    pw.println("</html>");
    





}catch(Exception exception)
{
System.out.println(exception.getMessage());

}

}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}
private void sendBackView(HttpServletResponse response)
{
try
{
DesignationDAO designationDAO;
designationDAO=new DesignationDAO();
List<DesignationDTO> designations;
designations=designationDAO.getAll();
PrintWriter pw=response.getWriter();
response.setContentType("text/html");

pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='eng'>");
pw.println("<head>");
pw.println("<title> HR Application </title>");
pw.println("</head>");
pw.println("<body>");
pw.println("<!-- Main container starts here -->");
pw.println("<div style='width:90hw;height:auto;border:1px solid black'>");
pw.println("<!-- Header Starts Here -->");
pw.println("<div style='margin:5px;width:90hw;height:auto;border:1px solid black'>");
pw.println("<img src='/styleone/images/logo.png' style='float:left'><div style='margin-top:40px;margin-bottom:40px;font-size:20pt'>Thinking Machines </div>");
pw.println("</div> <!-- Header ends Here -->");
pw.println("<!-- content section starts here -->");
pw.println("<div style='width:90hw;height:70vh;margin:5px;border:1px solid white'> ");
pw.println("<!-- Left Pannel -->");
pw.println("<div style='height:60vh;margin:5px;float:left;padding:5px;border:1px solid black'>");
pw.println("<b> Designations </b><br>");
pw.println("<a href='/styleone/employeeview'> Employee <a/><br>");
pw.println("<a href='/styleone/index.html'>Home</a>");
pw.println("</div>");
pw.println("<!-- right pannel -->");
pw.println("<div style='height:60vh;margin-left:105px;margin-top:5px;margin-bottom:5px;margin-right:5px;padding:5px;overflow:scroll;border:1px solid black'>");
pw.println("<table border='1'>");
pw.println("<thead>");
pw.println("<tr>");
pw.println("<th colspan='2' style='text-align:left;padding:5px'><h2>Deisgnations</h2></th>");
pw.println("<th colspan='4' style='text-align:right;padding:5px'><a href='/styleone/AddDesignation.html'> Add New Deisgnation</a></th>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<th style='width:60px;text-align:center'>S.No</th>");
pw.println("<th style='width:200px'>Designation</th>");
pw.println("<th style='width:100px'>Edit</th>");
pw.println("<th style='width:100px;text-align:center'>Delete</th>");
pw.println("</tr>");
pw.println("</thead>");
pw.println("<tbody>");
int x;
DesignationDTO designationDTO;
int code;
String title;
int sno=0;
for(x=0;x<designations.size();x++)
{
sno++;
designationDTO=designations.get(x);
code=designationDTO.getCode();
title=designationDTO.getTitle();
pw.println("<tr>");
pw.println("<td style='text-align:center'>"+sno+".</td>");
pw.println("<td style='text-align:center'>"+title+"</td>");
pw.println("<td style='text-align:center'><a href='/styleone/editDesignation?code="+code+"'>Edit</a></td>");
pw.println("<td style='text-align:center'><a href='/styleone/confirmDeleteDesignation?code="+code+"'>Delete</a></td>");
pw.println("</tr>");
}
pw.println("</tbody>");
pw.println("</table>");
pw.println("</div>");
pw.println("</div>");
pw.println("<!-- content section ends here -->");
pw.println("<!-- Footer starts here -->");
pw.println("<div style='width:90hw;height:auto;margin:5px; text-align:center;border:1px solid white'>");
pw.println("&copy; thinking machines");
pw.println("</div>");
pw.println("<!-- Footer Ends here -->");
pw.println("</div> <!-- Main container ends here -->");
pw.println("</body>");
pw.println("</html>");
}catch(DAOException daoException)
{
daoException.printStackTrace();
System.out.println(daoException.getMessage()); // remove after testing and setup 500(internal error page)
}
catch(Exception exception)
{
System.out.println(exception.getMessage()); // remove after testing and setup 500(internal error page)
}
}


}