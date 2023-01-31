<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>	
<script type="text/javascript">
function writeValidate(f)
{
	if(f.name.value==""){
		alert("작성자 이름을 입력하세요");
		f.name.focus();
		return false;
	}
	if(f.contents.value==""){
		alert("내용을 입력하세요");
		f.contents.focus(); 
		return false;
	} 
}
</script>
<div class="container">
	<h3>방명록(글쓰기) - 
		<small>Mybatis로 제작한 방명록입니다.</small></h3>
	
	<form name="writeFrm" method="post" 
		onsubmit="return writeValidate(this);"
		action="<c:url value="/mybatis/modifyAction.do" />">
	<!--  
	action="/mybatis/modifyAction.do" => 컨텍스트 루트가 없으므로 에러발생
	action="../mybatis/modifyAction.do" => 정상실행
	action="./modifyAction.do" => 정상실행
	action="/Ex03Mybatis/mybatis/modifyAction.do" => 정상실행.
	즉, JSTL의 url태그를 사용하면 컨텍스트 루트 경로를 자동으로 추가해주므로 가장 안전한
	방법이 될 수 있다. 배포시에는 컨텍스트 루트를 알아서 제거해준다.  
	-->
	
	<!-- 게시물의 일련번호와 작성자아이디를 hidden박스로 추가한다.  -->			
	<input type="hid den" name="idx" value="${dto.idx }"/>
	<input type="hid den" name="id" value="${sessionScope.siteUserInfo.id }"/>
		
	<table class="table table-bordered">
	<colgroup>
		<col width="20%"/>
		<col width="*"/>
	</colgroup>
	<tbody>
		<tr>
			<th class="text-center" 
				style="vertical-align:middle;">작성자</th>
			<td>
				<input type="text" class="form-control" 
					style="width:100px;" name="name" value="${dto.name }" />
			</td>
		</tr>
		<tr>
			<th class="text-center" 
				style="vertical-align:middle;">내용</th>
			<td>
				<textarea rows="10" class="form-control" 
				name="contents">${dto.contents }</textarea>
			</td>
		</tr>	
	</tbody>
	</table>
	
	<div class="row text-center" style="">
		<!-- 각종 버튼 부분 -->		
		<button type="submit" class="btn btn-danger">전송하기</button>
		<button type="reset" class="btn">Reset</button>
		<button type="button" class="btn btn-warning" 
			onclick="location.href='list.do';">리스트보기</button>
	</div>
	</form> 
</div>
</body>
</html>




