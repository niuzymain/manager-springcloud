$(function() {
    var type;
    $("#submit").click(function() {
        var username = $("#username").val();
        var password = $("#password").val();
        var checkcode = $("#checkcode").val();
        if(!username){
            alert("请输入用户名")
            changecode(document.getElementById("checkcodeimg"))
            return false;
        }
        if(!password){
            alert("请输入密码")
            changecode(document.getElementById("checkcodeimg"))
            return false;
        }
        if(!checkcode){
            alert("请输入验证码")
            changecode(document.getElementById("checkcodeimg"))
            return false;
        }
        var superadmin = {
            "accountname":username,
            "password":password,
        };
        data = {
            username:username,
            password:password,
            "code":checkcode
        }
        $.ajax({
            url:"http://localhost:9000/manager/login/checklogin",
            type:"post",
            data:data,
            xhrFields:{
                withCredentials:true
            },
            success:function(res){
                if(res.success){
                    window.location.href="./governmentinfo.html"
                }
                else{
                    alert(res.errorMsg);
                }
            }
        })
    })
})