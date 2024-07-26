<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://github.com/JosephBean/SpringStudy2/blob/main/src/main/webapp/resources/images/logo.png?raw=true" rel="icon" type="image/x-icon">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>LIST</title>
    <style>
        a.list-group-item:hover {cursor: pointer;font-weight:bold;color:#fff;background-color:#b2327d;box-shadow:5px 5px 10px 5px rgba(77, 71, 71, 0.2);}
    </style>
</head>
<body>
    <div class="container mt-3">
        <h1 class="text-center bg-success text-dark bg-opacity-50">LIST</h1>
        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <a href="/webtest/list" class="btn btn-secondary">전체</a>
            <a href="/webtest/list/1" class="btn btn-success">승인</a>
            <a href="/webtest/list/0" class="btn btn-warning">미승인</a>
            <a href="/webtest/new" class="btn btn-primary">추가</a>
        </div>
        <div class="list-group mt-2 text-center">
        <c:forEach var="row" items="${list}" varStatus="s">
            <a class="list-group-item m-1 ${(row.accept == true)? 'bg-success': 'bg-warning'} display-6" href="/webtest/detail/${row.no}">
                ${row.title}    
            </a>
        </c:forEach>            
        </div>
    </div>
</body>
</html>