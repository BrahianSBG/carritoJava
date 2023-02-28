$(document).ready(function (){
    $("tr #btnDelete").click(function (){
        var idp=$(this).parent().find("#idp").val();
        swal({
            tittle: "¿Estás seguro de eliminar?",
            text: "Once deleted",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        })
                .then((willDelete) => {
                    eliminar(idp);
                    if (willDelete) {
                        swal("Poof! ...", {
                            icon: "success",
                        }).then((willDelete)=>{
                            if (willDelete) {
                                parent.location.href="controladorP?accion=Carrito";
                            }
                        });
                    } else{
                        swal("");
                    }
        });
    }); 
    function eliminar(idp){
        var url="controladorP?accion=Eliminar";
        $aja({
            type: 'POST',
            url: url,
            data: "idp="+idp,
            success: function (data, textStatus, jqXHR) {  
            }
        })
    }
    
    $("tr #Cantidad").click(function() {
        var idp=$(this).parent().find("#idpro").val();
        var cantidad=$(this).parent().find("#Cantidad").val();
        var url="controladorP?accion=ActualizarCantidad";
        $.ajax({
            type:'POST',
            url: url,
            data: "idp="+idp+"&Cantidad="+cantidad,
            success: function (data, textStatus, jqXHR){
                location.href="controladorP?accion=Carrito";
            }
        });
    });
});

