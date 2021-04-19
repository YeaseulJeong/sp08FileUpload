<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function downloadFile(file){  // 단일 객체 file을 인자값으로 받는다
		if(confirm("선택하신 파일을 다운로드 하시겠습니까?"))
			location.href="multiDownloadFile.do?filename="+file;  // javascript에서 사이트 이동할 때 사용 ? 뒤의 filename 은 DownloadView 에서 getParameter 할 때 동일해야
	}

</script>
</head>
<body>
<h2> Multi File Upload OK~~~ </h2>
<c:forEach items="${mFile}" var="file">
	<ul> Upload File:: <a href="javascript:downloadFile('${file.getOriginalFilename()}')">${file.getOriginalFilename()}</a></ul>
</c:forEach>
</body>
</html>