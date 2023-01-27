var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetingsPerson1', function (greeting) {
            showMessagesFromPerson1(JSON.parse(greeting.body).content);
        });

         stompClient.subscribe('/topic/greetingsPerson2', function (greeting) {
                    showMessagesFromPerson2(JSON.parse(greeting.body).content);
                });

         stompClient.subscribe('/topic/greetingsPerson3', function (greeting) {
                              showMessagesFromPerson3(JSON.parse(greeting.body).content);
                          });

    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendMessageFromPerson1() {
    stompClient.send("/app/endpointPerson1", {}, JSON.stringify({'messageContent': $("#messageFromPerson1").val()}));
}

function sendMessageFromPerson2() {
    stompClient.send("/app/endpointPerson2", {}, JSON.stringify({'messageContent': $("#messageFromPerson2").val()}));
}
function sendMessageFromPerson3() {
    stompClient.send("/app/endpointPerson3", {}, JSON.stringify({'messageContent': $("#messageFromPerson3").val()}));
}

function showMessagesFromPerson1(message) {
    $("#messagesFromPerson1").append("<tr><td style='color:green'>" + message + "</td></tr>");
    $("#messagesFromPerson2").append("<tr><td>" + "Person 1: " + message + "</td></tr>");
    $("#messagesFromPerson3").append("<tr><td>" + "Person 1: " + message + "</td></tr>");
}
function showMessagesFromPerson2(message) {
    $("#messagesFromPerson2").append("<tr><td style='color:green'>" + message + "</td></tr>");
    $("#messagesFromPerson1").append("<tr><td>" + "Person 2: " + message + "</td></tr>");
    $("#messagesFromPerson3").append("<tr><td>" + "Person 2: " + message + "</td></tr>");
}

function showMessagesFromPerson3(message) {
    $("#messagesFromPerson3").append("<tr><td style='color:green'>" + message + "</td></tr>");
    $("#messagesFromPerson1").append("<tr><td>" + "Person 3: " + message + "</td></tr>");
    $("#messagesFromPerson2").append("<tr><td>" + "Person 3: " + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#sendButtonPerson1" ).click(function() { sendMessageFromPerson1(); });
    $( "#sendButtonPerson2" ).click(function() { sendMessageFromPerson2(); });
    $( "#sendButtonPerson3" ).click(function() { sendMessageFromPerson3(); });
});
