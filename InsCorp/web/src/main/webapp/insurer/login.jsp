<%--
  Created by IntelliJ IDEA.
  User: AcerPC
  Date: 20.10.2017 г.
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>InsuranceCorporation</title>
        <link href = "../style.css" type="text/css" rel = "stylesheet"/>
    </head>

    <body>
        <div class="login">
            <div class="shell">
                <form action="/insurerlogin" method="post">
                    <h3>Вход за служители</h3>
                    <table width="100%">
                        <tr>
                            <td><label>Потребителско име </label></td>
                            <td><input type="text" class="field" name="username" placeholder="Потребителско име" maxlength="50"><br/></td>
                        </tr>
                        <tr>
                            <td><label>Парола</label></td>
                            <td><input type="password" class="field" name="password" placeholder="Парола" maxlength="50"><br/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" value="Вход"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>