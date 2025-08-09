const loginButton = document.querySelectorAll('#root .login-btn');
const enrollButton = document.querySelectorAll('#root .enroll-btn');
const ml = document.querySelector('.model-login');
const em = document.querySelector('.model-enroll');

const lclose = document.querySelector('#l-close');
const eclose = document.querySelector('#e-close');



loginButton.forEach(lb=>{
    lb.onclick = () => {
        
        ml.classList.add('mactive');
        em.classList.remove('mactive');
    }
});

enrollButton.forEach(eb=>{
    eb.onclick = () => {
       
        em.classList.add('mactive');
        ml.classList.remove('mactive');
    }
    
});


lclose.onclick = () => {
    const ml = document.querySelector('.model-login');
    console.log(ml);
    ml.classList.add('mclose');
    ml.classList.remove('mactive');
    em.classList.remove('mactive');
}
eclose.onclick = () => {
    const me = document.querySelector('.model-enroll');
    console.log(me);
    me.classList.add('mclose');
    ml.classList.remove('mactive');
    em.classList.remove('mactive');
}















