/**
 * @license
 * Copyright (c) 2014, 2019, Oracle and/or its affiliates.
 * The Universal Permissive License (UPL), Version 1.0
 */
/*
 * Your dashboard ViewModel code goes here
 */
define(['ojs/ojcore','knockout','jquery','ojs/ojformlayout','ojs/ojbutton','ojs/ojdialog'],
 function() {

    function InicioViewModel() {
      var self = this;
      
      this.direccionInicio = function (event) {
        router.stateId('info');
      }
      this.direccionSimulacion = function (event) {
        router.stateId('simuin');
      }
      this.openContinuar = function (event) {
        document.getElementById('modalContinuar').open();
      }
      this.closeContinuar = function (event) {
        document.getElementById('modalContinuar').close();
      }
    }

    return new InicioViewModel();
  }
);
