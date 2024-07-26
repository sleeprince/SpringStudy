<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/resources/images/logo.png" rel="icon" type="image/x-icon">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Test</title>
<style>.btn-min-size{min-width: 200px;}</style>
</head>
<body>
	<div class="container mt-3">
		<h1 class="text-center bg-success text-dark bg-opacity-50">화면 목록</h1>
		<div class="d-grid gap-2 text-center">
				<a href="/testAPI" class="btn btn-primary btn-min-size">데이터베이스 테스트</a>
				<a href="/resources/v1/list.html" class="btn btn-primary btn-min-size">기본 화면</a>
				<a href="#" class="btn btn-primary btn-min-size">평가 화면</a>
		</div>
	</div>
</body>
</html>