$(function () {
    var check1 = false;
    var check2 = false;
    var check3 = false;
    var $username = $('#username');
    var username = $username[0].value;
    var $usernameTips = $('#usernameTips');

    function getCode(){
        var src = "../getCode?" + new Date().getTime();
        $('#codePic').attr("src", src);
        check3 = false;
    }

    $username.focus(function () {
        $usernameTips.text("")
    })

    $username.blur(function () {
        $username = $('#username');
        username = $username[0].value;
        if (username.length == 0) {
            $usernameTips.text("请输入用户名")
            check1 = false;
            return false;
        }
        check1 = true;
    })
    $('#password').focus(function () {
        $('#passwordTips').text("");
    })

    $('#password').blur(function () {
        if (/.*[\u4e00-\u9fa5]+.*$/.test($('#password')[0].value)) {
            $('#passwordTips').text("请勿输入汉字");
            check2 = false;
            return false;
        }
        if ($('#password')[0].value.length == 0) {
            $('#passwordTips').text("请输入密码");
            check2 = false;
            return false;
        }
        check2 = true;
    })

    $('#codeInput').focus(function () {
        $('#codeTips').text("");
    })

    $('#codeInput').blur(function () {
        var code = $('#codeInput')[0].value;
        if (/.*[\u4e00-\u9fa5]+.*$/.test(code)) {
            $('#codeTips').text("请勿输入汉字");
            check3 = false;
            return false;
        }
        if (code.length === 0) {
            $('#codeTips')[0].style.color = "red";
            $('#codeTips').text("请输入验证码");
            check3 = false;
            return false;
        }
        if (!check3) {
            $.ajaxSettings.async = false;

            $.post(
                "../codeCheck",
                {"code": code},
                function (data) {
                    if (data == "true") {
                        $('#codeTips')[0].style.color = "green";
                        $('#codeTips').text("验证码正确！");
                        check3 = true;
                    }
                    if (data == "false") {
                        $('#codeTips')[0].style.color = "red";
                        $('#codeTips').text("验证码错误！");
                        check3 = false;
                        return false;
                    }
                },
                "html"
            );
            $.ajaxSettings.async = true;
        }
    })

    $('#codePic').click(function () {
        getCode();
    })


    $('#login').click(function () {
        $('#username').blur()
        if (!check1) {
            return false
        }
        $('#password').blur()
        if (!check2) {
            return false
        }
        $('#codeInput').blur()
        if (check3) {
            var userInfo = $('#username').val().trim();
            var password = $('#password').val().trim();
            var rem=$("#rememberCheck").prop('checked')

            $.post("../loginCheck", {"inputInfo": userInfo, "password": password,"rem": rem },
                function (data) {
                    if (data==="true") {
                        window.location.href = "../";
                    } else {
                        $('#usernameTips').text("用户名或密码错误")
                    }
                },
                "html"
            );
        }
    })
})
