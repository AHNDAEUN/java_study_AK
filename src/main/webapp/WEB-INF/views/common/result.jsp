<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script type="text/javascript">
//자바스크립트엔 el를 사용하지 못해서 스크립트를 사용하지 않고 
//sts에서 작성
let result = '${result}';
let message= '${message}';// 가저올때 달러 중괄호 활용
alert(message);
alert(result);
//메세지를 띄우고 자동이동
//요청하는 자바스크립트 형식
location.href="${url}";

</script>
</body>
</html>