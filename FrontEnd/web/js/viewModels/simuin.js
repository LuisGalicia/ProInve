/**
 * @license
 * Copyright (c) 2014, 2019, Oracle and/or its affiliates.
 * The Universal Permissive License (UPL), Version 1.0
 */
/*
 * Your incidents ViewModel code goes here
 */
define(['ojs/ojcore', 'knockout', 'jquery', 'ojs/ojarraydataprovider', 'text!../viewModels/json/simulacion.json', 'ojs/ojresponsiveutils', 'ojs/ojresponsiveknockoututils',
  'ojs/ojknockout', 'ojs/ojformlayout', 'ojs/ojlabel', 'ojs/ojselectcombobox', 'ojs/ojselectcombobox',
  'ojs/ojinputtext', 'ojs/ojbutton', 'ojs/ojdatetimepicker', 'ojs/ojradioset', 'ojs/ojinputnumber',
  'ojs/ojswitch', 'ojs/ojbutton', 'ojs/ojtable', 'ojs/ojbootstrap', 'ojs/ojdialog', 'ojs/ojarraydataprovider',
  'ojs/ojchart', 'ojs/ojtoolbar'],
  function (oj, ko, $, ArrayDataProvider, data) {

    function SimuinViewModel() {
      var self = this;

      var smQuery = oj.ResponsiveUtils.getFrameworkQuery(oj.ResponsiveUtils.FRAMEWORK_QUERY_KEY.SM_ONLY);
      self.smScreen = oj.ResponsiveKnockoutUtils.createMediaQueryObservable(smQuery);

      this.columns = ko.computed(function () {
        return this.smScreen() ? 1 : 2;
      }.bind(this));

      var deptArray = [{ tipoinversion: "Tipo de inversión 1" }, { tipoinversion: "Tipo de inversión 3" }];

      this.close = function (event) {
        document.getElementById('modalsimulador').close();
      }

      this.open = function (event) {
        document.getElementById('modalsimulador').open();
      }

      this.dataprovider = new ArrayDataProvider(deptArray, {
        keyAttributes: 'tipoinversion',
        implicitSort: [{ attribute: 'tipoinversion', direction: 'ascending' }]
      });
        
      orientationValue = ko.observable('vertical');
       stackValue = ko.observable('off');
       dataProvider = new ArrayDataProvider(JSON.parse(data), { keyAttributes: 'id' });
  

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
