
<%@page import="config.Config"%>
<%@ page session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%
request.setAttribute("tomcatDocUrl", Config.getApplicationURL());

%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <title>CS 320 Finals</title>
        <link href="${tomcatDocUrl}views/tomcat.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <div id="wrapper">
                  
            <div id="upper" class="curved container">
   
                <div id="notice">
                    <img src="${tomcatDocUrl}views/csula.png" alt="[csu la logo]" style="height:20%;width:20%" />
                    <div id="asf-box">
                         <h1>  ${initParam.UniversityName} </h1>
                         <h2>${initParam.DepartmentName} </h2>
                    </div>
                
                </div>
            
                <br class="separator" />
            </div>
         
            <div id="lower">
                <div id="low-docs">
                    <div class="curved container">
                        <h4><a href='<%=Config.applicationURL%>doSort?method=position' > CS Jobs </a>- Application
                        	 
                        </h4>
                        <h3>
                        </h3>
                        <form  action="<%=Config.applicationURL%>doAddApplicant" method="post">
						 
                        <table border =1 width='100%'>
                        	<tr>	
                        		<td>Name: </td>
                        		<td><input type='text' name='applicantName' ></input></td>
                        	</tr>
                        		
                        	<tr>
                        		<td>Position: </td>
                        		<td>
                        			<c:forEach var="jobsvar" items="${applicationScope.jobs}">
                        			<input type='checkbox' name='positionIds' value='${jobsvar.id }' /> ${jobsvar.name } <br/>
                        			</c:forEach>
                        		</td>
                        	</tr>
                        	<tr>
                        		<td colspan="2" > <center> <input type ='submit' value='Add'/> </center></td>
                        	</tr>
                        </table>
                       
                 
                                                <br/><br/><br/>
						</form>                       
                        <br/><br/><br/><br/><br/><br/>
                        <ul>
                        	<lh>API</lh>
                        	<li><a href="http://tomcat.apache.org/tomcat-8.0-doc/">Tomcat 8.0 JavaDocs</a></li>
                        </ul>
                        
                        
                        
                    </div>
                </div>
              
                </div>
                <br class="separator" />
            </div>
          
            <p class="copyright">Copyright &copy;1999- Apache Software Foundation.  All Rights Reserved</p>
        </div>
    </body>

</html>
