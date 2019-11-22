/**
 * @license
 * Copyright (c) 2014, 2019, Oracle and/or its affiliates.
 * The Universal Permissive License (UPL), Version 1.0
 */
/*
 * Your incidents ViewModel code goes here
 */
define(['ojs/ojcore', 'knockout', 'jquery', 'ojs/ojarraydataprovider', 'text!../viewModels/json/simulacion.json',
  'text!../viewModels/json/comparacion.json', 'ojs/ojresponsiveutils', 'ojs/ojresponsiveknockoututils',
  'ojs/ojknockout', 'ojs/ojformlayout', 'ojs/ojlabel', 'ojs/ojselectcombobox', 'ojs/ojselectcombobox',
  'ojs/ojinputtext', 'ojs/ojbutton', 'ojs/ojdatetimepicker', 'ojs/ojradioset', 'ojs/ojinputnumber',
  'ojs/ojswitch', 'ojs/ojbutton', 'ojs/ojtable', 'ojs/ojbootstrap', 'ojs/ojdialog', 'ojs/ojarraydataprovider',
  'ojs/ojchart', 'ojs/ojtoolbar'],
  function (oj, ko, $, ArrayDataProvider, dataSimu, dataComp) {

    function SimuinViewModel() {
      var self = this;
      var o;

      var smQuery = oj.ResponsiveUtils.getFrameworkQuery(oj.ResponsiveUtils.FRAMEWORK_QUERY_KEY.SM_ONLY);
      self.smScreen = oj.ResponsiveKnockoutUtils.createMediaQueryObservable(smQuery);

      this.columns = ko.computed(function () {
        return this.smScreen() ? 1 : 2;
      }.bind(this));

      var deptArray = [{ tipoinversion: "Tipo de inversión 1" }, { tipoinversion: "Tipo de inversión 3" }];

      this.closeSimu = function (event) {
        document.getElementById('modalsimulador').close();
      }

      this.getGraficaSimulacions = function (event) {
        getGraficas(3, 200000, 'wacha');
      }

      function openSimu(){
        document.getElementById('modalsimulador').open();
      }
     
      this.direccionSolicitud = function (event) {
        router.stateId('soliin');
      }

      this.closeCompa = function (event) {
        document.getElementById('modalcomparar').close();
      }

      this.openCompa = function (event) {
        document.getElementById('modalcomparar').open();
      }

      this.dataprovider = new ArrayDataProvider(deptArray, {
        keyAttributes: 'tipoinversion',
        implicitSort: [{ attribute: 'tipoinversion', direction: 'ascending' }]
      });

      orientationValue = ko.observable('vertical');
      stackValue = ko.observable('off');
      dataSimulacion = ko.observable();

      dataComparacion = new ArrayDataProvider(JSON.parse(dataComp), { keyAttributes: 'id' });

      function getGraficas(plazoParam, importeParam, tipoinversionParam) {
        // Post a user
        var url = "http://localhost:8085/WebServicesProInve/webresources/graficas/simulacion";

        var data = [];

        data.push(encodeURIComponent("plazo") + "=" + encodeURIComponent(plazoParam));
        data.push(encodeURIComponent("importe") + "=" + encodeURIComponent(importeParam));
        data.push(encodeURIComponent("tipoinversion") + "=" + encodeURIComponent(tipoinversionParam));

        var json = data.join('&').replace(/%20/g,'+');
        console.log(json)

        var xhr = new XMLHttpRequest();
        xhr.open("POST", url);
        xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded', );
        xhr.timeout = 120000; //milliseconds
        
        xhr.onload = function () {
          var datas = this.response;
          if (xhr.status >= 200 && xhr.status < 300) {
            console.error(datas + ":datos mostrados:");
            dataSimulacion(new ArrayDataProvider(JSON.parse(datas), { keyAttributes: 'plazo' }));
            openSimu();
          } else {
            console.error(datas + "ERRRRRRROR");
          }
        }
        xhr.send(json);
      }


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
    return new SimuinViewModel();
  }
);
