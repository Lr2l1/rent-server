$(document).ready(() => {
	$('#password').focusout(e => {
		if ($('#password').val() === "") {
			$('#error-msg-password').show();
			$('#password').css('border', 'solid 1px tomato');
		} else {
			$('#error-msg-password').hide();
			$('#password').css('border', 'solid 1px lightgrey');
		}
	});
	$('#password-new').focusout(e => {
		if ($('#password-new').val() === "") {
			$('#error-msg-password-new').show();
			$('#password-new').css('border', 'solid 1px tomato');
		} else {
			$('#error-msg-password-new').hide();
			$('#password-new').css('border', 'solid 1px lightgrey');
		}
	});
	
	

	$('#telecom').focusout(e => {
		if ($('#telecom').val() === null) {
			$('#error-msg-telecom').show();
			$('#telecom').css('border', 'solid 1px tomato');
		} else {
			$('#error-msg-telecom').hide();
			$('#telecom').css('border', 'solid 1px lightgrey');
			$('#telecom').css('border-bottom', 'none');
		}
	});

	$('#phone').focusout(e => {
		if($('#phone').val() === "") {
			$('#error-msg-phone').show();
			$('#phone').css('border', 'solid 1px tomato');
		} else {
			$('#error-msg-phone').hide();
			$('#phone').css('border', 'solid 1px lightgrey');
		}
		
		const phone = $('#phone').val();
		
		if(phone.match(/\d{3}-\d{4}-\d{4}|\d{11}/) === null) {
			$('#error-msg-phone-pattern').show();
			$('#phone').css('border', 'solid 1px tomato');
		} else {
			if(phone.length === 11) {
				const update = `${phone.substr(0,3)}-${phone.substr(3,4)}-${phone.substr(7,4)}`;
				$('#phone').val(update);
			}
		}
	});



	$('form').submit(e => {
		e.preventDefault();

		const password = $('#password').val();
		const newPassword =$('#password-new').val(); 


		const telecom = $('#telecom').val();

		const phone = $('#phone').val();

		// 유효성 검사
		let isValid = true;

		
		if (password === "") {
			isValid = false;
			$('#error-msg-password').show();
			$('#password').css('border', 'solid 1px tomato');
		}
		if (newPassword === "") {
			isValid = false;
			$('#error-msg-password-new').show();
			$('#password-new').css('border', 'solid 1px tomato');
		}

		if (telecom === null) {
			isValid = false;
			$('#error-msg-telecom').show();
			$('#telecom').css('border', 'solid 1px tomato');
		}

		if (phone === "") {
			isValid = false;
			$('#error-msg-phone').show();
			$('#phone').css('border', 'solid 1px tomato');
		}


		if (isValid) {
			e.target.submit();
			// $('#form').submit();    -> 이렇게 쓰면 다시 이벤트로 돌아와서 무한루프에 갇힘
		}

	});
});