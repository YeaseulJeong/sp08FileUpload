<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- File Upload 폼 작성시 주의사항
1) 반드시 form 테그를 사용한다 a tag 사용 못함
2) 전송 방식은 반드시 post 로 한다 get 반식 사용 못함
_FileUpload 는 단순한 스트링 값을 넘기는 것이 아니라 덩어리로 MultipartFile(라이브러리 파일_ 파일을 업로드 하기 위한 모든 파일을 보여주고 선택한 파일의 정보를 가질 수 있는 클래스 _ 파일 경로, 메모리, 이름..)서버로
3) Form 태그의 속성으로 action, method 말고도 하나가 더 존재
_ enctype="multipart/form-data" 이부분을 반드시 추가해야 함
4)  MultipartFile를 bean 설정문서에 등록해야 돌아간다
5) 파일 업로드 form은 input type="file"
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">Single File Upload Test</h2>
<form action="fileupload.do" method="post" enctype="multipart/form-data">
사용자명 <input type="text" name="userName"><p>
<input type="file" name="uploadFile">
<input type="submit" value="파일 업로드">
</form>

<!-- 이때 name="userName" 는 사용자명 form 이름 -->
<!-- 보통은 여기까지 작성한 다음에 Controller 작성하는 부분으로 연결 되지만
하지만 파일 업로드는 그전에 반드시 VO 작성을 먼저 하고 넘어간다   (인자값으로 넘겨줄 때 값들을 일일이 파라미터로 안 넣어주고 한번에 객체에 넣어서 묶어 보내주려고)

VO ? 
VO가 뭔지부터 이해하는게 중요
내가 업로드한 파일에 대한 정보를 담을 VO _ 사용자 명까지도 통으로 받아도 된다
 -->
</body>
</html>