function isValidDate(dateVal) {
    var isvDateValid = moment(dateVal, 'DD/MM/YYYY', true).isValid();
    return isvDateValid;
}

function isNotEmptyNullUndfined(obj) {
    return ( (obj != null) && (obj !== '') && (obj !== 'undefined') );
}