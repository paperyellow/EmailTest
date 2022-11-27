<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="EUC-KR">
        <title>Insert title here</title>
    </head>

    <body>
        <div class="container">
            <form action="/join" method="post">
                <div class="form-group">
                    <input type="text" name="username" class="form-control" placeholder="Enter username" maxlength="20">
                </div>
                <div class="form-group">
                    <input type="password" name="password" class="form-control" placeholder="Enter password"
                        maxlength="20">
                </div>
                <div class="form-group">
                    <input type="email" name="email" class="form-control" placeholder="Enter email">
                </div>
                <button type="submit" class="btn btn-primary">회원가입</button>
            </form>
        </div>
    </body>

    </html>