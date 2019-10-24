define( ['knockout', 'ojs/ojbootstrap', 'ojs/ojmodule-element-utils', 'ojs/ojmodule-element','ojs/ojbutton'],
   function(ko, Bootstrap, ModuleElementUtils)
   {
      function SimpleModuleModel() {
         this.currentModule = ko.observable("stepfour");
         this.ModuleElementUtils = ModuleElementUtils;
       }
       Bootstrap.whenDocumentReady().then(function () {
         ko.applyBindings(new SimpleModuleModel(), document.getElementById('modulesteps'));
       });
   }
);