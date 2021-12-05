
    function obtenerArea(){
        var areaResultado = document.getElementById("areaResultado");
        var b = parseInt(document.getElementById("base").value);
        var h = parseInt(document.getElementById("altura").value);

        var area = (b * h) / 2;

        areaResultado.innerHTML = "" + area;
    }

    function obtenerPerimetro(){
        var perimetroResultado = document.getElementById("perimetroResultado");
        var l1 = parseInt(document.getElementById("lado 1").value);
        var l2 = parseInt(document.getElementById("lado 2").value);
        var l3 = parseInt(document.getElementById("lado 3").value);
        var perimetro = (l1 + l2 + l3 ) ;

        perimetroResultado.innerHTML = "" + perimetro;
    }

    function obtenerAreacu(){
        var areaResultadocu = document.getElementById("areaResultadocu");
        var x = parseInt(document.getElementById("lado x").value);
        var Area= (x * x) ;

        areaResultadocu.innerHTML = "" + Area;
    }

    function obtenerPerimetrocu(){
        var perimetrocuResultado = document.getElementById("perimetrocuResultado");
        var l4 = parseInt(document.getElementById("lado 4").value);
        var perimetro = (l4 * 4) ;

        perimetrocuResultado.innerHTML = "" + perimetro;
    }

    function obtenerAreacir(){
        var areacirResultado = document.getElementById("areacirResultado");
        var l8 = parseInt(document. getElementById("lado 8").value);
        var area = ( 3.1416 * (l8)**2);

        areacirResultado.innerText = "" + area;
    }

    function obtenerPerimetrocir(){
        var perimetrocirResultado = document.getElementById("perimetrocirResultado");
        var l9 = parseInt(document. getElementById("lado 9").value);
        var perimetro = ( 2 * 3.1416 * l9 );

        perimetrocirResultado.innerText = "" + perimetro;
    }

    function obtenerVolumenpi(){
        var volumenpiResultado = document.getElementById("volumenpiResultado");
        var i = parseInt(document. getElementById("i").value);
        var y = parseInt(document. getElementById("y").value);
        var volumen = ((1/3) * i * y );

        volumenpiResultado.innerText = "" + volumen;
    }

    function obtenerVolumencu(){
        var volumencuResultado = document.getElementById("volumencuResultado");
        var j = parseInt(document. getElementById("j").value);
        var volumen = ((j)**3);

        volumencuResultado.innerText = "" + volumen;
    }

    function obtenerVolumenes(){
        var volumenesResultado = document.getElementById("volumenesResultado");
        var k = parseInt(document. getElementById("k").value);
        var volumen = ((4/3) * 3.1416 * (k)**3 );

        volumenesResultado.innerText = "" + volumen;
    }
