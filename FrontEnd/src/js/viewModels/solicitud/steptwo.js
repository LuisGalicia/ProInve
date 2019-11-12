define( ['knockout', 'ojs/ojbootstrap', 'ojs/ojmodule-element-utils', 'ojs/ojmodule-element', 'ojs/ojbutton',
'ojs/ojformlayout'],
   function(ko, Bootstrap, ModuleElementUtils)
   {
      function SimpleModuleModel() {
         ModuleElementUtils = ModuleElementUtils;

         self.nextStep = function(){
            currentModule('stepthree');
            currentStep('stp3');
         };
      }
      return new SimpleModuleModel();
   }
);