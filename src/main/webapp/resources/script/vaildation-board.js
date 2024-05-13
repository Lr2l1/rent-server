$(document).ready(() => {

	$('form').submit(e => {
		e.preventDefault();

		const title = $('#title').val();
		const detail = $('#detail').val();
		
		let isValid = true;

		if (title === "") {
			isValid = false;
		}
		
		if (detail === "") {
			isValid = false;
		}
		if (isValid) {
			e.target.submit();
		}

	});
});