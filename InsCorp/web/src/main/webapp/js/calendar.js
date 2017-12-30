/**
 * Created by AcerPC on 29.12.2017 г..
 */
$(function() {
    $( "#datepicker1" ).datepicker({
        dateFormat: "dd-mm-yy",
        onSelect: function(datetext){
            $(this).val(datetext);}
    });
});

$(function() {
    $( "#datepicker2" ).datepicker({
        dateFormat: "dd-mm-yy",
        onSelect: function(datetext){
            $(this).val(datetext);}
    });
});
