function selecDoctor(){
    let medicos = document.getElementById('medico');
    let medico = medicos.value;
     
    document.getElementById('no').innerText = `${medico}`;
}

