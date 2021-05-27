document.addEventListener('DOMContentLoaded', () => {
    let password = document.getElementById('password');
    let confirm = document.getElementById('confirm');
    let email = document.getElementById('email');

    let PASSWORD_PATTERN = /(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%]).{8,}/;
    let EMAIL_PATTERN = /(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-z0-9-.]+$)/;

    email.addEventListener('input', () => {
        validate(email, password, confirm);
    });

    password.addEventListener('input', () => {
        validate(email, password, confirm);
    });

    confirm.addEventListener('input', () => {
        validate(email, password, confirm);
    });

    function validate(email, password, confirm) {
        if (EMAIL_PATTERN.test(email.value) && PASSWORD_PATTERN.test(password.value) && password.value === confirm.value) {
            confirm.style.borderColor = 'blue';
            document.getElementById('sign-up-btn').disabled = false;
        }
        else {
            confirm.style.borderColor = 'red';
            document.getElementById('sign-up-btn').disabled = true;
        }
    }
})