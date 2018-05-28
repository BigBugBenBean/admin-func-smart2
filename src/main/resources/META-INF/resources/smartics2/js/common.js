function isValidDate(dateVal) {
    var isvDateValid = moment(dateVal, 'DD/MM/YYYY', true).isValid();
    return isvDateValid;
}
