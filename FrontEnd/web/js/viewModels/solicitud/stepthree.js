define( ['knockout', 'ojs/ojbootstrap', 'ojs/ojmodule-element-utils', 'ojs/ojmodule-element', 'ojs/ojbutton',
'ojs/ojformlayout', 'ojs/ojselectcombobox'],
   function(ko, Bootstrap, ModuleElementUtils)
   {
      function SimpleModuleModel() {
         ModuleElementUtils = ModuleElementUtils;

         self.nextStep = function(){

            var calle = $("#inputcalle").val();
            var numerocalle = $("#inputcallenumero").val();
            var codigopostal = $("#codigoPostal").val();

            stepthree(calle, numerocalle, codigopostal, idsteponeapp());
         };
      }
      return new SimpleModuleModel();
   }
);