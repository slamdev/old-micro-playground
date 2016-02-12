"use strict";

$(document).ready(function () {

    var service1endpointUrl = "http://localhost:8081/service1";
    var service2endpointUrl = "http://localhost:8082/service2";

    $("#service1").click(function () {
        callService(service1endpointUrl, $("#service1Result"));
    });

    $("#service2").click(function () {
        callService(service2endpointUrl, $("#service2Result"));
    });

    function callService(url, output) {
        $.ajax(url).done(function (result) {
            output.val(JSON.stringify(result))
        }).fail(renderError);
    }

    function renderError(result) {
        console.log(result);
        alert("Error appeared during ajax request");
    }
});
