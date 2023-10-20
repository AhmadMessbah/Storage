<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP</title>
    <jsp:include page="css-import.jsp"/>
</head>
<body>
<div class="container-fluid">
    <p style="font-family: 'B Yekan'">قسمت اصلی سایت</p>
    <button class="btn btn-primary" onclick="fet()"><i class="fa fa-remove"></i> Test</button>
    <button onclick="wsConnect()">WebSocket</button>
</div>
<script>
    async function fet() {
        const resp = await fetch("/rest/group", {
            method: "GET",
        });
        const data = await resp.json();

        if (resp.status !== 200 && resp.status !== 201) {
            console.log("Error : " + resp.status + " : " + data);
        } else {
            data.forEach(function (item) {
                console.log(item);
            });
        }
    }
</script>

<script>
    const webSocket = new WebSocket('ws://localhost/websocketendpoint');

    webSocket.onerror = function (event) {
        onError(event)
    };
    webSocket.onopen = function (event) {
        onOpen(event)
    };
    webSocket.onmessage = function (event) {
        onMessage(event)
    };

    webSocket.onclose = function (event) {
        onClose(event)
    };

    function onMessage(event) {
        // const eventPayload = JSON.parse(event.data);
        // document.getElementById('stockInformation').innerHTML +=
        <%--    `<tr><td>${eventPayload.stock}</td><td>${eventPayload.price} $</td></tr>`;--%>
    }

    function onClose(event) {
        console.log("Close : " + event);
    }

    function onOpen(event) {
        console.log("Connect : " + event);
        // document.getElementById('connectionMessage').innerHTML = 'Connection established';
    }

    function onError(event) {
        console.log("Error");
        alert('An error occurred:' + event.data);
    }

    function send() {
        // const payload = {
        //     'stock': document.getElementById('stockName').value,
        //     'price': document.getElementById('stockPrice').value
        // };
        //
        // webSocket.send(JSON.stringify(payload));
    }
</script>
<jsp:include page="js-import.jsp"/>
</body>
</html>