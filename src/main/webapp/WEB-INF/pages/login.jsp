<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/resources/styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/resources/styles/global_color.css"/>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.js"></script>

</head>
<body class="index">
<div class="login_box">

    <table>
        <tr>
            <td class="login_info">账号：</td>
            <td colspan="2"><input name="username" id="username" type="text" class="width150"/></td>
            <td class="login_error_info"><span class="required" id="usernamehint"></span></td>
            <%--<c:if test="${usernameError != null}">--%>
            <%--${usernameError.defaultMessage}--%>
            <%--</c:if>--%>
        </tr>
        <tr>
            <td class="login_info">密码：</td>
            <td colspan="2"><input name="password" id="password" type="password" class="width150"/></td>
            <td><span class="required" id="passwordhint"></span></td>
        </tr>
        <tr>
            <td class="login_info">验证码：</td>
            <td class="width70"><input name="code" id="code" type="text" class="width70"/></td>
            <%--<td><img src="/getVerifyCode" alt="验证码" title="点击更换" id="verifyCodeImage" onclick="changeImage"/></td>--%>
            <td><img src="/validateCode" title="点击更换" onclick="javascript:this.src = '/validateCode?tm='+Math.random()"
                     id="codesuper"></td>
            <td><span class="required" id="sc"></span></td>
        </tr>
        <tr>
            <td class="login_info">手机号：</td>
            <td colspan="2"><input name="phone" id="phone" type="text" class="width150"/></td>
            <td colspan="2"><input type="button" id="phoneTo" value="免费获取验证码"/></td>
            <td class="login_error_info"><span class="required" id="phonehint"></span></td>
        </tr>
        <tr>
            <td class="login_info">手机号验证码：</td>
            <td colspan="2"><input name="phone" id="phoneCode" type="text" class="width150"/></td>
            <td><span class="required" id="phmsg"></span></td>
        </tr>
        <tr>
            <td class="login_info">电子邮箱：</td>
            <td colspan="2"><input name="email" id="email" type="text" class="width150"/></td>
            <td colspan="2"><input type="button" id="emailTo" value="免费获取验证码"/></td>
            <td class="login_error_info"><span class="required" id="emailhint"></span></td>
        </tr>
        <tr>
            <td class="login_info">电子邮箱验证码：</td>
            <td colspan="2"><input name="phone" id="emailCode" type="text" class="width150"/></td>
            <td><span class="required" id="emailmsg"></span></td>
        </tr>
        <tr>
            <td></td>
            0
            <td class="login_button" colspan="2">
                <%--<input type="image" src="/resources/images/login_btn.png">--%>
                <a href="#" id="b"><img src="/resources/images/login_btn.png"/></a>
            </td>
            <td><span class="required" id="required"></span></td>
        </tr>
    </table>
    <br><br>
    <div>
        <iframe allowtransparency="true" frameborder="0" width="385" height="96" scrolling="no" src="//tianqi.2345.com/plugin/widget/index.htm?s=1&z=1&t=0&v=0&d=3&bd=0&k=&f=&ltf=009944&htf=cc0000&q=1&e=1&a=1&c=54511&w=385&h=96&align=center"></iframe>
    </div>

    <div>
        <a href="/baidu" id="baidu"> <img src="/resources/images/baidu.png"></a>
    </div>
</div>
<%--<h3 style="color: red">${phonemsg}</h3>--%>
<script>
    //        function changeImage() {
    //            $('#verifyCodeImage').attr('src', '/getVerifyCode');
    //        }
    var phonehint = document.getElementById("phonehint");
    var reg = /^1[3|4|5|7|8][0-9]{9}$/; //验证规则
