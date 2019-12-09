var url = "http://localhost:8085/WebServicesProInve/webresources/";

function stepZero(plazoParam, importeParam, tipoinversionParam) {

    console.log(plazoParam, importeParam, tipoinversionParam);
    // Post a user
    var urlAccess = "steps/step0";

    var request = new XMLHttpRequest();
    var respuesta;
    var urlEncodedData = "";
    var urlEncodedDataPairs = [];
    var stepcero = JSON.stringify({
        id_tipo_inversion: tipoinversionParam, id_origen: 1,
        monto_inversion: importeParam, plazo: plazoParam
    });
    urlEncodedDataPairs.push(encodeURIComponent("datosRecuperados") + "=" +
        encodeURIComponent(stepcero));

    urlEncodedData = urlEncodedDataPairs.join("&").replace(/%20/g, "+");

    request.open("POST", url + urlAccess);
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    request.timeout = 5000;

    request.onreadystatechange = function () {
        if (!request.status >= 200 && request.status < 300) {
            alert("Ocurrió un error en la petición");
        }
    };

    request.ontimeout = function (e) {
        alert("Se agotó el tiempo de espera, intentelo más tarde");
    };

    request.onload = function () {
        respuesta = JSON.parse(this.response);
        if (request.status >= 200 && request.status < 300) {
            if (respuesta.error) {
                alert(respuesta.mensaje);
            } else {
                alert(respuesta);
            }
        }
    };
    request.send(urlEncodedData);
}

function stepOne() {

    // Post a user
    var urlAccess = "steps/step0";

    var request = new XMLHttpRequest();
    var respuesta;
    var urlEncodedData = "";
    var urlEncodedDataPairs = [];
    var stepcero = JSON.stringify({
        id_tipo_inversion: tipoinversionParam, id_origen: 1,
        monto_inversion: importeParam, plazo: plazoParam
    });
    urlEncodedDataPairs.push(encodeURIComponent("datosRecuperados") + "=" +
        encodeURIComponent(stepcero));

    urlEncodedData = urlEncodedDataPairs.join("&").replace(/%20/g, "+");

    request.open("POST", url + urlAccess);
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    request.timeout = 5000;

    request.onreadystatechange = function () {
        if (!request.status >= 200 && request.status < 300) {
            alert("Ocurrió un error en la petición");
        }
    };

    request.ontimeout = function (e) {
        alert("Se agotó el tiempo de espera, intentelo más tarde");
    };

    request.onload = function () {
        respuesta = JSON.parse(this.response);
        if (request.status >= 200 && request.status < 300) {
            if (respuesta.error) {
                alert(respuesta.mensaje);
            } else {
                alert(respuesta);
            }
        }
    };
    request.send(urlEncodedData);
}


