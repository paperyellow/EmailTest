<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="EUC-KR">
        <title>Insert title here</title>
    </head>

    <body>
        <form class="upload-form" action="/image" method="post" enctype="multipart/form-data">
            <input type="file" name="file" onchange="imageChoose(this)" />
            <div class="upload-img">
                <img src="/images/cat.jpg" alt="" id="imageUploadPreview" />
            </div>

            <div class="upload-form-detail">
                <input type="text" placeholder="��������" name="caption" />
                <button class="cta blue">���ε�</button>
            </div>

        </form>
    </body>

    </html>