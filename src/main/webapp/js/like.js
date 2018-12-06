function like(perfil, iniciativa,e){
				//alert(#{!operacionIBean.votado(perfil,iniciativa)});
				//let heart=e.children[0];
				if('#{operacionIBean.votado(perfil,iniciativa)}'){
					e.style.color='red';
				}
				else{
					e.children[0].style.backGrcolor='blue';
				}
}
