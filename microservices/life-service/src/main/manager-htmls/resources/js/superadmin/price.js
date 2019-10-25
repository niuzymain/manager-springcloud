$(function () {
    var status = 0;
    var head;
    var body;
    $.getJSON("http://localhost:9000/manager/vegprice/listprice", function (data) {
        if (data.success) {
            for (var i = 0; i < data.data.length; i++) {
                body = "<tr>" +
                    "<td><input type='text' class='vg-name' readonly='readonly' style='border: none' value=" + data.data[i].vegName  + "></td>" +
                    "<td><input type='text' class='vg-price' readonly='readonly' style='border: none' value=" + data.data[i].price  + "></td>" +
                    "<td><a href='#' class='edit' onclick=Edit(this," + data.data[i].id+ ")  >修改</a></td>" +
                    "</tr>"
                $("#itemlist tbody").append(body)
            }
        }
        else {
            alert(data.errormsg)
        }
    })

    $("#insert").click(function () {
        $("#itemlist tbody").append("<tr><td><input type='text' placeholder='蔬菜名称' id='name'></td><td><input type='text' placeholder='价格' id='price'></td></tr>");
        $("#submit").click(function () {
            var price = {
                vegName:$("#name").val(),
                price:$("#price").val()
            }
            $.ajax({
                url: "http://localhost:9000/manager/vegprice/addprice",
                data: {
                    jsonstr:JSON.stringify(price)
                },
                type: "post",
                success: function (data) {
                    if (data.success) {
                        alert("success");
                        location.reload();
                    }
                    else {
                        alert("error：" + data.errormsg);
                    }
                }
            })
        })
    })

})

function Edit(target,id){
    $(target).parent().parent().find("input").css("border","solid 1px")
    $(target).parent().parent().find("input").removeAttr("readonly")
    $("#submit").click(function () {
        var price = {
            id:id,
            vegName:$(target).parent().parent().find(".vg-name").val(),
            price:$(target).parent().parent().find(".vg-price").val()
        }
        $.ajax({
            url: "http://localhost:9000/manager/vegprice/editprice",
            data: {
                jsonstr:JSON.stringify(price)
            },
            type: "post",
            success: function (data) {
                if (data.success) {
                    alert("success");
                    location.reload();
                }
                else {
                    alert("error：" + data.errormsg);
                }
            }
        })
    })
}
