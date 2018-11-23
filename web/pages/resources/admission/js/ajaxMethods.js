
var _ms_XMLHttpRequest_ActiveX = ""; // Holds type of ActiveX to instantiate
var _ajax;                           // Reference to a global XMLHTTPRequest object for some of the samples
var _logger = true;                  // write output to the Activity Log
var _status_area;                    // will point to the area to write status messages to

BASE_URL = "../../"

if (!window.Node || !window.Node.ELEMENT_NODE) {

    var Node = { ELEMENT_NODE: 1, ATTRIBUTE_NODE: 2, TEXT_NODE: 3, CDATA_SECTION_NODE: 4, ENTITY_REFERENCE_NODE: 5,
                  ENTITY_NODE: 6, PROCESSING_INSTRUCTION_NODE: 7, COMMENT_NODE: 8, DOCUMENT_NODE: 9, DOCUMENT_TYPE_NODE: 10,
    		  DOCUMENT_FRAGMENT_NODE: 11, NOTATION_NODE: 12 };
}

// From prototype.js @ www.conio.net | Returns an object reference to one or more strings
// ignore the fact that there are no arguments to this method -- javascript doesn't care how many you send (not strongly typed)
// The method checks the actual # of arguments -- returns a single object or an array
function $() {
  // alert("$()")
    var elements = new Array();

    for (var i = 0; i < arguments.length; i++) {
        var element = arguments[i];

        if (typeof element == 'string')
            element = document.getElementById(element);

        if (arguments.length == 1)
            return element;

        elements.push(element);
    }

    return elements;
}

// Method to get text from an XML DOM object
function getTextFromXML( oNode, deep ) {
  // alert("getTextFromXML( oNode, deep )")
    var s = "";
    var nodes = oNode.childNodes;

    for (var i = 0; i < nodes.length; i++) {
        var node = nodes[i];

        if (node.nodeType == Node.TEXT_NODE) {
            s += node.data;
        } else if (deep == true && (node.nodeType == Node.ELEMENT_NODE || node.nodeType == Node.DOCUMENT_NODE
                                       || node.nodeType == Node.DOCUMENT_FRAGMENT_NODE)) {
            s += getTextFromXML(node, true);
        };
    }

    ;
    return s;
}

;

// If you plan on doing anything outside of North America, then you'd better encode the things you pass back and forth
// the escape() method in Javascript is deprecated -- should use encodeURIComponent if available
function encode( uri ) {
// alert(" encode( uri )")
    if (encodeURIComponent) {
        return encodeURIComponent(uri);
    }

    if (escape) {
        return escape(uri);
    }
}

function decode( uri ) {
// alert(" decode( uri )")
    uri = uri.replace(/\+/g, ' ');

    if (decodeURIComponent) {
        return decodeURIComponent(uri);
    }

    if (unescape) {
        return unescape(uri);
    }

    return uri;
}

// log information to the status area textfield
function logger( text, clear ) {
// alert(" logger( text, clear )")
    if (_logger) {
        if (!_status_area) {
            _status_area = document.getElementById("status_area");
        }

        if (_status_area) {
            if (clear) {
                _status_area.value = "";
            }

            var old = _status_area.value;
            _status_area.value = text + ((old) ? "\r\n" : "") + old;
        }
    }
}


/*
 * AJAXRequest: An encapsulated AJAX request. To run, call
 * new AJAXRequest( method, url, async, process, data )
 *
 */

function executeReturn( AJAX ) {
// alert(" executeReturn( AJAX )")
    if (AJAX.readyState == 4) {
        if (AJAX.status == 200) {
            worker_stop("");
            logger('AJAXRequest is complete: ' + AJAX.readyState + "/" + AJAX.status + "/" + AJAX.statusText);
	    if ( AJAX.responseText ) {
		    logger(AJAX.responseText);
		    logger("-----------------------------------------------------------");
		    eval(AJAX.responseText);
	    }
	}
    }
}

