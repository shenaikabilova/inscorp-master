/**
 * Created by AcerPC on 13.12.2017 г..
 */
function isValidRegNumber() {
    var str = document.getElementById("registrationNumber").value;
    var reg = /^(Е|А|В|ВТ|ВН|ВР|ЕВ|ТХ|К|КН|ОВ|М|РА|РК|ЕН|РВ|РР|Р|СС|СН|СМ|СО|С|СА|СВ|СТ|Т|Х|Н|У)[1-9]{4}[А-Я]{1,2}$/;
    var result = reg.test(str);
    if(!result) {
        alert("Грешен регистрационен номер!");
    }
}

function validateEmail() {
    var email = document.getElementById("e-mail").value;
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if(!re.test(email)) {
        alert("Невалиден е-майл адрес!");
    }
}

function isValidateEGN() {
    var egn = document.getElementById("EGN").value;

    var weights = [ 2, 4, 8, 5, 10, 9, 7, 3, 6 ];

    var year = egn.substring(0,2);
    var month = egn.substring(2,4);
    var day = egn.substring(4, 6);
    var checkSum  = 0;

    if(egn.length != 10) {
        alert("Полето за ЕГН трябва да съдържа 10 числа!");
    }

    if(year < 0 || year > 99) {
        alert("Очаква се година между 00...99!");
    }
    if(month > 20 && month < 40) {
        month -= 20;
    } else if(month > 40) {
        month -=40;
    }
    if (month < 1 || month > 12) {
        alert("Месецът трябва да бъде между 1...12!");
    }
    if(day < 1 || day > 31) {
        alert("Датата трябва да бъде между 1...31!");
    }

    for(var i = 0; i < egn.length - 1; i++) {
        checkSum += (egn.charAt(i) - '0')*weights[i];
    }
    checkSum %= 11;
    if(checkSum != (egn.charAt(9) - '0')) {
        alert("Невалидна контролна сума!");
    }
}