define( ['knockout', 'ojs/ojbootstrap', 'ojs/ojmodule-element-utils', 'ojs/ojmodule-element', 'ojs/ojbutton',
'ojs/ojformlayout', 'ojs/ojselectcombobox'],
   function(ko, Bootstrap, ModuleElementUtils)
   {
      function SimpleModuleModel() {
         ModuleElementUtils = ModuleElementUtils;

         self.nextStep = function(){
            currentModule('stepfive');
            currentStep('stp5');
         };
      }
      return new SimpleModuleModel();
   }
);