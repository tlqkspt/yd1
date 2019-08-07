function formSubmit(n) {
	var form = document.frm;
	//form.id.value = n;

	//out.print(form.id.value);
	 if (confirm("정말 수정하시겠습니까??") == true){    //확인
		 
		 form.submit();

	 } else{   //취소

	     return false;

	 }
	
}