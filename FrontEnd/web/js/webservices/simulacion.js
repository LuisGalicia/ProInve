function getGraficaSimulacion(plazo, importe, tipoinversion) {
    var request = new XMLHttpRequest();
    var formdata = new FormData();
    formdata.append('plazo', plazo);
    formdata.append('importe', importe);
    formdata.append('tipoinversion', tipoinversion);
    request.open('POST',
        'http://localhost:8085/WebServicesProInve/webresources/graficas/simulacion', true);
    request.timeout = 120000; //milliseconds
    request.onload = function () {
        var data = JSON.parse(this.response);
        if (request.status >= 200 && request.status < 300 && !data.error) {
            
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