function like(perfil, iniciativa){
				var vote = document.getElementsByClassName("voto");
				alert("HOLA MUNDO");
				//alert(#{!operacionIBean.votado(perfil,iniciativa)});
				if("#{!operacionIBean.votado(perfil,iniciativa)}"){
					vote.style.color='gray';
				}
				else{
					vote.style.color='red';
				}
				"#(operacionIBean.votar(perfil,iniciativa))"
}