$(function () {
    var submiturl = "http://localhost:9000/manager/govinfo/addgovinfo";
    $("#submit").click(function () {
        var info = {
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