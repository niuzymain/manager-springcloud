////////////////////////////// 从url中取参数/////////////////////////////////////
function getURLarg(variable) {
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i = 0; i < vars.length; i++) {
        var pair = vars[i].split("=");
        if (pair[0] == variable) {
            return pair[1];
        }
    }
    return null;
}

///////////////////////////////////更换验证码///////////////////////////////////////
function changecode(target) {
    target.src = "../checkcode?" + Math.floor(Math.random() * 100);
}

/////////////////////////根据状态值显示状态名称//////////////////////////////////////////
function statusinfo(data) {
    if (data == 1) {
        return "可用"
    }
    else if (data == 0) {
        return "禁用"
    }
    else if (data == 2) {
        return "服务中"
    }

}

function checkinfo(data) {
    if (data == -1) {
        return "审核不通过"
    }
    else if (data == 0) {
        return "审核中"
    }
    else if (data == 1) {
        return "待签合同"
    }
    else if (data == 2) {
        return "审核通过"
    }

}

/////////////////////////////////根据性别值显示性别名称////////////////////////////////
function sexinfo(data) {
    if (data == 1) {
        return "男"
    }
    else if (data == 2) {
        return "女"
    }

}


//格式化date
function timeStamp2String(time) {
    var datetime = new Date();
    datetime.setTime(time);
    var year = datetime.getFullYear();
    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
    var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
    // var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();
    // var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
    // var second = datetime.getSeconds()< 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
    return year + "-" + month + "-" + date/*+" "+hour+":"+minute+":"+second*/;
}

//二级列表显示切换
function displaychange() {
    $(".secondmenu").show();
}


//从数据库中获取字段
function getItemsFromDB() {
    $.getJSON("/common/getitemlist", function (data) {
        if (data.success) {
            var i;
            for (i = 0; i < data.degrees.length; i++) {
                $(".degree select").append("<option value=" + data.degrees[i].degreeid + ">" + data.degrees[i].degreename + "</option>")
            }
            for (i = 0; i < data.citys.length; i++) {
                $(".area .citys").append("<option value=" + data.citys[i].workareaid + ">" + data.citys[i].workareaname + "</option>")
            }
            for (i = 0; i < data.types.length; i++) {
                $(".type select").append("<option value=" + data.types[i].servicetypeid + ">" + data.types[i].servicetypename + "</option>")
            }
        }
        else {
            alert(data.errormsg)
        }
    })
}

