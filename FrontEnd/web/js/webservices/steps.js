function subirFirmaWS(signature) {
    var request = new XMLHttpRequest();
    var formdata = new FormData();
    formdata.append('id', 11);
    formdata.append('signature', signature);
    request.open('POST',
        'https://hightek.com.mx:8443/WSSubirFirmaDigitalizada/ws/firma/guardar', true);
    request.timeout = 120000; //milliseconds
    request.onload = function () {
        var data = JSON.parse(this.response);
        if (request.status >= 200 && request.status < 300 && !data.error) {
            alert(data.mensaje);
            hasSignature = false;
            signaturePad.clear();
        } else {
            alert("El servicio no se encuentra disponible en este momento");
        }
    }
    request.onreadystatechange = function () {
        if (!(request.status >= 200 && request.status < 300)) {
            alert("El servicio no se encuentra disponible en este momento...");
        }
    };
    request.ontimeout = function (e) {
        alert("El servicio no se encuentra disponible en este momento... ");
    };
    request.send(formdata);
}
