$("#jiqueSearch").click(function (e) { 
    e.preventDefault();
    console.log($("#jique").val())
    $.ajax({
        type: "get",
        url: "getPlayer",
        data: "name="+$("#jique").val(),
        success: function (res) {
            console.log(res);
            for(var x in res){
                if(x!='img')
                    $("#"+x).html(res[x])
                else if(x=='img')
                    $("#img").attr("src",res[x])
            }
            $("#seasonPres").html('');
            $("#seasonSums").html('')
            var seasonPres=res.seasonPres;
            for(var i=0;i<seasonPres.length;++i){
              //  $("#seasonPres").append("<tr");
            	var app="<tr>";
                for(var x in seasonPres[i]){
                    if(x!='season'&&x!='team')
                        seasonPres[i][x]=seasonPres[i][x].toFixed(1);
                    app=app+'<td>'+seasonPres[i][x]+"</td>";   
                }
                app=app+"</tr>";
                $("#seasonPres").append(app);    
            }

            var sms = res.seasonSums;
            for(var i=0;i<sms.length;++i){
                var sm=sms[i];
                $("#seasonSums").append("<tr>");
                $("#seasonSums").append("<td>" + sm.season + "</td>");
                $("#seasonSums").append("<td>" + sm.team + "</td>");
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
var jique=document.getElementById("jique");
jique.onkeyup=function(e){
    var val=$("#jique").val();
    $.ajax({
        type: "get",
        url: "getPlayerList",
        data: "name="+val,
        success: function (res) {
            console.log(res);
            $("#tishi").html('');
            for(var i=0;i<res.length;++i)
                $("#tishi").append('<li>'+res[i].name+'</li>')
          
        }
    });
}
$("#tishi").on('click','li',function(){
    var val=$(this).text();
    $("#jique").val(val);
    $("#tishi").html('')
});

var tishi=document.getElementById("tishi");
document.onclick=function(e){
    console.log(e);
    var x=e.offsetX,y=e.offsetY;
    console.log(x+" "+y) 
    console.log(tishi.offsetLeft+" "+tishi.offsetTop) 
    console.log(tishi.clientWidth+" "+tishi.clientHeight) 
    var x1=tishi.offsetLeft;
    var x2=x1+tishi.clientWidth;
    var y1=tishi.offsetTop;
    var y2=y1+tishi.clientHeight;
    if(!(x>=x1&&x<=x2&&y>=y1&&y<=y2))
    	 $("#tishi").html('')
}

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