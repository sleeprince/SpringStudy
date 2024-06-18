<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="/SpringStudy2/resources/calc.js"></script>
<link href="/SpringStudy2/resources/calc.css" rel="stylesheet">
</head>
<body>
	<div class="container text-center mt-3">
	  <h1>계산기</h1>
		<form action="" method="get">
			<div class="input-group mb-3">
				<input type="hidden" id="mark" name="mark">
				<input type="hidden" id="nums" name="nums">
				<input type= "number" class="text-start fs-2 form-control" id="value" name="value" placeholder="0" value=${result} readonly="readonly">
				<button class="btn btn-success" type="button" id="del">
					<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-arrow-left" viewBox="0 0 16 16">
					<path fill-rule="evenodd" d="M15 8a.5.5 0 0 0-.5-.5H2.707l3.147-3.146a.5.5 0 1 0-.708-.708l-4 4a.5.5 0 0 0 0 .708l4 4a.5.5 0 0 0 .708-.708L2.707 8.5H14.5A.5.5 0 0 0 15 8"/>
				</svg>
				</button>
			</div>
		</form>
		<table class="table table-bordered">
		  <tbody class="fs-3 cursor-pointer">
		    <tr>
		      <td>+</td><td>-</td><td>*</td><td>/</td>
		    </tr>
		    <tr>
		      <td>=</td><td>7</td><td>8</td><td>9</td>
		    </tr>
		    <tr>
					<td>C</td><td>4</td><td>5</td><td>6</td>
		    </tr>
		    <tr>
		      <td>0</td><td>1</td><td>2</td><td>3</td>
		    </tr>
		  </tbody>
		</table>
<!-- 반복 시작 -->
		<ol class="list-group" id="history"></ol>
<!-- 반복 끝 -->
	</div>
</body>
</html>