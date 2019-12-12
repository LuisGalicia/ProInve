var url = "http://localhost:8080/WebServicesProInve/webresources/";

function stepZero(plazoParam, importeParam, tipoinversionParam) {
  // Post a user
  var urlAccess = "steps/step0";

  var request = new XMLHttpRequest();
  var respuesta;
  var urlEncodedData = "";
  var urlEncodedDataPairs = [];
  var stepcero = JSON.stringify({
    id_tipo_inversion: tipoinversionParam,
    id_origen: 1,
    monto_inversion: importeParam,
    plazo: plazoParam
  });
  urlEncodedDataPairs.push(
    encodeURIComponent("datosRecuperados") + "=" + encodeURIComponent(stepcero)
  );

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
      idstepzeroapp(respuesta[0].id_recuperado);
    }
  };
  request.send(urlEncodedData);
}

function stepOne(
  nombre,
  apellidopa,
  apellidoma,
  rfc,
  fecha,
  profesion,
  empresa,
  correo,
  telefono,
  idstepzero
) {
  // Post a user
  var urlAccess = "steps/step1";

  var request = new XMLHttpRequest();
  var respuesta;
  var urlEncodedData = "";
  var urlEncodedDataPairs = [];
  var stepone = JSON.stringify({
    nombre: nombre,
    apellido_paterno: apellidopa,
    apellido_materno: apellidoma,
    rfc: rfc,
    fecha_nacimiento: fecha,
    profesion: profesion,
    nombre_empresa: empresa,
    correo: correo,
    telefono: telefono,
    id_step0: idstepzero
  });
  urlEncodedDataPairs.push(
    encodeURIComponent("datosRecuperados") + "=" + encodeURIComponent(stepone)
  );

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
      idsteponeapp(respuesta[0].id_recuperado);
      currentModule('steptwo');
      currentStep('stp2');

    }
  };
  request.send(urlEncodedData);
}
function steptwo(codigo, idstepone) {
  // Post a user
  var urlAccess = "steps/verifica";

  var request = new XMLHttpRequest();
  var respuesta;
  var urlEncodedData = "";
  var urlEncodedDataPairs = [];
  var stepcero = JSON.stringify({
    Id_Step1: idstepone,
    Codigo_Verificacion: codigo
  });
  urlEncodedDataPairs.push(
    encodeURIComponent("datosRecuperados") + "=" + encodeURIComponent(stepcero)
  );

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
      if(espuesta[0].id_recuperado == 1){
        currentModule('stepthree');
        currentStep('stp3');
      }else{
        alert("El codigo ingresado no corresponde");
      }
    }
  };
  request.send(urlEncodedData);
}
function stepthree(calle, numerocalle, codigopostal, idstepone) {
  // Post a user
  var urlAccess = "steps/step3";

  var request = new XMLHttpRequest();
  var respuesta;
  var urlEncodedData = "";
  var urlEncodedDataPairs = [];
  var stepcero = JSON.stringify({
    calle: calle,
    numero: numerocalle,
    id_codigo_postal: codigopostal,
    id_step1: idstepone
  });
  urlEncodedDataPairs.push(
    encodeURIComponent("datosRecuperados") + "=" + encodeURIComponent(stepcero)
  );

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
      currentModule('stepfour');
      currentStep('stp4');
    }else{
      alert("Ocurrió un error, vuelva a intentar");
    }
  };
  request.send(urlEncodedData);
}

function stepfour(cuenta, clabe, idstepone) {
  // Post a user
  var urlAccess = "steps/step4";

  var request = new XMLHttpRequest();
  var respuesta;
  var urlEncodedData = "";
  var urlEncodedDataPairs = [];
  var stepcero = JSON.stringify({
    clabe: clabe,
    no_cuenta: cuenta,
    id_step1: idstepone
  });
  urlEncodedDataPairs.push(
    encodeURIComponent("datosRecuperados") + "=" + encodeURIComponent(stepcero)
  );

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
      currentModule('stepfive');
      currentStep('stp5');
      }else{
        alert("Ocurrió un error, vuelva a intentar");
      }
    
  };
  request.send(urlEncodedData);
}

function subirFirmaWS(signature) {
  var request = new XMLHttpRequest();
  var formdata = new FormData();
  var urlAccess = "firma";
  formdata.append("id", 11);
  formdata.append("signature", signature);
  request.open("POST", url + urlAccess, true);
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
  };
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
