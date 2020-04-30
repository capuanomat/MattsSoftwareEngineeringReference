/* Every form you create in your HTML code is stored in a form array.
     This is created automatically, you can can use it to access data about
     the forms.
     E.g. one of the data of each element is it's length, which is how many
          items are in the form.
*/


    var form0 = document.forms[0];
    document.write(form0.length + "<br />");
    var form0elem0 = form0.elements[0];
    var form0elem1 = form0.elements[1];
    var form0elem2 = form0.elements[2];
    document.write(form0elem0.name + "<br />");
    document.write(form0elem1.name + "<br />");
    document.write(form0elem2.name + "<br />");

    // Note: Another way to access the forms and elems is using the name
    var form0 = document.myForm;
    document.write(form0.length + "<br />");
    var form0elem0 = form0.username;
    var form0elem1 = form0.password;
    var form0elem2 = form0.elements[2];
    document.write(form0elem0.name + "<br />");
    document.write(form0elem1.name + "<br />");
    document.write(form0elem2.name + "<br />");

    // Check if the box is ticked
    function checkTheBox() {
        if(document.boxForm.theBox.checked) {
            alert(form0elem0.value);
        } else {
            alert("Not Checked!");
        }
    }
