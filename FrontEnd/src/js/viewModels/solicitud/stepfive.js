define(['knockout', 'ojs/ojbootstrap', 'ojs/ojmodule-element-utils', 'ojs/ojmodule-element', 'ojs/ojbutton',
   'ojs/ojformlayout', 'ojs/ojdialog'],
   function (ko, Bootstrap, ModuleElementUtils) {
      function SimpleModuleModel() {
         ModuleElementUtils = ModuleElementUtils;
         var hasSignature = false;
         var signaturePad = null;         

         self.limpiarFirma = function () {
            hasSignature = false;
            signaturePad.clear();
         };
         self.guardarFirmaYFinaliza = function (event) {
            if (hasSignature) {
               const dataURL = signaturePad.toDataURL('image/png');
               const data = atob(dataURL.substring('data:image/png;base64,'.length)), asArray
                  = new Uint8Array(data.length);
               for (var i = 0, len = data.length; i < len; ++i) {
                  asArray[i] = data.charCodeAt(i);
               }
               const blob = new Blob([asArray], { type: 'image/png' });
               subirFirmaWS(blob);
            } else {
               alert("Es necesario que introduzcas tu firma digitalizada...");
            }

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