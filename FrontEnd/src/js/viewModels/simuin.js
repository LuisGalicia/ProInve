/**
 * @license
 * Copyright (c) 2014, 2019, Oracle and/or its affiliates.
 * The Universal Permissive License (UPL), Version 1.0
 */
/*
 * Your incidents ViewModel code goes here
 */
define([
  "ojs/ojcore",
  "knockout",
  "jquery",
  "ojs/ojarraydataprovider",
  "text!../viewModels/json/comparacion.json",
  "ojs/ojknockout-keyset",
  "ojs/ojresponsiveutils",
  "ojs/ojresponsiveknockoututils",
  "ojs/ojknockout",
  "ojs/ojformlayout",
  "ojs/ojlabel",
  "ojs/ojselectcombobox",
  "ojs/ojselectcombobox",
  "ojs/ojinputtext",
  "ojs/ojbutton",
  "ojs/ojdatetimepicker",
  "ojs/ojradioset",
  "ojs/ojinputnumber",
  "ojs/ojswitch",
  "ojs/ojbutton",
  "ojs/ojtable",
  "ojs/ojbootstrap",
  "ojs/ojdialog",
  "ojs/ojarraydataprovider",
  "ojs/ojchart",
  "ojs/ojtoolbar",
  "ojs/ojcheckboxset"
], function(oj, ko, $, ArrayDataProvider, dataComp, keySet) {
  function SimuinViewModel() {
    var self = this;
    
    var o;
    //this.arraytipos = alltiposinversion();
    this.arraytipos = [{"id_tipo_inversion":5,"tasa_retorno":0.07,"tipo_inversion":"Tipo de inversion 1"},
    {"id_tipo_inversion":6,"tasa_retorno":0.065,"tipo_inversion":"Tipo de inversion 2"},
    {"id_tipo_inversion":7,"tasa_retorno":0.082,"tipo_inversion":"Tipo de inversion 3"}];

    orientationValue = ko.observable("vertical");
    stackValue = ko.observable("off");
    dataSimulacion = ko.observable();
    dataComparacion = new ArrayDataProvider(JSON.parse(dataComp), {
      keyAttributes: "id"
    });
    var tipoinversionSeleccionados = "";

    var smQuery = oj.ResponsiveUtils.getFrameworkQuery(
      oj.ResponsiveUtils.FRAMEWORK_QUERY_KEY.SM_ONLY
    );
    self.smScreen = oj.ResponsiveKnockoutUtils.createMediaQueryObservable(
      smQuery
    );

    this.columns = ko.computed(
      function() {
        return this.smScreen() ? 1 : 2;
      }.bind(this)
    );

    var deptArray = [
      { tipoinversion: "Tipo de inversión 1" },
      { tipoinversion: "Tipo de inversión 3" }
    ];

    this.closeSimu = function(event) {
      document.getElementById("modalsimulador").close();
    };

    this.getGraficaSimulacion = function(event) {
      var importe = $("#importeinput").val();
      var plazo = $("#plazoinversioninput").val();
      var array = tipoinversionSeleccionados.split(",");
      if (tipoinversionSeleccionados != "") {
        if (array.length < 2) {
          getGraficasService(plazo, importe, array);
        } else {
          alert("Seleccione solo un tipo de inversión");
        }
      } else {
        alert("Seleccione un tipo de inversión");
      }
    };

    this.getGraficaSimulacion1 = function(event) {
      var importe = $("#importeinput").val();
      var plazo = $("#plazoinversioninput").val();
      var array = tipoinversionSeleccionados.split(",");
      if (tipoinversionSeleccionados != "") {
        if (array.length < 2) {
          getGraficasService(plazo, importe, array[0]);
        } else {
          alert("Seleccione solo un tipo de inversión");
        }
      } else {
        alert("Seleccione un tipo de inversión");
      }
    };

    this.direccionSolicitud = function(event) {
      var importe = $("#importeinput").val();
      var plazo = $("#plazoinversioninput").val();
      var array = tipoinversionSeleccionados.split(",");
      stepZero(plazo, importe, array);
      router.stateId("soliin");
    };

    this.direccionSolicitudCompara = function(event) {
      router.stateId("soliin");
    };

    this.closeCompa = function(event) {
      document.getElementById("modalcomparar").close();
    };

    this.openCompa = function(event) {
      document.getElementById("modalcomparar").open();
    };

    this.dataprovider = new ArrayDataProvider(deptArray, {
      keyAttributes: "tipoinversion",
      implicitSort: [{ attribute: "tipoinversion", direction: "ascending" }]
    });

    var url = "http://localhost:8080/WebServicesProInve/webresources/";

    function getGraficasService(plazoParam, importeParam, tipoinversionParam) {
      // Post a user
      var urlAccess = "graficas/simulacion";

      var data = [];

      data.push(
        encodeURIComponent("plazo") + "=" + encodeURIComponent(plazoParam)
      );
      data.push(
        encodeURIComponent("importe") + "=" + encodeURIComponent(importeParam)
      );
      data.push(
        encodeURIComponent("tipoinversion") +
          "=" +
          encodeURIComponent(tipoinversionParam)
      );

      var json = data.join("&").replace(/%20/g, "+");

      var xhr = new XMLHttpRequest();
      xhr.open("POST", url + urlAccess);
      xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
      xhr.timeout = 120000; //milliseconds

      xhr.onload = function() {
        var datas = this.response;
        if (xhr.status >= 200 && xhr.status < 300) {
          console.error(datas + ":datos mostrados:");
          dataSimulacion(
            new ArrayDataProvider(JSON.parse(datas), { keyAttributes: "plazo" })
          );
          document.getElementById("modalsimulador").open();
        } else {
          console.error(datas + "ERRRRRRROR");
        }
      };
      xhr.send(json);
    }

    function getGraficasCompararService(
      plazoParam,
      importeParam,
      tipoinversionParam
    ) {
      var urlAccess = "graficas/simulacion";

      var request = new XMLHttpRequest();
      var respuesta;
      var urlEncodedData = "";
      var urlEncodedDataPairs = [];
      var stepcero = JSON.stringify({
        importe: importeParam,
        tiposInversion: tipoinversionParam,
        plazo: plazoParam
      });

      urlEncodedDataPairs.push(
        encodeURIComponent("datosRecuperados") +
          "=" +
          encodeURIComponent(stepcero)
      );

      urlEncodedData = urlEncodedDataPairs.join("&").replace(/%20/g, "+");

      request.open("POST", url + urlAccess);
      request.setRequestHeader(
        "Content-Type",
        "application/x-www-form-urlencoded"
      );
      request.timeout = 5000;
      request.onreadystatechange = function() {
        if (!request.status >= 200 && request.status < 300) {
          alert("Ocurrió un error en la petición");
        }
      };

      request.ontimeout = function(e) {
        alert("Se agotó el tiempo de espera, intentelo más tarde");
      };

      request.onload = function() {
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

    //table tipos de inversion

    console.error(this.arraytipos);
    this.dataprovider = new ArrayDataProvider(this.arraytipos, {
      keyAttributes: "id_tipo_inversion"
    });

    this.columnArray = [
      {
        headerTemplate: "headerCheckTemplate",
        headerText: "Select All",
        template: "checkTemplate",
        sortable: "disabled"
      },
      {
        headerText: "No. tipo de inversión ",
        field: "id_tipo_inversion",
        id: "id_tipo_inversion"
      },
      {
        headerText: "Tipo de inversión",
        field: "tipo_inversion",
        id: "tipo_inversion"
      },
      {
        headerText: "Tasa de retorno (%)",
        field: "tasa_retorno",
        id: "tasa_retorno"
      }
    ];

    this.selectedItems = new keySet.ObservableKeySet();
    this.headerCheckStatus = ko.observable();

    // get checkbox selected value based on selectedItems and selectAll state
    this.handleCheckbox = function(id) {
      var isChecked = this.selectedItems().has(id);
      return isChecked ? ["checked"] : [];
    }.bind(this);

    this.checkboxListener = function(event) {
      if (event.detail != null) {
        var value = event.detail.value;

        // need to convert to Number to match the DepartmentId key type
        var key = Number(event.target.dataset.rowKey);
        if (value.length > 0 && !this.selectedItems().has(key)) {
          this.selectedItems.add([key]);
        } else if (value.length === 0 && this.selectedItems().has(key)) {
          this.selectedItems.delete([key]);
        }
      }
    }.bind(this);

    this.headerCheckboxListener = function(event) {
      if (event.detail != null) {
        var value = event.detail.value;
        if (value.length > 0) {
          this.selectedItems.addAll();
        } else if (
          value.length === 0 &&
          event.detail.updatedFrom == "internal"
        ) {
          this.selectedItems.clear();
        }
      }
    }.bind(this);

    this.selectionListener = function(event) {
      var selected = event.detail.value.row;
      if (selected.isAddAll()) {
        selected.deletedValues().size > 0
          ? this.headerCheckStatus([])
          : this.headerCheckStatus(["checked"]);
      } else if (selected.values().size > 0) {
        this.headerCheckStatus([]);
      }
      this.printCurrentSelection(selected);
    }.bind(this);

    this.printCurrentSelection = function(selected) {
      var selectionTxt = "";

      if (selected.isAddAll()) {
        var iterator = selected.deletedValues();
        iterator.forEach(function(key) {
          selectionTxt =
            selectionTxt.length === 0 ? key : selectionTxt + ", " + key;
        });

        if (iterator.size > 0) {
          selectionTxt = " except " + selectionTxt;
        }
        selectionTxt = "Everything selected" + selectionTxt;
      } else {
        selected.values().forEach(function(key) {
          selectionTxt =
            selectionTxt.length === 0 ? key : selectionTxt + "," + key;
        });
      }

      tipoinversionSeleccionados = selectionTxt + "";
      console.log(tipoinversionSeleccionados);
    };
  
      
    

    self.connected = function() {
      // Implement if needed
    };

    /**
     * Optional ViewModel method invoked after the View is disconnected from the DOM.
     */
    self.disconnected = function() {
      // Implement if needed
    };

    /**
     * Optional ViewModel method invoked after transition to the new View is complete.
     * That includes any possible animation between the old and the new View.
     */
    self.transitionCompleted = function() {
      // Implement if needed
    };
  }

  /*
   * Returns a constructor for the ViewModel so that the ViewModel is constructed
   * each time the view is displayed.  Return an instance of the ViewModel if
   * only one instance of the ViewModel is needed.
   */
  return new SimuinViewModel();
});
