const showModalDeletar = function(id){
    $('#modalDeletar').modal('show')
    $('#id_deletar').val(id)
}

const deletar = function(path){
    let id = $('#id_deletar').val()
    if (id !== 0){
        window.location.href='/' + path + '/delete/' + id    
    }
}

const showEdit = function(id,path){
    if (id !== 0){
        window.location.href='/' + path + '/edit/' + id    
    }
}

const showView = function(id,path){
    if (id !== 0){
        window.location.href='/' + path + '/view/' + id    
    }
}



const senhaIgual = function(){
    let senha1 = document.getElementById("senha1")
    let senha2 = document.getElementById("senha2")

    if (senha1.value === senha2.value){

        $("#alertSenha").fadeOut();
        $('#btnSalvar').prop('disabled', false);

    }else{
        
        $("#alertSenha").fadeIn();
        $('#btnSalvar').prop('disabled', true);
    }

}