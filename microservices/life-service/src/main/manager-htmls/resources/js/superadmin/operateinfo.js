$(function () {
    var infoId = getURLarg("id")
    var submiturl = "http://localhost:9000/manager/govinfo/editgovinfo";
    $.getJSON("http://localhost:9000/manager/govinfo/listinfobyid?govinfoid=" + infoId, function (data) {
        if (data.success) {
            $("#title").val(data.data.infoTitle);
            $("#details").val(data.data.infoDetail)
        }
        else {
            alert("error" + data.errormsg)
        }
    })

    $("#submit").click(function () {
        var info = {
            infoId: infoId,
            infoTitle:$("#title").val(),
            infoDetail: $("#details").val()
        }
        $.ajax({
            url: submiturl,
            data: {
                jsonstr:JSON.stringify(info)
            },
            type: "post",
            success: function (data) {
                if (data.success) {
                    alert("success");
                    window.location.href = "governmentinfo.html";
                }
                else {
                    alert("error：" + data.errormsg);
                }
            }
        })
    })
})