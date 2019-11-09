define(['knockout', 'ojs/ojbootstrap', 'ojs/ojmodule-element-utils', 'ojs/ojmodule-element', 'ojs/ojbutton',
   'ojs/ojformlayout'],
   function (ko, Bootstrap, ModuleElementUtils) {

      function SimpleModuleModel() {
         currentModule = ko.observable();
         ModuleElementUtils = ModuleElementUtils;
      }
      return new SimpleModuleModel();
   }
);