$(document).on('click', '#idEditar', function() {
	let cod, nom, estado;
	cod = $(this).parents("tr").find("td")[0].innerHTML;
	nom = $(this).parents("tr").find("td")[1].innerHTML;
	estado = $(this).parents("tr").find("td")[2].innerHTML;

	$("#idrol").val(cod);
	$("#idNombre").val(nom);
	$("#idEstado").val(estado);
});



$(document).on('click', '#idelimi', function() {
	let cod;
	cod = $(this).parents("tr").find("td")[0].innerHTML;

	$("#idcodigo").val(cod);
});

$(document).on("click", "#idclose", function() {
	//limpiar controles del formulario
	$('#idRegistrar').trigger("reset");
	//resetear validaciones
	$('#idRegistrar').data("bootstrapValidator").resetForm(true);
	$("#idrol").val('0');

});


$(document).on("click", ".close", function() {
	//limpiar controles del formulario
	$('#idRegistrar').trigger("reset");
	//resetear validaciones
	$('#idRegistrar').data("bootstrapValidator").resetForm(true);
	$("#idrol").val('0');

});


$(document).on("click", "#idelimi", function(){
	const swalWithBootstrapButtons = Swal.mixin({
		customClass: {
			confirmButton: 'btn btn-success',
			cancelButton: 'btn btn-danger'
		},
		buttonsStyling: false
	})

	swalWithBootstrapButtons.fire({
		title: 'Seguro de eliminar?',
		text: "no hay opcion, despues de eliminar!",
		icon: 'warning',
		showCancelButton: true,
		confirmButtonText: 'Eliminar!',
		cancelButtonText: 'Cancel!',
		reverseButtons: true,
		 timer: 5000
	}).then((result) => {
		if (result.isConfirmed) {
			$("#idEliminar").submit();
			swalWithBootstrapButtons.fire(
				'Deleted!',
				'Tu archivo a sido eliminado.',
				'success'
			)
		} else if (
			/* Read more about handling dismissals below */
			result.dismiss === Swal.DismissReason.cancel
		) {
			swalWithBootstrapButtons.fire(
				'Cancelo la accion.',
				'Tu archivo imaginario esta seguro :)',
				'error'
			)
		}
	});
});
