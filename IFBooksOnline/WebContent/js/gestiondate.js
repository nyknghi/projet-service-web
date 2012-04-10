$(document).ready(function() {
    jQuery(function($){
        $.datepicker.regional['fr'] = {
            clearText: 'Effacer',
            clearStatus: '',
            closeText: 'Fermer',
            closeStatus: 'Fermer sans modifier',
            prevText: '&lt;Préc',
            prevStatus: 'Voir le mois précédent',
            nextText: 'Suiv&gt;',
            nextStatus: 'Voir le mois suivant',
            currentText: 'Courant',
            currentStatus: 'Voir le mois courant',
            monthNames: ['janvier','février','mars','avril','mai','juin',
            'juillet','août','septembre','octobre','novembre','décembre'],
            monthNamesShort: ['Jan','Fév','Mar','Avr','Mai','Jun',
            'Jul','Aoû','Sep','Oct','Nov','Déc'],
            monthStatus: 'Voir un autre mois',
            yearStatus: 'Voir un autre année',
            weekHeader: 'Sm',
            weekStatus: '',
            dayNames: ['Dimanche','Lundi','Mardi','Mercredi','Jeudi','Vendredi','Samedi'],
            dayNamesShort: ['Dim','Lun','Mar','Mer','Jeu','Ven','Sam'],
            dayNamesMin: ['Di','Lu','Ma','Me','Je','Ve','Sa'],
            dayStatus: 'Utiliser DD comme premier jour de la semaine',
            dateStatus: 'Choisir le DD, MM d',
            dateFormat: 'dd/mm/yy',
            firstDay: 0,
            initStatus: 'Choisir la date',
            isRTL: false
        };
        $.datepicker.setDefaults($.datepicker.regional['fr']);
    });
    jQuery.datepicker.setDefaults(jQuery.datepicker.regional['fr']);
    
    $("#datepickerd").datepicker({
        dateFormat:'dd/mm/yy'
    });
    $('#dateFinCampagne').datepicker({
        dateFormat:'dd/mm/yy'
    });
    //$.datepicker.setDefaults($.datepicker.regional['']);
    $("#datepickerd").datepicker($.datepicker.regional['fr']);
         
    $("#locale").change(function() {
        $('#datepickerd').datepicker('option', $.datepicker.regional[$(this).val()]);
    });
    $("#anim").change(function() {
        $('#datepickerd').datepicker('option', {
            showAnim: $(this).val()
        });
    });

    $("#datepickerf").datepicker({
        dateFormat:'dd/mm/yy'
    });
    $("#datepickerf").datepicker($.datepicker.regional['fr']);
    $("#locale").change(function() {
        $('#datepicker').datepicker('option', $.datepicker.regional[$(this).val()]);
    });
    $(".dateEnvoyer" ).button({
        icons: {
            primary:'ui-icon-gear'
        }
    });
    $(".weekEnvoyer" ).button({
        icons: {
            primary:'ui-icon-gear'
        }
    });
    $(".monthEnvoyer" ).button({
        icons: {
            primary:'ui-icon-gear'
        }
    });
    $(".lastMonthEnvoyer" ).button({
        icons: {
            primary:'ui-icon-gear'
        }
    });
});