define( ['knockout', 'ojs/ojbootstrap', 'ojs/ojmodule-element-utils', 'ojs/ojmodule-element', 'ojs/ojbutton',
'ojs/ojformlayout', 'ojs/ojselectcombobox'],
   function(ko, Bootstrap, ModuleElementUtils)
   {
      function SimpleModuleModel() {
         ModuleElementUtils = ModuleElementUtils;

         this.sendstepfour = function (event) {
            var cuenta = $("#inputcuenta").val();
            var clabe = $("#inputclabe").val();

            stepfour(cuenta, clabe, idsteponeapp);
            
         }
         self.nextStep = function(){
            currentModule('stepfive');
            currentStep('stp5');
         };
      }
      return new SimpleModuleModel();
   }
);