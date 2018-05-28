$(document).ready(function () {

    var submitBtnDom = jQuery('#submitBtn');
    submitBtnDom.on('click', function () {
        var form =jQuery('#searchForm');
        console.log(form);
        if (isValidSearchCriteria()) {
            form.submit();
        }
    });


    function isValidSearchCriteria() {
        var apptType = $('#appointmentType').val();
        var hkic = $('#hkic').val();
        var tdNo = $('#tdNo').val();
        var dobDay = $('#dobDay').val();
        var dobMonth = $('#dobMonth').val();
        var dobYear = $('#dobYear').val();
        var dob = dobDay + '/' + dobMonth + '/' + dobYear;
        if (!apptType) {
            alert('Please select Appointment Type.');
            return false;
        } else if (!hkic && !tdNo) {
            alert('Please enter HKIC or TD No.');
            return false;
        } else if (tdNo && (!dobDay && !dobMonth && !dobYear)) {
             alert('Please enter DOB Day, Month and Year.');
             return false;
        } else if (tdNo && (dobDay && dobMonth && dobYear)) {
            if (!isValidDate(dob)) {
                alert('Please enter valid DOB Day, Month and Year.');
                return false;
            }
        } else if ($('input:radio[name=radioSearchCriteria]')[1].checked) {
            if (!dobDay) {
                alert('Please enter DOB Day.');
                return false;
            } else if (!dobMonth) {
                alert('Please enter DOB Month.');
                return false;
            } else if (!dobYear) {
                alert('Please enter DOB Year.');
                return false;
            }
        }
        return true;
    }
});

function clearFields(id) {
    //if ($(obj).attr("id") == 'hkic') {
    if (id == 'hkic') {
        $('#tdNo').val('');
        $('#dobDay').val('');
        $('#dobMonth').val('');
        $('#dobYear').val('');
        $('input:radio[name=radioSearchCriteria]')[0].checked = true;
    } else  if (id == 'tdNo' || (id == 'dobDay' || id == 'dobMonth' || id == 'dobYear')) {
         $('#hkic').val('');
         $('input:radio[name=radioSearchCriteria]')[1].checked = true;
    }
}