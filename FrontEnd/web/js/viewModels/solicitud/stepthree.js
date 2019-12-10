define( ['knockout', 'ojs/ojbootstrap', 'ojs/ojmodule-element-utils', 'ojs/ojmodule-element', 'ojs/ojbutton',
'ojs/ojformlayout', 'ojs/ojselectcombobox'],
   function(ko, Bootstrap, ModuleElementUtils)
   {
      function SimpleModuleModel() {
         ModuleElementUtils = ModuleElementUtils;


         this.sendstepthree = function (event) {
            var calle = $("#inputcalle").val();
            var numerocalle = $("#inputcallenumero").val();
            var codigopostal = $("#codigoPostal").val();

            stepthree(calle, numerocalle, codigopostal, idsteponeapp);
            
         }

         self.nextStep = function(){
            currentModule('stepfour');
            currentStep('stp4');
         };
      }
      return new SimpleModuleModel();
   }
);