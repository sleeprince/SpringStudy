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
				<a href="/v1/list" class="btn btn-primary btn-min-size">Path Variable 이용한 방식</a>
				<a href="/v2/list" class="btn btn-primary btn-min-size">Query String 이용한 방식</a>
		</div>
</body>
</html>