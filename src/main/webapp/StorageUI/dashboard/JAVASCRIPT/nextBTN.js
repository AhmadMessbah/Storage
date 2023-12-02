const  form = document.querySelector("form"),
    nextBTN = form.querySelector(".nextBTN"),
    backBTN = form.querySelector(".backBTN"),
    allInput = form.querySelectorAll(".first input");


nextBTN.addEventListener("click" , ()=>{
    allInput.forEach(input => {
        if (input.value != ""){
            form.classList.add('secActive');
        }else {
            form.classList.remove('secActive');
        }
    })
})
backBTN.addEventListener("click" , ()=> form.classList.remove('secActive'));