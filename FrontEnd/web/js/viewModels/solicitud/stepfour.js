define( ['knockout', 'ojs/ojbootstrap', 'ojs/ojmodule-element-utils', 'ojs/ojmodule-element', 'ojs/ojbutton',
'ojs/ojformlayout', 'ojs/ojselectcombobox', "ojs/ojinputnumber"],
   function(ko, Bootstrap, ModuleElementUtils)
   {
      function SimpleModuleModel() {
         ModuleElementUtils = ModuleElementUtils;

         self.nextStep = function(){

            var cuenta = $("#inputcuenta").val();
            var clabe = $("#inputclabe").val();

            stepfour(cuenta, clabe, idsteponeapp()); 
         };
      }
      return new SimpleModuleModel();
   }
);