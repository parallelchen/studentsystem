<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Alert Info Page</title>
</head>
<body>
	<center><h3>修改学生信息</h3></center>
	<form action=" " method="post">
		<table align="center" border="1" width="300px" cellpadding="0" cellspacing="0">
			<tr>
				<th>姓名</th>
				<td><input type="text" name="name" value="" /></td>
			</tr>
			<tr>
				<th>生日</th>
				<td><input type="text" name="birthday" value=""/></td>
			</tr>
			<tr>
				<th>备注</th>
				<td><input type="text" name="description" value=""/></td>
			</tr>
			<tr>
				<th>平均分</th>
				<td><input type="text" name="avgscore" value=""/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="保存"/>&nbsp;
					<!-- <input type="rest" value="重置"/> -->
				
				</td>
			</tr>
			
		</table>
		
	
	</form>
	

</body>
</html>