function AJAXRequest( method, url, data, process, async, dosend) {
    // self = this; creates a pointer to the current function
    // the pointer will be used to create a "closure". A closure
    // allows a subordinate function to contain an object reference to the
    // calling function. We can't just use "this" because in our anonymous
    // function later, "this" will refer to the object that calls the function
    // during runtime, not the AJAXRequest function that is declaring the function
    // clear as mud, right?
    // Java this ain't
     // alert(" AJAXRequest( method, url, data, process, async, dosend)")
    var self = this;


    // check the dom to see if this is IE or not
    if (window.XMLHttpRequest) {
	// Not IE
        self.AJAX = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
	// Hello IE!
        // Instantiate the latest MS ActiveX Objects
        if (_ms_XMLHttpRequest_ActiveX) {
            self.AJAX = new ActiveXObject(_ms_XMLHttpRequest_ActiveX);
        } else {
	    // loops through the various versions of XMLHTTP to ensure we're using the latest
	    var versions = ["Msxml2.XMLHTTP.7.0", "Msxml2.XMLHTTP.6.0", "Msxml2.XMLHTTP.5.0", "Msxml2.XMLHTTP.4.0", "MSXML2.XMLHTTP.3.0", "MSXML2.XMLHTTP",
                        "Microsoft.XMLHTTP"];

            for (var i = 0; i < versions.length ; i++) {
                try {
		    // try to create the object
		    // if it doesn't work, we'll try again
		    // if it does work, we'll save a reference to the proper one to speed up future instantiations
                    self.AJAX = new ActiveXObject(versions[i]);


                    if (self.AJAX) {
                        _ms_XMLHttpRequest_ActiveX = versions[i];
                        break;
                    }
                }
                catch (objException) {

                // trap; try next one
                } ;
            }

            ;
        }
    }



    // if no callback process is specified, then assing a default which executes the code returned by the server
    if (typeof process == 'undefined' || process == null) {
        process = executeReturn;
    }

    self.process = process;

    // create an anonymous function to log state changes
    self.AJAX.onreadystatechange = function( ) {
        //logger("AJAXRequest Handler: State =  " + self.AJAX.readyState);
        self.process(self.AJAX);
    }

    // if no method specified, then default to POST
    if (!method) {
        method = "POST";
    }

    method = method.toUpperCase();

    if (typeof async == 'undefined' || async == null) {
        async = true;
    }


    logger("----------------------------------------------------------------------");
    logger("AJAX Request: " + ((async) ? "Async" : "Sync") + " " + method + ": URL: " + url + ", Data: " + data);

    self.AJAX.open(method, url, async);

    if (method == "POST") {
        self.AJAX.setRequestHeader("Connection", "close");
        self.AJAX.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        self.AJAX.setRequestHeader("Method", "POST " + url + "HTTP/1.1");
    }

    // if dosend is true or undefined, send the request
    // only fails is dosend is false
    // you'd do this to set special request headers
    if ( dosend || typeof dosend == 'undefined' ) {
	    if ( !data ) data="";
	    self.AJAX.send(data);
    }
    return self.AJAX;
}



//<!------------------------------------- BEGIN SELECT ------------------------------------------->


// Clears each select that was passed to this method
// uses Javascripts dynamic argument capability--method isn't declared with args, they are looped through
// in the code using the built-in arguments array
function clearSelect() {
    for (var i = 0; i < arguments.length; i++) {
        var element = arguments[i];

        if (typeof element == 'string')
            element = document.getElementsByName(element)[0];

        if (element && element.options) {
            element.options.length = 0;
            element.selectedIndex = -1;
        }
    }
}

// base method for calling the get_select servlet
// takes dataset such as customers, cities, states, etc

function getSelectData( dataset ,key1 ,key2 ,key3 ,key4 ,target ) {
    var ajaxResult= AJAXRequest("POST", BASE_URL + "/getComboData", "dataset=" + dataset + "&key1=" + key1+ "&key2=" + key2+ "&key3=" + key3+ "&key4=" + key4 + "&target=" + target);
    return ajaxResult;
}

   function fillNextList(dataset,target,key1,key2)
    {
       clearSelect(target);
       new getSelectData(dataset,key1,key2 ,'key3' ,'key4' ,target);
    }

    function fillPerCovList(key1,target1,target2 )
    {
         clearSelect(target1);
         clearSelect(target2);
       new getSelectData('percov',key1,'key2' ,'key3' ,'key4' ,target1);

    }




//<!------------------------------------- END SELECT --------------------------------------------->


   function worker_start(status)
{
	var w = document.getElementById("worker") ;
	if(w)
	{
	 w.style.visibility = 'visible'
	 w.innerHTML ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+status
	 w.style.height = '50px'
	}

    var w2 = document.getElementById("worker2") ;
	if(w2)
	{
	 w2.style.visibility = 'visible'
	 w2.innerHTML ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+status
	 w2.style.height = '50px'
	}
	 var b = document.getElementById("search") ;
	if(b)
	{
     b.disabled = true
    }

    var c = document.getElementById("districtsDiv") ;
	if(c)
	{

     c.style.visibility = 'hidden'
     c.style.height = '0'
    }

    var s = document.getElementById("specssDiv") ;
	if(s)
	{

     s.style.visibility = 'hidden'
     s.style.height = '0'
    }

    var x = document.getElementById("courses") ;
	if(x)
	{
     x.size = '0'
     x.style.width='380px'
    }

	return true;
}
function worker_stop(status)
{
   var w = document.getElementById("worker") ;
	if(w)
	{
     w.style.visibility = 'hidden'
     w.style.height = '0'
    }

   var w2 = document.getElementById("worker2") ;
	if(w2)
	{
     w2.style.visibility = 'hidden'
     w2.style.height = '0'
    }

    var b = document.getElementById("search") ;
	if(b)
	{
     b.disabled = false
    }
    var c = document.getElementById("districtsDiv") ;
	if(c)
	{
      c.style.visibility = 'visible'
      c.style.height = 'auto'
    }

    var s = document.getElementById("specsDiv") ;
	if(s)
	{
      s.style.visibility = 'visible'
      s.style.height = 'auto'
    }

        var x = document.getElementById("courses") ;
    	if(x)
    	{
         x.size = '8'
         x.style.width='380px'
        }

}