//    var phone = $("#phone").val();

    $("#phoneTo").click(function () {

    var phone = document.getElementById("phone").value;
//        alert(phone)
//        alert(reg.test(phone))

        if (!reg.test(phone)) {

            phonehint.innerText = "手机号码有误，请重填";

//            alert("手机号码有误，请重填");

        } else {

            phonehint.innerText = "";

            $.post("sendsmm", "phone=" + $("#phone").val());

            settime(this);

        }

    });

    var emailhint = document.getElementById("emailhint");
    var szReg=/^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,5}$/;

    $("#emailTo").click(function () {

        var email = document.getElementById("email").value;
//        alert(szReg.test(email))

        if (!szReg.test(email)) {

            emailhint.innerText = "邮箱地址不正确";

//            alert("手机号码有误，请重填");

        } else {

            emailhint.innerText = "";

            $.post("sendMail", "email=" + $("#email").val());

            set(this);

        }

    });

    //$("#phoneTo").click(function () {
    //    settime(this);
    //});

    var countdown = 60;
    var time = 60;

    function set() {
        if (time == 0) {
            $("#emailTo").attr("disabled", false);
            $("#emailTo").attr("value", "免费获取验证码");
            time = 60;
            return;
//        clearTimeout(a);
        } else {
            $("#emailTo").attr("disabled", true);
            $("#emailTo").attr("value", "重新发送(" + time + ")");
            time--;
        }
        setTimeout(set, 1000)
    }


    function settime() {
        if (countdown == 0) {
            $("#phoneTo").attr("disabled", false);
            $("#phoneTo").attr("value", "免费获取验证码");
            countdown = 60;
            return;
//        clearTimeout(a);
        } else {
            $("#phoneTo").attr("disabled", true);
            $("#phoneTo").attr("value", "重新发送(" + countdown + ")");
            countdown--;
        }
        setTimeout(settime, 1000)
    }


    //var wait = 60;
    //function time(o) {
    //   if (wait == 0) {
    //           o.removeAttribute("disabled");
    //           o.innerHTML = "免费获取验证码";
    //           wait = 60;
    //        } else {
    //            o.setAttribute("disabled", true);
    //            o.innerHTML = wait + "秒后可以重新发送";
    //            wait--;
    //            setTimeout(function() {
    //                time(o)
    //            }, 1000)
    //    }
    //}

//    $("#baidu").click(function () {
//
//        $.post("baidu");
//
//    })


    $("#b").on("click", function (event) {

        var username = document.getElementById("username");
        var usernamehint = document.getElementById("usernamehint");
        var password = document.getElementById("password");
        var passwordhint = document.getElementById("passwordhint");

        var i = 0;


        if (username.value === "") {
            usernamehint.innerText = "输入不能为空";
            i++;
        } else if (username.value.length >= 30) {
            usernamehint.innerText = "30长度的字母、数字和下划线";
            i++;
        }

        if (!(0 < password.value.length && password.value.length < 30)) {
            passwordhint.innerText = "30长度的字母、数字和下划线";
            i++;
        }


        if (i === 0) {
            event.preventDefault();
            $.ajax({
                type: "post",
                url: "/login",
                data: {
                    "username": $("#username").val(),
                    "password": $("#password").val(),
                    "code": $("#code").val(),
                    "phoneCode": $("#phoneCode").val(),
                    "emailCode": $("#emailCode").val()
                },
                success: function (result) {
                    if (result.errorCode == 0) {
                        console.log(result)
//                $("#loginresult").text("成功")
//                $.cookie("loginmsg", result.data.username, {expires: 1})
//                $.cookie("userid", result.data.id, {expires: 1})
//                alert(location.href)

                        location.href = "/index"

                    } else {
                        $("#codesuper").click();
                        $("#code").val("")
                        $("#username").val("")
                        $("#password").val("")
                        $("#sc").text(result.mess)
                        $("#required").text(result.message)
                        $("#phmsg").text(result.phonemess)
                        $("#emailmsg").text(result.eamilmess)
//                console.log(result)
                    }
                }
            })
        }


    })

</script>
</body>
</html>
