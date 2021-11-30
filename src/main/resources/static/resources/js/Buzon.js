$(document).ready(function() {
	$('#tablaBuzon').DataTable();



});

$(document).on('click', '#actualizar', function() {
	let cod, nom, pate, mate, correo, celu,  estado,cvnombre;

	cod = $(this).parents("tr").find("td")[0].innerHTML;
	nom = $(this).parents("tr").find("td")[1].innerHTML;
	pate = $(this).parents("tr").find("td")[2].innerHTML;
	mate = $(this).parents("tr").find("td")[3].innerHTML;
	correo = $(this).parents("tr").find("td")[4].innerHTML;
	celu = $(this).parents("tr").find("td")[5].innerHTML;
	cvnombre = $(this).parents("tr").find("td")[6].innerHTML;
	estado = $(this).parents("tr").find("td")[7].innerHTML;

	$("#idcodigo").val(cod);
	$("#idnombre").val(nom);
	$("#idpaterno").val(pate);
	$("#idmaterno").val(mate);
	$("#idcorreo").val(correo);
	$("#idcelular").val(celu);
	$("#idestado").val(estado);
	$("#nuevocv").val(cvnombre);

});


$(document).on('click', '#ideliminarSolicitante', function() {
	let cod;
	cod = $(this).parents("tr").find("td")[0].innerHTML;

	$("#idcodigoeliminar").val(cod);
});

$(document).on("click", "#ideliminarSolicitante", function(){
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









