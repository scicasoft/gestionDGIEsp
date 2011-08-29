$(document).ready(function(){

    $(".form_blog textarea, .form_blog input[type=text], .form_blog input[type=password]").css("width","100%").addClass("champ");

    $(".form_blog_1 textarea, .form_blog_1 input[type=text], .form_blog_1 input[type=password]").css("width","100%").addClass("champ");

    $(".groupe_bouton").children().addClass("bouton");

    $(".bouton").button();

    $(".tableau").attr("cellpadding", "3px").attr("cellspacing", "1px");

    $(".tableau tr").addClass("tableau_ligne");

    $("[type_bouton=recherche]").button({
        icons: {
            primary: 'ui-icon-gear'
        }
    });

    $("[type_bouton=config]").button({
        icons: {
            primary: 'ui-icon-gear'
        }
    });

    $("[time]").timepicker({});

    $("[date]").datepicker({
        changeMonth: true,
        changeYear: true,
        yearRange:"1970:2000",
        dateFormat: 'yy-mm-dd',
        currentText: 'Now',
        dayNamesMin: ['Di', 'Lu', 'Ma', 'Me', 'Je', 'Ve', 'Sa'],
        dayNamesShort: ['Dim', 'Lun', 'Mar', 'Mer', 'Jeu', 'Ven', 'Sam'],
        firstDay: 1,
        gotoCurrent: true
    });

    $(".fenetre_formulaire").dialog({
        width: "500px",
        autoOpen: false,
        modal: true,
        draggable: false,
        resizable: false,
        show: 'explode',
        hide: 'explode',
        buttons: {
            'Envoyer': function() {
                $("#"+$(this).attr("id")).submit();
                $(this).dialog('close');
            },
            'Annuler' : function() {
                $(this).dialog('close');
            }
        }
    });

    $(".lien_fenetre").click(function(){
        $("#"+$(this).attr("fenetre")).dialog('open');
        return false;
    });

});

//ROUNDIES
//universel.css
DD_roundies.addRule('#tete', '0 0 10px 0', true);
DD_roundies.addRule('#page', '0 0 10px 10px', true);
DD_roundies.addRule('#menu li a', '0 0 10px 10px', true);
DD_roundies.addRule('.bouton', '3px', true);

//style.css
DD_roundies.addRule('.ms, #partie3', '10px', true);
DD_roundies.addRule('#post_contenu', '5px', true);
DD_roundies.addRule('.post', '5px', true);
DD_roundies.addRule('.ms_titre', '10px 10px 0px 0px', true);

//formulaire.css
DD_roundies.addRule('#form_blog', '5px', true);
DD_roundies.addRule('.champ', '5px', true);