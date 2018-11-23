/*
Copyright (c) 2003-2011, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/
CKEDITOR.plugins.addExternal('fmath_formula', 'plugins/fmath_formula/', 'plugin.js');
CKEDITOR.editorConfig = function( config )
{


	// Define changes to default configuration here. For example:
     config.language = 'en';

     config.uiColor = '#f99f20';
     config.toolbar = 'Custom';

   //  config.extraPlugins = 'equation';

      config.extraPlugins = 'fmath_formula';

      config.toolbar_Basic =  [
            ['Bold', 'Italic', '-', 'NumberedList', 'BulletedList', '-', 'Link', 'Unlink','-','About']
        ];

        // This is actually the default value.
        config.toolbar_Full =
        [
            { name: 'document',    items : [ 'Source','-','Save','NewPage','DocProps','Preview','Print','-','Templates' ] },
            { name: 'clipboard',   items : [ 'Cut','Copy','Paste','PasteText','PasteFromWord','-','Undo','Redo' ] },
            { name: 'editing',     items : [ 'Find','Replace','-','SelectAll','-','SpellChecker', 'Scayt' ] },
            { name: 'forms',       items : [ 'Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton', 'HiddenField' ] },
            '/',
            { name: 'basicstyles', items : [ 'Bold','Italic','Underline','Strike','Subscript','Superscript','-','RemoveFormat' ] },
            { name: 'paragraph',   items : [ 'NumberedList','BulletedList','-','Outdent','Indent','-','Blockquote','CreateDiv','-','JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock','-','BidiLtr','BidiRtl' ] },
            { name: 'links',       items : [ 'Link','Unlink','Anchor' ] },
            { name: 'insert',      items : [ 'Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','fmath_formula','PageBreak' ] },//,'equation'
            '/',
            { name: 'styles',      items : [ 'Styles','Format','Font','FontSize' ] },
            { name: 'colors',      items : [ 'TextColor','BGColor' ] },
            { name: 'tools',       items : [ 'Maximize', 'ShowBlocks','-','About' ] }
        ];

         // This is actually the custom value.
        config.toolbar_Custom =
        [
            { name: 'document',    items : [ 'Source','-','NewPage','DocProps','Preview','Print','-','Templates' ] },
            { name: 'clipboard',   items : [ 'Cut','Copy','Paste','PasteText','PasteFromWord','-','Undo','Redo' ] },
            { name: 'editing',     items : [ 'Find','Replace','-','SelectAll','-','SpellChecker', 'Scayt' ] },
           // { name: 'forms',       items : [ 'Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton', 'HiddenField' ] },
            '/',
            { name: 'basicstyles', items : [ 'Bold','Italic','Underline','Strike','Subscript','Superscript','-','RemoveFormat' ] },
            { name: 'paragraph',   items : [ 'NumberedList','BulletedList','-','Outdent','Indent','-','Blockquote','-','JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock','-','BidiLtr','BidiRtl' ] },
            { name: 'links',       items : [ 'Link','Unlink','Anchor' ] },
            { name: 'insert',      items : [ 'Image','Flash','Table','HorizontalRule','Smiley','SpecialChar','fmath_formula','PageBreak' ] },//,'equation'
            '/',
            { name: 'styles',      items : [ 'Styles','Format','Font','FontSize' ] },
            { name: 'colors',      items : [ 'TextColor','BGColor' ] },
            { name: 'tools',       items : [ 'Maximize', 'ShowBlocks'] }
        ];


};
