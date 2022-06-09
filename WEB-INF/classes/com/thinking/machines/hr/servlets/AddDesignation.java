package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class AddDesignation extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
PrintWriter pw=null;
String title="";
try
{
pw=response.getWriter();
title=request.getParameter("title");
DesignationDTO designation=new DesignationDTO();
designation.setTitle(title);
DesignationDAO designationDAO;
designationDAO=new DesignationDAO();
designationDAO.add(designation);


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
pw.println("Designation Added <br><br>");
pw.println("<table>");
pw.println("<tr>");
pw.println("<td>");
pw.println("<form action='/styleone/AddDesignation.html'>");
pw.println("<button type='submit'>Yes</button>");
pw.println("</form>");
pw.println("</td>");
pw.println("<td>");
pw.println("<form action='/styleone/designationView'>");
pw.println("<button type='submit'>No</button>");
pw.println("</form>");
pw.println("</td>");
pw.println("</tr>");
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









}catch(DAOException daoexception)
{
   



pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='eng'>");
pw.println("<head>");
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
pw.println("<div style='width:90hw;height:70vh;margin:5px;border:1px solid white'> ");

pw.println("<!-- Left Pannel -->");
pw.println("<div style='height:60vh;margin:5px;float:left;padding:5px;border:1px solid black'>");
pw.println("<b> Designations </b></a><br>");
pw.println("<a href='/styleone/employeeView'> Employee </a><br>");
pw.println("<a href='/styleone/index.html'>Home</a><br>");
pw.println("</div>");

pw.println("<!-- right pannel -->");
pw.println("<div style='height:60vh;margin-left:105px;margin-top:5px;margin-bottom:5px;margin-right:5px;padding:5px;border:1px solid black'>");
pw.println("<h2 style='text-align:center'>Add Designation</h2> ");
pw.println("<div style='color:red'>"+daoexception.getMessage()+"</div>");
pw.println("<form action='/styleone/addDesignation' onsubmit='return validateForm(this)'>");
pw.println("<b>Designations</b>");
pw.println("<input type='text' id='title' name='title' maxlength='35' size='36' value='"+title+"'>");
pw.println("<span id='titleErrorSection' style='color:red'></span><br>");
pw.println("<button type='submit'>Add</button>");
pw.println("</form>");
pw.println("<form action='/styleone/designationView'>");
pw.println("<button type='submit'>Cancel</button>");
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





}catch(Exception exception)
{


}

}

}