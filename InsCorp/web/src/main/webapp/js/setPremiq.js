/**
 * Created by AcerPC on 30.12.2017 г..
 */
function setGOPremiq() {
    var premiq   = document.getElementById("vehicleInsValue").value;
    var otstapki = document.getElementById("insOtstapki").value;
    var nadbavki = document.getElementById("insNadbavki").value;

    if(nadbavki == null || nadbavki == "") {
        document.getElementById("insNadbavki").value = 0;
        document.getElementById("value").value = (parseFloat(premiq)-parseFloat(otstapki)+parseFloat(nadbavki));
    }
    if(otstapki == null || otstapki == "") {
        document.getElementById("insOtstapki").value = 0;
        document.getElementById("value").value = (parseFloat(premiq)-parseFloat(otstapki)+parseFloat(nadbavki));
    }

    console.log(premiq + " " + otstapki + " " + nadbavki );
    console.log((parseFloat(premiq)-parseFloat(otstapki)+parseFloat(nadbavki)));
    document.getElementById("value").value = (parseFloat(premiq)-parseFloat(otstapki)+parseFloat(nadbavki));
}

function setKaskoPremiq() {
    var vehicleValue = document.getElementById("vehicleValue").value;
    var vehicleInsValue = document.getElementById("vehicleInsValue").value/100;
    var otstapki = document.getElementById("insOtstapki").value;
    var nadbavki = document.getElementById("insNadbavki").value;

    if(vehicleValue == null || vehicleValue == ""){
        document.getElementById("vehicleValue").value = 0;
        document.getElementById("value").value = parseFloat(vehicleValue)*parseFloat(vehicleInsValue);
    }
}