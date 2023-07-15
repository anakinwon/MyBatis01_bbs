<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>게시판 리스트</title>
		<style>
		      table {
		        width: 100%;
		        border-top: 1px solid #444444;
		        border-collapse: collapse;
		      }
		      th, td {
		        border-bottom: 1px solid #444444;
		        padding: 10px;
		        text-align: center;
		      }
		      table,tr,td{
				  border:1px solid #000000;
				  border-collapse:collapse;
				}
				tr.colored:nth-child(even){
				  background-color:#F6F6F6;
				  color:#000000;
				}
				tr.colored:nth-child(odd){
				  background-color:#D5D5D5;
				  color:#000000;
				}
	    </style>
	</head>
	
	<body>
		<div align="center">
			<h3>게시판 리스트</h3>
			<hr width="500">
			<table width = "600" cellpadding="0" cellspacing="0" border="1">
				<colgroup bgcolor ="#ddffaa">
					<col width="10%">
					<col width="60%">
					<col width="20%">			
					<col width="10%">			
				</colgroup>
				
				<tr>
					<td align="center">번호</td>
					<td align="center">제목</td>
					<td align="center">작성자</td>
					<td align="center">삭제</td>
					
				</tr>
				<c:forEach items="${list}" var="vo">
				<tr bgcolor="white">
					<td>${vo.bId}</td>
					<td>${vo.bContent}</td>
					<td>${vo.bName}</td>
					<td><a href="delete?bId=${vo.bId}">삭제</a></td>
				</tr>
				</c:forEach>
			</table>
			<a href="writeForm"> 글쓰기</a>
		</div>
	</body>
</html>