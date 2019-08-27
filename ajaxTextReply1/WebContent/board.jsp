<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            var requestPage = "${pageContext.request.contextPath}/BoardServ";	//pageContext.request.contextPath 로컬호스트밑의 프로젝트
            $.ajax({
                url: requestPage,
                data: { action: "list" },
                dataType: "json",
                success: function (result) {
                    console.log(result);	//데이터 들어온거확인
                    var $table = $("<table>").attr("id", "tab1");
                    $.map(result, function (r, i) {
                        $tr = $("<tr>").attr("id", r.boardNo).append(
                            $("<td>").text(r.boardNo),
                            $("<td>").text(r.title),
                            $("<td>").text(r.content),
                            $("<td>").html($("<button>").text("수정").click(onupdate)),	//버튼추가
                            $("<td>").html($("<button>").text("삭제").click(ondelete))
                        )
                        $table.append($tr);
                    })
                    $("#show").append($table);
                }
            });
         	 
            //삭제누르면 행삭제 
            function ondelete() {	
                $(this).parent().parent().remove();
                var boardNo = $(this).parent().parent().children().eq(0).text();
                $.ajax({
                    url: requestPage,
                    data: {
                        action: "delete",
                        boardNo: boardNo
                    },		//변경하기위한 데이터를얻어와야함
                    dataType: "json",
                    success: function (result) {
                        $("#" + boardNo).after(
                            $("<tr>").append(
                                $("<td>").html(boardNo).val("삭제")
                            )
                        )
                    }
                });
            }


            //수정 버튼누르면
            function onupdate() {			//$("<td>").html($("<button>").text("수정").click(onupdate)),	//버튼추가
                var boardNo = $(this).parent().parent().children().eq(0).text();//this = button 이벤트 발생하는태그를 가르킨다
                //     td       td       tr       처음
                console.log(boardNo)
                if ($(this).parent().parent().children().eq(0).next())
                    $.ajax({
                        url: requestPage,
                        data: {
                            action: "get",
                            boardNo: boardNo
                        },		//변경하기위한 데이터를얻어와야함
                        dataType: "json",
                        success: function (result) {
                        	console.log(result);
                            $("#" + boardNo).after(
                                $("<tr>").append(
                                    $("<td>").html(boardNo).css("color", "white"),
                                    $("<td>").html($("<input>").attr("type", "text").val(result[0].title)),	//한건이지만 배열타입이라서 result[0]
                                    $("<td>").html($("<input>").attr("type", "text").val(result[0].content)),//수정누르면 현재 제목 내용 텍스트창에 자동으로넣음
                                    $("<td>").html($("<button id='up'>").text("변경").click(updateRow))
                                )
                            );
                        }
                    });
            }

            //변경버튼 클릭
            function updateRow() {
                var $id = $(this).parent().parent().children().eq(0).text();
                var $title = $(this).parent().parent().children().eq(1).children().eq(0).val();
                var $content = $(this).parent().parent().children().eq(2).children().eq(0).val();

                $.ajax({
                    url: requestPage,
                    data: {
                        action: "update",
                        boardNo: $id,
                        title: $title,
                        content: $content
                    },
                    success: function () {		//변경 성공? 하면 버튼 조상의 조상(<tr>) 삭제 //위에 아이디 추가해줬음 <button id='up'>
                        console.log($("#up"));	//   && 수정한 내용 바로 반영되게
                        console.log($title);
                        $("#" + $id).children().eq(1).text($title);	//수정제목입력
                        $("#" + $id).children().eq(2).text($content);	//수정내용
                        $("#up").parent().parent().remove();
                    }
                })
            }

            //등록버튼 클릭시.
            $("#register").on("click", function () {
                $.ajax({
                    url: requestPage,
                    data: {
                        action: "register",
                        title: $("#title").val(),
                        content: $("#content").val()
                    },
                    success: function (result) {
                        console.log(result);
                        $("#tab1").append(
                            $("<tr>").append(
                                $("<td>").text(result),
                                $("<td>").text($("#title").val()),
                                $("<td>").text($("#content").val()),
                                $("<td>").html($("<button>").text("수정").click(onupdate)),	//버튼추가
                                $("<td>").html($("<button>").text("삭제").click(ondelete))
                            )
                        );
                        $("#title").val("");
                        $("#content").val("");
                    }
                });
            });
        });
    </script>
</head>

<body>
    <div id="show"></div>
    <form id="frm1">
        <table>
            <tr>
                <td>Title:<input type="text" id="title" name="title"></td>
                <td>Contend:<input type="text" id="content" name="content"></td>
                <td><input type="button" id="register" value="등록"></td>
            </tr>
        </table>
    </form>
</body>

</html>