<%@ page isELIgnored="false" language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
	
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Student System Index</title>
		
		
		<style type="text/css">
			table td{
				text-align: center;
	
			}

		</style>
       <%--  <script src="jquery-3.3.1.min.js"></script> 
		
		 <script type="text/javascript">
			    /*  setInterval("function",3000)   */
			    $(function(){
					$.post({
						url:"<%=basePath%>FindAllServlet",
					});
				}) 
			
		</script>  --%>
	</head>
	<body >
		<center><h3>学生成绩展示</h3></center>
		
		
			<table id="2" align="center" border="1" width="700px" cellpadding="0" cellspacing="0" >
				<tr>
					<td colspan="8" align="center">
						<a href="addStudentInfo.jsp">[新增数据]</a>
					</td>
				</tr>
				<tr>
					<th style="display: none">Id</th>
					<th>姓名</th>
					<th>生日</th>
					<th>备注</th>
					<th>平均分</th>				
					<th>操作</th>				
				</tr>
				 
						<c:forEach items="${sessionScope.pageBean.pageDate }" var="stu" >
							<tr >
								<td style="display: none">${stu.id }</td>
								<td>${stu.name }</td>
								<td><fmt:formatDate value="${stu.birthday }" pattern="yyyy年MM月dd日"/></td>
								<td>${stu.description }</td>
								<td>${stu.avgscore }</td>
								
								
								 <td> 
								 	<a href="QueryStudentInfoServlet?id=${stu.id }">修改</a> 
									<a href="AlertStudentServlet?id=${stu.id }">删除</a>
								
								 </td> 
						
							</tr>
						</c:forEach>
					
					
				
				
				  <tr >
					
					<td colspan="8" align="center">
						 当前第${pageBean.currentPage }页	&nbsp;&nbsp;
						<a href="${pageContent.request.contentPath }/studentsystem/FindAllServlet?currentPage=1">首页</a>
						<a href="${pageContent.request.contentPath }/studentsystem/FindAllServlet?currentPage=${pageBean.currentPage-1}">上一页</a>
						<a href="${pageContent.request.contentPath }/studentsystem/FindAllServlet?currentPage=${pageBean.currentPage+1}">下一页</a>
					</td>  
				
				 </tr> 
				
					
		
			</table>	
			
	</body>
</html>