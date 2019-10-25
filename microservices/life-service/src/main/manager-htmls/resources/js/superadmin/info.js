$(function () {
    var status = 0;
    var head;
    var body;
    $.getJSON("http://localhost:9000/manager/govinfo/listinfo", function (data) {
        if (data.success) {
            for (var i = 0; i < data.data.length; i++) {
                body = "<tr>" +
                    "<td>" + data.data[i].infoTitle + "</td>" +
                    "<td>" + timeStamp2String(data.data[i].createTime) + "</td>" +
                    "<td>" + timeStamp2String(data.data[i].editTime) + "</td>" +
                    "<td><a href=infodetail.html?id="+data.data[i].infoId+" class=\"sui-btn btn-xlarge btn-primary handle\">详情</a></td>" +
                    "</tr>"
                $("#infotable tbody").append(body)
            }
        }
        else {
            alert(data.errormsg)
        }
    })

})