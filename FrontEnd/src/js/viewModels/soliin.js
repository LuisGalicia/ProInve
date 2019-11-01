/**
 * @license
 * Copyright (c) 2014, 2019, Oracle and/or its affiliates.
 * The Universal Permissive License (UPL), Version 1.0
 */
/*
 * Your customer ViewModel code goes here
 */
define(['ojs/ojcore', 'knockout', 'jquery', 'ojs/ojbootstrap', 'ojs/ojmodule-element-utils', 'ojs/ojmodule-element',
  'ojs/ojarraydataprovider', 'ojs/ojresponsiveutils', 'ojs/ojresponsiveknockoututils',
  'ojs/ojknockout', 'ojs/ojformlayout', 'ojs/ojlabel', 'ojs/ojselectcombobox', 'ojs/ojselectcombobox',
  'ojs/ojinputtext', 'ojs/ojbutton', 'ojs/ojdatetimepicker', 'ojs/ojradioset', 'ojs/ojinputnumber',
  'ojs/ojswitch', 'ojs/ojbutton', 'ojs/ojtable', 'ojs/ojbootstrap', 'ojs/ojtrain'],
  function (oj, ko, $, Bootstrap, ModuleElementUtils) {


    var self = this;
    this.ModuleElementUtils = ModuleElementUtils;
    this.currentModule = ko.observable("stepone");
    this.stepArray =
      ko.observableArray(
        [{ label: 'Información Personal', id: 'stp1' },
        { label: 'Autenticación', id: 'stp2' },
        { label: 'Datos de Dirección', id: 'stp3', disabled: true },
        { label: 'Información Financiera', id: 'stp4', disabled: true },
        { label: 'Comprobantes', id: 'stp5', disabled: true }]);



    function SoliinViewModel() {
      var self = this;


      // Below are a set of the ViewModel methods invoked by the oj-module component.
      // Please reference the oj-module jsDoc for additional information.

      /**
       * Optional ViewModel method invoked after the View is inserted into the
       * document DOM.  The application can put logic that requires the DOM being
       * attached here.
       * This method might be called multiple times - after the View is created
       * and inserted into the DOM and after the View is reconnected
       * after being disconnected.
       */
      self.connected = function () {
        // Implement if needed
      };

      /**
       * Optional ViewModel method invoked after the View is disconnected from the DOM.
       */
      self.disconnected = function () {
        // Implement if needed
      };

      /**
       * Optional ViewModel method invoked after transition to the new View is complete.
       * That includes any possible animation between the old and the new View.
       */
      self.transitionCompleted = function () {
        // Implement if needed
      };
    }

    /*
     * Returns a constructor for the ViewModel so that the ViewModel is constructed
     * each time the view is displayed.  Return an instance of the ViewModel if
     * only one instance of the ViewModel is needed.
     */
    return new SoliinViewModel();
  }
);
