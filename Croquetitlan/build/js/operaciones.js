var valor1;
var valor2;
var STATE_INIT=0;
var STATE_CAPTURE=2;
var STATE_OPERATOR=3;
var STATE_CALCULATE=4;

var OPERATION_CLEAN = 0;
var OPERATION_NUMBER=1;
var OPERATION_OPERATOR =2;
var OPERATION_EQUAL = 3;

var OPERATION_MUL = 0;
var OPERATION_DIV=1;
var OPERATION_SUMA =2;
var OPERATION_RESTA = 3;
var OPERATION_PORCENTAJE=4;

var estado;
var operador;
$(function(){
    estado = STATE_INIT;
    $("#btnAC").on("click",Clean);
    $("#btn0").on("click",Capturando);
    $("#btn1").on("click",Capturando);
    $("#btn2").on("click",Capturando);
    $("#btn3").on("click",Capturando);
    $("#btn4").on("click",Capturando);
    $("#btn5").on("click",Capturando);
    $("#btn6").on("click",Capturando);
    $("#btn7").on("click",Capturando);
    $("#btn8").on("click",Capturando);
    $("#btn9").on("click",Capturando);
    $("#btnpunto").on("click",Capturando);
    $("#btndiv").on("click",Operador);
    $("#btnporc").on("click",Operador);
    $("#btnmas").on("click",Operador);
    $("#btnmen").on("click",Operador);
    $("#btnpor").on("click",Operador);
    $("#btnigual").on("click",Solicitarresultado);
  
})
function Limpiardisplay(){
    $("#txtdisplay").val("");
   
}
function Actualizardisplay(valor){
    if(estado==STATE_CAPTURE || estado==STATE_INIT){
        if($.isNumeric($("#txtdisplay").val()+valor)){
        $("#txtdisplay").val($("#txtdisplay").val()+valor);
    }
        
    }else if(estado==STATE_OPERATOR){
        valor1=$("#txtdisplay").val();
        Limpiardisplay();
        $("#txtdisplay").val(valor);
    }else if(estado==STATE_CALCULATE){
        valor2=$("#txtdisplay").val();
        var resultado = Calcular(operador,valor1,valor2);
        $("#txtdisplay").val(resultado);
    }
   
}
function Capturando(){
    
    Actualizardisplay($(this).val());
    Actualizarestado(OPERATION_NUMBER);
}
function Actualizarestado(operacion){
    if(operacion==OPERATION_CLEAN){
        estado=STATE_INIT;
    }else if(estado==STATE_INIT && operacion==OPERATION_NUMBER || estado==STATE_OPERATOR && operacion==OPERATION_NUMBER){
        estado=STATE_CAPTURE;
    }else if(estado==STATE_CAPTURE && operacion==OPERATION_OPERATOR || estado==STATE_CALCULATE && operacion==OPERATION_OPERATOR){
        estado=STATE_OPERATOR;
    }else if (estado==STATE_CAPTURE && operacion==OPERATION_EQUAL){
        estado =STATE_CALCULATE;  
    }
}
function Operador(){
    Actualizarestado(OPERATION_OPERATOR);
    if($(this).val()=="*"){
        operador=OPERATION_MUL;
    }else if($(this).val()=="+"){
        operador=OPERATION_SUMA; 
    }else if($(this).val()=="-"){
        operador=OPERATION_RESTA;
    }
    else if($(this).val()=="/"){
        operador=OPERATION_DIV;
    }else if($(this).val()=="%"){
        operador=OPERATION_PORCENTAJE;
    }
    
}
function Clean(){
    Limpiardisplay();
    Actualizarestado(OPERATION_CLEAN);
}
function Solicitarresultado(){
    Actualizarestado(OPERATION_EQUAL); 
    Actualizardisplay();
}
function Calcular(operador,valor1,valor2){
    var resultado;
    
    valor1 = parseFloat(valor1);
    valor2 = parseFloat(valor2);
    if(operador == OPERATION_MUL ){
       resultado = valor1 * valor2;
    }else if(operador == OPERATION_SUMA){
         resultado = valor1 + valor2;
    }else if(operador == OPERATION_RESTA){
         resultado = valor1 - valor2;
    }else if(operador == OPERATION_DIV){
         resultado = valor1 / valor2;
    }else if(operador == OPERATION_PORCENTAJE){
         resultado = valor1 * valor2/100;
    }
    return resultado;
    
}