define(['knockout', 'ojs/ojbootstrap', 'ojs/ojmodule-element-utils', 'ojs/ojmodule-element', 'ojs/ojbutton',
   'ojs/ojformlayout', 'ojs/ojdialog'],
   function (ko, Bootstrap, ModuleElementUtils) {
      function SimpleModuleModel() {
         ModuleElementUtils = ModuleElementUtils;
         var hasSignature = false;

         self.limpiarFirma = function () {
            hasSignature = false;
            signaturePad.clear();
         };
         self.guardarFirmaYFinaliza = function (event) {
            document.getElementById("modalcontrato").open();
         };      
         this.closeContra = function (event) {
            document.getElementById('modalcontrato').close();
          }
         $(document).ready(function () {
            signaturePad = new SignaturePad(document.getElementById('signature-pad'), {
               backgroundColor: 'rgba(255, 255, 255, 0)',
               penColor: 'rgb(0,0,139)',
               onEnd: function () {
                  hasSignature = true;
               }
            });
         });

         self.nextStep = function () {

         };
      }
      return new SimpleModuleModel();
   }
);