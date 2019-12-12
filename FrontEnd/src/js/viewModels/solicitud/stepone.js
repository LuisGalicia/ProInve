define(['knockout', 'ojs/ojbootstrap', 'ojs/ojmodule-element-utils', 'ojs/ojmodule-element', 'ojs/ojbutton',
   'ojs/ojformlayout'],
   function (ko, Bootstrap, ModuleElementUtils) {

      function SimpleModuleModel() {
         ModuleElementUtils = ModuleElementUtils;

         self.nextStep = function(){
            var nombre = $("#inputnombre").val();
            var apellidopa = $("#inputapellidopa").val();
            var apellidoma = $("#inputapellidoma").val();
            var rfc = $("#inputrfc").val();
            var fecha = $("#datepicker").val();
            var profesion = $("#inputprofesion").val();
            var empresa = $("#inputnombreemperesa").val();
            var correo = $("#inputcorreo").val();
            var telefono = $("#inputtelefono").val();
            stepOne(nombre, apellidopa, apellidoma, rfc, fecha, profesion, empresa, correo, telefono, idstepzeroapp());
            
         };

      }
      return new SimpleModuleModel();
   }
);