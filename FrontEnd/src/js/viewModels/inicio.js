/**
 * @license
 * Copyright (c) 2014, 2019, Oracle and/or its affiliates.
 * The Universal Permissive License (UPL), Version 1.0
 */
/*
 * Your dashboard ViewModel code goes here
 */
define([
  "ojs/ojcore",
  "knockout",
  "jquery",
  "ojs/ojformlayout",
  "ojs/ojbutton",
  "ojs/ojdialog"
], function() {
  function InicioViewModel() {
    var self = this;

    this.direccionInicio = function(event) {
      router.stateId("info");
    };
    this.direccionSimulacion = function(event) {
      var urlAccess =
        "http://localhost:8080/WebServicesProInve/webresources/graficas/getalltiposinversion";
      var xhr = new XMLHttpRequest();
      xhr.open("GET", urlAccess);
      xhr.timeout = 1200000; //milliseconds

      xhr.onload = function() {
        var datas = this.response;

        if (xhr.status >= 200 && xhr.status < 300) {
          console.log(datas + ":  Index");
          alltiposinversion(datas);
          router.stateId("simuin");
        } else {
          console.error(datas + "ERRRRRRROR");
        }
      };
      xhr.send(null);
      
    };
    this.openContinuar = function(event) {
      document.getElementById("modalContinuar").open();
    };
    this.closeContinuar = function(event) {
      document.getElementById("modalContinuar").close();
    };
  }

  return new InicioViewModel();
});
