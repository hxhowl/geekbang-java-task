<%--
  Created by IntelliJ IDEA.
  User: huangchp
  Date: 2021/3/2
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <jsp:directive.include file="/WEB-INF/jsp/prelude/include-head-meta.jspf" />
    <title>Register</title>
    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
</head>

<body>
     <h3 align="center">注册</h3>
     <hr>
     <form action="registerSubmit" method="post">
         <table align="center"  border="1">
             <tr>
                 <td>用户名：</td>
                 <td><input type="text" name = "username"/></td>
             </tr>
              <tr>
                 <td>密码：</td>
                 <td><input type="password" name = "password"/></td>
             </tr>
             <tr>
                 <td>email：</td>
                 <td><input type="text" name = "email"/></td>
             </tr>

             <tr>
                 <td>电话：</td>
                 <td><input type="text" name = "phoneNumber"/></td>
             </tr>

             <tr>
                 <td colspan="2" align="center">
                     <input type="submit" name="submit" value="注册"/>
                     <input type="reset" name="reset" value="重置"/>
                 </td>
             </tr>
         </table>
         </form>
</body>
</html>
