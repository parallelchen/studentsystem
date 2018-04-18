<%@ page isELIgnored="false" language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>add info</title>
</head>
	<script type="text/javascript">
		function check(form){
			
			if(form.name.value == ''){
				alert("请输入名字！！");
				form.name.focus();
				return false;
			}else{
				if(form.name.value.length > 40){
					alert("长度不符合要求！！");
					form.name.focus();
					return false;
				}
			}
			
			if(form.birthday.value == ''){
				alert("请输入生日！！");
				form.birthday.focus();
				return false;
			}
			
			if(form.description.value == ''){
				alert("请输入描述！！");
				form.description.focus();
				return false;
			}
			
			if(form.avgscore.value == ''){
				alert("请输入平均分！！");
				form.avgscore.focus();
				return false;
			}else{
				var reg = /^([1-4]\d\d{0,1}|500|0|[1-9]\d{0,1})$/ ;
				if(reg.test(form.avgscore.value)){
					return true ;
				}else{
					alert("平均分是0-500的整数");
					return false ;
				}
				
			}
		
		}

	</script>
<body>
	<center><h3>修改数据</h3></center>
	<form action="UpdateStudentInfoServlet" method="post" onsubmit="return check(this)">
		<table align="center" border="1" width="300px" cellpadding="0" cellspacing="0">
			<tr>
				<th style="display: none">id</th>
				<td ><input style="display: none" type="text" name="id" size="34" value="${student.id }"/></td>
			</tr>
			<tr>
				<th>姓名</th>
				<td ><input type="text" name="name" size="34" value="${student.name }"/></td>
			</tr>
			<tr>
				<th>生日</th>
				<%-- <fmt:formatDate value="${student.birthday }" pattern="yyyy年MM月dd日"/> --%>
				<td><input type="Date" name="birthday" size="34" value=<fmt:formatDate value="${student.birthday }" pattern="yyyy-MM-dd"/>></td>
			</tr>
			<tr>
				<th>备注</th>
				<td><input type="text" name="description" size="34" value="${student.description }"/></td>
			</tr>
			<tr>
				<th>平均分</th>
				<td><input type="text" name="avgscore" size="34" value="${student.avgscore }"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="保存" width="200px"/>&nbsp;
				
				</td>
			</tr>
			
		</table>
		
		
		
	
	</form>



</body>
</html>