/**
 * @license
 * Copyright (c) 2014, 2019, Oracle and/or its affiliates.
 * The Universal Permissive License (UPL), Version 1.0
 */
/*
 * Your application specific code will go here
 */
define(['knockout', 'ojs/ojmodule-element-utils', 'ojs/ojknockouttemplateutils', 'ojs/ojrouter', 'ojs/ojarraydataprovider', 'ojs/ojresponsiveutils', 'ojs/ojresponsiveknockoututils', 'ojs/ojarraydataprovider',
  'ojs/ojoffcanvas', 'ojs/ojmodule-element', 'ojs/ojknockout'],
  function (ko, moduleUtils, KnockoutTemplateUtils, Router, ArrayDataProvider, ResponsiveUtils, ResponsiveKnockoutUtils, ArrayDataProvider, OffcanvasUtils) {
    function ControllerViewModel() {
      
      var self = this;

      currentModule = ko.observable('stepfour');
      currentStep = ko.observable('stp1');

      idstepzeroapp = ko.observable();
      idsteponeapp = ko.observable();
      alltiposinversion = ko.observable([{}]);

      this.KnockoutTemplateUtils = KnockoutTemplateUtils;

      // Media queries for repsonsive layouts
      var smQuery = ResponsiveUtils.getFrameworkQuery(ResponsiveUtils.FRAMEWORK_QUERY_KEY.SM_ONLY);
      self.smScreen = ResponsiveKnockoutUtils.createMediaQueryObservable(smQuery);
      var mdQuery = ResponsiveUtils.getFrameworkQuery(ResponsiveUtils.FRAMEWORK_QUERY_KEY.MD_UP);
      self.mdScreen = ResponsiveKnockoutUtils.createMediaQueryObservable(mdQuery);

      // Router setup
      router = Router.rootInstance;
      router.configure({
        'inicio': { label: 'Inicio', isDefault: true },
        'simuin': { label: 'Simulador de Inversiones' },
        'soliin': { label: 'Solicitud De Inversiones' },
        'info': { label: 'Acerca De ProInvest' }
      });
      Router.defaults['urlAdapter'] = new Router.urlParamAdapter();

      moduleConfig = ko.observable({ 'view': [], 'viewModel': null });

      self.loadModule = function () {
        ko.computed(function () {
          var name = router.moduleConfig.name();
          var viewPath = 'views/' + name + '.html';
          var modelPath = 'viewModels/' + name;
          var masterPromise = Promise.all([
            moduleUtils.createView({ 'viewPath': viewPath }),
            moduleUtils.createViewModel({ 'viewModelPath': modelPath })
          ]);
          masterPromise.then(
            function (values) {
              moduleConfig({ 'view': values[0], 'viewModel': values[1] });
            }
          );
        });
      };

      // Navigation setup
      var navData = [
        {
          name: 'Inicio', id: 'inicio',
          iconClass: 'oj-navigationlist-item-icon demo-icon-font-24 demo-home-icon-24'
        },
        {
          name: 'Simulador de Inversiones', id: 'simuin',
          iconClass: 'oj-navigationlist-item-icon demo-icon-font-24 demo-chart-icon-24'
        },
        {
          name: 'Solicitud De Inversiones', id: 'soliin',
          iconClass: 'oj-navigationlist-item-icon demo-icon-font-24 demo-people-icon-24'
        },
        {
          name: 'Acerca De ProInvest', id: 'info',
          iconClass: 'oj-navigationlist-item-icon demo-icon-font-24 demo-info-icon-24'
        }
      ];
      self.navDataProvider = new ArrayDataProvider(navData, { keyAttributes: 'id' });

      // Drawer
      // Close offcanvas on medium and larger screens
      self.mdScreen.subscribe(function () { OffcanvasUtils.close(self.drawerParams); });
      self.drawerParams = {
        displayMode: 'push',
        selector: '#navDrawer',
        content: '#pageContent'
      };
      // Called by navigation drawer toggle button and after selection of nav drawer item
      self.toggleDrawer = function () {
        return OffcanvasUtils.toggle(self.drawerParams);
      }
      // Add a close listener so we can move focus back to the toggle button when the drawer closes
      document.getElementById('navDrawer').addEventListener("ojclose", document.getElementById('drawerToggleButton').focus());

      // Header
      // Application Name used in Branding Area
      self.appName = ko.observable("App Name");
      // User Info used in Global Navigation area
      self.userLogin = ko.observable("john.hancock@oracle.com");
    }

    return new ControllerViewModel();
  }
);
