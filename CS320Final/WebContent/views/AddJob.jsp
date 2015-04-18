
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
        <style>
		    .split { padding-left: 200pt; }
		</style>
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
                        <h4><a href='<%=Config.applicationURL%>doSort?method=position' >CS Jobs </a> - Job Positions
                                
                        </h4>
                        <form  action="<%=Config.applicationURL%>doAddJobs" method="post">
						  <c:if test="${not empty applicationScope.jobs}">
						 	<table>	
						 	<tr>
						 		<td>
							 	<c:forEach var="jobs" items="${applicationScope.jobs}">	
								  	<ul style='list-style-type:disc' >
		                            	<li class="split"> ${jobs.name} </li>
		                         	</ul>
		                         </c:forEach>
						 		</td>
						 	</tr>
						 	</table>	
						 	
					
						</c:if>
						                       
                        <br/><br/><br/>
                        
                        New Position  : <input type = 'text' name='positionName' />
                        <input type="submit" value="Add"/>
                        
						</form>  
						      
                        <br/><br/><br/><br/><br/><br/><br/>
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
