$(document).ready(function(){

	$.validator.addMethod(
		"birthDateValidator",
		function(val, element) {
			var todaysDate = new Date();
			var bDate = new Date(val.trim());
			if(bDate.setHours(0,0,0,0) > todaysDate.setHours(0,0,0,0))
				return false;
			else
				return true;
		});

	$.validator.addMethod(
		"fieldFormatter",
		function(val, element, format) {
			var regValidator = new RegExp(format);
			return this.optional(element) || val.match(regValidator);
		});


	$(function(){
		$("form[name='register']").validate({

			errorClass: "hidden-div",
			errorElement: 'div',

			rules:{
				birthDate:{required: true, birthDateValidator:true},
				fName:{required: true, fieldFormatter:/^[A-Za-z]*$/},
				lName:{required: true, fieldFormatter:/^[A-Za-z]*$/},
				email:{required: true, fieldFormatter: /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$/},
				phNumber:{required: true, fieldFormatter: /^\d{3}-\d{3}-\d{4}$/},
				address:{required: true},
				sex:{required: true},
				position:{ required:true},
				pass:{required:true, fieldFormatter: /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{5,12}$/},
				cPass:{required:true, fieldFormatter: /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{5,12}$/,  equalTo:'#pass'}
			},
			messages:{

				birthDate:{required:"this field is mandatory", birthDateValidator:"Enter a valid date"},
				fName:{required:"this field is mandatory", fieldFormatter:"Enter a valid firstName"},
				lName:{required: "this field is mandatory", fieldFormatter:"Enter a valid last Name"},
				email:{required: "this field is mandatory", fieldFormatter:"Enter a valid email address"},
				phNumber:{required:"this field is mandatory", fieldFormatter:"Enter a valid phone number"},
				address:{required:"this field is mandatory"},
				sex:{required:"select your gender"},
				position:{ required:"Select a position to apply."},
				pass:{required:"this field is mandatory", fieldFormatter:"enter password between 5-12 , atleast one uppercase, atleast one lowercase" },
				cPass:{required:"this field is mandatory", fieldFormatter:"enter password between 5-12 , atleast one uppercase, atleast one lowercase"}

			},
			errorPlacement : function(error,element) {
 				if ( element.is(":radio") ) 
 						error.insertAfter($('input[name=sex]:last'));
 	 				

 				else
 					error.insertAfter( element );
 			},

 			submitHandler: function(form) {
 				alert('Registration Form submitted successfully.')
 				form.submit();
 			}

		});
	});
});