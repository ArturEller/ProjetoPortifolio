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