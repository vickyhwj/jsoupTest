var fu;
$("#sub").click(function (e) {
    e.preventDefault();
    $("#seasonPres").html('')
    $("#seasonSums").html('')
    $.ajax({
        type: "get",
        url: "getPlaysBySeason_Team",
        data: "season=" + $("#seasonName").val() + "&team=" + $("#teamName").val(),
        success: function (res) {
            console.log(res)
            for (var i = 0; i < res.length; ++i) {
                $("#seasonPres").append("<tr>");
                $("#seasonPres").append("<td>" + res[i].name + "</td>");
                var sp = res[i].seasonPres[0];
                for (var x in sp) {
                    if (x != 'season' && x != 'team')
                        $("#seasonPres").append("<td>" + sp[x].toFixed(1) + "</td>");
                }
                $("#seasonPres").append("</tr>");

                $("#seasonSums").append("<tr>");
                $("#seasonSums").append("<td>" + res[i].name + "</td>");

                var sm = res[i].seasonSums;
                $("#seasonSums").append("<td>" + sm.chuchang.toFixed(0) + "</td>");
                $("#seasonSums").append("<td>" + sm.shoufa.toFixed(0) + "</td>");
                $("#seasonSums").append("<td>" + sm.shijian.toFixed(0) + "</td>");
                $("#seasonSums").append("<td>" + sm.toulanmingzhong.toFixed(0) + "-" +
                    sm.toulancishu.toFixed(0) + "</td>");
                $("#seasonSums").append("<td>" + sm.sanfenmingzhong.toFixed(0) + "-" +
                    sm.sanfencishu.toFixed(0) + "</td>");
                $("#seasonSums").append("<td>" + sm.faqiumingzhong.toFixed(0) + "-" +
                    sm.faqiucishu.toFixed(0) + "</td>");
                $("#seasonSums").append("<td>" + sm.qianlanban.toFixed(0) + "</td>");
                $("#seasonSums").append("<td>" + sm.houlanban.toFixed(0) + "</td>");
                $("#seasonSums").append("<td>" + sm.zonglanban.toFixed(0) + "</td>");
                $("#seasonSums").append("<td>" + sm.cugong.toFixed(0) + "</td>");
                $("#seasonSums").append("<td>" + sm.qiangduan.toFixed(0) + "</td>");
                $("#seasonSums").append("<td>" + sm.gaimao.toFixed(0) + "</td>");
                $("#seasonSums").append("<td>" + sm.shiwu.toFixed(0) + "</td>");
                $("#seasonSums").append("<td>" + sm.fangui.toFixed(0) + "</td>");
                $("#seasonSums").append("<td>" + sm.defen.toFixed(0) + "</td>");
                $("#seasonSums").append("</tr>");

            }
        }
    });

});

$("#bu_pre").click(function () {
    $("#bu_sum").removeClass('active')
    $("#table_sum").hide()
    $(this).addClass("active")
    $("#table_pre").show();
})
$("#bu_sum").click(function () {
    $("#bu_pre").removeClass('active')
    $("#table_pre").hide()
    $(this).addClass("active")
    $("#table_sum").show();
})